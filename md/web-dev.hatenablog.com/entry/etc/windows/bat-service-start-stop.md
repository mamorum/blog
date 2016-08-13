---
Title: Windows：サービス起動バッチ・停止バッチ
Category:
- etc
Date: 2016-03-23T12:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/windows/bat-service-start-stop
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178928184
---

Windows のサービスを起動するバッチと、停止するバッチの作成手順を書きます。試しに、PostgreSQL のサービスを起動したり、停止したりしてみます。


## 手順1. サービス名の確認
Windows メニューの管理ツールで、サービスを選択します。

![menu-service](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813161603.png)

対象サービスのプロパティで、サービス名を確認します。

![service-postgresql](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813161604.png)

自分の端末だと、PostgreSQL のサービス名は「postgresql-x64-9.4」でした。


## 手順2. バッチファイルの作成
サービス起動バッチの内容は次の通りです。

```
net start postgresql-x64-9.4
```

停止バッチは次の通りです。

```
net stop postgresql-x64-9.4
```

コマンドを実行する行（net ... postgresql-x64-9.4 の行）は、最後に改行を入れます。ファイル名は任意で、拡張子は `.bat` で保存します。


## 手順3. 実行
バッチファイルを右クリックして「管理者として実行」すると、サービスを起動停止することができます。


## 補足
普段はサービスを停止しておいて、使うときだけ起動したい場合は、次のようにします。

- サービスのプロパティで、スタートアップの種類を「手動」にしておきます。
- サービスを利用する前に、起動バッチを「管理者として実行」します。

スタートアップを「手動」にすると、端末起動時にサービスが起動しなくなるので、事前に問題ないかを調べておきます。PostgreSQL のサービスは、使わないときに停止しておいても大丈夫です。


## 参考文献
[Tech TIPS：Windowsのnetコマンドの使い方 - ＠IT](http://www.atmarkit.co.jp/ait/articles/0211/23/news002.html)
