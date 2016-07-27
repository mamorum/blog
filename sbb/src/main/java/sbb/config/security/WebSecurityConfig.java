package sbb.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration @EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private DataSource dataSource;

    // This method defines which URL paths should be secured and which should not.
    @Override protected void configure(HttpSecurity http) throws Exception {

        // セッションをステートレスにしたい場合の設定
        // http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/lib/**", "/favicon.ico").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.permitAll()
                .loginPage("/login")
                .and()
            .logout()
                .permitAll()
                .and()
            .rememberMe()
            	.tokenRepository(jdbcTokenRepository())
            	.tokenValiditySeconds(2592000); // remember for a month.
    }

    @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new JdbcUserDetailService(dataSource));
    }


    PersistentTokenRepository jdbcTokenRepository() {
    	JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
    	repository.setDataSource(dataSource);
    	return repository;
    }
}
