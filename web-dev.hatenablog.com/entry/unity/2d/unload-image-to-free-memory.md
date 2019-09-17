---
Title: Unity 2D：画像のメモリを解放する（Resourcesを使用）
Category:
- Unity
Date: 2019-07-15T01:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/unload-image-to-free-memory
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127210108215
---

Unity の [Resources](https://docs.unity3d.com/ja/current/ScriptReference/Resources.html) を使って、画像のメモリを解放する方法を書いていきます。

この記事は、

- Unity 2D
- Windows 向けスタンドアロン

のゲーム開発を想定して書いています。


## 概要・補足
今回書いていくメモリの解放手順ですが、

1. Resources で画像を動的に読み込む
2. Resources で画像のメモリを解放する

といった感じで、事前に画像を動的に読み込んでおく必要があります。その方法は以下の記事に書いてあります。

[https://web-dev.hatenablog.com/entry/unity/2d/load-image-at-runtime:embed:cite]

あと、`Resources` の使用はベストプラクティスではないみたいで、その辺のこともリンク先にあります。



## 手順1. 準備
上の記事の手順を完了させて、画像を動的に読み込めるようにしておきます。


## 手順2. スクリプト変更
前の記事で作成したスクリプトを変更します。

`Controller.cs`

```cs
using UnityEngine;

public class Controller : MonoBehaviour {
  public SpriteRenderer[] renders;
  string[] paths = {
    "marisa", "pache", "reimu", "sakuya"
  };
  bool loaded = false;
  void Update() {
    if (Input.GetKeyDown(KeyCode.Return)) {
      if (loaded) Unload();
      else Load();
    }
  }
  void Load() {
    for (int i = 0; i < renders.Length; i++) {
      renders[i].sprite = (Sprite)
        Resources.Load(paths[i], typeof(Sprite));
    }
    loaded = true;
  }
  void Unload() {
    foreach (SpriteRenderer sr in renders) {
      Resources.UnloadAsset(sr.sprite.texture);
      sr.sprite = null;
    }
    loaded = false;
  }
}
```

Unload メソッドを追加していて、ポイントは以下の通りです。

- Sprite のテクスチャをアンロードする。
- SpriteRenderer の変数に null を代入する。

```cs
Resources.UnloadAsset(sr.sprite.texture);
sr.sprite = null;
```


## 手順3. 動作確認
ゲームを起動して、Enter で動作確認します。

### 画像読み込み後
プロファイラのテクスチャは 220 で、21.0MB でした。

[f:id:mamorums:20190628155149p:plain]

### メモリ解放後
テクスチャは 216、5.0MB になりました。

[f:id:mamorums:20190628155203p:plain]


## 最後に
Unity のドキュメントを見ると、Resources は使わないほうが良さそうな書きぶりでした（画像は事前に読み込んでおく、画像のパスをコードに書くから避けたほうが良い、メモリリークも心配？、等々）。

最近の実機はメモリ容量も増えたので、メモリに展開したままでも余裕あったりしますよね。メモリサイズよりもディスクアクセスを少なくすべきという考え（特にHDD）も、すごく良く分かります。


## 参考文献
以下のページを参考にさせて頂きました。

[http://ft-lab.ne.jp/cgi-bin-unity/wiki.cgi?page=unity%5Fscript%5Fget%5Fresources%5Fobject:title]

