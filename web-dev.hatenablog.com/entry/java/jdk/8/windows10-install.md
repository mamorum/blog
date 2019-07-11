---
Title: JDK8：Win10にインストール
Category:
- Java
Date: 2018-01-13T11:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/jdk/8/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958053255929
---

JDK8（8u131）を Windows10 64bit にインストールする手順を書いていきます。


## 手順1. インストーラのダウンロード
Oracle の [ダウンロードページ](http://www.oracle.com/technetwork/java/javase/downloads/index.html) で、以下のダウンロードアイコンをクリックします。

[f:id:mamorums:20170608120925p:plain]

次のページに遷移したら、ラジオボタン `Accept License Agreement` をチェックして、`jdk-8u131-windows-x64.exe` をクリックしてローカルに保存します。

[f:id:mamorums:20170608120935p:plain]


## 手順2. インストーラの実行
指示通りインストールして大丈夫ですが、自分の場合は設定を２点変更しました。

1. パブリックJRE：インストールしない
2. インストール先：C:\opt\jdk1.8.0_131


JRE は JDK（開発ツール）に含まれているので、パブリックJRE はインストールしないことにしました。設定変更をした後の画面は以下の通りです。

[f:id:mamorums:20170608120948p:plain]


## 手順3. 環境変数の設定
以下の通り、`JAVA_HOME` と `Path` の設定をしました。

| 操作    | 変数名             | 値                             |
|--------|------------------|-----------------------|
| 作成    | `JAVA_HOME` | `C:\opt\jdk1.8.0_131` |
| 値追加 | `Path`             | `%JAVA_HOME%\bin` |

環境変数の設定方法は、以下の記事にもまとめています。

[JDK：Win10の環境変数設定](/entry/java/jdk/8/windows10-env-variables)


## 手順4. 確認
コマンド `java -version` を実行して、バージョンが表示されることを確認しました。

```
>java -version
```
