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


## Java以外
- JavaScript
  - history api ?
  - local storage
- 中断：Java FX


## POML Blog の充実（余裕があれば）
- Ubuntu のソフトインストール方法（poml/doc/dev.md）
  - jdk8, maven
  - git, zip, unzip, nkf
