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
    browserSync.reload();
});
 
// src 配下の *.html, *.css ファイルが変更されたリロード。
gulp.task('default', ['browser-sync'], function () {
    gulp.watch("src/*.html", ['bs-reload']);
    gulp.watch("src/*.css", ['bs-reload']);
});