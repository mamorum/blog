---
Title: lsFeed：4. フィードの設定
Category:
- lsFeed
Date: 2019-11-23T00:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/lsfeed/manual/setting-feeds
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613467237954
Draft: true
---

この記事は、lsFeed（フィードリーダー）のマニュアルです。今回は、閲覧するフィードの設定方法を書いていきます。

アプリを初めて利用する際は、先に以下のリンク先を参照して頂ければと思います。

[https://web-dev.hatenablog.com/entry/lsfeed/manual/first-time:embed:cite]


## フィードの設定方法
設定画面に遷移すると、フィードの設定ができます。

[f:id:mamorums:20191117165307p:plain]

具体的には、フィードの、

- 追加
- 削除
- 編集
- 並び替え

をすることができます。


## 設定画面の詳細
### 1. 戻るボタン（ヘッダー左）
`<` をクリックすると、[閲覧画面](/entry/lsfeed/manual/reading-feeds) に戻ります。

### 2. プラスボタン（ヘッダー左）
閲覧するフィードを追加できます。

### 3. フィードの一覧（中心）
閲覧対象のフィードタイトルが表示されて、

- ゴミ箱：クリックで削除
- 鉛筆：クリックで編集
- バー：ドラッグ＆ドロップで並び替え

アイコンで上記の操作ができます。


## 設定画面の仕様
設定は後勝ちです。

複数の画面（タブなど）で設定を変えると、最後の設定が有効になります。
