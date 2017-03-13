package gssb.rdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;

@Entity    // JPAエンティティに必要。
public class Memo extends TimestampEntity {

  // データ型 serial（PostgreSQL）。
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  public long id;

  @NotEmpty
  public String text;

  @Version
  public long version;    
}