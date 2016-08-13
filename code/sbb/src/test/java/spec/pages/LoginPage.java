package spec.pages;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.domain.FluentWebElement;

import spec.common.ConfiguredPage;

public class LoginPage extends ConfiguredPage {

	FluentWebElement username, password, submit;

	@Override public String getUrl() {
		return config.url;
	}
	@Override public void isAt() {
		assertThat(title()).contains("ログイン");
		assertThat(username).isDisplayed();
		assertThat(password).isDisplayed();
		assertThat(submit).isDisplayed();
	}

	public void ログイン情報を入力する() {
		this.入力する(config.user.name, config.user.password);
	}

	public void 入力する(String username, String password) {
		this.username.text(username);
		this.password.text(password);
	}

	public void サブミットする() {
		submit.click();
	}

	public void ログインする() {
		ログイン情報を入力する();
		サブミットする();
	}

	public void 管理者でログインする() {
		入力する(config.admin.name, config.admin.password);
		サブミットする();
	}

}
