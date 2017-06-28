---
Title: HerokuToolbelt：CentOS にインストール
Category:
- 環境
Date: 2016-05-15T12:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/heroku/toolbelt/centos-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179194863
---

Heroku Toolbelt は、Herokuアプリを管理するためのツールです。この記事では、Heroku Toolbelt を CentOS にインストールする方法を書いていきます。

## 手順1. インストールコマンドの実行
[Heroku Toolbelt のサイト](https://toolbelt.heroku.com/) を開いて、Standalone をクリックします。

![page-heroku-toolbelt](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815144618.png)

Standalone の下にコマンドが表示されたら、それを root で実行します。執筆時に実行したコマンドは次の通りです。

```txt
# wget -O- https://toolbelt.heroku.com/install.sh | sh
```

## 手順2. パスの設定
次に、Heroku Toolbelt の利用ユーザで、環境変数のパスを設定します。vi 等で `~/.bash_profile`を開いて、次の内容を追加します（ファイル末尾で大丈夫です）。

```txt
export PATH=$PATH:/usr/local/heroku/bin    
```

これで Heroku Toolbelt（heroku コマンド）が使えるようになります。

## 補足. エラーが発生したら
Heroku Toolbelt の使用中にエラーが発生したら、Ruby のバージョンアップを試してみると良さそうです。自分の環境だと、OS の Ruby を 2.3.1 にしたらエラーが解消されました。

※ すみません、Ruby のバージョンアップ方法は省略させて頂きます。
