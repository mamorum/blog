---
Title: Eclipse：lombokインストール手順
Category:
- Java
Date: 2017-06-19T00:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/lombok
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179020064
---

Eclipse は、lombok をインストールしないと、lombok に関連するエラーが発生します。下の画像はその例で、lombok が生成しているはずの setter がないと言われています。

[f:id:mamorums:20170619152021p:plain]

これから、Eclipse に lombok をインストールする手順を書いていきます。


## 手順1. lombok.jar の実行
lombok.jar をダブルクリックして、インストール画面を起動します。

起動しない場合は、コマンドプロンプトから lombok.jar を実行します。

```txt
> java -jar lombok.jar
```

※ lombok.jar は、[lombok のページ](https://projectlombok.org/) からもダウンロードできます。


## 手順2. インストール
インストール画面の `eclipse.exe` が、正しいインストール先であることを確認して、`Install /Update` ボタンを押します。

![install-lombok](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092027.png)

`eclipse.exe` が表示されていなかったり、インストール先が異なる場合は、ボタン `Specify location...` を押して、正しい場所を指定します。

インストール完了画面が表示されたら、ボタン `ＯＫ` を押して閉じます。

![install-lombok-complete](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092028.png)


## 手順4. Eclipse 再起動
Eclipse を再起動して、lombok 関連のエラーが出なくなれば成功です。エラーが消えない場合は、プロジェクトの再ビルド（クリーンなど）すると良さそうです。

[f:id:mamorums:20170619152054p:plain]

## 補足. eclipse.ini の設定
インストールが完了すると、eclipse.ini に `-javaagent:lombok.jar` が自動的に追加されています。エラーが消えない場合や、違うパラメータで起動している場合は、こちらの設定を確認してみると良さそうです。


## 関連記事
次の記事には、Eclipse関連記事のリンクをまとめています。

[Eclipse：記事の一覧](http://web-dev.hatenablog.com/entry/eclipse/table-of-contents)

Eclipse の日本語化やカスタマイズなどの記事がありますので、参照して頂けると嬉しいです。
