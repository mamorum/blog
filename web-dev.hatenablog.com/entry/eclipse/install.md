---
Title: Eclipse：Win7にインストール
Category:
- Eclipse
Date: 2017-06-11T18:48:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179017803
---

Eclipse IDE for Java Developers の バージョン Mars (4.5.1) を、Windows7 にインストールする手順を書いていきます。Eclipse のバージョンが多少違っていても、同じ手順でインストールできると思います。

## 前提
JDK がインストールされていることが前提となります。JDK のインストール方法は、以下の記事を参照して頂けると嬉しいです。

- [JDK8：Win7にインストール](/entry/java/jdk/windows-install)
- [JDK8：Win7の環境変数設定](/entry/java/jdk/windows-variables)


## 手順１. ZIPのダウンロード
[Eclipse のページ](https://eclipse.org/downloads/) を開いて、対象のパッケージを表示します。

![page-eclipse-package](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814085100.png)

右側のプラットフォームに応じたリンク（32bit or 64bit）をクリックして、次のページに遷移します。

![page-download](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814085101.png)

ボタン「Download」を押して、ZIPファイルを任意の場所に保存します。


## 手順２. ZIPの解凍
ZIPファイルを解凍して、中身を任意の場所（今回は C:\eclipse ）に配置します。

![unzip-directory](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814085102.png?1471132319)


## 手順３. メモリ設定（任意）
次の手順で、Eclipse の最少メモリサイズを１ＧＢに設定します。

1. `C\eclipse\eclipse.ini` を開きます。
2. ファイル内の `-Xms256m` を `-Xms1024m` に変更して保存します。

Eclipse の使用中にメモリを拡張しなくなるので、動作速度が改善され（ると言われて）ます。


## 手順４. 動作確認
`C:\eclipse\eclipse.exe` を実行して、画面が表示されれば成功です。Welcom（ようこそ）のビューは閉じて大丈夫です。


