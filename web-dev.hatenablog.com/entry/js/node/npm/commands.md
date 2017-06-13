---
Title: npm コマンドのメモ
Category:
- JavaScript
Date: 2016-08-12T09:55:33+09:00
URL: http://web-dev.hatenablog.com/entry/js/node/npm/commands
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178738637
---

最近よく使う npm のコマンドと、その処理内容を書いていこうと思います。

## init
```txt
> npm init
```

- プロジェクト情報の入力を対話形式で始める。
- 入力した情報は `package.json` に保存される。


## install パッケージ名
### --save
```txt
> npm install --save パッケージ名
```

- アプリ実行時に必要となるパッケージをインストールする。
- パッケージの情報は、`package.json` の `dependencies` に保存される。
- 実行時のパッケージとしては、フレームワーク（express, etc） などがあげられる。

### --save-dev 
```txt
> npm install --save-dev パッケージ名
```

- 開発時に必要となるパッケージをインストールする。
- パッケージの情報は、`package.json` の `devDependencies` に保存される。
- 開発時のパッケージとしては、テスト用のライブラリや、コンパイラ（sass, less, etc）などがあげられる。

### -g（--global）
```txt
> npm install -g パッケージ名
```

- 色々なプロジェクトで使うパッケージをインストールする。
- インストールしたパッケージは、PATH が通ってコマンドとして使えるようになる。
- ビルドシステムの [gulp-cli](https://www.npmjs.com/package/gulp-cli) などは、グローバルでインストールする。
- インストールは１回で大丈夫だが、プロジェクト単位でもインストールが必要なパッケージもある。（例:
gulp の場合は `> npm install --save-dev gulp` も必要。）


## install
```txt
> npm install
```
- `package.json` の内容（`dependencies`, `devDependencies`）に従って、依存するパッケージをインストールする。


## install の補足
- インストールしたパッケージは、`node_modules` ディレクトリ に追加される。
- `node_modules` 配下は、バージョン管理対象外にすると良さそう。
- `node_modules` はファイルが多すぎるのと、`package.json` があれば再インストール（`> npm install`）できるため。
