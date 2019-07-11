## このプロジェクトについて

Spring MVC は、サーブレット 3 をベースにして、リクエストの非同期処理を実装しています。このプロジェクトは、そのデモを実装しています。デモのコードは、次のサイトのコードを改良しています。

[Understanding Callable and Spring DeferredResult](http://xpadro.blogspot.jp/2015/07/understanding-callable-and-spring.html)


## はじめに

サーブレット 3.0 の非同期処理のサポートで、HTTP リクエストを他のスレッドで処理できるようになります。長い時間のかかる処理がある場合、非同期処理が重宝されます。他のスレッドでリクエストを処理している間に、コンテナのスレッドは解放されて、他のリクエストを処理することができるからです。

Spring MVC でも、サーブレット 3.0 ベースの非同期リクエスト処理が導入されました。コントローラのメソッドは、従来通り値を返すのではなく、`java.util.concurrent.Callable` を返すことで、戻り値を別のスレッド上で生成させることができます。この場合の別スレッドとは、Spring MVC が管理するスレッドで、`TaskExecutor` を使って実行されるものです。

また、非同期処理を実現するもう１つの選択肢は、コントローラのメソッドに `DeferredResult` のインスタンスを戻り値として返すというものです。この場合も戻り値の生成は別スレッドで行われることになります。しかし、Spring MVC はそのスレッドについて関知しません。アプリケーションが管理するスレッドで処理を実行して、`DeferredResult` を返却します。

次に、Spring MVC での非同期リクエスト処理のデモコードを実装していきます。


## 1. サービスクラスとアプリ実行クラス

時間のかかる処理はサービス `TaskService` として実装しています。アプリ実行クラスは `Application` になります。


## 2. 同期処理のコントローラ（ブロッキングコントローラ）

コントローラのメソッドの処理が完了するまで、コンテナのスレッドを解放しない例です。`BlockingController` として実装されています。`http://localhost:8080/block` にアクセスすると、コンソールに次のように出力されます。

```
2015-10-19 15:04:03.720  INFO 6788 --- [nio-8080-exec-1] sma.controller.BlockingController        : Request received
2015-10-19 15:04:08.720  INFO 6788 --- [nio-8080-exec-1] sma.service.TaskService                  : Slow task executed
2015-10-19 15:04:08.720  INFO 6788 --- [nio-8080-exec-1] sma.controller.BlockingController        : Servlet thread released
```

## 3. 非同期処理（Callable を返却）

Callable を返却する非同期処理の例は、`AsyncCallableController` として実装されています。`http://localhost:8080/callable` にアクセスすると、コンソールに次のように出力されます。

```
2015-10-19 15:08:13.052  INFO 6788 --- [nio-8080-exec-2] sma.controller.AsyncCallableController   : Request received
2015-10-19 15:08:13.055  INFO 6788 --- [nio-8080-exec-2] sma.controller.AsyncCallableController   : Servlet thread released
2015-10-19 15:08:18.068  INFO 6788 --- [      MvcAsync1] sma.service.TaskService                  : Slow task executed
```

コンテナのスレッドはすぐに解放されて、Spring MVC のスレッドで処理が実行されます。処理が実行されている間は、クライアントにレスポンスが返却されていません。クライアントとコンテナ間のコミュニケーションは開いていて、レスポンスの生成を待っている状態になります。その一方で、コンテナのスレッドは、他のリクエストを処理できるようになっています。


## 4. 非同期処理（DeferredResult を返却）

DeferredResult を返却する非同期処理の例は、`AsyncDeferredController` として実装されています。`http://localhost:8080/deferred` にアクセスすると、コンソールに次のように出力されます。

```
2015-10-19 15:20:08.461  INFO 6788 --- [nio-8080-exec-7] sma.controller.AsyncDeferredController   : Request received
2015-10-19 15:20:08.691  INFO 6788 --- [nio-8080-exec-7] sma.controller.AsyncDeferredController   : Servlet thread released
2015-10-19 15:20:13.689  INFO 6788 --- [onPool-worker-1] sma.service.TaskService                  : Slow task executed
```

Callable との違いは、スレッドをアプリケーションで管理している点です。非同期処理を実行するスレッドは、`CompletableFuture` を使って生成しています。このスレッドで戻り値を生成して、`DeferredResult`に値を設定しています（`DeferredResult#setResult`）。


## 結論

大きな視点で見ると、Callable と DeferredResult は同じことを実現しています。それは、コンテナのスレッドを解放して、他のスレッドで非同期に処理（長い処理）を実行しているということです。両者の違いは、非同期処理のスレッドを誰が管理するかという点です。


## おまけ：@Async のメソッドを呼び出す

サーブレット 3.0 の非同期リクエスト処理を使わずに、コントローラから非同期処理を呼び出す例を `TaskService#async()` と `AsyncController`に実装しました。（`Application` にも `@EnableAsync` を追加。）

`TaskService#async()` は、アノテーション `@Async` を付与して非同期処理にしています。`AsyncController` は `TaskService#async()` を呼び出して、すぐにレスポンスを返却しています。`http://localhost:8080/async` にアクセスして、実行すると次のようになります。

```
2015-10-19 16:21:04.348  INFO 9100 --- [nio-8080-exec-9] sma.controller.AsyncController           : Request received
2015-10-19 16:21:04.349  INFO 9100 --- [nio-8080-exec-9] sma.controller.AsyncController           : Servlet thread released
2015-10-19 16:21:09.352  INFO 9100 --- [TaskExecutor-18] sma.service.TaskService                  : Slow task executed by @Async.
```

Callable, DeferredResult といった、リクエスト非同期処理との違いは、レスポンスをすぐにクライアントへ返却できる点になります。例えば、次のような処理を実現できると思います。

1. クライアントからのリクエストが来る。
2. コントローラで非同期処理を開始する（@Async のメソッドを呼び出す）。
3. クライアントには「処理を受け付けました。処理が完了したらメールで通知します。」といったようなメッセージ（レスポンス）を返す。
4. 非同期処理は、完了したらクライアントにメール通知する。


## 参考文献
- [Asyncronous Request Processing - Spring Framework Document](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-async)
- [非同期リクエストの処理 - Spring Framework ドキュメント和訳](http://m12i.hatenablog.com/entry/2014/11/17/222816)
- [サーブレット 3.0 の非同期処理](http://www.atmarkit.co.jp/ait/articles/1106/10/news116.html)
