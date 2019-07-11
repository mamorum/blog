package spec.pages.admin;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.annotation.AjaxElement;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import spec.common.ConfiguredPage;

public class UserPage extends ConfiguredPage {

	FluentWebElement username, search;
	FluentWebElement addUsername, addPassword, add;

	@AjaxElement
	FluentWebElement editUsername, editPassword,
								editEnabled, editAuthority, update;

	@AjaxElement @FindBy(css=".delete") FluentWebElement delete;
	@AjaxElement @FindBy(css=".edit") FluentWebElement edit;
	@AjaxElement @FindBy(css="tbody") FluentWebElement tbody;
	@AjaxElement @FindBy(css="tbody tr") FluentWebElement tr;

	@Override public String getUrl() {
		return config.url + "/admin/user";
	}
	@Override public void isAt() {
		await().atMost(5000).until("#addUsername").areDisplayed();
		await().atMost(5000).until("#addPassword").areDisplayed();
		await().atMost(5000).until("#add").areDisplayed();
		assertThat(addUsername).isDisplayed();
		assertThat(addPassword).isDisplayed();
		assertThat(add).isDisplayed();
	}
	public void 追加ユーザを入力する(User user) {
		addUsername.text(user.username);
		addPassword.text(user.password);
	}

	public void 追加する() {
		add.click();
	}

	public void 検索ユーザを入力する(User user) {
		username.text(user.username);
	}

	public void 検索する() {
		search.click();
	}

	public void ユーザを編集する(User user) {
		edit.click();
		await().atMost(5000).until("#modal").areDisplayed();
		editUsername.text(user.username);
		editPassword.text(user.password);
		editEnabled.find("option", 1).click();
		editAuthority.find("option", 1).click();
	}

	public void 更新する() {
		update.click();
	}

	public void 削除する() {
		delete.click();
		alert().accept();
	}

	public void 表示されている(User user) {
		await().atMost(5000).until("tbody tr td").withText().startsWith(user.username).isPresent();
		assertThat(tr.find("td", 0).getText()).contains(user.username);
		assertThat(tr.find("td", 1).getText()).contains("true");
		assertThat(tr.find("td", 2).getText()).contains("ROLE_USER");
	}

	public void 編集後ユーザが表示されている(User user) {
		await().atMost(5000).until("tbody tr td").withText().startsWith(user.username).isPresent();
		assertThat(tr.find("td", 0).getText()).contains(user.username);
		assertThat(tr.find("td", 1).getText()).contains("false");
		assertThat(tr.find("td", 2).getText()).contains("ROLE_ADMIN");
	}

	public void 削除されている() {
		assertThat(tbody.getText()).isEmpty();
	}

	public static class User {
		public String username, password;
		public User(String username, String password) {
			this.username = username;
			this.password = password;
		}
	}
}
