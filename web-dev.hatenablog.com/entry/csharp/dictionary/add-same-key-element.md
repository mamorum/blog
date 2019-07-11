---
Title: C#：Dictionaryの要素を上書きする
Category:
- C#
Date: 2019-02-18T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/csharp/dictionary/add-same-key-element
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/98012380859390415
---

C# の Dictionary で、重複するキーの要素を上書きする方法を書いていきます。


## 上書きする方法
添え字を使って、イコールで代入すると上書きできました。

```cs
Dictionary<string, string> conv = new Dictionary<string, string>();
conv["あ"] = "a";
conv["あ"] = "A"; //-> OK（key="あ", val="A" になる）
```


## Addメソッドを使う方法（例外発生）
Addメソッドを使う方法だと、


```cs
Dictionary<string, string> conv = new Dictionary<string, string>();
conv.Add("あ", "a");
conv.Add("あ", "A"); //-> 例外発生
```

例外 `ArgumentException` が発生しました。

```
ArgumentException: An item with the same key has already been added...
```

キーの重複を許可しない場合とか、こちらを使うと良さそうなケースもありそうです。
