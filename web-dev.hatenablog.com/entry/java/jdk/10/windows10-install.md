---
Title: JDK10：Win10にインストール
Category:
- Java
Date: 2018-03-22T13:45:48+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/10/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971628220885
---

Oracle の JDK10（Java10）を、Windows10 64bit にインストールする手順を書いていきます。


## 補足. サポート期間について
Oracle の [Java SE サポート・ロードマップ](http://www.oracle.com/technetwork/jp/java/eol-135779-ja.html) によると、公式アップデートの期限は、

- JDK9 は 2018年3月 まで
- JDK10 は 2018年9月 まで

のようです（商用除く）。

JDK11（Java11）のリリースが 2018年9月 に予定されているので、11 が出たらすぐ切り替えることになりそうです。また、11 は LTS で サポート期間（公式アップデートの期限）が長くなりそうです。


## 手順1. ダウンロード
[Oracle のダウンロードページ](http://www.oracle.com/technetwork/java/javase/downloads/index.html) で、JDK10 のアイコンをクリックします。

[f:id:mamorums:20180322134515p:plain]

次のページに遷移したら、ラジオボタン `Accept License Agreement` をチェックします。

[f:id:mamorums:20180322134528p:plain]

それから Windows のリンクをクリックして、ファイルをローカルの任意の場所に保存します。


## 手順2. インストール
保存したインストーラを実行します。インストール画面の指示通りで大丈夫ですが、自分は設定を以下の通り変更してみました。

1. パブリックJRE：インストールしない
2. インストール先：C:\opt\jdk-10\

[f:id:mamorums:20180322134540p:plain]


## 手順3. 環境変数の設定
以下の通り、`JAVA_HOME` と `Path` の設定をしました。

| 操作    | 変数名             | 値                   |
|--------|------------------|------------------|
| 作成    | `JAVA_HOME` | `C:\opt\jdk-10` |
| 値追加 | `Path`       | `%JAVA_HOME%\bin` |

環境変数の設定方法は、以下の記事にもまとめています。

[JDK：Win10の環境変数設定](/entry/java/jdk/8/windows10-env-variables)


## 手順4. 確認
コマンドラインで `java -version` を実行してみました。

```
>java -version
java version "10" 2018-03-20
Java(TM) SE Runtime Environment 18.3 (build 10+46)
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10+46, mixed mode)
```
