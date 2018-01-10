---
Title: PostgreSQL 9.6：Win10 にインストール
Category:
- DB
Date: 2018-01-10T13:51:11+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/9.6/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812335812286
---

PostgreSQL9.6.x を Windows10 64bit にインストールする方法を書いていきます。


## 手順1. インストーラのダウンロード
[PostgreSQL の公式ページ](https://www.postgresql.org/download/windows/) で「Download the installer」をクリックします。

[f:id:mamorums:20180110134749p:plain]

遷移先の画面で、PostgreSQL のバージョンと OS を選択して「DOWNLOAD NOW」をクリックします。

[f:id:mamorums:20180110134806p:plain]


## 手順2. インストールの開始
ダウンロードした exe を実行します。実行するとインストール用のウィンドウが表示されるので、基本は「Next」ボタンを押して進めていきます。

インストール先を変更したい場合は、下の「手順3」を参考にして頂ければと思います。


## 手順3. インストール先の変更（任意）
自分はインストール先を「C:\opt\PostgreSQL\9.6」に変更しました。

[f:id:mamorums:20180110134818p:plain]

データの保存先は「C:\opt\PostgreSQL\9.6\data」にしました。


## 手順4. パスワード入力
スーパーユーザ（postgres）のパスワードの入力するように求められます。

[f:id:mamorums:20180110134830p:plain]

任意の値を２回入力して覚えておきます。


## 手順5. スタックビルダの起動確認
インストール画面の最後で、スタックビルダを起動するか聞かれます。

[f:id:mamorums:20180110134841p:plain]

必要なければチェックを外して「Finish」を押します。

スタックビルダを使うと、ODBC ドライバやツールなどをインストールすることができます。スタックビルダは、Windows のスタートメニューから起動できるので、迷ったらチェックを外して良いかと思います。


## 関連記事
[Windows：サービスを起動停止するバッチ](/entry/windows/bat-service-start-stop)

PostgreSQL（のサービス）を、使うときだけ起動する方法をまとめています。
