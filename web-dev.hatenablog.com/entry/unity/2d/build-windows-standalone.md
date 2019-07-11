---
Title: Unity 2D：ビルド方法（スタンドアロン）
Category:
- Unity
Date: 2018-06-21T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/build-windows-standalone
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971653138187
---

Unity 2D で、スタンドアロンのゲームをビルドする方法を書いていきます。使用した環境は以下の通りです。

- Windows10 64bit
- Unity 2018.1.1f1


## 1. ビルドセッティングを開く
Unityエディタ（開発環境）のメニューで File をクリックしてから、Build Settings... を選択します。

[f:id:mamorums:20180611194301p:plain]


## 2. シーンの選択
選択すると、Build Settings のウィンドウが開きます。そこでビルドするシーンを選択します。

[f:id:mamorums:20180611194316p:plain]

上の画像の `Add Open Scenes` を押すか、下の Project ウィンドウからシーンをドラッグ＆ドロップすると選択できます。シーンを選択できたら `Build` ボタンを押します。

※ Platform は「PC, Mac & Linux Standalone」を選択しておきます。


## 3. ディレクトリの選択
`Build` ボタンを押すとダイアログが開くので、プロジェクトのルートディレクトリ配下に Build ディレクトリを作成します。

[f:id:mamorums:20180611194337p:plain]

その下にゲーム名称のディレクトリを作成して「フォルダーの選択」ボタンを押します。ボタンを押すとビルドが始まります。

[f:id:mamorums:20180611194352p:plain]

※ 今回は例として `Build/UFO Game` というディレクトリにしています。


## 4. ゲームの実行
選択したディレクトリを開くと、EXEファイルが生成されています。

[f:id:mamorums:20180611194404p:plain]

EXE を実行すると、Unity のウィンドウが開きます。

[f:id:mamorums:20180611194414p:plain]

Graphics を選択して `Play!` ボタンを押すとゲームが起動します。


## 5. ゲームの終了
ゲームの終了処理を実装していない場合は、ゲームをウィンドウ化してから画面の「×ボタン」を押すと終了できます。

※ ゲームは「Alt+Enter」でウィンドウ化できます。


## 参考文献
[2D UFO ゲームをビルドする - Unity](https://unity3d.com/jp/learn/tutorials/projects/2d-ufo-tutorial/building-our-2d-ufo-game?playlist=25844)
