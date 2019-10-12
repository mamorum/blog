---
Title: Unity 2D：オーディオの音量調整
Category:
- Unity
Date: 2019-10-12T10:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/_volume-control
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613446706692
---

Unity のゲーム内で音量を調節したくて、Audio Mixer を使ってコントロールすることにしました。これから Audio Mixer について調べたことをまとめていきます。


## Audio Mixer について
Assets 配下で右クリックして、Audio Mixer を作成できるようです。

[f:id:mamorums:20191009105719p:plain]

[f:id:mamorums:20191009105730p:plain]

音を出す方法などは、以下のページを参考にさせて頂きました。

[https://gametukurikata.com/se/audiomixer:embed:cite]


あとは、Unity の公式チュートリアルも見たりしました。

[https://unity3d.com/jp/learn/tutorials/s/audio:embed:cite]


## Audio Source の Volume について
Audio Source に Volume というプロパティがあって、こちらでも音の大きさを調整することができそうです。

[f:id:mamorums:20191009105748p:plain]

ただ、オーディオソースのマニュアルだと、

[https://docs.unity3d.com/ja/current/Manual/class-AudioSource.html:embed:cite]

Volume の機能説明は以下の通りでした。

> Audio Listener から 1 ワールドユニット（1メートル）の距離における、音の大きさです。

ちょっと自分だと分からない感じだったので、Audio Mixer を使って調整するようにしました。
