---
Title: Java：ログ出力（SLF4J, Logback）
Category:
- Java
Date: 2016-07-23T16:55:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/trends-of-logging
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178774092
---

最近は、Java のログ出力に SLF4J と Logback を使うことが多いようです。そこで、SLF4J と Logback の概要・利用手順をまとめてみました。


## 概要
- SLF4J：ログファサードライブラリ
- Logback：ログ出力ライブラリ

SLF4J が Commons Logging、Logback が Log4j の新しいバージョン、といった感じみたいです。SLF4J を使って書いておけば、ログ出力ライブラリを切り替えられそうです。


## 利用手順1. Gradle の定義
### 1.1. アプリケーション開発時
```txt
dependencies {
  compile 'org.slf4j:slf4j-api:1.7.21'
  compile 'ch.qos.logback:logback-classic:1.1.7'
  ...
```

実行時・テスト時の両方で、SLF4J と Logback を使います。


### 1.2. ライブラリ開発時
```txt
dependencies {
  compile 'org.slf4j:slf4j-api:1.7.21'
  testCompile 'ch.qos.logback:logback-classic:1.1.7'
  ...
```

実行時のログ出力ライブラリは、アプリ（ライブラリの利用者）の依存性に従います。テスト時のログ出力には Logback を使います。


## 利用手順2. ログ出力
```java
package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);
  
  public static void main(String[] args) {
    logger.info("Hello World.");
    logger.debug("Hello {}, {} and {}.", "Bob", "Tom", "Taro");
  }
}
```

Logger を使って出力します。上の `logger.debug(...)` では、プレースホルダ `{}` を使っています。プレースホルダは、第２引数（可変引数）の値で置換されます。

```txt
14:54:18.867 [main] INFO sample.Main - Hello World.
14:54:18.871 [main] DEBUG sample.Main - Hello Bob, Tom and Taro.
```

プレースホルダは、DEBUG レベルが有効な場合だけ置換されます。
ログレベル判定API（`logger.isDebugEnabled()` 等）を使う箇所が減りそうです。


## 利用手順3. ログ設定
### 3.1. 設定方法
Logback の場合、クラスパスに設定ファイルを用意するようです。
次のファイル（上が優先度高）を探して、見つかったらそれを使うようです。

1. logback.groovy
2. logback-test.xml
3. logback.xml

### 3.2. 設定ファイルがない場合
手順2 のように、標準出力にログが出力されるようです。

### 3.3. 設定ファイルの例
DEBUG レベルを抑えたい場合などは、次のようなファイルを用意しています。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE logback>
<!-- <configuration debug="true"> -->
<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <!-- encoders are assigned the type
         ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
    <encoder>
      <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <root level="debug">
    <appender-ref ref="STDOUT" />
  </root>
  <logger name="org.eclipse.jetty" level="INFO" />
  <logger name="org.reflections" level="INFO" />
</configuration>
```

Jetty のログなどは、INFO 以上だけが出力されるようになります。


## 参考文献
- [SLF4J](http://www.slf4j.org/)
- [Logback](http://logback.qos.ch/)
- [Javaのログ出力 - SlideShare](http://www.slideshare.net/miyakawataku/concepts-and-tools-of-logging-in-java)
