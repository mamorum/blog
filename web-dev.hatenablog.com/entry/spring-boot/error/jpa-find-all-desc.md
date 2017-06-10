---
Title: SpringBoot：findAllOrderBy…Desc のエラー対応
Category:
- Spring Boot
Date: 2016-07-30T20:55:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/error/jpa-find-all-desc
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178787646
---

Spring JPA でリポジトリを作成したら、アプリ起動時にエラーが発生しました。今回はそのエラーと対応方法について書いていきます。


## リポジトリのコード
次のリポジトリを作成しました。

```java
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllOrderByIdDesc(Pageable page);
}
```


## エラー内容
Spring Boot の起動時に、次のエラーが出力されました。

```txt
org.springframework.context.ApplicationContextException: Unable to start embedded container; nested exception is org.springframework.boot.context.embedded.EmbeddedServletContainerException: Unable to start embedded Tomcat
（省略）
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'userRepository': Invocation of init method failed; nested exception is org.springframework.data.mapping.PropertyReferenceException: No property desc found for type long! Traversed path: User.id.
（省略）
    ... 100 more
```

`UserRepository` が作成できない、といった感じです。


## 原因
リポジトリで `findAllOrderBy…Desc` というメソッドを定義しているのが原因みたいです。


## 対応方法
メソッド名を次のように変更したら、エラーが発生しなくなりました。

```java
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByOrderByIdDesc(Pageable page);
}
```

`findAllBy…By…` で、少し違和感はあります。もっとちゃんとした解決方法があるのかもしれません。


## 参考文献
[Order By Date Desc with Spring Data - stackoverflow.com](http://stackoverflow.com/questions/19733464/order-by-date-desc-with-spring-data)
