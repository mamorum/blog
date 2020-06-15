---
Title: lsFeed：無料のフィードリーダー
Category:
- lsFeed
Date: 2020-06-15T14:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/lsfeed/manual/table-of-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613464973575
---

lsFeed は、Windows PC用のシンプルなフィードリーダーです。

<a target="_blank" href="https://mamorum.github.io/lsFeed/Content/index.html">サンプル画面</a>
（※ 別のタブで開きます。）


## インストール（アップデート）
1. <a target="_blank" href="https://github.com/mamorum/lsFeed/releases">リリースページ</a> から Zip をダウンロードします。
2. Zip を解凍して `setup.bat` をダブルクリックします。
3. 画面表示後に「詳細情報」と「実行」をクリックします。

[f:id:mamorums:20191112154137p:plain]


## アプリの起動
インストール先（ユーザフォルダの `lsFeed`）を開いて、`lsFeed.exe` をダブルクリックで起動します。

```
例）
C:\Users\John（ユーザフォルダ）
C:\Users\John\lsFeed（インストール先）
```


## フィードの登録・閲覧
アプリが起動したら「歯車ボタン」を押して、

[f:id:mamorums:20200615150748p:plain]

「＋」ボタンを押します。

[f:id:mamorums:20200615150814p:plain]

下の登録ダイアログが開くので、

[f:id:mamorums:20191113090634p:plain]

フィードの情報を入力して「Add」ボタンを押します。

```
例）
・Title：Yahoo! 主要
・URL：https://news.yahoo.co.jp/pickup/rss.xml
```

登録できたら「<」ボタンで元の画面に戻ってフィードを閲覧します。


## フィードの設定
歯車ボタンを押した先の画面で、フィードの設定（編集・削除・並び替え）ができます。


## データ移行
アプリのデータ（設定）は、インストール先の `conf.json` に保存されています。このファイルを、移行先の同じ場所に保存すれば大丈夫です。


## アンインストール方法
アンインストールしたい場合は、インストール先のフォルダを削除します。
