---
Title: SpringBoot入門：MessageSource を使う
Category:
- Java
Date: 2017-05-11T18:06:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/intro/message-source
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179613894
---

Spring の `MessageSource` を使うと、メッセージをプロパティファイルから簡単に取得できます。これから、Spring Boot で `MessageSource` を使う手順を書いていこうと思います。


## 手順1. application.properties の設定
次のように設定すると、メッセージを `messages_ja.properties` から取得できます（日本語環境でロケールが ja の場合）。

```
spring.messages.basename=messages
spring.messages.cache-seconds=-1
spring.messages.encoding=UTF-8
```

`application.properties` は Spring Boot の設定ファイルで、クラスパス直下に置くと読み込んでくれます。


## 手順2. messages_ja.properties の作成
ファイルを作成して、次のようにキーとメッセージを定義します。

```
key=こんにちは。
```

`messages_ja.properties` も、クラスパス直下に作成します。Gradle や Maven を使っている場合は、`src/main/resources` に用意すれば大丈夫です。

あと、プロパティファイルは native2ascii しなくて大丈夫みたいです（Java SE 6 から。詳細は [こちら](http://d.hatena.ne.jp/shin/20090707/p4)。）。


## 手順3. Java でメッセージを取得
### 手順3.1. MessageSource を定義
メッセージを取得したい Java クラスで、`MessageSource` をプロパティとして定義します。そして `@Autowired` を付けて、Spring Boot に設定（DI）してもらいます。

```java
@RestController
public class MsgController {

    @Autowired MessageSource msg;

    // ・・・省略
}
```

※ `MessageSource` を使うクラスは、Spring Boot で管理されている必要があります。（`@RestController`, `@Controller`, `@Service`, `@Component` などが付いてれば大丈夫です。）


### 手順3.2. メッセージの取得
`MessageSource` のメソッド `#getMessage` を呼び出して、メッセージを取得します。

```java
String message = msg.getMessage("key", null, Locale.JAPAN);
```

メソッドの第１引数はメッセージキー、第２引数は置換文字列（今回は指定なし）、第３引数はロケールを指定します。


## 補足：国際化・多言語対応について
上の例だと、ロケール（`#getMessage` の第３引数 `Locale.JAPAN`）が固定で、常に日本語のメッセージが取得されます。

逆に、ローケルを可変にすれば、多言語に対応することができます。

やり方は色々あると思いますが、コントローラはメソッド引数に `Local` を定義すると、Spring Boot が要求元のロケールを渡してくれるみたいです。

```java
@RequestMapping(value="/msg", method=RequestMethod.GET)
public Map<String, String> msg(Locale locale) {
    String message = msg.getMessage("key", null, locale);
    return Collections.singletonMap("message", message);
}
```

このやり方だと、クライアントに応じてメッセージを可変にすることができます。ロケールに対応するメッセージは、別のプロパティファイル（`messages_en.properties` など）で用意します。
