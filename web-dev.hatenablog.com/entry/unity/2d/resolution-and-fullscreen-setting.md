---
Title: Unity 2D：解像度とフルスクリーンの設定
Category:
- Unity
Date: 2020-09-18T19:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/resolution-and-fullscreen-setting
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613629359571
---

Unity 2019.4（LTS）を使うようになってから、ゲーム起動時に Configurationのダイアログが出ないようになりました。どうやら、以下のブログを拝見したところ、ダイアログ自体が非推奨になったみたいです。

[http://nakamura001.hatenablog.com/entry/2019/04/18/Unity%E3%82%A2%E3%83%97%E3%83%AA%E3%81%AE%E8%B5%B7%E5%8B%95%E6%99%82%E3%81%AE%E8%A7%A3%E5%83%8F%E5%BA%A6%E9%81%B8%E6%8A%9E%E3%81%AE%E3%83%80%E3%82%A4%E3%82%A2%E3%83%AD%E3%82%B0%E8%A1%A8%E7%A4%BA:embed:cite]

そこで、解像度と表示形式（フルスクリーン or ウィンドウ）について、

- デフォルト設定の確認方法
- スクリプトでの設定方法

を調べてみました。


## デフォルト設定の確認方法
スタンドアロンの場合、Player Settings でデフォルト設定を確認できるみたいです。開発中のプロジェクトは下のような内容でした。

[f:id:mamorums:20200918135051p:plain]

- Fullscreen Mode：`Fullscreen Window`
- Default Is Native Resolution：`true`

マニュアルを見た感じだと、実行環境のディスプレイ解像度で、フルスクリーンになるみたいです。


## スクリプトでの設定方法
`Screen` クラスのメソッドを使うと良さそうでした。

```cs
Screen.SetResolution(1920, 1080, true);
```

第三引数が `true` だとフルスクリーン、`false` はウィンドウみたいです。リフレッシュレートを指定できるメソッドもありました。


## 補足. ディスプレイの解像度
ディスプレイの解像度は、以下の変数に格納されているみたいです。

```cs
int w = Screen.currentResolution.width;
int h = Screen.currentResolution.height;
```

デフォルトに戻す場合は、こちらを使ってみようと思いました。


## 参考文献
- [Standalone Player settings - Unity](https://docs.unity3d.com/ja/2019.4/Manual/class-PlayerSettingsStandalone.html)
- [Screen.SetResolution - Unity](https://docs.unity3d.com/ja/current/ScriptReference/Screen.SetResolution.html)
- [Screen.currentResolution - Unity](https://docs.unity3d.com/ja/2019.4/ScriptReference/Screen-currentResolution.html)

