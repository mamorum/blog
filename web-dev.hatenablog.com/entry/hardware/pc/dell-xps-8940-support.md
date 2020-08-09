---
Title: メモ：Dell XPS 8940
Category:
- ハード
Date: 2020-08-08T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/hardware/pc/dell-xps-8940-support
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613610637720
---

Dell のデスクトップPC「XPS 8940」を購入して、対応や調査をしたときのメモです。

<a target="_blank" href="https://www.dell.com/support/home/ja-jp/product-support/product/xps-8940-desktop/docs">XPS 8940 のサポート・マニュアル - Dell</a>


## 放電作業
電源ランプが「白色点滅」と「オレンジ点滅」を交互に繰り返したら、以下の放電作業をしてみると良さそうです。

1. PC背面の電源ケーブルを抜く
2. 電源ボタンを 15～20秒間押し続ける


## グラボのブラケット
以下の「グラフィックスカードサポートブラケット」は、販売してないみたいです。

[f:id:mamorums:20200806132801p:plain]

グラボ付きで購入すると付属してそうでした。グラボの固定をサポートしたり、配線を取りまわせたりするみたいです。


## Kernel-Power 137 のエラー
自分の環境だと、スリープに入る際に以下のエラーが発生しています。

- ログの名前：システム
- ソース：Kernel-Power
- イベントID：137

サポートに問い合わせて、休止状態を無効にしても改善しませんでした。休止状態の無効化は、以下のコマンドを管理者権限で実行する感じです。

```
powercfg -h off
```

BIOS でも S4 と S5 を無効化してみたのですがダメでした。
