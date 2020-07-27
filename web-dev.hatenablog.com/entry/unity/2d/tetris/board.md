---
Title: テトリス考察：ボード・座標
Category:
- Unity
Date: 2020-07-24T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/tetris/board
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613602887044
---

Unity 2D でテトリスを制作したときのメモです。 

[https://web-dev.hatenablog.com/entry/unity/2d/tetris/overview:embed:cite]

上のリンク先の参考文献を元に、ボードや座標について考えた内容です。


## 概要
テトリスのプレイ画面を、下のように考えてみました。

[f:id:mamorums:20200723180139p:plain]

図中の数字は、位置 `(x, y)` を示します。右に行くと `x` が、上に行くと `y` が増えます。

座標は３つに分けていて、

- 中央：`Main`
- 左：`Hold`
- 右：`Next`

といった感じで、それぞれの左下が `(0, 0)` です。


## 実装方法
ゲーム内部では、座標の位置ごとに IDを覚えておきます。

[f:id:mamorums:20200723180157p:plain]

例えば、

- 空：0
- 壁：1
- I字ブロック：2
- O字ブロック：3

といった感じです。

あとは、IDで色を解決できれば画面表示できそうです。


