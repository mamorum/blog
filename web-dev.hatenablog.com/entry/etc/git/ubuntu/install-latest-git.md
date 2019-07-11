---
Title: Git：Ubuntu14に最新版をインストール
Category:
- etc
Date: 2017-11-15T06:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/git/ubuntu/install-latest-git
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812316416575
---

最新版の Git をビルドして、Ubuntu 14 にインストールする方法を書いていきます。動作確認は Vagrant Box の `ubuntu/trusty64` で行っています。

※ インストール方法は [Git のマニュアル](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) を参考にしました。


## 手順1. 事前準備
事前に root になって、作業するディレクトリ（例：`/opt`）に移動しておきます。

```
$ sudo su -
# cd /opt
```


## 手順2. ライブラリのインストール
最初にライブラリのインデックスを更新しておきます。

```
# apt-get update
```

Git をソースコードからビルドするために、依存するライブラリをインストールします。

```
# apt-get install dh-autoreconf libcurl4-gnutls-dev libexpat1-dev gettext libz-dev libssl-dev
```

それから、ドキュメント関連の依存性もインストールしておきます。

```
# apt-get install asciidoc xmlto docbook2x
```

Git のマニュアルだと、ここで `getopt` もインストールすることになってますが、エラーになったので省略してみました。

```
# apt-get install asciidoc xmlto docbook2x getopt
E: Unable to locate package getopt
```


## 手順4. ダウンロード
Git の資源は、以下のどちらからでもダウンロードできるみたいです。

- [https://www.kernel.org/pub/software/scm/git/](https://www.kernel.org/pub/software/scm/git/)
- [https://github.com/git/git/releases](https://github.com/git/git/releases)

インストールしたい git（のバージョン）の URL を控えて、wget で取得します。

```
# wget https://www.kernel.org/pub/software/scm/git/git-2.14.2.tar.gz
```

今回は v2.14.2 のソースコードをダウンロードしてみました。


## 手順5. 解凍・インストール
ダウンロードしたファイルを解凍してインストールします。

```
# tar -zxf git-2.14.2.tar.gz
# cd git-2.14.2
# make configure
# ./configure --prefix=/usr
# make all doc info
# make install install-doc install-html install-info
```

インストールが完了したら、動作確認のためバージョンを表示してみます。

```
# git --version
git version 2.14.2
```

## 補足1. アカウント設定について
Git を利用する前には、アカウント情報を設定しておいたほうが良さそうです。設定方法は以下のリンク先にも書いています。

[Git：アカウント設定（初回利用時）](/entry/etc/git/set-account)


## 補足2. アップデートについて
Git をインストールすると、git コマンドで最新の Git資源を取得できるようになります。

```
# cd /opt
# git clone git://git.kernel.org/pub/scm/git/git.git
```

取得した資源をビルドするとアップデートされます。

```
# cd git
# make configure
# ./configure --prefix=/usr
# make all doc info
# make install install-doc install-html install-info
```

バージョンを表示させて確認します。

```
# git --version
git version 2.15.0.124.g7668cbc60
```
