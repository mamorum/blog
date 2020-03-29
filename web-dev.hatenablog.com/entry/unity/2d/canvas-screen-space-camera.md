---
Title: Unity 2D：Canvasをカメラの表示領域に合わせる
Category:
- Unity
Date: 2020-03-29T00:48:18+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/canvas-screen-space-camera
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613541826509
---

Unity UI の Canvas と、カメラ（2D: Orthographic）の表示領域を合わせる方法を書いていきます。


## 補足
Unity 2D で UI要素を初めて追加すると、下の画像のようになると思います。

[f:id:mamorums:20200329004107p:plain]

Canvas の領域は広くて、Camera の表示領域は左下のように小さくなってしまいます。


## 方法
Canvas の Render Mode を以下の通り変更します。

- 変更前：Screen Space - Overlay
- 変更後：Screen Space - Camera

[f:id:mamorums:20200329004117p:plain]

あとは、Render Camera に表示領域を合わせたい Camera を設定します。（※ 上画像の右下・青四角の箇所です。）


## 変更後
Scene View は以下の通りになります。

[f:id:mamorums:20200329004126p:plain]


## 参考文献
[https://docs.unity3d.com/ja/current/Manual/UICanvas.html:embed:cite]


