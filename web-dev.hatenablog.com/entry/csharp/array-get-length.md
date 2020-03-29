---
Title: C#：二次元配列の長さ取得
Category:
- C#
Date: 2020-03-25T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/csharp/array-get-length
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613539272599
---

C# の二次元配列（多次元配列）で、配列の長さを取得する方法を書いていきます。


## コード例
`GetLength(int)` で取得するみたいです。引数には、取得したい次元（0開始）を指定します。

```cs
int[,] array = new int[2, 4];

Console.WriteLine(array.GetLength(0)); //-> 2
Console.WriteLine(array.GetLength(1)); //-> 4

Console.ReadKey();
```

引数`0`だと最初の次元、`1`だと次の次元、といった感じになるようです。


## 参考文献
[https://docs.microsoft.com/ja-jp/dotnet/api/system.array.getlength:embed:cite]


