---
Title: Maven：テストしないで package する
Category:
- Java
Date: 2016-04-02T10:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/maven/skip-tests
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178885842
---

Maven の package タスクを実行すると、プロジェクトのテストも実行されます。この記事では、package タスクでテストをしない方法を書きます。


## テストをスキップする方法
`-DskipTests=true` を付けると、テストをスキップできます。コマンドは次のようになりました。

```txt
> mvn package -DskipTests=true
```
