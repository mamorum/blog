---
Title: Servletアプリ開発：3.Java開発１（モデル・リポジトリ）
Category:
- Java
Date: 2017-11-10T06:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/dev-restful-app/java1
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812315713167
---

サーブレットアプリ（RESTful API）の Java開発について書いていきます。Java開発は２つの記事に分けていて、今回はモデル（Memo オブジェクト）と、リポジトリ（データを操作するクラス）をつくっていきます。

※ 開発するアプリの概要は、以下のリンク先に書いてあります。

[Servletアプリ開発：1.概要](/entry/java/servlet/dev-restful-app/overview)


## モデルの作成
メモのデータを保持するクラスを作成します。

`servlet-rest/src/main/java/model/Memo.java`

```java
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
```

メモの内容は、変数 `txt` に格納されます。コンストラクタは、メモを作成する処理で使います。


## リポジトリの作成
メモの取得・作成・更新・削除ができるクラスを作成します。

`servlet-rest/src/main/java/data/MemoRepository.java`

```java
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
    synchronized (data) {
      return new ArrayList<>(data.values());
    }
  }
  public static Memo create(String txt) {
    Memo memo = new Memo(
      id.getAndIncrement(), txt, new Date()
    );
    synchronized (data) {
      data.put(memo.id, memo);
    }
    return memo;
  }
  public static Memo update(Long id, String txt) {
    synchronized (data) {
      Memo memo = data.get(id);
      if (memo == null) return null;
      memo.txt = txt;
      memo.updated = new Date();
      return memo;
    }
  }
  public static Memo delete(Long id) {
    synchronized (data) {
      return data.remove(id);
    }
  }
}
```

メモのデータは `LinkedHashMap` の `data` 変数に格納します。今回はサーブレットに特化したサンプルアプリなので、データをメモリで保持することにしてます。メモリ保持だと、アプリを停止（コンテナを停止）するとデータは失われます。

実運用するアプリだと、RDBMS などにデータを永続化することが多いと思います。
