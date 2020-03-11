---
Title: Windowsオーディオの概要と比較
Category:
- Windows
Date: 2020-03-14T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/audio-overview
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613532359719
Draft: true
---

Windowsオーディオの種類と特徴について、調べたことを比較しつつまとめていきます。


## 前提
録音はよく分からないので再生に絞って書いています。あと、ASIO（Microsoft の実装ではない）も含めています。

自分も分からないことが多いので、間違いとかあったらすみません。


## 参考文献
[https://docs.microsoft.com/ja-jp/archive/blogs/windows_multimedia_jp/4-windows7:embed:cite]

Windows7 の記事ですが、大まかなところは Windows10 でも変わらないのかなぁと思っています。


## ビットパーフェクトではないもの
- DirectSound
- MME（WinMM）
- WASAPI 共有モード

ミキサーを通して音が出てくるものです。（複数の）アプリの音をミックスして出力してくれます。「カーネルミキサーを通って・・」「ミキシング処理をされて・・」といった表現をよく見かけます。

DirectSound と MME ですが、今は WASAPI共有を通って出力されるみたいです。音の正確性は同程度になるのかなぁと思っています。


## ビットパーフェクトに近いと思われるもの
- WASAPI 排他モード
- ASIO

ミキサーを通さず音を出す感じです。１つのアプリが音を出してると（デバイスを専有すると）、他は音が出せなくなります。ミキサーを通すものよりレイテンシが短いです。
