---
Title: ASP.NET Core：Web API プロジェクトの作成
Category:
- .NET
Date: 2020-04-05T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/dotnet/core/asp/create-web-api-project
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613544703847
---

ASP.NET Core で、Web API のプロジェクトを作成していきます。開発環境は、Visual Studio 2019 Community を使いました。


## 手順
Visual Studio を起動して「新しいプロジェクトの作成」を選んでから、

[f:id:mamorums:20200403224611p:plain]

「ASP.NET Core Web アプリケーション」を選択しました。「次へ」を押すとプロジェクト名の入力になります。今回は調査目的だったので、`WebApi1` にしました。

それから、API を選択して作成を押します。

[f:id:mamorums:20200403224625p:plain]

HTTPS のチェックは外しました。


## 動作確認
プロジェクトが作成されると、テンプレートのコードなども一緒に作成されてました。デバッグ実行すると JSON を返してくれます。ブラウザも起動してくれて、URL は以下の通りでした。

```
http://localhost:xxxxx/weatherforecast
```

上の `xxxxx` はポート番号で、自動的に振られていました。
