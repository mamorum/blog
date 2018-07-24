package it;

import it.page.TsubuyakiPage;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class TsubuyakiTest extends FluentTest {

	@Page TsubuyakiPage つぶやき画面;

	@Test public void つぶやきを投稿する() {

		// given
		goTo(つぶやき画面);
		String つぶやき = "こんにちは。";

		// when
		つぶやき画面.つぶやきを投稿する(つぶやき);

		// then
		goTo(つぶやき画面);
		つぶやき画面.つぶやきが表示されている(つぶやき);
	}
}
