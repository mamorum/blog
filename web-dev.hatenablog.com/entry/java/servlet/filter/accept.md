---
Title: Servlet Filter：フィルターで前後処理を追加
Category:
- Java
Date: 2017-09-11T11:59:39+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/filter/accept
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812296942738
---

Servlet API のフィルターを使うと、特定のURLやサーブレットに対して前後処理を追加することができます。これから、フィルターの処理を追加する方法を書いていきます。


## 前提
この記事のサンプルを動かすには、以下の記事の資源（コードや環境）が必要になります。

[Servlet：リクエストの受信](/entry/java/servlet/request/accept)

必要に応じて参照して頂けると嬉しいです。


## 手順1. フィルターの作成
`Filter` インターフェイスを実装するクラスを作成します。

`ssjp/src/main/java/ssjp/filter/AcceptFilter.java`

```java
package ssjp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/req/accept")
public class AcceptFilter implements Filter {
  @Override public void doFilter(
    ServletRequest rq, ServletResponse rs, FilterChain fc)
  throws IOException, ServletException {
    System.out.println("Before servlet doGet.");
    fc.doFilter(rq, rs); // 次のフィルターorサーブレットに処理を渡す。
    System.out.println("After servlet doGet.");
  }
  @Override public void init(FilterConfig c) throws ServletException {}
  @Override public void destroy() {}
}
```

`@WebFilter` を付けて、`/req/accept` のリクエストに対して処理（`doFilter` メソッド）を実行するようにしています。今回は文字列を標準出力だけの処理です。


## 手順2. 確認
コンテナ（Jetty Plugin など）を起動して、ブラウザで `http://localhost:8080/req/accept` を開きます。

サーブレットが実行されて、標準出力に以下の文字列が表示されれば成功です。

```
Before servlet doGet.
Process Http Get.
After servlet doGet.
```

文字列 `Process Htttp ...` は、[Servlet：リクエストの受信](/entry/java/servlet/request/accept) で作成したサーブレットが出力しています。その前後にフィルターの処理が行われています。


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
