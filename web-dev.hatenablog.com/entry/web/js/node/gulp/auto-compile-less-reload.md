---
Title: gulp：less コンパイルとブラウザ更新の自動化
Category:
- JS/CSS/HTML
Date: 2015-05-23T11:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/node/gulp/auto-compile-less-reload
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178901464
---

gulp を使って、less のコンパイルとブラウザ更新を自動化する手順を書いていきます。ブラウザ更新（リロード）には、[Browsersync](https://www.browsersync.io/) を使ってみようと思います。


## 前提
今回の記事は、[gulp： less コンパイルの自動化](/entry/js/node/gulp/auto-compile-less) の続きとして書いています。ディレクトリ構成や資源は、前回記事のものを使っています。


## 手順1. browser-sync のインストール
次のコマンドでインストールします。

```txt
> npm install browser-sync --save-dev
```


## 手順2. gulpfile.js の編集
前回作成した gulpfile.js に、内容を追加していきます。

```javascript
// パッケージの読み込み
var gulp = require('gulp');
var less = require('gulp-less');
var plumber = require("gulp-plumber");
var browserSync = require('browser-sync').create();

// lessコンパイルタスク
gulp.task('less', function() {
  return gulp.src('src/*.less')  // src の less が対象。
    .pipe(plumber())  // エラーが発生しても止めない。
    .pipe(less()).pipe(gulp.dest('src'))  // css は src に出力。
    .pipe(browserSync.stream());  // ブラウザ更新
});

// デフォルトタスク
gulp.task('default', ['less'], function() {
    browserSync.init({
        server: "./src"  // サーバ起動
    });
    // less が更新されたらコンパイル
    gulp.watch("src/*.less", ['less']);

    // html が更新されたらブラウザ更新
    gulp.watch("src/*.html").on('change', browserSync.reload);
});
```


## 手順3. gulp実行
デフォルトタスクとして実行します。

```txt
> gulp
```

実行すると、gulp が常駐してブラウザが起動します。less か html ファイルが変更されたら、ブラウザが自動で更新されます。

終了する場合は、`ctrl + c` を押します。
