---
Title: WebSocket：Tomcatでエコーアプリを起動
Category:
- Java
Date: 2018-02-15T07:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/websocket/echo/deploy-tomcat
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971615018026
---

Java の WebSocket を使ったエコーアプリを、Tomcat に配備して起動してみようと思います。アプリの資源は、以下の記事で準備してきました。

- [エコーアプリのJava開発](/entry/java/websocket/echo/dev-java)
- [エコーアプリのUI開発](/entry/java/websocket/echo/dev-ui)

実際に配備する場合は、上の記事の資源が必要になります。


## 1. war の作成
事前にコマンドラインを開いて、プロジェクトのルートディレクトリに移動しておきます。それから、Maven を使って war を作成します。

```
ws-echo > mvn package
```

コマンドが成功すると、`target` ディレクトリ配下に `ws-echo.war`が作成されています。


## 2. Tomcat に配備
Tomcat をインストールしたディレクトリの下に、`webapps` というディレクトリがあると思います。そこに `ws-echo.war` をコピーします

※ ブログ執筆時は Tomcat 8.5.24 を使いました。


## 3. Tomcat を起動
Tomcat をインストールしたディレクトリの下に、`bin` というディレクトリがあると思います。そのディレクトリの `startup.bat`（Linux や Mac は `startup.sh`）で Tomcat を起動します。


## 動作確認
画面を使った動作確認は、次回の記事にまとめようかと思っています。
