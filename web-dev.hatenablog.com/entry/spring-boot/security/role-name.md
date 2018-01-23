---
Title: SpringBoot：ロール名と認可の設定
Category:
- Spring
Date: 2015-06-03T01:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/security/role-name
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179338700
---

Spring Security のロール名について、プログラムの設定値とＤＢの設定値の違いをまとめてみました。

例として、管理者のロール `ROLE_ADMIN` を設定することにしています。


## プログラムの設定値（認可）
管理者のロールは、`ROLE_` を省略して `ADMIN` という文字列で設定します。

```java
@Override protected void configure(HttpSecurity http) throws Exception {

  http
    .authorizeRequests()
      .antMatchers("/html/**", "/css/**", "/js/**").permitAll()
      // ↓ ADMIN だけが、/admin 配下にアクセス可能。
      .antMatchers("/admin", "/admin/**").hasRole("ADMIN")
      .anyRequest().authenticated()
      .and()
      // 省略・・・
}
```

## ＤＢの設定値（認証情報）
管理者のロールは、`ROLE_ADMIN` で設定します。

```txt
> select username, authority from users;

   username    | authority
---------------+------------
 3@test.com    | ROLE_USER
 2@test.com    | ROLE_USER
 1@test.com    | ROLE_ADMIN
```


## プログラムの設定値について
Spring Security 4.0 から、プログラムは `.hasRole(String)` を 使って `ROLE_` を省略するようです。

下の例のように、`.access(String)` だとプレフィックスが必要になるみたいです。

```java
.antMatchers("/admin", "/admin/**").access("ROLE_ADMIN")	
```


## 参考文献
[Spring Security Reference](http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/)
