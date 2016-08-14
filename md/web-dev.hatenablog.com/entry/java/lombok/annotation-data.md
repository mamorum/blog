---
Title: Java：Lombok の @Data でコード量削減
Category:
- java
Date: 2016-08-01T13:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/lombok/annotation-data
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179057267
---

Lombok は Java のライブラリで、getter/setter やコンストラクタなどのコードを自動的に生成してくれます。今回は、Lombok のアノテーション `@Data` を使って、コード量を削減する方法を書いてみます。


## 手順1. ビルドシステムの設定
Lombok への依存性を追加します。

### 1. Maven
```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.16.10</version>
</dependency>
```

### 2. Gradle
```gradle
compile 'org.projectlombok:lombok:1.16.10'
```

### 3. ビルドシステムを使わない場合
[Lombok 公式サイト](https://projectlombok.org/index.html) から jar をダウンロードして、クラスパスに通します。


## 手順2. @Data を追加
getter/setter などを生成したいクラスに、アノテーションを付与します。

```java
import lombok.Data;

@Data public class Greeting {
    private long id;
    private String content;
}
```

`@Data` は、getter/setter, equals(Object), canEqual(Object), hashCode(), toString(), コンストラクタを生成してくれます。Eclipse で `Greeting` クラスのアウトラインを見ると、コードが生成されていることを確認できます。

![class-outline](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814132504.png)

`@Data` 以外にも色々なアノテーションがあるので、必要に応じて使い分けると良さそうです。


## 補足１. Eclipse で使う場合
IDE で使う場合、Lombok のインストールが必要みたいです。インストール方法は、[Eclipse：lombokインストール手順](/entry/eclipse/lombok) を参照して頂けると嬉しいです。


## 補足2. JPA のエンティティ
JPA のエンティティには、デフォルトコンストラクタが必要です。Lombok のアノテーションを使う場合は、デフォルトコンストラクタが生成されているか確認したほうが良さそうです。

`@Data` と引数有りのコンストラクタを定義すると、デフォルトコンストラクタが生成されなくなるので要注意です。`@Data` だけなら問題なさそうです。
