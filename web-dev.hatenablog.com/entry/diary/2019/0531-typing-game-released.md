---
Title: タイピングゲームのリリース
Category:
- 日記
Date: 2019-05-31T12:30:43+09:00
URL: https://web-dev.hatenablog.com/entry/diary/2019/0531-typing-game-released
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127176618497
---

2019年5月31日に、フリーのタイピングゲーム（無料のタイピングソフト）をリリースしました。


## 概要
ゲームタイトルは「タイピング紅魔郷」で、東方Project の二次創作となっています。ゲーム内容は、紅魔郷に関連しそうな文言をタイピングしていく感じです。

タイトルのネーミングは、すぐに二次創作だと分かるようにしたかった・・、ということにさせてください。

一応ストーリーがあって、キャラ同士の会話もあります。物語としては完結してないので、永夜抄あたりまで続く予定です（続けたい・・・）。あらすじや概要は以下の記事にまとめています。

[https://web-dev.hatenablog.com/entry/nijisousaku/touhou/game/typing/koumakyou/manual/overview:embed:cite]


## ゲームのダウンロード
下の記事にダウンロード方法やインストール方法を書いています。

[https://web-dev.hatenablog.com/entry/nijisousaku/touhou/game/typing/koumakyou/manual/install-and-start:embed:cite]


## 感想
自分のつくったものがゲームと呼べるか分からないですが、開発した感想を少し書いてみました。


### 開発全般
今までWebアプリ（特にサーバサイド）がメインだったので、プログラミングで考慮する点とかもだいぶ違う感じがしました。

あと、イラストが必要だったり、音楽が必要だったり、できないことだらけでした。フリーのイラストや楽譜（MIDI）が公開されていて本当に助かりました。東方Project は二次創作が多くてすごいです。


### プログラミング
Unity（スクリプトは C#）で開発したんですが、事前に C++（VC++）とか Java の調査もしてみました。

ゲーム開発で検索すると C++ の記事が多かった気がします。あと、Java（LWJGL?）もマインクラフトで使われてると聞いたことがありました。

最終的には Unityを使うことになったのですが、あれだけのものが無料でも使えるとは・・。すごい時代になっていました。Visual Studio も無料版があって、C# で書けるのもありがたかったです。


### 改善点
背景とか演出とか、何もできないところが色々ありました。プログラミングも色んな事ができるように頑張りたいところです。
