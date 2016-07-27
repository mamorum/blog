package spec;

import static org.assertj.core.api.Assertions.*;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Ignore;
import org.junit.Test;

import spec.pages.LoginPage;

@Ignore
public class LoginErrorTest extends FluentTest {

	@Page LoginPage ログイン画面;

	@Test public void メールアドレスを入力せずにログインする() {
		// given
		goTo(ログイン画面);
		ログイン画面.入力する("", "ng");

		// when
		ログイン画面.サブミットする();

		// then
		ログイン画面.isAt();
	}

	@Test public void パスワードを入力せずにログインする() {
		// given
		goTo(ログイン画面);
		ログイン画面.入力する("ng@ng.com", "");

		// when
		ログイン画面.サブミットする();

		// then
		ログイン画面.isAt();
	}

	@Test public void 誤った情報でログインする() {
		// given
		goTo(ログイン画面);
		ログイン画面.入力する("ng@ng.com", "ng");

		// when
		ログイン画面.サブミットする();

		// then
		ログインに失敗している();
	}

	private void ログインに失敗している() {
		ログイン画面.isAt();
		assertThat($(".text-danger").getText()).contains("違います。");
	}

}
