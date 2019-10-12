---
Title: Ubuntu：nkfのインストール
Category:
- Linux
Date: 2017-07-06T14:48:00+09:00
URL: https://web-dev.hatenablog.com/entry/linux/ubuntu/install-nkf
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812277282155
---

Ubuntu に nkf をインストールする方法を書いていきます。nkf を使うと文字コードを変換したり、改行コードを変換したりできます。

インストールの動作確認は、Vagrant Box の `ubuntu/trusty64` で行っています。


## 手順1. apt-get の実行
以下のコマンドでインストールします。

```
$ sudo apt-get install nkf
```


## 手順2. 確認
オプション `--version` でバージョンが表示されれば大丈夫です。

```
~$ nkf --version
Network Kanji Filter Version 2.1.3 ...
```

長い間使ってたんですが、ようやく nkf が何の頭文字なのか分かりました。日本人の方が作者のようです。すごいです。


## 使用例
改行コード LF のテキストを、CRLF に変換する例です。

```
$ nkf -Lw lf.txt > crlf.txt
```


## 参考文献
使い方などは、次のリンク先の記事を参考にさせて頂きました。

[文字コード変換コマンドの nkfの使い方と実例をまとめました。](http://takuya-1st.hatenablog.jp/entry/20100511/1273585953)
