---
Title: Unity：ゲームを終了させる
Category:
- Unity
Date: 2019-03-04T06:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/quit-game
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971652478547
---

C#スクリプトで、Unity のゲームを終了させる方法を書いていきます。


## コード例
```cs
void Quit() {
  #if UNITY_EDITOR
    UnityEditor.EditorApplication.isPlaying = false;
  #elif UNITY_STANDALONE
    UnityEngine.Application.Quit();
  #endif
}
void Update () {
  if (Input.GetKey(KeyCode.Escape)) Quit();
}
```

`Quit()` が終了するためのコードで、Escape が押されたときに実行されるようにしてみました。


## 解説
`#if`, `#elif`,`#endif` は条件付きコンパイルになります。

Unityエディタ（開発環境）でゲームを実行している場合は、

```cs
UnityEditor.EditorApplication.isPlaying = false;
```

で終了させてます。

スタンドアロンで実行している場合は、

```cs
UnityEngine.Application.Quit();
```

で終了させる感じです。


## 補足
スタンドアロンだけ終了させたい場合は、条件付きコンパイルは不要になります。`UnityEngine.Application.Quit();` だけで大丈夫だと思います。


## スクリプトの追加方法
自分の場合、上のスクリプトをゲームを管理するような GameObject に追加したりしてます。手順は以下の通りです。

Unityエディタの Hirerarchy で Create を押して Create Empty を選択します。

[f:id:mamorums:20180609171730p:plain]

適当な名前（例：Game）に変更して、スクリプト（例：GameController）を追加します。

[f:id:mamorums:20180609171746p:plain]

スクリプトを開いて、終了処理を追加します。

※ 他の方法もあると思います。


## 参考文献
- [アプリケーションを終了する - 凛(kagring)のUE4とUnityとQt勉強中ブログ](http://kagring.blog.fc2.com/blog-entry-42.html)
- [Unityでスタートボタン、ゲーム終了ボタンのUIを作成する - Unityを使った３Dゲームの作り方（かめくめ）](https://gametukurikata.com/ui/startbuttonui)
- [プラットフォーム依存コンパイル - Unity](https://docs.unity3d.com/jp/current/Manual/PlatformDependentCompilation.html)
