package spec.pages;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.annotation.AjaxElement;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import spec.common.ConfiguredPage;

public class CustomerPage extends ConfiguredPage {

	FluentWebElement addLastNameKana, addFirstNameKana, addLastName, addFirstName, add;
	FluentWebElement lastName, search;

	@AjaxElement FluentWebElement editLastNameKana, editFirstNameKana, editLastName, editFirstName, update;

	@AjaxElement FluentWebElement page;
	@AjaxElement @FindBy(css=".delete") FluentWebElement delete;
	@AjaxElement @FindBy(css=".edit") FluentWebElement edit;
	@AjaxElement @FindBy(css="tbody") FluentWebElement tbody;
	@AjaxElement @FindBy(css="tbody tr") FluentWebElement tr;

	@Override public String getUrl() {
		return config.url + "/customer";
	}
	@Override public void isAt() {
		assertThat(addLastNameKana).isDisplayed();
		assertThat(addFirstNameKana).isDisplayed();
		assertThat(addLastName).isDisplayed();
		assertThat(addFirstName).isDisplayed();
		assertThat(add).isDisplayed();
	}

	public void ログアウトする() {
		$("#logout").click();
	}

	public void 追加する(Customer c) {
		addLastNameKana.text(c.lastNameKana);
		addFirstNameKana.text(c.firstNameKana);
		addLastName.text(c.lastName);
		addFirstName.text(c.firstName);
		add.click();
	}

	public void 検索する(Customer c) {
		lastName.text(c.lastName);
		search.click();
	}

	public void 全件検索する() {
		lastName.text("");
		search.click();
	}

	public void 編集する(Customer c) {
		edit.click();
		await().atMost(5000).until("#modal").areDisplayed();
		editLastNameKana.text(c.lastNameKana);
		editFirstNameKana.text(c.firstNameKana);
		editLastName.text(c.lastName);
		editFirstName.text(c.firstName);
		update.click();
	}

	public void 削除する() {
		delete.click();
		alert().accept();
	}

	public void 顧客が表示されている(Customer c) {
		await().atMost(5000).until("tbody tr td").withText().startsWith(c.lastName).isPresent();
		assertThat(tr.find("td", 0).getText()).contains(c.lastName + " " + c.firstName);
		assertThat(tr.find("td", 1).getText()).contains(c.lastNameKana + " " + c.firstNameKana);
	}

	public void ページ数が表示されている(int i) {
		await().atMost(5000).until("#page").withText().startsWith(String.valueOf(i)).isPresent();
		assertThat(page.getText()).startsWith(i + " / ");
	}

	public void 顧客が削除されている() {
		assertThat(tbody.getText()).isEmpty();
	}

	public static class Customer {
		public String lastNameKana, firstNameKana, lastName, firstName;
		public Customer(String lastNameKana, String firstNameKana, String lastName, String firstName) {
			this.lastNameKana = lastNameKana;
			this.firstNameKana = firstNameKana;
			this.lastName = lastName;
			this.firstName = firstName;
		}
	}
}
