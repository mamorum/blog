---
Title: Ubuntu16：nkfのインストール
Category:
- OS
Date: 2018-06-20T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/linux/ubuntu16/install-nkf
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971655639868
---

Ubuntu16 に、nkf をインストールする方法を書いていきます。

※ 動作確認は、Windows にインストールした Ubuntu16（WSL：Windows Subsystem for Linux）で行っています。


## 1. インストール
apt を使ってインストールします。

```
$ sudo apt install nkf
```

最近は、apt-get より apt が推奨されているようです。


## 2. 確認
which コマンドと、nkf のオプション `--version` を確認しました。

```
$ which nkf
/usr/bin/nkf
```

```
$ nkf --version
Network Kanji Filter Version 2.1.3 (2013-11-22)
...
```
