package sbb.config.security;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

// I can't use @Component, because of DaoSupport#afterPropertiesSet().
public class JdbcUserDetailService extends JdbcDaoImpl {

    private final String USER_QUERY =
            "select username, password, enabled, id from users where username = ?";

    private final String AUTHORITY_QUERY =
            "select username, authority from users where username = ?";

    public JdbcUserDetailService(DataSource dataSource) {
        setDataSource(dataSource);
        setUsersByUsernameQuery(USER_QUERY);
        setAuthoritiesByUsernameQuery(AUTHORITY_QUERY);
    }

    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] { username },
                new RowMapper<UserDetails>() {
                    public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                        String username = rs.getString(1);
                        String password = rs.getString(2);
                        boolean enabled = rs.getBoolean(3);
                        Long id = rs.getLong(4);
                        return new LoginUser(id, username, password, enabled, true, true, true,
                                AuthorityUtils.NO_AUTHORITIES);
                    }
                });
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities)
    {
        Long id = ((LoginUser) userFromUserQuery).getId();
        String returnUsername = userFromUserQuery.getUsername();
        //        if (!this.usernameBasedPrimaryKey) {
        //            returnUsername = username;
        //        }
        return new LoginUser(id, returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), true, true,
                true, combinedAuthorities);
    }

}
