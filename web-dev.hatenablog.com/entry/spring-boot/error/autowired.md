---
Title: SpringBoot：@Autowired のエラー対応
Category:
- Java
Date: 2016-07-28T12:40:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/error/autowired
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178774603
---

`@Autowired` の使い方を間違えて、エラーを発生させてしまったことがあります。そのときのエラー内容と対応方法について書いていこうと思います。


## エラーが発生したコード
### コントローラ
プロパティにサービスクラスを DI したくて、`@Autowired` を付けていました。

```java
@Controller
public class CustomerController extends WebMvcAutoConfigurationAdapter {

    @Autowired CustomerService cs;
    
（以下省略）
}
```

### サービスクラス
アノテーションを付けずに実装していました。

```java
public class CustomerService {

（以下省略）
}
```

## エラー内容
アプリ起動時に、サービスクラスが定義されていない、といったエラーが発生しました。スタックトレース（の一部）は次の通りです。

```txt
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [hello.service.CustomerService] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1301)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1047)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:942)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:533)
	... 99 more	
```


## エラー原因
サービスクラスに、アノテーション `@Service` を付けていないのが原因でした。アノテーションを付けないと、Spring Boot がサービスクラスを管理しないようです。


## 対応方法
サービスクラスにアノテーション `@Service` を付けました。

```java
@Service
public class CustomerService {

（以下省略）
}
```

これで、サービスクラスが Spring Boot に管理されて、DI されるようになります。


## 補足1. @Component について
`@Component` でも、Spring Boot が管理してくれるようです。サービスクラスじゃない場合に使えそうです。


## 補足2. リポジトリの DI について
リポジトリクラスは、アノテーションを付けなくても大丈夫です。`CrudRepository` などを継承していると、Spring Boot が管理してくれるみたいです。
