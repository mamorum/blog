---
Title: Unity 2D：画像を動的に読み込む（Resourcesを使用）
Category:
- Unity
Date: 2019-07-08T01:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/2d/load-image-at-runtime
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127210066719
---

Unity の [Resources](https://docs.unity3d.com/ja/current/ScriptReference/Resources.html) を使って、画像を動的に読み込む方法を書いていきます。

この記事は、

- Unity 2D
- Windows 向けスタンドアロン

のゲーム開発を想定して書いています。


## 概要・補足
`Resources` を使うと、画像を読み込むまではメモリ消費を抑えることができそうです。

ただ、Unity の [チュートリアル](https://unity3d.com/jp/learn/tutorials/topics/best-practices/resources-folder) を見ると、`Resources` の使用はベストプラクティスではないみたいです（2.1.Best Practices for the Resources System で Don't use it.）。


## メリット
ゲーム実行中にメモリを解放したい場合は、`Resources` を使うと便利だったりします。メモリ解放の手順は、以下の記事にまとめています。

[https://web-dev.hatenablog.com/entry/unity/2d/unload-image-to-free-memory:embed:cite]

※ 今回の記事の続き、という感じで書いてます。


## 手順1. Resource フォルダの準備
`Assets` 配下に `Resources` フォルダを作成して、読み込む画像を置きます。

[f:id:mamorums:20190628135009p:plain]


## 手順2. SpriteRenderer の作成
`Resources` フォルダの画像を `Hierarchy` にドラッグ＆ドロップして、`SpriteRenderer` を作成します。

[f:id:mamorums:20190628135033p:plain]

今回は４つの画像を追加してて、画面に画像が表示されてます。

[f:id:mamorums:20190628135044p:plain]

必要に応じて `SpriteRenderer` の Position を調節しておきます。


## 手順3. Sprite の削除
`SpriteRenderer` の `Sprite` を削除します。インスペクタで `Sprite` の値をクリックして Delete を押すと削除できます。

[f:id:mamorums:20190628135054p:plain]

削除すると、画面の画像も消えます。

[f:id:mamorums:20190628135106p:plain]

今回は全ての `Sprite` を削除しておきました。


## 手順4. スクリプト作成
Enter が押されたら、画像を読み込むスクリプトを作成します。

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
      if (loaded) return;
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
}
```

それから、空の `GameObject` を作成して、スクリプトをアタッチします。

[f:id:mamorums:20190628135118p:plain]

スクリプトの public変数 `renders` には、先ほどの `SpriteRenderer` を全て紐づけておきます。


## 手順5. 動作確認
ゲームを起動して、Enter が押されたら画像が表示されることを確認します。あと、プロファイラを使って、自分の環境でメモリ使用状況を確認してみました。

### 画像読み込み前
テクスチャは 323 で、8.4MB でした。

[f:id:mamorums:20190628135145p:plain]


### 画像読み込み後
テクスチャが 4増えて 327、24.4MB でした。

[f:id:mamorums:20190628135154p:plain]

`SpriteRenderer` の `Sprite` を削除しない場合は、ゲーム起動時に画像が読み込まれると思います。
