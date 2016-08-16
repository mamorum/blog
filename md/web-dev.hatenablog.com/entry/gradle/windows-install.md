---
Title: Gradle：Windowsにインストール
Category:
- Gradle
Date: 2016-05-14T12:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/gradle/windows-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179310396
---

Gradle を Windows にインストールする手順を書いていきます。記事を書くときは、Windows 7 の 64bit を使いました。


## 前提1. JDK のインストール
事前に JDK or JRE 6 以上をインストールしておきます。JDK のインストール手順は、次の記事を参照して頂けると嬉しいです。

- [JDK：Windowsにインストール](/entry/java/jdk/windows-install)
- [JDK：Windowsの環境変数設定](/entry/java/jdk/windows-variables) 


## 前提2. Groovy は不要
Groovy はインストールしなくて大丈夫です。Gradle に含まれているようです。


## 手順1. Gradle のダウンロード
[公式のダウンロードページ](http://gradle.org/gradle-download/) から、Binary only distribution を取得して、任意の場所に保存します。Complete distribution でも大丈夫だと思います。


## 手順2. 解凍
ダウンロードしたファイルを解凍します（解凍先は任意）。私は解凍した資源を `C:\gradle-2.10` に置いて、次のような構成にしました。

```
C:\>tree /f gradle-2.10
C:\GRADLE-2.10
│  changelog.txt
│  ・・・省略・・・
├─bin
│      gradle
│      gradle.bat
・・・省略・・・
```


## 手順3. PATH の設定
`C:\gradle-2.10\bin` を環境変数 PATH に追加します。


## 手順4. 動作確認
次のコマンドで、Gradle のバージョンを表示できれば大丈夫です。

```
C:\>gradle -v

------------------------------------------------------------
Gradle 2.10
------------------------------------------------------------

Build time:   2015-12-21 21:15:04 UTC
・・・省略・・・
```
