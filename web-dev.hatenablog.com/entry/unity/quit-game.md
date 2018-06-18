---
Title: Unity：ゲームを終了させる
Category:
- Unity
Date: 2018-06-19T06:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/quit-game
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971652478547
---

Esc（エスケープキー）を押したときに、Unity のゲームを終了させる方法を書いていきます。


## 方法
スクリプトでキーを判定して終了させます。

```cs
void Update () {
  if (Input.GetKey(KeyCode.Escape)) {
    #if UNITY_EDITOR
      EditorApplication.isPlaying = false;
    #elif UNITY_STANDALONE
      Application.Quit();
    #endif
  }
}
```

処理は Update メソッドに追加しています。

`#if`, `#elif`,`#endif` は条件付きコンパイルになります。Unityエディタ（開発環境）でゲームを実行している場合は `EditorApplication.isPlaying = false;`、スタンドアロンで実行している場合は `Application.Quit();` で終了させています。

スタンドアロンだけ終了させたい場合は、条件付きコンパイルがいらなくて `Application.Quit();` だけで大丈夫だと思います。


## スクリプトの追加方法
ゲームを管理するような GameObject を作成して、そのオブジェクトにスクリプトを追加しました。手順は以下の通りです。

Unityエディタの Hirerarchy で Create を押して Create Empty を選択します。

[f:id:mamorums:20180609171730p:plain]

適当な名前（例：Game）に変更して、スクリプト（例：GameController）を追加します。

[f:id:mamorums:20180609171746p:plain]

スクリプトを開いて、Update メソッドに処理を追加します。

※ どの GameObject にスクリプトを追加しても良いと思います。


## 参考文献
- [アプリケーションを終了する - 凛(kagring)のUE4とUnityとQt勉強中ブログ](http://kagring.blog.fc2.com/blog-entry-42.html)
- [Unityでスタートボタン、ゲーム終了ボタンのUIを作成する - Unityを使った３Dゲームの作り方（かめくめ）](https://gametukurikata.com/ui/startbuttonui)
- [プラットフォーム依存コンパイル - Unity](https://docs.unity3d.com/jp/current/Manual/PlatformDependentCompilation.html)
