---
Title: Jetty：ホスト名がlocalhostだと遅い
Category:
- Java
Date: 2017-07-25T20:33:46+09:00
URL: http://web-dev.hatenablog.com/entry/jetty/embed/localhost-slow-from-win
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812282682438
---

Windows10 のブラウザから、ローカルの Jetty（`localhost:8080`）に接続すると時間がかかることがありました。そのときの設定内容などをまとめていこうと思います。

※ このとき使っていた Jetty のバージョンは `9.4.6.v20170531` です。


## 設定内容
Jetty の `ServerConnector` を使って、ホストを `localhost` に設定してました。

```java
HttpConfiguration conf = new HttpConfiguration();
ServerConnector http = new ServerConnector(
  svr, new HttpConnectionFactory(conf)
);
http.setHost("localhost");
```

組み込み Jetty の起動時ログは、設定どおり `localhost` になっていました。

```
INFO:oejs.AbstractConnector:main: Started ServerConnector@28864e92{HTTP/1.1,[http/1.1]}{localhost:8080}
```

## 接続時間
Chrome の Time は 400～450ms 程度でした。デベロッパーツールのネットワークで確認しました。

`http://localhost:8080/...` に接続すると、Waiting (TTFB) などで時間がかかっていました。FireFox だと「ブロック」や「待機」で時間がかかっていました。


## 対応
[Windowsでlocalhostへの接続が遅い(解決方法)](https://ah-2.com/2012/01/28/win_localhost_slow.html) を拝見させて頂き、`localhost` の設定をやめてみようと思いました。

`localhost` の設定なしで起動したログは以下のとおりです。

```
INFO:oejs.AbstractConnector:main: Started ServerConnector@28864e92{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
```

ホストは `0.0.0.0` になってそうでした。


## 対応後の接続時間
Chrome の Time は 120～150ms 程度になりました。


## 参考文献
[Windowsでlocalhostへの接続が遅い(解決方法)](https://ah-2.com/2012/01/28/win_localhost_slow.html)

