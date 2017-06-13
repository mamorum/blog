---
Title: Node.js のアップデート
Category:
- JavaScript
Date: 2016-08-05T08:21:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/node/update
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178917462
---

Windows 7 で node.js をアップデートする方法を書きます。


## アップデート方法
既存の node.js をアンインストールして、新しい node.js をインストールすれば大丈夫そうです。


## 手順1. アンインストール
コントロールパネルの「プログラムのアンインストールまたは変更」から、node.js をアンインストールします。


## 手順2. インストール
[公式サイト](https://nodejs.org/en/) から、インストーラをダウンロードして実行します。インストール場所は `C:\nodejs\` などにします。


## 手順3. バージョン確認
インストールしたら、コマンドプロンプトでバージョンが上がっていることを確認します。

```txt
>node -v
v5.1.1
```


## 手順4. npm のバージョン確認
こちらもコマンドプロンプトで確認します。

```txt
>npm view npm version
3.5.1
```

npm が古い場合は、次のコマンドでアップデートできるようです。

```txt
>npm update npm -g
```
