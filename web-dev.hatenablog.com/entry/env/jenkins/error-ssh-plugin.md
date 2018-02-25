---
Title: Jenkins：SSH plugin のエラー対応
Category:
- 環境
Date: 2016-04-09T13:15:00+09:00
URL: http://web-dev.hatenablog.com/entry/env/jenkins/error-ssh-plugin
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178929944
---

Jenkins の SSH plugin を使ったところ、ビルド実行時にエラーが発生しました。そのときのエラー内容や対応方法を書いていきます。


## エラーになったビルド
エラーになったのは、「SSH plugin を使って、リモートホストでシェルを実行するビルド」です。


## エラー内容
実行したビルドが終了しませんでした。Jenkins のビルド履歴（下の画像）で、ずっと青丸が点滅していました。

![build-history](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813162957.png)

終了しないビルドは、手動で止めたりしました。


## エラー解析
ログ（コンソール出力）を見ると、SSH plugin のシェルを実行してから、処理が止まっているようでした。


## 対応方法
SSH リモートホストの設定で、Pty にチェックを入れました。

![setting-ssh-remote-host](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813162958.png)

SSH リモートホストの設定は、Jenkins のトップ画面から、Jenkins の管理 → システムの設定、の順で選択すると表示されます。

その後、ビルドは正常終了するようになりました。


## 原因
今のところ原因不明です・・・。
