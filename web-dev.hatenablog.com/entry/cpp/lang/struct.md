---
Title: C言語：構造体（概要、値渡し・参照渡し）
Category:
- C/C++
Date: 2018-01-23T14:26:43+09:00
URL: https://web-dev.hatenablog.com/entry/cpp/lang/struct
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812340185530
---

C言語の構造体についてまとめてみました。構造体の概要、宣言方法と使用方法、関数への渡し方（参照渡し、値渡し）などを書いています。


## 概要
[Wikipedia の構造体](https://ja.wikipedia.org/wiki/%E6%A7%8B%E9%80%A0%E4%BD%93) には、

> プログラミング言語におけるデータ型の一つで、1つもしくは複数の値をまとめて格納できる型。それぞれのメンバ（フィールド）は型が異なっていてもよい点が配列と異なる。

と書かれていました。


## 宣言方法
`struct` を使って宣言します。

```
struct bokin {
  int id;
  int yen;
};
```

bokin（募金）が型名で、閉じ括弧（`}`）の後にセミコロン（`;`）が必要になります。


## 使用方法
構造体を変数として宣言すると、その型の領域が1つ確保されます。ピリオド `.` を使うとメンバにアクセスできます。

```c
#include <stdio.h>

struct bokin {
  int id;
  int yen;
};
int main() {
  //-> 変数宣言（領域確保）
  bokin b;
  //-> メンバに値を代入
  b.id = 1;
  b.yen = 100;
  //-> メンバの値を取得
  printf("id=%d\n", b.id);
  printf("yen=%d\n", b.yen);
  return 0;
}
```

## 関数への渡し方
### 値渡し
値渡しは、構造体の中身が全てコピーされて関数に渡されます。コピーするので、メモリ（スタック）の容量を使うみたいです。サイズが大きいと、コピーで時間もかかるみたいです。

```c
#include <stdio.h>

struct bokin {
  int id;
  int yen;
};
void print(bokin b) {
  printf("id=%d\n", b.id);
  printf("yen=%d\n", b.yen);
}
int main() {
  bokin b;
  b.id = 1;
  b.yen = 1000;
  print(b);
  return 0;
}
```

値渡しの場合、ピリオド `.` で構造体のメンバにアクセスします。


### 参照渡し
参照渡は、構造体のアドレスを関数に渡します。値渡しと違って構造体はコピーされません。参照渡しを受けた関数で、構造体の値を変更することができます。

```c
#include <stdio.h>

struct bokin {
  int id;
  int yen;
};
void print(bokin *b) {
  printf("id=%d\n", b->id);
  printf("yen=%d\n", b->yen);
}
int main() {
  bokin b;
  b.id = 1;
  b.yen = 10000;
  print(&b);
  return 0;
}
```

参照渡しの場合、`&変数名` で関数に渡します。構造体のメンバにアクセスする際は、アロー演算子 `->` を使います。

上の print関数は、引数が `bokin *b` となっています。`*` が付くとポインタ変数で、bokin型のアドレスを保持する変数になります。アドレスとポインタの詳細は、以下のリンク先に書いています。

[C言語：アドレスとポインタ](/entry/c/lang/address-and-pointer)

