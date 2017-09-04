---
Title: Servlet：リクエストの受信
Category:
- Java
Date: 2017-09-04T11:03:55+09:00
URL: http://web-dev.hatenablog.com/entry/java/servlet/request/accept
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812294837342
---

Java のサーブレットで、リクエストを受け付ける方法を書いていきます。


## 前提
記事内のコードを実行する場合、サーブレットの動作環境（コンテナ）が必要になります。環境がない場合は、下の記事などを参照して頂けると嬉しいです。

[Servlet：動作環境構築（Jetty Maven Plugin）](/entry/java/servlet/env/jetty-maven-plugin)


## 手順1. サーブレットの作成
HTTPメソッド `GET`, `POST`, `PUT`, `DELETE` を受信して、文字列を標準出力するサーブレットを作成します。

`ssjp/src/main/java/ssjp/servlet/AcceptServlet.java`

```java
package ssjp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/accept")
@SuppressWarnings("serial")
public class AcceptServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Get.");
  }
  public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Post.");
  }
  public void doPut(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Put.");
  }
  public void doDelete(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
  {
    System.out.println("Process Http Delete.");
  }
}
```

`@WebServlet` を付けて、`/req/accept` のリクエストを処理できるようにしています。


## 手順2. 確認
コンテナ（Jetty Plugin など）を起動して、ブラウザで `http://localhost:8080/req/accept` を開きます。

サーブレットが実行されて、標準出力に文字列 `Process Http Get.` が表示されれば成功です。


## 補足1. GET（doGet）以外の確認
ブラウザで URL直打ちすると `GET` メソッドになるため、サーブレットの `doGet` が実行されます。他のメソッドを確認する場合は、`curl` などを使うと便利です。

```
> curl -X POST http://localhost:8080/req/accept
```

上のコマンドだと、メソッドは `POST` になります。


## 補足2. サーブレットのメソッドについて
[サーブレット 3.1 の仕様書（PDF）](http://download.oracle.com/otn-pub/jcp/servlet-3_1-fr-spec/servlet-3_1-final.pdf) には、以下のように書かれています。

- 一般的に、開発者は `doGet` と `doPost` を実装することになる。
- `doPut`, `doDelete` を実装することで、HTTP 1.1 のクライアントをサポートすることができる。
- 他には `doHead`, `doOptions`, `doTrace` などがあり、それぞれ `HEAD`, `OPTIONN`, `TRACE` といった HTTP メソッドを受け付ける。
- サーブレットの `service` メソッドは全てのリクエストに対して実行される。`service` メソッドから、`doGet`, `doPost` などが呼び出される。


## コード
今回のコードは GitHub にも置いています。

[GitHub - ssjp](https://github.com/mamorum/blog/tree/master/code/servlet/ssjp)（※ Servlet Sample Jetty Plugin）
