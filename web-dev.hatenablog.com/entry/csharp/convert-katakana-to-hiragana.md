---
Title: C#：カタカナをひらがなに変換する（片仮名→平仮名）
Category:
- C#
Date: 2019-01-28T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/csharp/convert-katakana-to-hiragana
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132701771666
---

C# を使って、カタカナをひらがなに変換する方法を書いていきます。


## コード例
変換コードの一例は以下の通りです。

```cs
  static internal string Convert(string s) {
    StringBuilder sb = new StringBuilder();
    char[] target = s.ToCharArray();
    char c;
    for (int i = 0; i < target.Length; i++) {
      c = target[i];
      if (c >= 'ァ' && c <= 'ヴ') { //-> カタカナの範囲
        c = (char)(c - 0x0060);  //-> 変換
      }
      sb.Append(c);
    }
    return sb.ToString();
  }
```

コード（メソッド）の仕様等は下に書いていきます。


## 仕様
引数に渡された文字列を１文字ずつチェックして、変換対象の片仮名を平仮名にしています。


### 変換対象
上のコードは、if 文を使って「ァ」から「ヴ」を変換対象にしています。

```
x >= ァ（U+30A1）&& x <= ヴ（U+30F4）
```

下は片仮名の Unicode表で、枠線部分（オレンジ色）が該当します。

[f:id:mamorums:20190110090827p:plain]


### 変換ロジック
カタカナのユニコードから、U+0060（0x0060）を引いてます。例えば「ァ」を変換する場合だと、

```
U+30A1（ァ）- U+0060 = U+3041（ぁ）
```

といった感じです。

下が平仮名の Unicode表で、ちょうど  U+0060（0x0060）を引くと平仮名の Unicodeに対応します。

[f:id:mamorums:20190110090840p:plain]


### 注意事項
上の例だと、

- 「ヵ」「ヶ」は変換対象外
- 「ヰ」「ヱ」は変換対象

になります。

変換対象の文字列は、必要に応じて変更すると良いのかと思います。
