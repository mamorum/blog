---
Title: ASP.NET Core：リクエストのJSONをバインド
Category:
- C#
Date: 2020-04-26T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/dotnet/core/asp/bind-requested-json
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613548741843
---

ASP.NET Core の APIコントローラーで、受信した JSONをオブジェクトにバインドする方法を書いていきます。


## 補足
Web API のプロジェクトを作成している前提で記事を書きました。プロジェクトの作成方法は、以下のリンク先に書いてあります。

[Web API プロジェクトの作成](/entry/dotnet/core/asp/create-web-api-project)


## 手順
プロジェクトの `Controllers` 配下に、以下のコントローラーを追加します。

`Controllers/PersonController.cs`

```cs
using Microsoft.AspNetCore.Mvc;
using System;

namespace WebApi1.Controllers {
  [ApiController] [Route("api/person")]
  public class PersonController : ControllerBase {
    [HttpPost]
    public Person Post([FromBody] Person p) {
      return p;
    }
  }
  public class Person {
    public int id { get; set; }
    public string name { get; set; }
    public DateTime created { get; set; }
    public Person() {
      created = DateTime.Now;
    }
  }
}
```

`Person` がバインド先のオブジェクトです。引数の `[FromBody]` は無くても大丈夫そうですが、念のために付けています。

※ コントローラーの追加方法は、[こちら](/entry/dotnet/core/asp/return-json-response) にも書いています。


## 動作確認
プロジェクトをデバッグ実行して、`curl` で JSONを POSTします。

```
> curl http://localhost:xxxxx/api/person -H "Content-Type: application/json" -d "{\"id\":1, \"name\":\"Jhon Doe\"}"
```

実行すると、下のような JSONが返ってきます。

```
{
  "id":1,
  "name":"Jhon Doe",
  "created":"2020-04-12T15:22:22.6031744+09:00"
}
```

`Person` がインスタンス化されて、送信した JSONの値が設定されていることが確認できました。


## 補足：curl について
動作確認の `curl` は、Windows版を利用しているため、JSON の二重引用符を `\` でエスケープしています。詳細は以下のリンク先に記載しています。

[Windows：curl を使う](/entry/windows/use-curl)
