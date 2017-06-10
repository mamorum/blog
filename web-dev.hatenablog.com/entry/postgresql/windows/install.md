---
Title: PostgreSQL：Windowsにインストール
Category:
- PostgreSQL
Date: 2016-03-23T12:05:00+09:00
URL: http://web-dev.hatenablog.com/entry/postgresql/windows/install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178953688
---

PostgreSQL（9.4 系）を、Windows にインストールする手順を書いていきます。


## 手順1. インストーラのダウンロード
[公式のダウンロードページ](http://www.postgresql.org/download/windows/) で、リンク「Download」をクリックします。

![download-page](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813194615.png)

リンク先に遷移したら、環境に応じたインストーラのボタン（下画像）を押してダウンロードします。私は「Version 9.4.6 Win x86-64（64bit 用）」をダウンロードしました。

![installer-page](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813194616.png)

ボタンを押すと画面が変わって、少ししてからダウンロードが始まります（保存先は任意）。


## 手順2.  インストールの開始
ダウンロードした EXE をダブルクリックして、インストール画面を起動します。

![install-window](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813194617.png)

画面が起動したら、基本的に Next ボタン押下で、指示通り進めていきます。


## 手順3. パスワード入力
インストール途中で、postgres ユーザのパスワードを入力するよう指示が出ます。任意の値（覚えておく）を２回入力して進めます。


## 手順4. スタックビルダをスキップ
最後にスタックビルダの画面が出たら、キャンセルを押してインストールを完了しますす。

![stackbuilder-window](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813194618.png)

ODBC ドライバなどをインストールしたい場合は、スタックビルダを使うと良いと思います。ここで画面を閉じても、Windows のスタートメニューから起動できます。


## 関連記事
PostgreSQL（のサービス）を、使うときだけ起動したい場合は、次の記事が参考になると思います。

[Windows：サービスを起動停止するバッチ](/entry/windows/bat-service-start-stop)
