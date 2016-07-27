package spec.admin;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

import spec.pages.LoginPage;
import spec.pages.admin.UserPage;
import spec.pages.admin.UserPage.User;

public class UserCrudTest extends FluentTest {

	@Page LoginPage ログイン画面;
	@Page UserPage ユーザ管理画面;

	@Before public void ユーザ管理画面に遷移する() {
		goTo(ログイン画面);
		ログイン画面.管理者でログインする();
		goTo(ユーザ管理画面);
		ユーザ管理画面.isAt();
	}

	@Test public void ユーザを追加する() {
		try {
			// given
			User ユーザ = new User("user@test.com", "user");
			ユーザ管理画面.追加ユーザを入力する(ユーザ);

			// when
			ユーザ管理画面.追加する();

			// then
			ユーザ管理画面.表示されている(ユーザ);
		} finally {
			ユーザ管理画面.削除する();
		}
	}

	@Test public void ユーザを検索する() {
		try {
			// given
			User ユーザ = new User("user@test.com", "user");
			ユーザ管理画面.追加ユーザを入力する(ユーザ);
			ユーザ管理画面.追加する();
			ユーザ管理画面.検索ユーザを入力する(ユーザ);

			// when
			ユーザ管理画面.検索する();

			// then
			ユーザ管理画面.表示されている(ユーザ);
		} finally {
			ユーザ管理画面.削除する();
		}
	}

	@Test public void ユーザを全件検索する() {
		try {
			// given
			User ユーザ = new User("user@test.com", "user");
			ユーザ管理画面.追加ユーザを入力する(ユーザ);
			ユーザ管理画面.追加する();

			// when
			ユーザ管理画面.検索する();

			// then
			ユーザ管理画面.表示されている(ユーザ);
		} finally {
			ユーザ管理画面.削除する();
		}
	}

	@Test public void ユーザを編集する() {
		try {
			// given
			User ユーザ = new User("user@test.com", "user");
			ユーザ管理画面.追加ユーザを入力する(ユーザ);
			ユーザ管理画面.追加する();
			User 編集ユーザ = new User("update@test.com", "update");
			ユーザ管理画面.ユーザを編集する(編集ユーザ);

			// when
			ユーザ管理画面.更新する();

			// then
			ユーザ管理画面.編集後ユーザが表示されている(編集ユーザ);
		} finally {
			ユーザ管理画面.削除する();
		}
	}

	@Test public void ユーザを削除する() {
		// given
		User ユーザ = new User("user@test.com", "user");
		ユーザ管理画面.追加ユーザを入力する(ユーザ);
		ユーザ管理画面.追加する();

		// when
		ユーザ管理画面.削除する();

		// then
		ユーザ管理画面.削除されている();
	}
}
