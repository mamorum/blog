package gssb.rdb.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Map;
import org.junit.Test;
import gssb.rdb.model.Memo;
import gssb.rdb.repository.MemoRepository;

public class JpaMemoControllerTest {

	@Test public void testCreate() {
		
		// 準備：テストデータ
		Memo memo = new Memo();
		memo.text = "テスト";

		// 準備：リポジトリのモック（戻り値を設定）
		MemoRepository repo = mock(MemoRepository.class);
		when(repo.save(memo)).thenReturn(memo);

		// 準備：テスト対象（リポジトリのモックを設定）
		JpaMemoController controller = new JpaMemoController();
		controller.repository = repo;

		// 実行
		Map<String, Memo> result = controller.create(memo);

		// 検証
		assertThat(result.get("memo").text).isEqualTo("テスト");
	}
}
