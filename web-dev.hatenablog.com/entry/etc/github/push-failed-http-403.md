---
Title: GitHub：push で 403 エラー
Category:
- etc
Date: 2016-10-02T13:06:50+09:00
URL: http://web-dev.hatenablog.com/entry/etc/github/push-failed-http-403
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687187383744
---

CentOS から GitHub に push（`git push`）したら、403 エラーが発生しました。今回はそのエラー内容や原因、対応方法をまとめていきます。


## エラー内容
GitHub から https で clone したリポジトリ（の資源）を更新して、`git push` を実行したら、次のエラーが出力されました。

```
Error: The requested URL returned error: 403 while accessing
https://github.com/mamorum/poml.git/info/refs
```

## 原因
古い Git（バージョン 1.7.1）を使っていたのが原因のようでした。

[GitHub のドキュメント](https://help.github.com/articles/https-cloning-errors/) によると、1.7.10 以上だと GitHub のクライアントとして安定するみたいです。

※ git config の `user.name`, `user.email` はちゃんと設定できてたので、そっちは問題なさそうでした。


## 対応方法
新しい Git のソースをコンパイルしてインストールしました。すると、`git push` でエラーが発生しなくなりました。

自分が使っている CentOS の yum だと、古いバージョンの Git がインストールされるみたいでした。そのため、yum でインストールされた Git を削除して、マニュアルでインストールしました。


## 参考文献
Git のインストール方法は、次の記事を参考にさせて頂きました。

[CentOSに最新版のGitをインストール・アップデートする方法 - TASK NOTES](http://www.task-notes.com/entry/20150622/1434942000)
