---
Title: Maven：テスト用設定ファイルの置き場所
Category:
- maven
Date: 2016-04-02T11:04:00+09:00
URL: http://web-dev.hatenablog.com/entry/maven/test-file
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178896107
---

以前、テスト用設定ファイル（プロパティファイル等）の置き場所を間違えて、Maven コマンドラインから実行したテストが失敗しました。今回はそのメモです。


## NG：src/test/java 配下
設定ファイルを `src/test/java` 配下に置くと、コンパイル先（`target` 配下）にコピーされませんでした。そのため、ファイルを読み込めずにテストが失敗しました。


## OK：src/test/resources 配下
設定ファイルを `src/test/resources` 配下に置くと、コンパイル先（`target` 配下）にコピーされました。そのため、テストで設定ファイルを読み込むことができました。


## 注意点
Eclipse のビルドとだと、`src/test/java` 配下の設定ファイルが、コンパイル先（`target` 配下）にコピーされました。Maven コマンドラインのビルドとは少し動作が異なっていました。
