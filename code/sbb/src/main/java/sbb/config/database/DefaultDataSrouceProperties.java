package sbb.config.database;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "default.datasource")
public class DefaultDataSrouceProperties {
	// values from application.properties.
	String url, username, password, driverClassName;
}
