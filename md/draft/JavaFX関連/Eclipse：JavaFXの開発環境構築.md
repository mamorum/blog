eclipse/install-efxclipse

[e(fx)clipse](https://www.eclipse.org/efxclipse/install.html) を Eclipse にインストールして、 JavaFX の開発境を準備してみました。これからその手順を書いてみようと思います。


## 前提
以下のソフトがインストールされていることが前提となります。

- JDK 1.8
- Eclipse（執筆時 Neon.2 = 4.6.2）

JDK と Eclipse のインストール方法は、以下のリンク先を参考にして頂けると嬉しいです。

- [Eclipse：インストール手順](/entry/eclipse/install)（バージョンは Mars）
- [JDK：Windowsにインストール](/entry/java/jdk/windows-install)


## 手順1. インストール画面の起動
Eclipse を起動して、メニューの「Help → Install New Software」をクリックします。


## 手順2. リポジトリの追加
インストール画面が表示されたら、ボタン「Add」を押して、次のリポジトリを追加します。

- Name: e(fx)clipse
- Location: http://download.eclipse.org/efxclipse/updates-released/2.4.0/site

add.png


## 手順3. インストールソフトの選択
インストール対象が表示されたら、`e(fx)clipse - IDE` にチェックを入れます。

install.png


## 手順4. インストールの開始
上の画面で、ボタン「Next」を押してインストールを始めます。ライセンスの確認画面などが出てくるので指示通り進めます。

最後に、画面の指示通り Eclipse を再起動したら完了です。


