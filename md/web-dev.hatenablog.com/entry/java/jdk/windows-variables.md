---
Title: JDK8：Win7の環境変数設定
Category:
- Java
Date: 2017-06-08T20:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/windows-variables
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178827384
---

環境変数 `JAVA_HOME`と `Path` を、Windows7 で設定する手順を書いています。Windows に JDK をインストールしたら、この変数を設定することが多いです。JDKのインストール記事は [こちら](/entry/java/jdk/windows-install) にあります。


## 手順1. 環境変数の表示
最初に環境変数（のウィンドウ）を表示します。

下の画像のように、エクスプローラのコンピューター上で右クリックして、プロパティを選択します。

![computer-property](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223135.png)

コントロールパネルが表示されたら、システムの詳細設定をクリックします。

![system-detail-setting](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223136.png)

下のように、詳細設定が表示されます。

![detail-setting](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223137.png)

ここで「環境変数」をクリックします。


## 手順2. JAVA_HOME の設定
環境変数のウィンドウで、システム環境変数の「新規」を押します。

![create-java-home](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223138.png)

新しいシステム変数（のウィンドウ）が表示されたら、次の文字列を入力して OK を押します。

- 変数名：JAVA_HOME
- 変数値：JDK のインストール先（例：C:\jdk1.8.0_71）


## 手順3. Path の設定
Path は既存の変数があります。システム環境変数で「Path」をクリックして、ボタン「編集」を押します。

![edit-path](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160812/20160812223139.png)

Path の変数値が表示されたら、その一番左に「%JAVA_HOME%\bin;」を追加します。

追加したら「OK」で画面を閉じていきます。


## 手順4. 動作確認
コマンドプロンプトを起動します（Windowsキー押下 → cmdと入力 → Enterキー押下）。

`java -version` を実行して、次のようにバージョンが表示されれば成功です。

```txt
> java -version
java version "1.8.0_71"
Java(TM) SE Runtime Environment (build 1.8.0_71-b15)
Java HotSpot(TM) 64-Bit Server VM (build 25.71-b15, mixed mode)
```
