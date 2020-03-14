---
Title: Unity UI：三目並べの開発
Category:
- Unity
Date: 2020-03-14T17:45:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971657550482
---

Unity UI を使って、2D の三目並べ（Tic tac toe）を制作してみました。

[f:id:mamorums:20200314173140p:plain]


## ソース
[https://github.com/mamorum/ttt:embed:cite]


## 仕様
- 人 vs CPU
- CPU は空マスをランダム選択
- 先手`X`、後手`O` の選択可能


## 勝敗判定
`X` か `O` を３つ揃えたほうが勝ちです。

実装としては、下のようにマスのインデックスを振って、

[f:id:mamorums:20200314173226p:plain]

横３列、縦３列、斜め２列のいずれかが揃っているかチェックする感じです。

- 横：(0, 1, 2), (3, 4, 5), (6, 7, 8)
- 縦：(0, 3, 6), (1, 4, 7), (2, 5, 8)
- 斜：(0, 4, 8), (2, 4, 6)


## 引き分け
３つ揃わずに９マス全て埋まったら引き分けです。

先手後手が互いに最善手を取ると、引き分けになるみたいでした。


## 課題・改善点
- CPUがランダム選択なので弱い。
- 人 vs 人を実装してない。
- 等々。


## 参考文献
[https://learn.unity.com/tutorial/creating-a-tic-tac-toe-game-using-only-ui-components:embed:cite]

[https://ja.wikipedia.org/wiki/%E4%B8%89%E7%9B%AE%E4%B8%A6%E3%81%B9:embed:cite]


