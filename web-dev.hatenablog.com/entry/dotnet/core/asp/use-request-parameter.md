---
Title: ASP.NET Core：リクエストパラメータ使う
Category:
- C#
Date: 2020-04-19T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/dotnet/core/asp/use-request-parameter
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613547223444
---

ASP.NET Core で、リクエストパラメーター（クエリ文字列）を APIコントローラーで使う方法を書いていきます。

具体的には、以下の URLでリクエストを受け取った場合、

```
http://localhost:xxxxx/api/task?id=4
```

コントローラーで `4` を使う方法になります。


## 補足
Web API のプロジェクトを作成している前提で記事を書きました。プロジェクトの作成方法は、以下のリンク先に書いてあります。

[Web API プロジェクトの作成](/entry/dotnet/core/asp/create-web-api-project)


## 手順
プロジェクトの `Controllers` 配下に、以下のコントローラーを追加します。

`Controllers/TaskController.cs`

```cs
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace WebApi1.Controllers {
  [ApiController] [Route("api/task")]    
  public class TaskController : ControllerBase {
    [HttpGet]
    public Dictionary<string, long> Get(
      [FromQuery] long id
    ) {
      return new Dictionary<string, long>() {
        { "id", id }
      };
    }
  }
}
```

引数名をパラメータ名と同じにすると取得できました。引数の属性 `FromQuery` は無くても大丈夫そうですが、念のため付けておくことにしました。

※ コントローラーの追加方法は、[こちら](/entry/dotnet/core/asp/return-json-response) にも書いてあります。


## 動作確認
デバッグ実行して、以下の URL にアクセスすると、

```
http://localhost:xxxxx/api/task?id=4
```

下の JSON が返ってきます。

```
{"id":4}
```

今回はサンプルなので、JSONを返すだけにしています。

