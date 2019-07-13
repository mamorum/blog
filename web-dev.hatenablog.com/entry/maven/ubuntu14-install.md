---
Title: Maven：Ubuntu14にインストール
Category:
- Java
Date: 2017-07-05T08:18:50+09:00
URL: https://web-dev.hatenablog.com/entry/maven/ubuntu14-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812276889148
---

Maven 3.5.0 を、Ubuntu 14.04 LTS（Trusty Tahr）にインストールする手順を書いていきます。動作確認は、Vagrant Box の ubuntu/trusty64 で行っています。 


## 前提
[JDK をインストール](/entry/java/jdk/ubuntu-install) していることが前提となります。


## 手順1. ダウンロード
事前に root になって、インストール先（例：`opt`）に移動します。それから `wget` で Maven をダウンロードします。

```
$ sudo su -
# cd /opt
# wget http://ftp.jaist.ac.jp/pub/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz
```

ダウンロードURLは、Maven の [ダウンロードページ](https://maven.apache.org/download.cgi) で確認できます。今回は「Binary tar.gz archive」をダウンロードしています。


## 手順2. 解凍
root でダウンロードしたファイルを解凍します。

```
# tar zxvf apache-maven-3.5.0-bin.tar.gz
```

解凍したら、ダウンロードした圧縮ファイルは削除しても大丈夫です。

```
#  rm apache-maven-3.5.0-bin.tar.gz
```


## 手順3. 環境変数の設定
Maven を使うユーザで、`~/.bashrc` を編集します。

```
$ vi ~/.bashrc
```

ファイル末尾に次の行を追加します。

```
export PATH=$PATH:/opt/apache-maven-3.5.0/bin
```

※ `.profile` でも大丈夫だと思います。


## 手順4. 環境変数の反映
次のコマンドで環境変数を反映します。

```
$ source ~/.bashrc
```

再ログインしても反映されます。


## 手順5. 確認
`mvn` コマンドを実行して、バージョンが表示されることを確認しました。

```
$ mvn -v
Apache Maven 3.5.0 ...
```
