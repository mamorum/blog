---
Title: lsFeed：3. フィードの閲覧
Category:
- lsFeed
Date: 2019-11-22T01:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/lsfeed/manual/reading-feeds
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613467116690
Draft: true
---

この記事は、lsFeed（フィードリーダー）のマニュアルです。今回は、フィードの閲覧方法を書いています。


## フィードの閲覧方法
lsFeed を起動すると、閲覧画面が表示されます。この画面で登録したフィードを読むことができます。

[f:id:mamorums:20191117121313p:plain]

アプリの起動方法、フィードの登録方法は、以下のリンク先に記載しています。

[https://web-dev.hatenablog.com/entry/lsfeed/manual/first-time:embed:cite]


## 閲覧画面の詳細
### 1. 歯車ボタン（ヘッダー左）
クリックすると、[設定画面](/entry/lsfeed/manual/setting-feeds) に遷移します。

### 2. サイドバー（左）
閲覧対象のフィードタイトルが表示されます。クリックすると、フィードの内容が右側に表示されます。

### 3. フィードの内容（右）
最新の見出しが最大８件表示されます。見出しをクリックすると、別のタブで記事（別サイトのページ）を開きます。

### 4. ナビゲーションボタン（右上下）
クリックすると、フィードの内容が切り替わります。

- `<`：前のフィード
- `>`：次のフィード

### 5. 電源ボタン（ヘッダー右）
アプリのプロセスを終了することができます。

※ 普段は電源ボタンを押さず、ブラウザのタブを閉じて頂ければ大丈夫です。lsFeed を起動すると、フィードを取得するためのプロセスが常駐します。プロセスは数MBの小さなもので、ブラウザでフィードを読んだり設定するときだけ動きます。
