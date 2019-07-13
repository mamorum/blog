---
Title: SpringBoot アプリ開発：2.環境準備
Category:
- Java
Date: 2016-06-23T22:05:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/env
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179181655
---

つぶやきアプリ（[こちら](/entry/spring-boot/dev-web-app/overview) のアプリ）を開発するために、必要な環境を準備していきます。以下に「インストール手順」と「ＤＢ設定手順」をまとめていきます。

## インストール手順
インストールが必要なプロダクト「JDK」「Gradle」「PostgreSQL」について、インストール手順（Windows向け）のリンクを掲載しておきます。既にインストールしている場合などは、飛ばして頂ければと思います。

- [JDK：Windowsにインストール](/entry/java/jdk/windows-install)
- [JDK：Windowsの環境変数設定](/entry/java/jdk/windows-variables)
- [Gradle：Windowsにインストール](/entry/gradle/windows-install)
- [PostgreSQL：Windowsにインストール](/entry/postgresql/windows/install)


## ＤＢ設定手順
事前に以下の設定（値）で、PostgreSQL のユーザとデータベースを作成しておきます。

- ユーザ・パスワード：spring
- データベース名：sbt

手順は、記事「[PostgreSQL：WindowsでユーザとDBを作成](/entry/postgresql/windows/create-user-db)」を参考にして頂けると嬉しいです。

※ 上の設定値（ＤＢの設定）は、設定ファイルを作成するときに使います。既存のデータベースやユーザを使う場合は、設定ファイルの内容を変えて頂ければ大丈夫です。


## 補足
Linux（CentOS）で開発する場合は、記事「[開発環境構築](/entry/etc/env/dev/table-of-contents)」に掲載している手順が参考になると思います。必要に応じて参照して頂けると嬉しいです。

