package model;

import java.util.Date;

public class Memo {
  public long id;
  public String txt;
  public Date updated, created;
  public Memo(long id, String txt, Date time) {
    this.id = id;
    this.txt = txt;
    this.updated = time;
    this.created = time;
  }
}
