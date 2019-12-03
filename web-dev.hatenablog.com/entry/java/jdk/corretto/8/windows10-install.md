---
Title: Amazon JDK8：Win10 にインストール
Category:
- Java
Date: 2019-12-03T15:54:46+09:00
URL: https://web-dev.hatenablog.com/entry/java/jdk/corretto/8/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613475563908
---

Amazon JDK8（Corretto 8）を、Windows10 64bit にインストールする手順を書いていきます。

## 補足
Amazon Corretto 8 は無料で、最短でも 2023年6月まではアップデートされるようです。詳細は以下のリンク先を参照して頂ければと思います。

[https://aws.amazon.com/jp/corretto/faqs/:embed:cite]


無償利用の場合、Oracle の JDK は避けたほうが良いと思います。無料の JDK もあるみたいですが、アップデート期間が短かったりするみたいです。ライセンス体系も分かりづらい気がします。


## 手順1. インストーラのダウンロード
Corretto 8 の <a target="_blank" href="https://docs.aws.amazon.com/ja_jp/corretto/latest/corretto-8-ug/downloads-list.html">ダウンロードページ</a> を開きます。

それから、該当の msi をクリックして保存します。

[f:id:mamorums:20191203155217p:plain]


## 手順2. インストーラの実行
インストーラーをダブルクリックして、画面の指示通り進めていきます。

[f:id:mamorums:20191203155229p:plain]

デフォルトだと `C:\Program Files\Amazon Corretto` 配下にインストールされて、環境変数も設定してくれるようです。



## 手順3. 確認
コマンドプロンプトを開いて、

- 環境変数（`%JAVA_HOME%` と `%Path%`）
- コマンド実行（`java -version`）

を確認してみました。

```
>echo %JAVA_HOME%
C:\Program Files\Amazon Corretto\jdk1.8.0_232

>echo %Path%
C:\Program Files\Amazon Corretto\jdk1.8.0_232\bin;・・・省略・・・

>where java
C:\Program Files\Amazon Corretto\jdk1.8.0_232\bin\java.exe

>java -version
openjdk version "1.8.0_232"
OpenJDK Runtime Environment Corretto-8.232.09.1 (build 1.8.0_232-b09)
OpenJDK 64-Bit Server VM Corretto-8.232.09.1 (build 25.232-b09, mixed mode)
```
