---
Title: ASP.NET Core：静的コンテンツを返す
Category:
- .NET
Date: 2020-04-12T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/dotnet/core/asp/return-static-contents
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613545882606
Draft: true
---

ASP.NET Core で、HTMLなどの静的コンテンツを返却する方法を書いていきます。


## 補足
Web API のプロジェクトを作成している前提で記事を書きました。プロジェクトの作成方法は、以下のリンク先に書いてあります。

[Web API プロジェクトの作成](/entry/dotnet/core/asp/create-web-api-project)


## 手順1. コードの追加
プロジェクト作成時に生成された、`Startup.cs` の `Configure` メソッドに以下のコードを追加します。

```cs
app.UseStaticFiles();
```

追加したプログラムの一部は以下の通りです。

```cs
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace WebApi1 {
  public class Startup {
    // ・・色々省略・・・
    public void Configure(
      IApplicationBuilder app,
      IWebHostEnvironment env
    ) {
      if (env.IsDevelopment()) {
        app.UseDeveloperExceptionPage();
      }
      app.UseRouting();
      app.UseStaticFiles();
      app.UseAuthorization();
      app.UseEndpoints(endpoints => {
        endpoints.MapControllers();
      });
    }
  }
}  
```


## 手順2. 静的コンテンツの追加
上のコードを追加すると、`wwwroot` ディレクトリの静的コンテンツを配信できるようになります。なので、ディレクトリを作成して、その中に以下の HTMLを追加してみました。

`wwwroot/index.html`

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>Index</title>
</head>
<body>
Welcome.
</body>
</html>
```

ディレクトリ構成は以下のようになっています。

[f:id:mamorums:20200406155636p:plain]

画像右側は HTMLファイルのプロパティで、出力ディレクトリにコピーするように変更しています。コンパイル先にも静的コンテンツが出力されるので、出力先をアーカイブする時などは便利だと思います。


## 動作確認
デバッグ実行して、ブラウザ等で以下のURLにアクセスすると、

```
http://localhost:xxxxx/index.html
```

先ほど追加した HTMLが返ってきます。

