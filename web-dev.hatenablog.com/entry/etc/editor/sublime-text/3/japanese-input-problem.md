---
Title: SublimeText3の日本語入力問題（表示がビミョウ）
Category:
- etc
Date: 2018-05-01T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/editor/sublime-text/3/japanese-input-problem
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812319683325
---

[Sublime Text 3.0 が正式にリリースされた](https://www.sublimetext.com/blog/articles/sublime-text-3-point-0) ので、Windows 版の SublimeText に [IMESupport](https://github.com/chikatoike/IMESupport) をインストールして日本語入力を試してみました。


## 2018.05.01 追記
Sublime Text から [Visual Studio Code](https://code.visualstudio.com/download) に乗り換えました。理由は Sublime Text 3 の日本語入力がビミョウだったためです。日本語入力の問題点は以下に記載しています。


## 日本語入力がビミョウ
自分の環境（Windows10）で日本語（全角）を入力すると、変換前文字列がエディタの入力位置より右上に表示されました。

[f:id:mamorums:20171121094005p:plain]

右上に表示される文字列のフォントもイケてない気がします。Enter を押すと、下のようにエディタに反映されます。

[f:id:mamorums:20171121094018p:plain]

日本語入力は、Sublime Text 3 のベータ版と同じで微妙な感じがしました。

※ IMESupport を入れないともっとツライ感じになるので、IMESupport は入れたほうが良さそうです。


## Sublime Text 2 の日本語入力
Sublime Text 2 は、IMESupport を入れると下の画像のように日本語を入力することができました。

[f:id:mamorums:20171121094048p:plain]

これならなんとかなるので、今までずっと Sublime Text 2 を使っていました。

ただ、Sublime Text 2 だと起動が遅い感じがするのと、3 が正式版になったのでもう機能改善などのアップデートはされないのかなと思っています。


## どうするか？
以下のエディタに乗り換えられないか、検討してみようと思っています。

- [Visual Studio Code](https://code.visualstudio.com/)（Microsoft）
- [Atom](https://atom.io/)（GitHub）

前に使ったときは、ちょっともっさりした感じがしてました。具体的には、キーボード押してから画面に反映されるのに時間がかかるというか。（あくまで自分個人の感想です。）

ただ、上のプロダクトもリリースされ続けてますし、自分の PC と OS も新しくなったので、もしかしたらサクサク動くかもしれません。近いうちに試してみようかと思っています。
