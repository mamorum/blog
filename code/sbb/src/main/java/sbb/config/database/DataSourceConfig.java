package sbb.config.database;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Autowired DefaultDataSrouceProperties dp;

	@Bean DataSource dataSource() throws Exception {

		String dbUrl = System.getenv("DATABASE_URL");

    	if (isHeroku(dbUrl)) {
    		return herokuDataSource(dbUrl);
    	}
    	return defaultDataSource();
	}

	private boolean isHeroku(String dbURL) {
		return !(StringUtils.isEmpty(dbURL));
	}

	private DataSource defaultDataSource() {
		return  DataSourceBuilder.create().url(dp.getUrl())
					.username(dp.username).password(dp.password)
					.driverClassName(dp.driverClassName).build();
	}

	private DataSource herokuDataSource(String dbUrl) throws Exception {
		HerokuDatbaseUrlSplitter s = HerokuDatbaseUrlSplitter.with(dbUrl);
    	return DataSourceBuilder.create().url(s.jdbcUrl)
	    			.username(s.user).password(s.password)
	    			.driverClassName(dp.driverClassName).build();
	}

	public static class HerokuDatbaseUrlSplitter {

		public final String user, password, jdbcUrl;

		private HerokuDatbaseUrlSplitter(String user, String password, String jdbcUrl) {
			this.user = user;
			this.password = password;
			this.jdbcUrl = jdbcUrl;
		}

		public static HerokuDatbaseUrlSplitter with(String dbUrl) throws URISyntaxException {
			URI uri = new URI(dbUrl);
			String user = uri.getUserInfo().split(":")[0];
			String password = uri.getUserInfo().split(":")[1];
			return new HerokuDatbaseUrlSplitter(user, password, jdbcUrl(uri));
		}

		private static String jdbcUrl(URI uri) {
			StringBuilder url = new StringBuilder();
			url.append("jdbc:postgresql://").append(uri.getHost());
			url.append(":").append(uri.getPort()).append(uri.getPath());
			return url.toString();
		}
	}
}
