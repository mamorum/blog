---
Title: GitHub：READMEのバッジが更新されない（Maven, TravisCI）
Category:
- etc
Date: 2018-07-27T10:44:43+09:00
URL: https://web-dev.hatenablog.com/entry/etc/git/github/readme-badges-are-not-updated
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132604979879
---

GitHub の README（のマークダウン）で、[Maven Badge](https://github.com/softwaremill/maven-badges) や Travis CI のバッジが更新されないことがありました。これからその詳細を書いていきます。


## 事象
Maven Central（Central Repository）に製品をリリースしても、Maven Badge のバージョン番号が最新になりませんでした。

下の画像の右側が Maven Badge で、Java のリポジトリだと README に掲載されていることが多いです。

[f:id:mamorums:20180727104326p:plain]

画像の左側は Travis CI のバッジで、こちらも（ビルド実行後に）最新にならないことがあるみたいです。


## 原因
GitHub が、README の画像をキャッシュしているのが原因みたいです。

詳細は以下のページに記載されていました。

- [About anonymized image URLs - GitHub Help](https://help.github.com/articles/about-anonymized-image-urls/)
- [GitHubのREADME上の画像キャッシュはPURGEリクエストで破棄させられる - Qiita](https://qiita.com/mpyw/items/16b693cb62820b480ce2)


※ 今回のキャッシュは、GitHub が利用しているプロダクト [Camo](https://github.com/atmos/camo) が関連しているみたいです。ブラウザのキャッシュをクリアしてもバッジは変わりませんでした。


## 対処方法１：PURGEリクエスト
上の文献（２つのリンク先）に記載されている方法なんですが、PURGEリクエストを送るとキャッシュが削除されて最新になるみたいです。

```
$ curl -X PURGE https://camo.githubusercontent.com/4d04・・・省略
{"status": "ok", "id": "216-8675309-1008701"}
```

上は curl でリクエストを送る例です。リクエストの宛先は GitHub の Camo で、URL は更新されない画像のものになります。

※ URL は Chrome のデベロッパーツールなどで確認できそうです。


## 対処方法２：リクエストパラメーターを変更
画像のURL（リクエストパラメーターなど） を変更して、キャッシュを最新にするやり方です。

例えば、

```
https://・・・/image.png?ver=1
```

で画像がキャッシュされているとします。

その後、キャッシュを無効にしたい（画像を最新にしたい）タイミングになったら、

```
https://・・・/image.png?ver=2
```

といったように、README の URLを変更して GitHub上のキャッシュを最新にします。

この方法は、

- [atom/markdown-preview Issue #207 - GitHub](https://github.com/atom/markdown-preview/issues/207)

に書かれていました。
