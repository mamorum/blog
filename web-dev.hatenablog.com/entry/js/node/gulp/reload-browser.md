---
Title: gulp：ブラウザのリロード自動化
Category:
- Node.js
Date: 2016-07-13T10:20:00+09:00
URL: http://web-dev.hatenablog.com/entry/js/node/gulp/reload-browser
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178919757
---

HTML や CSS が更新されたら、自動でブラウザをリロードする方法を書きます。今回は、Node.js のパッケージ Gulp を使ってみます。


## 環境
次のプロダクトがインストールされている必要があります。

- Node.js
- Gulp（グローバル）

Gulp（グローバル）は、Node.js のインストール後、`> npm install -g gulp-cli` でインストールできます。


## 手順1. 関連パッケージのインストール
任意のディレクトリ（例：gulp-reload）で作業していきます。まずは、次のコマンドで package.json を作成します。

```dos
gulp-reload > npm init
  -> 実行すると対話形式になります。
  -> 今回は全て Enter でも大丈夫です。
```

次に、gulp と browser-sync をインストールします。

```dos
gulp-reload > npm install --save-dev gulp
gulp-reload > npm install --save-dev browser-sync 
```

## 手順2. gulpfile.js の作成
Gulp はビルドシステムで、gulpfile.js にタスクを書くようです。今回は、リロード用のタスクを書いていきます。

`gulp-reload/gulpfile.js`

```javascript
var gulp = require('gulp');
var browserSync = require('browser-sync').create();
 
gulp.task('browser-sync', function() {
    browserSync.init({
        server: {
            baseDir: "src",
            index: "index.html"
        }
    });
});
 
gulp.task('bs-reload', function () {
    browserSync.reload();
});
 
// src 配下の *.html, *.css ファイルが変更されたリロード。
gulp.task('default', ['browser-sync'], function () {
    gulp.watch("src/*.html", ['bs-reload']);
    gulp.watch("src/*.css", ['bs-reload']);
});
```


## 手順3. HTML, CSS の作成
ディレクトリ src を作成して、その中に HTML と CSS を作成します。

`gulp-reload/src/index.html`

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <p>Hello gulp reload.</p>
</body>
</html>
```

`gulp-reload/src/style.css`

```css
p {
  color: red;
}
```


## 手順4. gulp 実行
次のコマンドを実行するとブラウザが起動します。それから index.html, style.css を更新すると、ブラウザが自動でリロードしてくれます。

```
gulp-reload > gulp
```

終了するには `ctrl + c` を押します。


## 補足
ブラウザ起動時の HTML を変えたい場合は「[gulp：ブラウザのリロード自動化２](/entry/js/node/gulp/reload-browser-2)」を参照して頂けると嬉しいです。


## ソースコード
今回のコードは、GitHub にも置いています。

[ui/gulp-reload - GitHub](https://github.com/mamorum/blog/tree/master/code/ui/gulp-reload)
