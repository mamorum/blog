---
Title: Poml：インストール方法
Category:
- Java
Date: 2018-01-12T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/java/poml/doc/installation-guide
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812336207732
---

[Poml](https://github.com/mamorum/poml) は、Maven のプロジェクト定義 `pom.xml` をシンプルに書くためのツールです。これから、Poml のインストール方法を書いていきます。


## 1. 必須環境
JDK8 以上がインストールされていて、

- Windows: Path に `%JAVA_HOME%\bin` を追加していること
- Linux: PATH に `$JAVA_HOME/bin` を追加していること

が必要になります。

### 1.1. 確認方法
フルパス指定なしで、java コマンドが実行できれば大丈夫です。

```
$ java -version
java version "1.8.0_...
```


## 2. Windows のインストール方法
### 2.1. ダウンロード
[リリースページ](https://github.com/mamorum/poml/releases) から ZIPファイルをダウンロードします。

例）ファイル名：`poml-1.1.0.zip`

### 2.2. 解凍
ダウンロードしたファイルを任意の場所に解凍します。

例）解凍先：`C:\opt`

### 2.3. Path の更新
環境変数 Path に、解凍したフォルダのパスを追加します。

例）パス：`C:\opt\poml-1.1.0`


## 3. Linux のインストール方法
### 3.1. ダウンロード
任意のインストール先ディレクトリに移動して、[リリースページ](https://github.com/mamorum/poml/releases) から圧縮ファイル（例：`poml-1.1.0.tar.gz`）をダウンロードします。

```
# cd /opt
# wget https://github.com/mamorum/poml/releases/download/v1.1.0/poml-1.1.0.tar.gz
```

### 3.2. 解凍
ダウンロードしたファイルを解凍します。

```
# tar zxvf poml-1.1.0.tar.gz
```

### 3.3. PATH の更新
環境変数 PATH に、解凍したディレクトリを追加します。

```
$ export PATH=$PATH:/opt/poml-1.1.0
```

上のような `export` コマンドを、`~/.bashrc` などに書いておくと便利だと思います。


## 4. 動作確認
以下のコマンドでバージョンを確認できます。

```
> poml -v
1.1.0
```
