---
Title: FluentLenium：Firefox 64bit でエラー
Category:
- Java
Date: 2016-01-07T10:15:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/test/fluentlenium/error-firefox64
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179059425
---

Firefox 64bit がインストールされた環境で、FluentLenium のテストがエラー（Selenium 関連のエラー）で終了しました。今回はその内容と対応方法を書きます。


## 環境・バージョン
- Windows 7
- Firefox 64bit 43.0.2
- FluentLenium 0.10.6
- Selenium 2.48.2
- JDK 8


## 事象
FluentLenium のテストを実行すると、Firefox が起動してフリーズしました（テスト対象の画面にも遷移しない）。

そして、だいぶ待つとテストがエラーで終了しました。


## 対応方法
Firefox 64bit をアンインストールして、Firefox 32bit をインストールしました。

その後、テストを実行すると、正常に動作して成功しました。


## エラーの詳細
テストがエラーで終了すると、コンソールにエラーの内容が出力されました。確かこんな感じでした。

```txt
org.openqa.selenium.firefox.NotConnectedException: Unable to connect to host 127.0.0.1 on port 7055 after 45000 ms. Firefox console output:
・・・省略・・・
at org.openqa.selenium.firefox.internal.NewProfileExtensionConnection.start(NewProfileExtensionConnection.java:118)
at org.openqa.selenium.firefox.FirefoxDriver.startClient(FirefoxDriver.java:246)
at org.openqa.selenium.remote.RemoteWebDriver.<init>(RemoteWebDriver.java:114)
・・・
```

## エラーの原因
原因不明です。もともと Firefox 32bit をインストールしていて、それから 64bit に変更したのが悪かったのかもしれません。

FluentLenium や Selenium のサイトで「Firefox 64bit に対応してない。」とは書かれてなかったです。
