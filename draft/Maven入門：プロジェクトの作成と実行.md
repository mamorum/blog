Maven でクイックスタート用のシンプルなプロジェクトを作成して、そのアプリを実行してみます。


## 前提
Maven をインストールしていることが前提となります。インストール記事のリンクは、以下の記事に掲載しています。

[Maven：記事の一覧](/entry/maven/table-of-contents)


## 手順1. プロジェクトの作成
次のコマンドでプロジェクトを作成します。

```
> mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

初回は Maven の資源が色々とダウンロードされます。


## 手順2. 確認
プロジェクトのルートディレクトリ `my-app` と、以下の資源が作成されていることを確認します。

- my-app/pom.xml
- my-app/src/main/java/com/mycompany/app/App.java
- my-app/src/test/java/com/mycompany/app/AppTest.java

`pom.xml` が Maven のプロジェクト設定ファイルになります。


## 手順3. アプリのjar作成・実行
次のコマンドで jar を作成して実行します。

```
> cd my-app
> mvn package
> java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```

App クラスの実行結果として、以下の文字列が画面に出力されます。

```
Hello World!
```


## 参考文献
[Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
