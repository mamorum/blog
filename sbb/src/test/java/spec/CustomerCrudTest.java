package spec;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;
import org.junit.Test;

import spec.pages.CustomerPage;
import spec.pages.CustomerPage.Customer;
import spec.pages.LoginPage;

public class CustomerCrudTest extends FluentTest {

	@Page LoginPage ログイン画面;
	@Page CustomerPage 顧客画面;

	@Before public void 顧客画面に遷移する() {
		goTo(ログイン画面);
		ログイン画面.ログインする();
		goTo(顧客画面);
		顧客画面.isAt();
	}

	@Test public void 顧客を追加する() {
		//given
		Customer 顧客 = new Customer("やまだ", "たろう", "山田", "太郎");

		//when
		顧客画面.追加する(顧客);

		//then
		顧客画面.顧客が表示されている(顧客);
	}

	@Test public void 顧客を検索する() {
		//given
		Customer 顧客 = new Customer("すずき", "じろう", "鈴木", "次郎");
		顧客画面.追加する(顧客);

		//when
		顧客画面.検索する(顧客);

		//then
		顧客画面.ページ数が表示されている(1);
		顧客画面.顧客が表示されている(顧客);
	}

	@Test public void 顧客を全件表示する() {
		//given
		Customer 顧客 = new Customer("うすい", "はなこ", "薄井", "花子");
		顧客画面.追加する(顧客);

		//when
		顧客画面.全件検索する();

		//then
		顧客画面.ページ数が表示されている(1);
		顧客画面.顧客が表示されている(顧客);
	}

	@Test public void 顧客を編集する() {
		//given
		Customer 顧客 = new Customer("よこやま", "さぶろう", "横山", "三郎");
		顧客画面.追加する(顧客);

		//when
		Customer 編集後顧客 = new Customer("あべ", "しろう", "安倍", "史郎");
		顧客画面.編集する(編集後顧客);

		//then
		顧客画面.顧客が表示されている(編集後顧客);
	}

	@Test public void 顧客を削除する() {
		//given
		Customer 顧客 = new Customer("なかやま", "さとる", "中山", "悟");
		顧客画面.追加する(顧客);

		//when
		顧客画面.削除する();

		//then
		顧客画面.顧客が削除されている();
	}
}
