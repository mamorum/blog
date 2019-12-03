---
Title: Oracle JDK9：Win10にインストール
Date: 2018-01-13T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/9/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613475489644
---

Oracle JDK9（9.0.1）を Windows10 64bit にインストールする手順を書いていきます。

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

環境変数の設定方法は、以下の記事にもまとめています。

[JDK：Win10の環境変数設定](/entry/java/jdk/8/windows10-env-variables)


## 手順4. 確認
コマンドラインで `java -version` を実行してみました。

```
>java -version
java version "9.0.1"
Java(TM) SE Runtime Environment (build 9.0.1+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.1+11, mixed mode)
```
