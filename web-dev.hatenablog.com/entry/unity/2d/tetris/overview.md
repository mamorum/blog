---
Title: Unity 2D：テトリスの開発１（概要・コード）
Category:
- Unity
Date: 2020-05-03T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/tetris/overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613560082110
---

Unity 2D を使って、テトリスを制作してみました。動作イメージ（無音）は以下の通りです。

[https://www.youtube.com/watch?v=LeKO05yuzxo:embed:cite]


## コード
ソースは GitHub で公開しています。

[https://github.com/mamorum/tetris:embed:cite]

バグや間違いなどがあったらごめんなさい。実行体は配布していないです。


## 操作方法
### キーボード
- 左右：左右移動
- 下：落下スピードUP
- Space, Enter：回転・決定
- H：ホールド

### ゲームパッド
- 左右下：同上
- 〇：回転・決定
- △：ホールド

※ Hori FightingCommander のみ確認。


## その他
- 今のところ、落下スピードは変化しません。
- ゲームオーバーになると終了できます。
- Alt+F4 でも終了できます。


## 参考文献
公開されているソースや解説などがあったので開発できました。ありがとうございます。

- [テトリスを1時間強で作ってみた【実況解説】- ニコニコ動画](https://www.nicovideo.jp/watch/sm8517855)
- [C言語テトリスのソースコードを読む - はてなブログ](http://itouhiro.hatenablog.com/entry/20121119/tetris)
- [動画のソースコード - GitHub](https://github.com/DQNEO/CppTetris)
- [テトリス - Wikipedia](https://ja.wikipedia.org/wiki/%E3%83%86%E3%83%88%E3%83%AA%E3%82%B9)
