---
Title: Maven入門：5.フェイズについて
Category:
- Maven
Date: 2017-06-30T10:09:09+09:00
URL: http://web-dev.hatenablog.com/entry/maven/intro/phases
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812275292222
---

Maven のビルドには「ライフサイクル（Build Lifecycle）」という概念があって、ライフサイクルにはいくつかの「フェイズ（ Phase）」があります。


## ライフサイクル
Maven には３つのライフサイクルが組み込まれているようです。

1. default: プロジェクトのビルドとデプロイを担当
2. clean: プロジェクトのクリーン（ビルド資源削除）を担当
3. site: プロジェクトのサイト生成（ドキュメント）を担当

今回は `default` のフェイズを中心に書いていこうと思います。


## `default` のフェイズ
以下に、`default` の主要なフェイズを書いてみました。

- validate
- compile
- test
- package
- verify
- install
- deploy

全てのフェイズは、[Lifecycle Reference](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference) に書かれています。


## mvn コマンドとフェイズ
入門記事の「[1.プロジェクトの作成と実行](/entry/maven/intro/create-prj-and-exec)」では、jar を作成するために以下のコマンドを実行しました。

```
> mvn package
```

これは `default` ライフサイクルの `package` フェイズを実行することになり、その結果として jar が作成されていました。


## フェイズの実行順序
上のように `package` フェイズを実行すると、その前のフェイズ（`validate`, `compile`, `test`, etc）が実行されることになります。

テストを実行する場合は、

```
> mvn test
```

で、その前のフェイズ（`validate`, `compile`, etc）が実行されます。


## 複数のフェイズ実行
`mvn` コマンドは複数のフェイズを引数にとることができます。

```
> mvn clean deploy
```

上のコマンドだと、`clean` を実行してから `deploy` が実行されます。
