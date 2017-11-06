## 開発ブログ
### サーブレットの記事改善
- 前提変更（記事「リクエストの受信」を前提に）
  - リクエストパラメーターの取得
  - HTMLを返す
  - JSONを返す
  - セッションを使う
  - ファイルアップロード
  - 前後処理を追加
  - ServletContextListener：起動時の処理追加
  - HttpSessionListener：実行タイミング
  - ServletRequestListener：リクエストの前後処理
- サンプルコード改善
  - プロジェクト名を変更する（×ssjp）
- 記事削除（前提変更の完了後）
  - Servlet API：動作環境構築（Jetty Maven Plugin）
    -> http://web-dev.hatenablog.com/entry/java/servlet/env/jetty-maven-plugin    
- Listener記事の修正
  - 〇ServletContextListener
  - △HttpSessionListener
    -> SessionServlet を追加して動作確認
  - 〇ServletRequestListener

### Jettyの記事作成
- 組込Jetty：WebSocket -> ejws
  - WebSocketを使う（何回かに分けるか検討）
```

### ハードウェア
- イヤホン
  - Elecom
- マウス
  - 現在のマウス
  - 静音マウス
  - バッファロー
- SSD
  - trancend 本体
  - trancend 接続キット
- メモリ
  - crutial 4gb*2
- キーボード
  - バッファロー（売却品）
  - 各社のキー配列研究


## Java以外
- JavaScript
  - history api ?
  - local storage
- 中断：Java FX


## POML Blog の充実（余裕があれば）
- Ubuntu のソフトインストール方法（poml/doc/dev.md）
  - jdk8, maven
  - git, zip, unzip, nkf
