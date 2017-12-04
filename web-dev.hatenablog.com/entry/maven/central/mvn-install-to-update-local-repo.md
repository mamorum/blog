---
Title: Maven：mvn install でローカルリポジトリを更新
Category:
- Maven
Date: 2017-12-07T05:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/maven/central/mvn-install-to-update-local-repo
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812322137699
Draft: true
---

Maven プロジェクトをビルドして、ローカルリポジトリの資源（jar など）を更新する方法を書いていきます。


## 方法
プロジェクトのルートディレクトリで、以下のコマンドを実行します。

```
mvn install
```

Windows の場合、デフォルトだと `C:\Users\{ユーザ名}\.m2\repository` 配下の資源が更新されると思います。更新した資源は、ローカルの他のプロジェクトから参照できるようになります。


## 背景
オープンソース（jar）の動作確認をするために、いつも SNAPSHOT をつくってリモートリポジトリ（[OSSRH のスナップショットリポジトリ](https://oss.sonatype.org/content/repositories/snapshots)）に送ってました。それをサンプルアプリ（他のプロジェクト）に取り込んで動作確認する感じです。

ただ、自分だけが一時的に使用するものなので、いつも申し訳ないなと思ってました。そこで、ローカルリポジトリだけにリリースする方法を探していました。
