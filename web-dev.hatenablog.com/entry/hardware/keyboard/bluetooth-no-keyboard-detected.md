---
Title: Bluetoothキーボード：No Keyboard Detected
Category:
- ハード
Date: 2017-08-24T09:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/hardware/keyboard/bluetooth-no-keyboard-detected
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812292743659
---

デスクトップＰＣのキーボードを USB から Bluetooth に変えたら、起動時に「No Keyboard Detected」というエラー画面が表示されるようになりました。これからその詳細をまとめてみます。


## 1. エラー画面
画面の一番上には「American Megatrends」というロゴがあって、

[f:id:mamorums:20170828105153p:plain]

一番下に「No Keyboard Detected」と表示されています。

[f:id:mamorums:20170828105209p:plain]


## 2. 影響
エラー画面は自動的に消えるので影響なさそうです。ＯＳが起動すると、Bluetoothキーボードも利用できるようになります。


## 3. 原因
ＰＣ起動直後に、Bluetoothキーボードが認識されないためだと思われます。


## 4. 対応
ＰＣメーカーに問い合わせて、指示されたとおり BIOS のリセットを何度か試しましたがダメでした。なんとなくエラー画面が嫌で、USBキーボードに戻しました。


## 補足. BIOS起動について
自分のＰＣだと、Bluetooth キーボードで BIOS を起動できず、USBキーボードが捨てられないことに気付きました。デスクトップの場合は USBキーボードを購入しようと思いました。
