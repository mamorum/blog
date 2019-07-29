---
Title: Unity：ゲームの起動が遅い（ZoneIdとウイルススキャン関連）
Category:
- Unity
Date: 2019-07-29T15:39:59+09:00
URL: https://web-dev.hatenablog.com/entry/unity/performance/slow-start-for-zoneid-and-scan
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613379345306
---

Unity で作成したスタンドアロンのプログラムをWebで配布すると、ゲームの起動が遅くなることがありました。これからその詳細と対応方法を書いていきます。

※ OS は Windows10 64bit を想定しています。


## 発生条件
ゲームの起動が遅くなる条件は以下の通りです。

- プログラムをZIPに固めてWebで公開
- ダウンロードしてローカルに保存
- ローカルで解凍と実行


## 原因
ダウンロードしたファイルに ZoneId が付与されていて、プログラムの実行時にウイルススキャンが走るのが原因のようです。

### ZoneId について
ダウンロードしたファイルのプロパティを開くと、セキュリティ欄に以下の表示があります。

[f:id:mamorums:20190729153656p:plain]

ZoneId が付与されてると表示されるみたいです。また、下の画像のように、ZoneId は解凍後のファイルにも引き継がれるようです。

[f:id:mamorums:20190729153706p:plain]

スタンドアロンのプログラムの場合、多くのファイル（dll等）に ZoneId が引き継がれて安全性が不明とマークされます。


### ウイルススキャンについて
解凍したフォルダを、OS のウイルススキャンから除外したところ、起動が速くなりました。上の ZoneId が付与されている場合、ウイルススキャンの対象になることがあるみたいです。


## 対応方法
ZoneId を削除してから、ZIPを解凍するようにします。ZIPの ZoneId を削除しておくと、解凍後のファイルに ZoneId が付かなくなります。

ZoneId 削除方法は、以下の記事にも書いています。

[https://web-dev.hatenablog.com/entry/windows/10/delete-zoneid:embed:cite]



