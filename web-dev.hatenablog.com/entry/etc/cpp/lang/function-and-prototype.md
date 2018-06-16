---
Title: C言語：関数の定義とプロトタイプ宣言
Category:
- etc
Date: 2018-01-04T12:57:02+09:00
URL: https://web-dev.hatenablog.com/entry/etc/cpp/lang/function-and-prototype
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812333145036
---

C言語の関数について、定義方法をまとめていきます。開発環境は、Visual C++ を使っています。


## 1. OK：同一ファイル内に関数定義
下の例は、関数プロトタイプ宣言（`void ok();`）をしています。

```c
#include <stdio.h>

void ok();

int main() {
  ok();
  return 0;
}
void ok() {
  printf("OK.");
}
```

下の例は、呼び出し先の関数（`void ok() { ... }`）を、main より前の行で定義してます。

```c
#include <stdio.h>

void ok() {
  printf("OK.");
}
int main() {
  ok();
  return 0;
}
```

どちらもコンパイルが通り、実行すると正常終了します。


## 2. NG：同一ファイル内に関数定義
関数プロトタイプ宣言がなく、呼び出し先の関数を事前に定義してないとエラーになります。

```c
#include <stdio.h>

int main() {
  ok();
  return 0;
}
void ok() {
  printf("OK.");
}
```

上のコードは VC++ だと、

- エラーコード: C3861
- 説明: ’OK’: 識別子が見つかりませんでした

というエラーが表示されました。


## 3. 別ファイルに関数定義
別ファイルに定義した関数を呼ぶ場合も、プロトタイプ宣言をしておけば大丈夫そうです。

`hello.cpp`

```c
#include <stdio.h>

void hello() {
  printf("Hello!");
}
```

関数 `hello()` を呼ぶために、下の `main.cpp` はプロトタイプ宣言をしています。

`main.cpp`

```c
void hello();

int main() {
  hello();
  return 0;
}
```

ただ、こういう場合はヘッダファイルを使うと良いみたいです。


## 4. 別ファイルに関数定義（ヘッダファイル使用）
ヘッダファイルには、プロトタイプ宣言、定数宣言などを書くみたいです。

`hello.h`

```c
void hello();
```

今回は `hello.cpp` で実装している関数のプロトタイプ宣言をしました。

`hello.cpp`

```c
#include <stdio.h>

void hello() {
  printf("Hello!");
}
```

それを下の `main.cpp` でインクルードしてます。

`main.cpp`

```c
#include "hello.h"

int main() {
  hello();
  return 0;
}
```

ヘッダーをインクルードすると、ヘッダーのプロトタイプ宣言などが追加されるみたいです。なので、`main.cpp` は、

```c
void hello();

int main() {
  hello();
  return 0;
}
```

上のような感じになってるみたいです。


## 補足. extern について
関数のプロトタイプ宣言だと、`extern` がついてもつかなくても良いみたいでした。

[C言語:extern - NINTON G.K.](http://www.ninton.co.jp/?p=13)

自分はまだそれが分かる領域には達してないので、上のリンク先を参考にさせていただきました。


## 参考文献
[Ｃ言語入門 小学生でもわかるＣ言語３ ソース分割](http://petitetech.com/c_intermediate/c_intermediate11.html)
