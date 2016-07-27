package sbt.controller;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

import org.junit.Test;

import sbt.model.Tsubuyaki;
import sbt.repository.TsubuyakiRepository;

public class TsubuyakiControllerTest {

	@Test public void testCreate() {

		// 準備：テストデータ
		Tsubuyaki data = new Tsubuyaki();
		data.txt = "メッセージ";

		// 準備：モック（リポジトリ）
		TsubuyakiRepository mock = mock(TsubuyakiRepository.class);
		when(mock.save(data)).thenReturn(data);

		// 準備：テスト対象クラス
		TsubuyakiController target = new TsubuyakiController();
		target.repo = mock;

		// 実行：テスト対象メソッド
		Map<String, Tsubuyaki> result = target.create(data);

		// 検証：つぶやきが等しいこと
		Tsubuyaki tsubuyaki = result.get("tsubuyaki");
		assertThat(tsubuyaki.txt).isEqualTo("メッセージ");
	}
}
