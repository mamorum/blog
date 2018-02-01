---
Title: C言語：別ファイルの変数を使う
Category:
- C/C++
Date: 2018-01-29T13:26:27+09:00
URL: http://web-dev.hatenablog.com/entry/c/lang/extern-variable
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812341843382
---

C言語でファイル分割をした場合に、別ファイルの変数を使えるようにする方法（アクセスする方法）を書いていきます。

※ コード例は、わざとグローバル変数を使うように書いてます。


## 方法1. extern な変数を宣言
別ファイルの変数を使う側で、`extern` な変数を定義します。

サンプルは以下の通りです。

`main.cpp`

```c
#include <stdio.h>
#include "calc.h"

extern int sum;

int main() {
  add(1, 2);
  printf("1+2=%d\n", sum);
  return 0;
}
```

上の  `extern int sum;` で、外部の変数を見るようしてます。

`calc.cpp`

```c
#include "calc.h"

int sum;

void add(int a, int b) {
  sum = a + b;
}
```

上で変数 `sum` を定義しています。`main.cpp` はその値を見るようになります。


`calc.h`

```c
#ifndef __CALC
void add(int a, int b);
#endif // __CALC
```

ヘッダファイルは、`#ifndef .... #endif` で二重インクルードを防止してます。


## 方法2. ヘッダに extern な変数を宣言
ヘッダファイルに `extern` の付いた変数を書いておいて、それを使う側でインクルードします。

サンプルは以下の通りです。

`calc.h`

```c
#ifndef __CALC
extern int sum;
void add(int a, int b);
#endif // __CALC
```

上のヘッダファイルで、`extern int sum;` を宣言してます。

`main.cpp`

```c
#include <stdio.h>
#include "calc.h"

int main() {
  add(1, 2);
  printf("1+2=%d\n", sum);
  return 0;
}
```
`main.cpp` はヘッダファイルをインクルードしているので、変数 sum を定義しなくて大丈夫です。

`calc.cpp`

```c
#include "calc.h"

int sum;

void add(int a, int b) {
  sum = a + b;
}
```

上の `calc.cpp` は、方法1 と同じ内容です。


## 実行結果
方法1 と 2 の実行結果は同じで、以下の文字列が出力されます。

```
1+2=3
```

## 参考文献
[一週間で身につくC言語の基本 - 第7日目：ファイル分割](http://c-lang.sevendays-study.com/day7.html)
