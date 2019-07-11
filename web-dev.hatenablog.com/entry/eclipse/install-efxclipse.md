---
Title: Eclipse：e(fx)clipseのインストール
Category:
- Java
Date: 2017-03-19T12:39:46+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/install-efxclipse
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687228514690
---

Eclipse で JavaFX 開発をするために、[e(fx)clipse](https://www.eclipse.org/efxclipse/install.html) をインストールしてみました。これからその手順を書いてみようと思います。


## 前提
以下のソフトがインストールされていることが前提となります。

- JDK 1.8
- Eclipse（執筆時 Neon.2 = 4.6.2）

JDK と Eclipse のインストール方法は、以下のリンク先を参考にして頂けると嬉しいです。

- [Eclipse：インストール手順](/entry/eclipse/install)  
- [JDK：Windowsにインストール](/entry/java/jdk/windows-install)


## 手順1. インストール画面の起動
Eclipse を起動して、メニューの「Help → Install New Software」をクリックします。


## 手順2. リポジトリの追加
インストール画面が表示されたら、ボタン「Add」を押して、次のリポジトリを追加します。

- Name: e(fx)clipse
- Location: `http://download.eclipse.org/efxclipse/updates-released/2.4.0/site`

[f:id:mamorums:20170319123902p:plain]


## 手順3. インストールソフトの選択
インストール対象が表示されたら、`e(fx)clipse - IDE` にチェックを入れます。

[f:id:mamorums:20170319123913p:plain]


## 手順4. インストールの開始
上の画面で、ボタン「Next」を押してインストールを始めます。ライセンスの確認画面などが出てくるので指示通り進めます。

最後に、画面の指示通り Eclipse を再起動したら完了です。
