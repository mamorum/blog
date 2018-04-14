---
Title: Git：アカウント設定（初回利用時）
Category:
- 環境
Date: 2017-11-10T19:52:27+09:00
URL: https://web-dev.hatenablog.com/entry/env/git/set-account
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812316516680
---

Git のアカウント情報（ユーザ名とメールアドレス）を設定する方法を書いていきます。アカウント情報を設定しないで GitHub にコミットすると、[ユーザ が invalid-email-address](/entry/etc/github/invalid-email-address-committed) になったりするので、使用前に設定しておきたいところです。 


## 補足
この記事は、CUI の Git をインストールした環境向けです。GitHub Desktop などは、今回の記事の設定をしなくて大丈夫そうです。


## 設定方法
`git config --global` を使って、`user.name` と `user.email` 設定します。

```
$ git config --global user.name "John Doe"
$ git config --global user.email johndoe@example.com
```

GitHub に接続する場合は、GitHub のアカウント情報にしておけば大丈夫そうです。


## 設定の確認方法
確認したい項目まで入力して、Enter を押すと確認できます。

```
$ git config --global user.name
$ git config --global user.email
```


## 参考文献
[Git - First-Time Git Setup](https://git-scm.com/book/en/v2/Getting-Started-First-Time-Git-Setup)
