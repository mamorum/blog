---
Title: SpringBoot アプリ開発：7. 動作確認
Category:
- Spring Boot アプリ開発
Date: 2016-06-24T19:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/check
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179186581
---

前回までに開発したアプリを起動して、ブラウザで動作を確認していきます。


## 1. アプリの起動
次のコマンドで起動できます。

```dos
sbt > gradle bootRun
・・・
2016-06-24 12:38:33.015  INFO 2900 --- [           main] sbt.App                                  : Started App in 9.388 seconds (JVM running for 11.201)
```

Eclipse などの IDE で `sbt/src/main/java/sbt/App.java` を Java アプリケーションとして実行しても大丈夫です。


## 2. ブラウザでの確認
`http://localhost:8080/` にアクセスして確認します。

### 2.1. 初回アクセス
![page-first](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122747.png)

つぶやきデータがないので、入力エリアだけ表示されています。


### 2.2. 投稿・表示
つぶやきを投稿していくと、次のように表示されます。

![page-create](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122744.png)


### 2.3. 編集
つぶやきの編集ボタンを押すと、モーダルが表示されて内容を変更できます。

![page-update](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122748.png)


### 2.4. 削除
つぶやきの削除ボタンを押すと、確認ダイアログが表示されます。ＯＫボタンを押すと、つぶやきを削除できます。

![page-delete](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122746.png)


## 3. モバイルでの確認
アプリは Bootstrap を使ってレスポンシブになっています。Chrome「デベロッパー ツール」の iPhone 5 から確認すると、次のように表示されます。

![page-mobile](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122743.png)


## 4. 課題
CRUD はできるようになりましたが、本格的なアプリにするには色々とやることがありそうです。例えば、

- 入力値チェック実装（長いメッセージに対応できていない）
- つぶやきの表示方法検討（全件表示でつぶやきが多くなったら大変）
- 認証機能の実装（ログインやユーザ管理）

・・・等々、です。

ただ、今回の開発はこの辺までにしようと思います。次は、テストについて簡単に書いてみようかと思います。
