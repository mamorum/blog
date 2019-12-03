---
Title: JDK：Win10の環境変数設定
Category:
- Java
Date: 2018-01-13T08:31:37+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/8/windows10-env-variables
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958053540311
---

環境変数 `JAVA_HOME` と `Path` を、Windows10 で設定する方法を書いていきます。


## 前提
Windows10 に JDK をインストールしていることが前提となります。インストール方法は、以下の記事を参照して頂けると嬉しいです。

- [JDK8 のインストール](/entry/java/jdk/8/windows10-install)


## 手順1. 環境変数の表示
エクスプローラの PC を右クリックして、プロパティを選択します。

[f:id:mamorums:20170609083040p:plain]

システムのウィンドウが表示されるので、システムの詳細設定をクリックします。

[f:id:mamorums:20170609083052p:plain]

詳細設定が表示されたら、環境変数をクリックします。

[f:id:mamorums:20170609083105p:plain]


## 手順2. JAVA_HOME の設定
環境変数のウィンドウで、新規ボタンを押して変数を追加します。

- 変数名：JAVA_HOME
- 変数値：JDK のインストール先（例：C:\opt\jdk1.8.0_131）

[f:id:mamorums:20170609083116p:plain]


## 手順3. Path の設定
システム環境変数で、既存の `Path` を選択して、編集ボタンを押します。

[f:id:mamorums:20170609083128p:plain]

編集ウィンドウが開くので、`%JAVA_HOME%\bin` を追加します。


## 手順4. 動作確認
コマンドプロンプトを起動して、`java -version` を実行します。

```
> java -version
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```

上のように、バージョンが表示されれば成功です。
