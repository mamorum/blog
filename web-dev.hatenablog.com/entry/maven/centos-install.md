---
Title: Maven：CentOSにインストール
Category:
- Java
Date: 2016-04-01T18:04:00+09:00
URL: https://web-dev.hatenablog.com/entry/maven/centos-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178885558
---

Maven を CentOS にインストールする手順を書いていきます。手順は、[JDK がインストール](/entry/java/jdk/centos-install) されていることが前提となります。


## 手順1. ダウンロード
root でインストール先（例：`/opt`）に移動します。それから、`wget` でダウンロードします。

```
# cd /opt
# wget http://ftp.riken.jp/net/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
```

`wget` の引数（ダウンロードURL）は、[Maven ダウンロードページ](https://maven.apache.org/download.cgi) で確認できます。


## 手順2. 解凍
ダウンロードした圧縮ファイルを解凍します。

```
# tar xzvf apache-maven-3.3.9-bin.tar.gz
```

解凍が終わったら、圧縮ファイルは削除しても大丈夫です。

```
# rm apache-maven-3.3.9-bin.tar.gz
```


## 手順3. .bash_profile の編集
Maven を使うユーザになって、vi 等で `~/.bash_profile` を開きます。それから、ファイル末尾に次の設定を追加します。

`追加`

```
export JAVA_HOME=/usr/java/jdk1.8.0_77
export PATH=$PATH:/opt/apache-maven-3.3.9/bin
```

`JAVA_HOME` は、環境に応じた値を設定します（設定済みなら不要）。


## 手順4. 環境変数の反映
次のコマンドで、追加した環境変数を読み込みます。

```
$ source ~/.bash_profile
```

次回ログイン時は、自動で反映されます。


## 手順5. 確認
次のコマンドを実行して、Maven のバージョンが表示されれば大丈夫です。

```
$ mvn --version
Apache Maven 3.3.9 ・・・
```
