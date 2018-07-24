package it.page;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

public class TsubuyakiPage extends FluentPage {

	FluentWebElement txt, create;

	@Override public String getUrl() {
		return "http://localhost:8080/";
	}
	@Override public void isAt() {
		assertThat(title()).isEqualTo("Spring Boot Tutorial.");
		assertThat(txt).isDisplayed();
		assertThat(create).isDisplayed();
	}

	public void つぶやきを投稿する(String つぶやき) {
		txt.text(つぶやき);
		create.click();
	}
	public void つぶやきが表示されている(String つぶやき) {
		await().atMost(5000).until(".tsubuyaki .txt p").isPresent();
		FluentWebElement p = findFirst(".tsubuyaki .txt p");
		assertThat(p.getText()).isEqualTo(つぶやき);
	}
}
