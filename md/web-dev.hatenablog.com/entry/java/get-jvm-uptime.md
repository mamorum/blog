---
Title: Java：JVMの稼働時間を取得
Category:
- Java
Date: 2016-10-29T18:10:54+09:00
URL: http://web-dev.hatenablog.com/entry/java/get-jvm-uptime
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687191910312
---

`java.lang.ManagementFactory` を使って、JVM の稼働時間（起動後の経過時間）を取得する方法を書いてみます。


## Javaコード
```
long uptime =
  ManagementFactory.getRuntimeMXBean().getUptime();
```

## 補足
`uptime` は、日本語だと「連続稼働時間」とか「起動時間」と言われるみたいです。


## 参考文献
- [ManagementFactory - Java SE 8](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/management/ManagementFactory.html)
- [RuntimeMXBean - Java SE 8](https://docs.oracle.com/javase/jp/8/docs/api/java/lang/management/RuntimeMXBean.html)
