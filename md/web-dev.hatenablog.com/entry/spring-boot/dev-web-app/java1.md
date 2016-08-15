---
Title: SpringBoot アプリ開発：3. Java（モデル・リポジトリ）
Category:
- spring-boot-アプリ開発
Date: 2016-06-23T22:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/java1
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179182407
---

つぶやきアプリ（[こちら](/entry/spring-boot/dev-web-app/table-of-contents) のアプリ）の モデルやリポジトリを、Java で作成していきます。また、事前にテーブル作成用の SQL を用意しておきます。


## SQLファイルの作成
テーブル作成用の SQL です。テーブルには、モデルのデータ（つぶやき）が保存されます。

`sbt/src/main/resources/db/migration/V1__Create.sql`

```sql
create table tsubuyaki (
  id serial primary key,
  txt varchar(100) not null,
  version integer not null default 0,
  updated_time timestamp not null default current_timestamp,
  created_time timestamp not null default current_timestamp
);
```

ファイルの場所と名前は、SpringBoot（+ Flyway）の規約に従っています。詳細は、記事「[SpringBoot入門：FlywayでDBマイグレーション](/entry/spring-boot/intro/flyway)」を参照して頂けると嬉しいです。

SQL は、アプリ起動時に Flyway を通して実行されます。


## モデル
つぶやきのデータを保持するクラスを、JPA エンティティとして作成します。

`sbt/src/main/java/sbt/model/Tsubuyaki.java`

```java
package sbt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tsubuyaki extends TimestampEntity {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long id;

	@NotEmpty
	public String txt;

	@Version
	public long version;
}
```

つぶやきの更新日時と作成日時は、次の親クラスで保持します。

`sbt/src/main/java/sbt/model/TimestampEntity.java`

```java
package sbt.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass    // Parent of JPA Entity.
public abstract class TimestampEntity {

	public Timestamp updatedTime;
	
	@Column(updatable=false)
	public Timestamp createdTime;
    
    @PrePersist
    public void prePersist() {
    	Timestamp ts = new Timestamp((new Date()).getTime());
    	this.createdTime = ts;
    	this.updatedTime = ts;
    }
    
    @PreUpdate
    public void preUpdate() {
    	this.updatedTime = new Timestamp((new Date()).getTime());
    }
}
```

テーブルに insert する前に作成日時を設定して（`@PrePersist`）、update する前に更新日時を設定しています（`@PreUpdate`）。


## リポジトリ
Spring の [CrudRepository](http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html) を継承するインターフェイスを作成します。`CrudRepository` を継承すると、一通りの CRUD 操作ができるようになります。

`sbt/src/main/java/sbt/repository/TsubuyakiRepository.java`

```java
package sbt.repository;

import org.springframework.data.repository.CrudRepository;

import sbt.model.Tsubuyaki;

public interface TsubuyakiRepository extends CrudRepository<Tsubuyaki, Long> {
	Iterable<Tsubuyaki> findAllByOrderByUpdatedTimeDesc();
}
```

今回は、つぶやきを全て取得するメソッドを定義しています。メソッド名は Spring の規約に従っていて、つぶやきは更新日時の降順でソートされます（新しいものが先）。詳細は [SpringBoot JPA の規約](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/) に書かれています。
