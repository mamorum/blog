package gsjt;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class AssertjTest {

	@Test public void test() {
		
		// 準備（≒ given）
		int a = 1;
		
		// 実行（≒ when）
		int result = a + a;
		
		// 検証（≒ then）
		// 結果 result が、期待値 2 と等しいこと。
		assertThat(result).isEqualTo(2);
	}
}
