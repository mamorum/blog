---
Title: Unity：オーディオのメモリ消費量削減
Category:
- Unity
Date: 2018-10-24T07:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/performance/reduce-audio-memory-size
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132655600423
---

Unity にオーデォ（AudioClips）を追加していたら、メモリ消費量が増えたので減らしてみました。


## 対応内容
オーディオファイルの `Load Type` を `Streaming` にしました。

[f:id:mamorums:20181017194533p:plain]

インスペクタで設定しました。プロジェクトウィンドウで対象のオーディオファイルを選択すると表示されます。


## 対応前
AudioClips で、約90MB程度消費していました。

MP3（約2-3MB、256kbps）を、7曲ほどヒエラルキーに追加してました。おそらく、起動時にMP3をメモリに展開する設定だったんだと思います。


## 対応後
AudioClips の消費は、約250KBくらいになりました。

[f:id:mamorums:20181017194543p:plain]

１曲だけ再生しているときにプロファイリングしました。


## 補足
設定変更による影響とかはまだ調査しきれてません。`Streaming` 以外の設定値もあるみたいです。


## 参考文献
[オーディオクリップ - Unityマニュアル](https://docs.unity3d.com/ja/current/Manual/class-AudioClip.html)
