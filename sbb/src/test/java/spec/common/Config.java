package spec.common;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Config {

	private static Config configured;

	public String profile, url;
	public User user, admin;

	public static class User {
		public String name, password;
	}


	/**
	 * config.yml から、Config クラスを生成します。
	 * -Dprofile=staging（システムプロパティ）が設定されている場合、
	 * profile: default の設定を profile: staging の設定で上書きします。
	 *
	 * @return Config
	 */
	public static Config configure() {

		if (configured != null) {
			return configured;
		}

		final String PROFILE = "profile";
		final String DEFAULT = "default";
		final String STAGING = "staging";

		Yaml yaml = new Yaml();
		InputStream is = Config.class.getResourceAsStream("/config.yml");
		Iterable<Object> allConfig =  yaml.loadAll(is);
		Map<Object, Object> defaultConfig = null, stagingConfig = null;

		for (Object o: allConfig) {
			@SuppressWarnings("unchecked")
			Map<Object, Object> config = (Map<Object, Object>) o;
			if (DEFAULT.equals(config.get(PROFILE))) {
				defaultConfig = config;
			}
			if (STAGING.equals(config.get(PROFILE))) {
				stagingConfig = config;
			}
		}

		String profile = System.getProperty(PROFILE);

		// for staging, overwites default.
		if (STAGING.equals(profile)) {
			defaultConfig.putAll(stagingConfig);
		}

		// set class name to create.
		String dump = yaml.dump(defaultConfig);
		StringBuilder config = new StringBuilder();
		config.append("!!").append(Config.class.getName());
		config.append(System.getProperty("line.separator")).append(dump);

		configured = (Config) yaml.load(config.toString());
		return configured;
	}
}
