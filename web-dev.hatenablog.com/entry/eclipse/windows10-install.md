---
Title: Eclipse：Win10にインストール
Category:
- Eclipse
Date: 2017-06-11T20:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958054457803
---

Eclipse IDE for Java Developers の バージョン Neon.3 (4.6.3) を、Windows10 にインストールする手順を書いていきます。

## 前提
JDK がインストールされていることが前提となります。JDK のインストール方法は、以下の記事を参照して頂けると嬉しいです。

- [JDK8：Win10にインストール](/entry/java/jdk/8/windows10-install)
- [JDK8：Win10の環境変数設定](/entry/java/jdk/8/windows10-env-variables)


## 手順１. ZIPのダウンロード
[Eclipse のダウンロードページ](https://eclipse.org/downloads/eclipse-packages/) を開いて、対象のパッケージを表示します。

[f:id:mamorums:20170611120138p:plain]

右側のプラットフォームに応じたリンク（32bit or 64bit）をクリックします。

次のページに遷移したら、Downloadボタンを押して、ZIPファイルを任意の場所に保存します。


## 手順２. ZIPの解凍
ZIPファイルを解凍して、中身を任意の場所（今回は C:\opt\eclipse ）に配置します。

[f:id:mamorums:20170611120149p:plain]


## 手順３. メモリ設定（任意）
次の手順で、Eclipse の最少メモリサイズを１ＧＢに設定します。

1. `C\opt\eclipse\eclipse.ini` を開きます。
2. ファイル内の `-Xms256m` を `-Xms1024m` に変更して保存します。

Eclipse の使用中にメモリを拡張しなくなるので、動作速度が改善され（ると言われて）ます。


## 手順４. 動作確認
`C:\opt\eclipse\eclipse.exe` を実行して、画面が表示されれば成功です。Welcom（ようこそ）のビューは閉じて大丈夫です。
