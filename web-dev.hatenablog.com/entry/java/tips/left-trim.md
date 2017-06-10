---
Title: Java：左トリム（前方トリム）
Category:
- Java
Date: 2017-05-17T10:08:24+09:00
URL: http://web-dev.hatenablog.com/entry/java/tips/left-trim
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687247436979
---

Java の文字列（`String`）で、左（前方）の空白を削除したいことがありました。これからそのコード例を書いてみます。


## コード例
```java
  public static String ltrim(String s) {
    int len=s.length(), i=0;
    char[] c = s.toCharArray();
    while ((i < len) && (c[i] <= ' ')) i++;
    return (i > 0 ? s.substring(i) : s);
  }
```

`' '`（半角スペース：`\u0020`）以下の文字コードを削除するのは、`String` の `trim()` メソッドと同じ仕様です。あと、`null` チェックはしてないです。


## String#trim() について
`String` の `trim()` だと、左右（前方と後方）の空白を削除します。


## 参考にしたコード
`java.lang.String` の `trim()` メソッド。
