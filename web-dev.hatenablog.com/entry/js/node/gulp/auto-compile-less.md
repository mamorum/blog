---
Title: gulp： less コンパイルの自動化
Category:
- JS/CSS/HTML
Date: 2015-05-22T13:12:47+09:00
URL: https://web-dev.hatenablog.com/entry/js/node/gulp/auto-compile-less
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178759774
---

[gulp](http://gulpjs.com/) は、Node.js の Stream API を使用したビルドシステムです。これから gulp を使って、less のコンパイルを自動化する手順を書いていきます。

## 前提
Node.js（と npm）がインストールされていること。

## ディレクトリ構成
今回の例は、sample というディレクトリ（プロジェクトのルート）を作成して、そこで作業しています。html, less, css などは、src ディレクトリ配下に置きます。

```txt
sample
　- node_modules
　- package.json
　- gulpfile.js
　- src
　  - *.html
　  - *.less
　  - *.css
```


## 手順1. gulp のインストール
※ 既にインストールしている場合は作業不要です。

次のコマンドで、gulp をグローバルでインストールします。

```txt
> npm install --global gulp-cli
```

今後、別プロジェクトで gulp を使う場合、この作業は省略できます。


## 手順2. package.json の作成
package.json は、プロジェクト情報や依存パッケージなどを管理するファイルです。次のコマンドで作成します。

```txt
> npm init
```

コマンドを実行すると対話形式になりますが、ひとまず全てデフォルト（何も入力せず Enter 押下）でも良いと思います。



## 手順3. パッケージのインストール
利用するパッケージをインストールします。

```txt
> npm install gulp --save-dev
> npm install gulp-less --save-dev
> npm install gulp-plumber --save-dev
```

`--save-dev` を付けているので、package.json に依存性が保存されます。


## 手順4. gulpfile.js の作成
gulpfile.js を作成して、次の内容を保存します。

```javascript
// パッケージの読み込み
var gulp = require('gulp');
var less = require('gulp-less');
var plumber = require("gulp-plumber");

// lessコンパイルタスク
gulp.task('less', function() {
  return gulp.src('src/*.less')  // src の less が対象。
    .pipe(plumber())  // エラーが発生しても止めない。
    .pipe(less()).pipe(gulp.dest('src'));  // css は src に出力。
});

// デフォルトタスク
// src の less が変更されたら、lessコンパイルタスクを実行。
gulp.task('default', function() {
  gulp.watch("src/*.less", ['less']);
});
```

## 手順5. gulp実行
次のコマンドで、デフォルトタスクを実行します。

```txt
> gulp
```

実行すると gulp が常駐して、less ファイルを変更するとコンパイルされます。

終了する場合は、`ctrl + c` を押します。
