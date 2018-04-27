---
Title: GitHub：ユーザ invalid-email-address のコミット
Category:
- etc
Date: 2016-09-30T13:04:31+09:00
URL: https://web-dev.hatenablog.com/entry/etc/git/github/invalid-email-address-committed
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687187072463
---

普段使わない環境から GitHub に push したら、コミットしたユーザが [invalid-email-address](https://github.com/invalid-email-address) と表示されてしまいました。今回はその原因や対応方法をまとめていきます。


## invalid-email-address になる原因
`git config` で `user.email` を設定せずにコミットしたのが原因のようです。

push のときに `user.email` を設定していても、コミットしたときに設定しないとダメみたいです。


## 対応方法
次のコマンドで、`user.email` を設定してからコミットします。

```
git config --global user.email "your_email@example.com"
```

`--global` を付けると、全てのリポジトリに対して
有効になるみたいです。


## 確認方法
次のコマンドで、設定されている内容を確認できます。

```
git config --global user.email
```


## 補足１：ユーザ名の設定
あとは、ユーザ名 `user.name` も設定しておいたほうが良いみたいです。コマンドは次のような感じです。

```
git config --global user.name "John Doe"
```


## 補足２：Git を使い始めるとき
[Git のドキュメント](https://git-scm.com/book/ja/v1/%E4%BD%BF%E3%81%84%E5%A7%8B%E3%82%81%E3%82%8B-%E6%9C%80%E5%88%9D%E3%81%AEGit%E3%81%AE%E6%A7%8B%E6%88%90) には、Git を使い始めるときにユーザ名とメールアドレスを設定したほうが良いと書いてありました。

```
$ git config --global user.name "John Doe"
$ git config --global user.email johndoe@example.com
```

## 参考文献
[Setting your email in Git - GitHub Help](https://help.github.com/articles/setting-your-email-in-git/)
