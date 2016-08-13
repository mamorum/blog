---
Title: gulp：ブラウザのリロード自動化２
Category:
- node.js
Date: 2016-07-13T12:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/node/gulp/reload-browser-2
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178919855
---

前回記事「[gulp：ブラウザのリロード自動化](/entry/js/node/gulp/reload-browser)」では、HTML や CSS が更新されたら、自動でブラウザをリロードする方法を書きました。今回は、コマンドライン引数で HTML を指定できるようにします。


## 前提
今回のコードを実行するには、前回記事の環境・コードが必要になります。必要に応じて参照して頂けると嬉しいです。


## 手順1. 関連パッケージのインストール
コマンドライン引数を解析するために、minimist をインストールしておきます。

```dos
> npm install --save-dev minimist
```

## 手順2. gulpfile.js の編集
前回作成した gulpfile.js を更新します。

`gulp-reload/gulpfile.js`

```javascript
var gulp = require('gulp');
var browserSync = require('browser-sync').create();

var argv = require('minimist')(process.argv.slice(2));
var file = argv.file ? argv.file : "index.html";
 
gulp.task('browser-sync', function() {
    browserSync.init({
        server: {
            baseDir: "src",
            index: file
        }
    });
});
 
gulp.task('bs-reload', function () {
・・・省略（前回と同じ）
```

コマンドラインで「`--file ファイル名`」が指定されているときは、ブラウザ起動時にそのファイルを読み込みます。指定されてないときは、index.html が対象になります。


## 手順3. HTML の作成
ディレクトリ src の中に HTMLを作成します。

`gulp-reload/src/hello.html`

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <p>Hello.</p>
</body>
</html>
```


## 手順4. gulp 実行
次のコマンドを実行するとブラウザが起動します。それから hello.html, style.css を更新すると、ブラウザが自動でリロードしてくれます。

```dos
> gulp --file hello.html
```

終了するには `ctrl + c` を押します。


## ソースコード
今回のコードは、GitHub にも置いています。

[ui/gulp-reload2 - GitHub](https://github.com/mamorum/blog/tree/master/code/ui/gulp-reload2)
