---
Title: Eclipse：Javaのコンパイルと実行
Category:
- eclipse
Date: 2016-02-01T17:42:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/compile-exec
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179038111
---

Eclipse で Java プログラムのコンパイルをして、実行をする手順を書きます。


## 手順1. Java プログラムの作成
### 手順1.1. プロジェクトの作成
Java のコードを書くために、Eclipse で「Java プロジェクト」を作成します。メニュー「ファイル」の「新規」から作成できます。

![create-java-project](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111118.png)

新しいウィンドウが開いたら、プロジェクト名（任意）を入力して「完了」を押します。

![input-project-name](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111119.png)

### 手順1.2. クラスの作成
プロジェクトができたら、プロジェクトを開いて「src」の上で右クリックして、クラスを作成します。

![create-class](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111120.png)

「新規」→「クラス」と選択します。

新しいウィンドウが開いたら、名前に「HelloWorld」と入力して、チェックボックス「public static void ・・・」にチェックを入れます。

![input-class-info](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111121.png)

「完了」を押してコードが生成されたら、`// TODO 自動生成・・・` を `System.out.println("Hello World");` に変更して保存します。

![coding](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111122.png)

これでプログラムは完成です。


## 手順2. コンパイル
Eclipse のデフォルト設定だと、コードを保存したときには、既にコンパイルされています。今回はコンパイル作業が不要です。


## 手順3. 実行
メニュー「実行」をクリックして、さらに「実行」を選択します。

![menu-run](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111123.png)

すると、コンソールに文字列が出力されます。

![output-cosole](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814111124.png)

