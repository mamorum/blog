package spec.pages;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.annotation.AjaxElement;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import spec.common.ConfiguredPage;

public class SettingPage extends ConfiguredPage {

	// for tabs.
	@FindBy(css=".nav-tabs li:nth-child(2)") FluentWebElement mailTab;
	@FindBy(css=".nav-tabs li:nth-child(3)") FluentWebElement passwordTab;

	// for name setting.
	@AjaxElement FluentWebElement
		lastNameKana, firstNameKana, lastName, firstName, saveInfo;

	// for mail setting.
	@AjaxElement FluentWebElement mail, mailPassword, saveMail;

	// for password setting.
	@AjaxElement FluentWebElement
		nowPass, nextPass, nextPassRe, savePass;

	@Override public String getUrl() {
		return config.url + "/setting";
	}
	@Override public void isAt() {
		assertThat(lastNameKana).isDisplayed();
		assertThat(firstNameKana).isDisplayed();
		assertThat(lastName).isDisplayed();
		assertThat(firstName).isDisplayed();
		assertThat(saveInfo).isDisplayed();
	}

	public void 名前を入力する(String name) {
		lastNameKana.text(name);
		firstNameKana.text(name);
		lastName.text(name);
		firstName.text(name);
	}

	public void 名前を保存する() {
		saveInfo.click();
	}

	public void 名前が保存されている() {
		await().atMost(5000).until(".alert-info #alert-msg")
			.withText().equalTo("名前を更新しました。").isPresent();
	}

	public void メール設定画面に遷移する() {
		mailTab.click();
		assertThat(mail).isDisplayed();
		assertThat(mailPassword).isDisplayed();
		assertThat(saveMail).isDisplayed();
	}

	public void メールを入力する(String text) {
		mail.text(text);
		mailPassword.text(config.user.password);
	}

	public void メールを保存する() {
		saveMail.click();
	}

	public void メールを元に戻す() {
		String originMail = config.user.name;
		メールを入力する(originMail);
		メールを保存する();
		メールが保存されている();
	}

	public void メールが保存されている() {
		await().atMost(5000).until(".alert-info #alert-msg")
			.withText().equalTo("メールアドレスを更新しました。").isPresent();
		$(".alert-info .alert-close").click();
	}

	public void パスワード設定画面に遷移する() {
		passwordTab.click();
		assertThat(nowPass).isDisplayed();
		assertThat(nextPass).isDisplayed();
		assertThat(nextPassRe).isDisplayed();
		assertThat(savePass).isDisplayed();
	}

	public void パスワードを入力する(String next) {
		パスワードを入力する(config.user.password, next);
	}

	public void パスワードを入力する(String original, String next) {
		nowPass.text(original);
		nextPass.text(next);
		nextPassRe.text(next);
	}

	public void パスワードを保存する() {
		savePass.click();
	}

	public void パスワードを元に戻す(String now) {
		パスワードを入力する(now, config.user.password);
		パスワードを保存する();
		パスワードが保存されている();
	}

	public void パスワードが保存されている() {
		await().atMost(5000).until(".alert-info #alert-msg")
			.withText().equalTo("パスワードを更新しました。").isPresent();
		$(".alert-info .alert-close").click();
	}

}
