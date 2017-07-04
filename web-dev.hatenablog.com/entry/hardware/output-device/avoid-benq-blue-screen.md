---
Title: BenQモニタ：信号なし青画面回避（HDMI）
Category:
- etc
Date: 2017-07-04T08:56:41+09:00
URL: http://web-dev.hatenablog.com/entry/hardware/output-device/avoid-benq-blue-screen
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812276580994
---

BenQ の液晶ディスプレイ [RL2460](http://www.benq.co.jp/product/gaminggears/rl2460/) を使っていて、HDMI の信号がなくなると明るい青画面が表示されました。

ちょっと刺激が強いので、明るい青画面を回避する方法を書いていきます。


## 手順1. HDMI自動切換の設定
画面が表示されている（HDMIなどの信号あり）状態で、モニターのコントロールキーを押します。それから、

`メニュー ＞ システム ＞ HDMI自動切換`

を選択して「オン」に設定します。


## 手順2. 入力信号切替
モニタの入力信号がない状態で、モニターのコントロールキーを押します。そこで、HDMI以外の入力信号（D-Sub or DVI）を選択します。


## まとめ
手順１の設定で、HDMIの信号が来ると自動で表示してくれます。

手順２の設定で、入力信号がない場合は D-Sub or DVI の信号なし画面が表示されます。こちらは明るい黒画面なので、青画面は回避することができます。


## 補足
回避方法は、ベンキュージャパンサポートセンターの方に教えて頂きました。ありがとうございます。
