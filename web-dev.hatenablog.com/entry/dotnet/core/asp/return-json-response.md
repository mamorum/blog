---
Title: ASP.NET Core：JSONを返す
Category:
- .NET
Date: 2020-04-11T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/dotnet/core/asp/return-json-response
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613545878914
Draft: true
---

ASP.NET Core で、JSON を返却する Web API を作成していきます。


## 補足
Web API のプロジェクトを作成している前提で記事を書きました。プロジェクトの作成方法は、以下のリンク先に書いてあります。

[Web API プロジェクトの作成](/entry/dotnet/core/asp/create-web-api-project)


## 手順1. APIコントローラーの追加
ソリューションエクスプローラーで右クリックして、`追加` → `コントローラー` を選択します。

[f:id:mamorums:20200406154840p:plain]

それから、空の APIコントローラーを選択して追加します。

[f:id:mamorums:20200406154849p:plain]

今回は、`Controllers` フォルダの下に `JsonController` という名前で作成してみました。


## 手順2. ソースの編集
あくまでサンプルですが、JSON を返すソースを書いて保存してみました。

```cs
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;

namespace WebApi1.Controllers {
  [ApiController] [Route("api/json")]
  public class JsonController : ControllerBase {
    [HttpGet]
    public Dictionary<string, string> Get() {
      return new Dictionary<string, string>() {
        { "msg", "Hello, World." },
        { "date", DateTime.Now.ToString("O") }
      };
    }
  }
}
```

属性 `Route` のパラメーターが URL（の一部）になります。`Route("[controller]")` 等の予約語？もあるみたいなので、この辺は任意で決めていくと良さそうです。


## 手順3. 動作確認
デバッグ実行して、以下の URL にアクセスすると、

```
http://localhost:xxxxx/api/json
```

下のような JSON を受け取ることができました。

```
{
  "msg":"Hello, World.",
  "date":"2020-04-05T13:29:40.6334457+09:00"
}
```
