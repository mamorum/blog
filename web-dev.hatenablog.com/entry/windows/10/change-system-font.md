---
Title: Windows10：システムフォントの変更
Category:
- OS
Date: 2018-05-09T08:06:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/10/change-system-font
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812295439558
---

Windows10 のシステムフォント「Yu Gothic UI」を「Meiryo UI」に手動で変更したので、そのときの作業内容をまとめていきます。


## 2018.05.09 追記
Windows Update（OS更新）で、手動変更した設定（レジストリ）が元に戻ったことがありました。また設定して元に戻ると面倒なので、今はレジストリを変更しないで游ゴシックに慣れようかと思ってます・・・。


## 参考文献
変更方法は、以下の記事を参考にさせて頂きました。

[windows10のフォント変更メモ - qunotak’s blog](http://qunotak.hatenablog.com/entry/2016/08/05/020704)

ソフトを使わない設定方法を知ることができて嬉しかったです。ありがとうございます。


## 変更対象のレジストリ
`コンピューター\HKEY_CURRENT_USER\Control Panel\Desktop\WindowMetrics` の

- CaptionFont
- IconFont
- MenuFont
- MessageFont
- SmCaptionFont
- StatusFont

を全て手動で変更しました。


## 変更内容
バイナリ値の編集で「Yu Gothic UI」を「Meiryo UI」に変更しました。

[f:id:mamorums:20170906093035p:plain]

CaptionFont などのデータを右クリックして修正しました。データの長さは変えず、文字のないところは `00` で埋めました。


## まとめ
手作業はちょっと面倒ですが、再起動すると文字が見やすくなって良い感じです。無料ソフトで設定する方法もあるみたいなので、好きな方法で変更すると良さそうです。
