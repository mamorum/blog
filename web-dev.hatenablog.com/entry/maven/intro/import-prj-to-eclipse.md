---
Title: Maven入門：3.Eclipseにインポート
Category:
- Java
Date: 2017-06-27T10:00:06+09:00
URL: https://web-dev.hatenablog.com/entry/maven/intro/import-prj-to-eclipse
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812274393099
---

前回の記事「[2.エンコーディングとコンパイラの設定](/entry/maven/intro/encoding-and-javac-version)」で作成したプロジェクトを Eclipse にインポートして（取り込んで）みます。


## 補足
Eclipse のインストール方法などは、[こちら](/entry/maven/table-of-contents) に掲載しています。Eclipse を利用していない場合などは、読み飛ばして頂いても大丈夫です。


## 手順1. インポートウィザードの表示
既存の Maven プロジェクトをインポートするウィザードを表示します。

まずは、File メニューの Import... をクリックします。

[f:id:mamorums:20170627095925p:plain]

新しいウィンドウが表示されるので、`Existing Maven Projects` を選択して、Next ボタンをクリックします。

[f:id:mamorums:20170627095938p:plain]


## 手順2. インポートの実行
次の画面の Root Directory で、前回までに作成した `my-app` ディレクトリを選択します。

[f:id:mamorums:20170627095949p:plain]

Browse ボタンを押すと、ディレクトリを選択するウィンドウが表示されます。Projects の `pom.xml` にチェックが入ったことを確認して、Finish ボタンを押します。


## 手順3. 確認
パッケージエクスプローラに、`my-app` が表示されることを確認します。

[f:id:mamorums:20170627095959p:plain]

java は 1.8 で、junit も依存性に追加されています。
