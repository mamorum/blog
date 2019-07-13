---
Title: SpringBoot：View のロール判定
Category:
- Java
Date: 2015-06-06T00:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/security/role-judgment-in-view
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179340970
---

Spring Boot（Spring Web, MVC）では、色んなテンプレートエンジンを選択することができます。今回は、JSP, FreeMarker, Velocity について、ロール判定の観点からまとめてみました。


## JSP：ロール判定可能
JSP は、サーブレットAPI を使えば、ロール判定ができます。Spring Security のドキュメントにも、次の処理を使うと便利だと書いてありました。

```
boolean isAdmin = httpServletRequest.isUserInRole("ADMIN");
```

ただ、Spring Boot だと JSP は使わないほうが良いみたいです。  
参考文献：[Spring Boot Reference Guide](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-template-engines)


## FreeMarker, Velocity：ロール判定不可能
テンプレートで HttpServletRequest が取れず、ロール判定ができませんでした（2015.06.06 ブログ執筆時）。
