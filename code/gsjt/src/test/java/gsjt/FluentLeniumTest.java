package gsjt;

import static org.assertj.core.api.Assertions.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;

public class FluentLeniumTest extends FluentTest {

	@Test public void BingでFluentLeniumを検索する() {

		// 準備：Bing を開いてキーワードを入力する。
		goTo("http://www.bing.com");
		fill("#sb_form_q").with("FluentLenium");

		// 実行：検索する。
		submit("#sb_form_go");

		// 検証：タイトルにキーワードが含まれること。
		assertThat(title()).contains("FluentLenium");
	}
}
