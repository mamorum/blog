---
Title: PiaproStudio：画面描画エンジンの変更
Category:
- etc
Date: 2019-10-05T20:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/music/piapro-studio-rendering-engine
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613444085897
---

Piapro Studio の描画エンジンを「OpenGL」にしていたら、GPUの使用率が高くなることがありました。自分の環境だと、描画エンジンを「Windows GDI」に変更したら改善したので、当時の対応内容などを書いていきます。


## 環境
環境は以下の通りでした。

- Windows10 64bit
- Studio One 4.5.4
- Piapro Studio 2.0.4.3
- Intel HD Graphics 630（オンボードGPU）


## 事象
描画エンジンが「OpenGL」の場合、Piapro Studio の使用中（再生中）に GPU使用率が高くなりました。

[f:id:mamorums:20191003121141p:plain]

初音ミクV4X のトラックを２つほど用意して再生すると、GPU使用率が 50%以上になりました。

[f:id:mamorums:20191003121156p:plain]

トラックを増やすと使用率がさらに上がる感じでした。


## 対応内容
描画エンジンを「Windows GDI」に変更しました。

[f:id:mamorums:20191003121206p:plain]


## 対応結果
GPU使用率が 5%程度に下がりました。

[f:id:mamorums:20191003121217p:plain]


## 補足1. DirectX について
描画エンジンを「DirectX」にしたら、GPU使用率は 17%程度になりました。

[f:id:mamorums:20191003121229p:plain]

OpenGL よりは改善しますが、Windows GDI に比べると少し高い気がします。


## 補足2. メーカーサポートについて
Piapro Studio の画面描画がおかしいときは、Windows GDI に切り替えて下さいと書かれていました。

[https://piaprostudio.com/?p=184:embed:cite]

Windows の場合は、もしかしたら Windows GDI が良いのかもしれません。
