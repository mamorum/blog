---
Title: C言語：ポインタ変数の値にアクセス（アドレスの先を参照）
Category:
- etc
Date: 2018-01-31T11:35:47+09:00
URL: https://web-dev.hatenablog.com/entry/etc/cpp/lang/access-pointer-val
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812342433544
---

C/C++ のポインタ変数（`*変数名`）には、アドレスが格納されています。そのアドレスの先（の値）にアクセスする方法を書いていきます。


## アクセス方法
ポインタ変数にアスタリスク `*` を付けて、アドレスの先（の値）にアクセスします。

※ この方法は「参照外し」や「参照はがし」と呼ばれることもあるみたいです。


### サンプル
下のサンプルでは、`int *b;` でポインタ変数を定義したあと、`*b` でポインタ変数の値にアクセスしています（`printf(...` 以降）。

```cpp
int main() {
  int a = 10;
  int *b;
  b = &a;
  printf("b=%d\n", *b);
  *b = 50;
  printf("b=%d\n", *b);
  return 0;
}
```

ポインタ変数を定義したら、アスタリスクを付けず（上の `b = &a;` のように）アドレスにアクセスすることが多いかもしれません。


### 実行結果
上のプログラムを実行すると、下のように標準出力されます。

```
b=10
b=50
```

`*b` でアドレスの先（の値）にアクセスできてます。


## C++：オブジェクトの場合
C++ の場合、オブジェクトのポインタ変数に `*` を付けて、参照渡しをすることができそうです。


```cpp
#include "cat.h"

void ref(Cat &cat) { // 参照渡し
  cat.eat();
}
int main() {
  Cat *dCat = new Cat();
  ref(*dCat);
  delete dCat;
  return 0;
}
```

でも、ポインター渡しのほうが良いのかもしれません。

まだどっちが良いのか分からず・・・。


## 参考文献
- [C言語 ポインタによる値の表現](http://ratan.dyndns.info/MicrosoftVisualC++/adress3.html)
- [C/C++ ポインタ入門 > ポインタの指す先を参照](http://vivi.dyndns.org/tech/cpp/pointerRef.html)
