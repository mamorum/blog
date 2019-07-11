---
Title: Unity UI：複数の画面解像度に対応させる
Category:
- Unity
Date: 2019-03-25T06:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/suppoert-multiple-screen-resolutions
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117126989366690
---

Unity UI で開発するゲーム（アプリ）を、複数の画面解像度に対応させる方法を書いていきます。


## 前提
- Unity UI を使った 2Dゲームを想定してます。
- 画面アスペクト比は `16:9` の１つを想定してます。
- 解像度は `1920×1080`, `1366×768`, `1280×720`, ... といった感じを想定してます。


## 対応方法
Canvas Scaler の設定を変更して、複数の画面解像度に対応させます。

Canvas（UI要素）を作成したばかりだと、

[f:id:mamorums:20190307150547p:plain]

Canvas Scaler の `UI Scale Mode` は `Constant Pixel Size` になっています。

これを `Scale With Screen Size` に変更します。

[f:id:mamorums:20190307150555p:plain]


## 確認
事前に UI Text を追加して、Gameウィンドウ（アスペクト比 16:9）でスケールを変更してみました。

[f:id:mamorums:20190307150336p:plain]

上が Canvas を拡大してて、下が縮小したものです。

[f:id:mamorums:20190307150347p:plain]

画面スケールが変わると、UI Text も一緒に変わっていることが分かります。これで複数の画面解像度に対応できそうです。

※ 初期設定の `Constant Pixel Size` だと、画面サイズが変わっても UI要素が変化しません。画面を縮小していくと、先ほどのテキストは大きいので画面から見切れてしまいました。


## Reference Resolution について
Canvas Scaler には `Reference Resolution` という設定値があって、UI設計中の解像度（基準値）を決めることができます。

デフォルトの値は `800×600` みたいですが、アスペクト比 `16:9` であれば `1920×1080` とか、想定する一番大きい解像度にしておいたほうが良いのかと考えています。解像度を小さくする分には、画像とかも劣化しない気がするので。

ちなみに、一度決めた `Reference Resolution` を変更すると、既に作成したUI要素の大きさが変わったりします。この設定値は、開発の最初に決めておくのが無難かと思います。


## Screen Match Mode について
Canvas Scaler の `Screen Match Mode` ですが、自分は今のところ `Expand` にしています。`Match Width Or Height` にしている参考文献もあったので、必要に応じて参照して頂ければと思います。


## 最後に
自分は Unity初心者で、まだ手探り状態です。Canvas Scaler の設定を変更するデメリットなども分かってなくて、他の方法（複数の解像度やアスペクト比に対応）もあるんだと思います。

何か良さそうな方法があれば教えて頂けると嬉しいです。


## 参考文献
- [画面解像度とスケーリング  - Metal Brage](http://www.metalbrage.com/UnityTutorials/uGUI/Scaler.html)
- [uGUIのレイアウトを理解する 〜 多種解像度対応 : Canvas Scaler - いんでぃーづ](https://indie-du.com/entry/2015/01/21/200000)
- [Canvas Scaler - Unityマニュアル](https://docs.unity3d.com/ja/current/Manual/script-CanvasScaler.html)
