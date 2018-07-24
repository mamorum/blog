package spec;

import static spec.common.Utils.*;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

import spec.pages.LoginPage;
import spec.pages.SettingPage;

public class SettingTest extends FluentTest {

	@Page LoginPage ログイン画面;
	@Page SettingPage 設定画面;

	@Before public void 設定画面に遷移する() {
		goTo(ログイン画面);
		ログイン画面.ログインする();
		goTo(設定画面);
		設定画面.isAt();
	}

	@Test public void 名前を変更する() {
		//given
		String name = unique();
		設定画面.名前を入力する(name);

		//when
		設定画面.名前を保存する();

		//then
		設定画面.名前が保存されている();
	}

	@Test public void メールを変更する() {
		try {
			//given
			設定画面.メール設定画面に遷移する();
			String mail = "test@test.com";
			設定画面.メールを入力する(mail);

			//when
			設定画面.メールを保存する();

			//then
			設定画面.メールが保存されている();
		}
		finally {
			設定画面.メールを元に戻す();
		}
	}

	@Test public void パスワードを変更する() {
		String nextPass = "test";
		try {
			//given
			設定画面.パスワード設定画面に遷移する();
			設定画面.パスワードを入力する(nextPass);

			//when
			設定画面.パスワードを保存する();

			//then
			設定画面.パスワードが保存されている();
		}
		finally {
			設定画面.パスワードを元に戻す(nextPass);
		}
	}
}
