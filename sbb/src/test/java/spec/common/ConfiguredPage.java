package spec.common;

import org.fluentlenium.core.FluentPage;

public class ConfiguredPage extends FluentPage {
	protected Config config = Config.configure();
}
