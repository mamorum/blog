---
Title: Bluetoothキーボード：No Keyboard Detected
Category:
- ハード
Date: 2017-08-24T09:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/hardware/keyboard/bluetooth-no-keyboard-detected
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812292743659
---

デスクトップＰＣのキーボードを有線USBから Bluetooth に変えたら、起動時に「No Keyboard Detected」というエラー画面が表示されるようになりました。これからその詳細をまとめてみます。


## 1. エラー画面
画面の一番上には「American Megatrends」というロゴがあって、

[f:id:mamorums:20170828105153p:plain]

一番下に「No Keyboard Detected」と表示されています。

[f:id:mamorums:20170828105209p:plain]

ＰＣ起動時に（BIOS で）Bluetooth キーボードが認識されないため、エラーが発生しているような気がします。


## 2. 影響
自分のＰＣだと、ＯＳ（Windows10）やアプリへの影響はなさそうでした。エラーは自動的に消えて、他はいつも通りです。ＯＳが起動すると、Bluetooth キーボードも利用できます。


## 3. 対応
ＰＣメーカーに問い合わせて、指示されたとおり BIOS のリセットを何度か試しましたがダメでした。他に対応案はなく、諦めることにしました。


## 最後に
再度USBキーボードを繋ぐと、エラー画面は表示されなくなります。

あと、Bluetooth キーボードだと BIOS を起動できず、USBキーボードが捨てられなかったりします。自分に合うUSBのワイヤレスキーボードがあれば、そちらを購入したほうが良さそうな気がします。
