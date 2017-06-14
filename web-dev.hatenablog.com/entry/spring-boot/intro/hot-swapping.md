---
Title: SpringBoot：Hot Swapping
Category:
- SpringBoot
Date: 2015-05-13T15:09:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/intro/hot-swapping
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179613077
---

Hot swapping とは、アプリ起動中にコードの変更を取り込んでくれる機能です。Hot reloading や Hot deploy と呼ばれることもあります。

今回は Spring Boot の Hot swapping について、spring-boot-devtool と、IDE のデバッグ起動のことを書いてみようと思います。


## spring-boot-devtool
Spring Boot 1.3 からは、spring-boot-devtool（Developer tools）と呼ばれるモジュールが追加されたみたいです。

[Developer tools - Spring Boot Reference](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools)

これを使うと、アプリケーションを自動で再起動してくれたり、LiveReload との連携が可能になったり、色々と便利になるみたいです。（すみません、自分はまだ使ってなかったりします。）


## IDE のデバッグ起動
Eclipse などの IDE で Spring Boot のアプリを起動すると、次のコードが Hot swapping されるようです。

- 静的ファイル（JS, CSS, 等）
- テンプレート（Thymeleaf, FreeMarker, 等）
- Java コード（※）

※ メソッドやクラスのシグネチャ変更は、Hot swapping されないようです。Hot swapping したい場合は、spring-boot-devtool を使うと良さそうです。

[Hot swapping - Spring Boot Reference](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-hotswapping)
