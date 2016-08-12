---
Title: CentOS：yum と rpm、どっちを使うか？
Category:
- linux
Date: 2016-03-15T09:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/linux/centos/yum-rpm
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178816165
---

CentOS には、パッケージ管理のコマンドとして yum と rpm があります。ちょっと気になったので、yum と rpm のどちらを使ったほうが良いか調べました。


## 基本的には yum を使うと良さそう。
yum のほうが高機能で、次のような特徴があるそうです。

- yum は内部で rpm を使っている。
- yum は依存関係のあるパッケージを自動でインストールしてくれる。

## rpm は？
yum でインストールできないものは、rpm を使ってインストールすると良さそうです。


## 参考文献
[初心者の頃に知っておきたかった rpm と yum の違いと使い分け](http://blog.inouetakuya.info/entry/20111006/1317900802)
