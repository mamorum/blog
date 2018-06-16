---
Title: C++：動的確保したオブジェクトを渡す（値、参照、ポインタ）
Category:
- etc
Date: 2018-02-01T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/cpp/lang/new-object-and-pass-to-func
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812342443061
---

C++ で、動的確保したオブジェクト（new で生成したオブジェクト）を、引数として渡す方法を書いていきます。

書いている渡し方は、

- 値渡し
- 参照渡し（リファレンス渡し）
- ポインタ渡し

の３種類になります。


## 関数の準備
Cat クラスを引数として受け取る関数３種類（値、参照、ポインタ）と、main 関数を定義したソースを用意しました。

`main.cpp`

```cpp
#include <stdio.h>
#include "cat.h"

void val(Cat cat) { // 値渡し
  cat.eat();
}
void ref(Cat &cat) { // 参照渡し
  cat.eat();
}
void pointer(Cat *cat) { // ポインタ渡し
  cat->eat();
}
int main() {
  printf("main開始->\n");
  Cat *dCat = new Cat(); // 動的確保
  dCat->eat();
  printf("\n値渡し->\n");
  val(*dCat);
  printf("\n参照渡し->\n");
  ref(*dCat);
  printf("\nポインタ渡し->\n");
  pointer(dCat);
  printf("\nmain終了->\n");
  delete dCat;
  return 0;
}
```

どの渡し方でも、関数内で Cat の eat() メソッドを実行するようにしてます。ポインタ渡しの場合は、アロー演算子（`->`）でメソッドを呼び出します。

値渡しと参照渡しの `*dCat`（main 関数内）は、ポインタの指してる先（の値）になります。詳細は以下のリンク先にも書いています。

[C言語：ポインタ変数の値にアクセス（アドレスの先を参照）](/entry/c/lang/access-pointer-val)

でも、動的確保したらポインタ渡しのほうが良いのかもしれません・・・。


## Cat クラスの準備
Cat クラスの内容は以下の通りです。

`cat.h`

```cpp
#ifndef __CAT
class Cat {
public:
  Cat();
  ~Cat();
  Cat(const Cat &c);
  void eat();
};
#endif // __CAT
```

`#ifndef ... #endif` は、二重インクルード防止です。

`cat.cpp`

```cpp
#include <stdio.h>
#include "cat.h"

Cat::Cat() {
  printf("コンストラクタ\n");
}
Cat::~Cat() {
  printf("デストラクタ\n");
}
Cat::Cat(const Cat & c) {
  printf("コピーコンストラクタ\n");
}
void Cat::eat() {
  printf("メソッド\n");
}
```

値渡しの確認のため、コピーコンストラクタも用意してます。


## 実行結果
上のプログラムを実行すると、下のように標準出力されました。

```
main開始->
コンストラクタ
メソッド

値渡し->
コピーコンストラクタ
メソッド
デストラクタ

参照渡し->
メソッド

ポインタ渡し->
メソッド

main終了->
デストラクタ
```


## まとめ
### 値渡し
コピーコンストラクタが呼ばれて、関数のブロックが終了するときにデストラクタが呼ばれました。オブジェクトのコピーが発生するので、大きいオブジェクトだと負荷がかかりそうです。

### 参照渡し・ポインタ渡し
オブジェクトのコピーは発生しませんでした。

### オブジェクトの動的確保
new でコンストラクタが呼ばれて、delete でデストラクタが呼ばれました。動的確保のオブジェクトは、ヒープ領域のメモリを使用するみたいです。
