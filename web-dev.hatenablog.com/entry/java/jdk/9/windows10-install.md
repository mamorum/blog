---
Title: JDK9：Win10にインストール
Category:
- Java
Date: 2017-11-29T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/9/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812321647660
---

JDK9（9.0.1）を Windows10 64bit にインストールする手順を書いていきます。

## 手順1. ダウンロード
[Oracle のダウンロードページ](http://www.oracle.com/technetwork/java/javase/downloads/index.html) で、JDK9 のアイコンをクリックします。

[f:id:mamorums:20171127213941p:plain]

次のページに遷移したら、ラジオボタン `Accept License Agreement` をチェックして、Windows のとこをクリックします。

[f:id:mamorums:20171127213950p:plain]

ファイルはローカルの適当なところに保存します。


## 手順2. インストール
インストーラをダブルクリックしてインストールを開始します。画面が表示されたら指示通り進んで大丈夫ですが、自分は設定を以下の通り変更してみました。

1. パブリックJRE：インストールしない
2. インストール先：C:\opt\jdk-9.0.1\

[f:id:mamorums:20171127214000p:plain]


## 手順3. 環境変数の設定
以下の通り、`JAVA_HOME` と `Path` の設定をしました。

| 操作    | 変数名             | 値                   |
|--------|------------------|------------------|
| 作成    | `JAVA_HOME` | `C:\opt\jdk-9.0.1` |
| 値追加 | `Path`       | `%JAVA_HOME%\bin` |


## 手順4. 確認
コマンドラインで `java -version` を実行してみました。

```
>java -version
java version "9.0.1"
Java(TM) SE Runtime Environment (build 9.0.1+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.1+11, mixed mode)
```


## 補足. 環境変数について
環境変数の設定方法は、以下の記事に書いたりしています。

[JDK8：Win10の環境変数設定](/entry/java/jdk/8/windows10-env-variables)

JDK8 の記事ですが、設定方法は変わらないので必要に応じて参照して頂けると嬉しいです。
