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