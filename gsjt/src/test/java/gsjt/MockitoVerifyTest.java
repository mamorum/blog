package gsjt;

import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Test;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MockitoVerifyTest {

	@Test public void test() {

		// モックの作成。
		List mockedList = mock(List.class);

		// モックのメソッドを実行。
		mockedList.add("one");
		
		// メソッドが実行されたか検証。
		verify(mockedList).add("one");
		
		// 実行されてないメソッドは検証エラー。
		// verify(mockedList).add("two");
	}
}
