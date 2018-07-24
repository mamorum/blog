package model;

import java.sql.Timestamp;

public class Memo {
  public long id;
  public String txt;
  public Timestamp updated, created;
  public String toString() {
    return new StringBuilder(
      ).append(id).append(", "
      ).append(txt).append(", "
      ).append(updated).append(", "
      ).append(created
    ).toString();
  }
}