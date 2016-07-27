package spec;

import static org.assertj.core.api.Assertions.*;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import spec.pages.CustomerPage;
import spec.pages.LoginPage;

public class LoginTest extends FluentTest {

	@Page LoginPage ログイン画面;
	@Page CustomerPage 顧客画面;

	@Test public void ログインする() {
		// given
		goTo(ログイン画面);
		ログイン画面.ログイン情報を入力する();
		screenShot("ログインする", 1);

		// when
		ログイン画面.サブミットする();

		// then
		顧客画面.isAt();
		screenShot("ログインする", 2);
	}

	@Test public void ログアウトする() {
		// given
		goTo(ログイン画面);
		ログイン画面.ログインする();

		// when
		顧客画面.ログアウトする();

		// then
		ログアウトしている();
	}

	private void ログアウトしている() {
		await().atMost(5000).until(".text-info").isPresent();
		assertThat($(".text-info").getText()).contains("ログアウトしました。");
	}

	private void screenShot(String parent, int num) {
		StringBuilder path = new StringBuilder();
		path.append("./target/screen/").append(parent).append("/")
				.append(num).append(".png");
		takeScreenShot(path.toString());
	}
}
