---
Title: ASP.NET Core：リクエストのURLパスを使う
Category:
- C#
Date: 2020-04-18T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/dotnet/core/asp/use-request-url-path
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613546780126
Draft: true
---

ASP.NET Core で、URLパス（の一部）を APIコントローラーで使う方法を書いていきます。

具体的には、以下の URLでリクエストを受け取った場合、

```
http://localhost:xxxxx/api/memo/2
```

コントローラーで `2` を使う方法になります。


## 補足
Web API のプロジェクトを作成している前提で記事を書きました。プロジェクトの作成方法は、以下のリンク先に書いてあります。

[Web API プロジェクトの作成](/entry/dotnet/core/asp/create-web-api-project)


## 手順
プロジェクトの `Controllers` 配下に、以下のコントローラーを追加します。

`Controllers/MemoController.cs`

```cs
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace WebApi1.Controllers {
  [ApiController] [Route("api/memo")]  
  public class MemoController : ControllerBase {
    [HttpGet("{id}")]
    public Dictionary<string, long> Get(long id) {
      return new Dictionary<string, long>() {
        { "id", id }
      };
    }
  }
}
```

属性 `HttpGet` のパラメータがプレースホルダで、URL `/api/memo/{id}` の末尾が引数として渡ってきます。

※ コントローラーの追加方法は、[こちら](/entry/dotnet/core/asp/return-json-response) にも書いてあります。


## 動作確認
デバッグ実行して、以下の URL にアクセスすると、

```
http://localhost:xxxxx/api/memo/2
```

下の JSON が返ってきます。

```
{"id":2}
```

実際のアプリだと、URLパスの値を使ってデータを取得したり・・といった処理になると思います。
