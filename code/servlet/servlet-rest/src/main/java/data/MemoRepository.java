package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import model.Memo;

public class MemoRepository {
  private static LinkedHashMap<Long, Memo> data = new LinkedHashMap<>();
  private static AtomicLong id = new AtomicLong(0);
  public static List<Memo> readAll() {
    return new ArrayList<>(data.values());
  }
  public static Memo create(String txt) {
    Memo memo = new Memo(
      id.getAndIncrement(), txt, new Date()
    );
    data.put(memo.id, memo);
    return memo;
  }
  public static Memo update(Long id, String txt) {
    Memo memo = data.get(id);
    if (memo == null) return null;
    memo.txt = txt;
    memo.updated = new Date();
    return memo;
  }
  public static Memo delete(Long id) {
    return data.remove(id);
  }
}