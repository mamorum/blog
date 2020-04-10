---
Title: C#：コレクション生成時に要素追加
Category:
- C#
Date: 2020-04-25T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/csharp/add-elements-in-creating-a-collection
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613547704721
Draft: true
---

C# の `List` と `Dictionary` で、インスタンス化する際に要素を追加する方法を書いていきます。


## コード例
`{` と `}`（コレクション初期化子）を使って、インスタンスを生成すると追加できました。

```cs
using System;
using System.Collections.Generic;

class Program {
  static void Main(string[] args) {
    var li = new List<string>() {
      "one", "two"
    };
    var dic = new Dictionary<string, string> {
      { "cat", "猫" }, { "dog", "犬"}
    };
    Console.WriteLine(li[0]); //-> one
    Console.WriteLine(li[1]); //-> two
    Console.WriteLine(dic["cat"]); //-> 猫
    Console.WriteLine(dic["dog"]); //-> 犬
    Console.ReadKey();
  }
}
```

## 参考文献
[https://docs.microsoft.com/ja-jp/dotnet/csharp/programming-guide/classes-and-structs/object-and-collection-initializers:embed:cite]

オブジェクト初期化子、というのもあるみたいです。
