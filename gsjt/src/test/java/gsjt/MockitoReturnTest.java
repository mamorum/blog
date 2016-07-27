package gsjt;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Test;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MockitoReturnTest {

	@Test public void test() {

		// モックの作成。
		List mockedList = mock(List.class);

		// モックのメソッドを実行。
		mockedList.add("one");
				
		// モックに追加した "one" は取得できない。
		assertThat(mockedList.get(0)).isNull();
				
		// モックの戻り値を設定。
		when(mockedList.get(0)).thenReturn("two");

		// モックの戻り値を検証。
		assertThat(mockedList.get(0)).isEqualTo("two");
	}
}
