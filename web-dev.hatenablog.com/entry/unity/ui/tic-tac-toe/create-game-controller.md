---
Title: Unity UI：三目並べの開発５
Category:
- Unity
Date: 2018-06-28T09:05:24+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/create-game-controller
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971658450249
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回はゲームをコントロールするスクリプトを作成していきます。

具体的には、

- プレイヤーが "X" か "O" か
- どちらのターンか
- どちらが勝者か

といったことを、

管理したり判定したりするような感じです。


## 1. スクリプトの作成
Main シーンに、スクリプトをアタッチする GameObject を `Create Empty` で作成します。

[f:id:mamorums:20180628090426p:plain]

作成したら、Inspector で名前を `Game Controller` に変更します。

それから `Add Component` を押して、スクリプト `GameController` を作成します。スクリプトは `Assets` フォルダに作成されるので、`Assets/Scripts` に移動しておきます。


## 2. スクリプトの編集
`GameController` をダブルクリックで開いて、以下の内容を保存します。

```cs
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {
  public Text[] buttonList;
}
```

マスに配置された UI Button（のテキスト）を格納する変数を用意しています。


## 3. ボタンリストの設定
Unity エディタで `Game Controller` を選択して、インスペクタの鍵マークを押してロックします。

[f:id:mamorums:20180628090441p:plain]

Hierarchy ウィンドウで、Grid Space の子要素 Text を Ctrl を押しながらクリックして全て選択します。

[f:id:mamorums:20180628090451p:plain]

選択したらドラッグして、Inspector の Button List にドロップします。うまくいくと、上の画像のように Button List が Size=9 に設定されるので、鍵マークを再度クリックしてロックを解除します。


## 4. スクリプト GridSpace の編集
以前作成した `GridSpace` を開いて、以下の内容に更新します。


```cs
using UnityEngine;
using UnityEngine.UI;

public class GridSpace : MonoBehaviour {
  public Button button;
  public Text buttonText;
  public string playerSide;
  public void SetSpace() {
    buttonText.text = playerSide;
    button.interactable = false;
  }
  private GameController gameController;
  public void SetGameControllerReference(GameController controller) {
    gameController = controller;
  }
}
```

`GameController` の変数と、それを設定するメソッドが追加になっています。`GameController` への参照を設定するためです。


## 5. スクリプト GameController の編集
先ほど作成した `GameController` を開いて、以下の内容に更新します。

```cs
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {
  public Text[] buttonList;
  void Awake() {
    SetGameControllerReferenceOnButtons();
  }
  void SetGameControllerReferenceOnButtons() {
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].GetComponentInParent<GridSpace>()
        .SetGameControllerReference(this);
    }
  }
  public string GetPlayerSide() {
    return "?";
  }
  public void EndTurn() {
    Debug.Log("EndTurn is not implemented!");
  }
}
```

メソッドは全て追加になります。

`SetGameControllerReferenceOnButtons()` では、`GridSpace` に自身への参照（`this`）を設定してます。


## 6. スクリプト GridSpace の再編集
`GridSpace` を以下の内容に更新します。


```cs
using UnityEngine;
using UnityEngine.UI;

public class GridSpace : MonoBehaviour {
  public Button button;
  public Text buttonText;
  private GameController gameController;
  public void SetGameControllerReference(GameController controller) {
    gameController = controller;
  }
  public void SetSpace() {
    buttonText.text = gameController.GetPlayerSide();
    button.interactable = false;
    gameController.EndTurn();
  }
}
```

変数 `playerSide` を削除しつつ、メソッド `SetSpace()` で `GameController` を使うようにしています。マスに表示する文字列（"X", "O"）を受け取りつつ、マスをクリックしたらターンを終了するように更新してます。


## 7. 動作確認
ゲームを起動して、マスをクリックすると `?` が表示されます。

[f:id:mamorums:20180628090508p:plain]

また、コンソールに `EndTurn is not implemented!` といった文字列が表示されるようになります。

[f:id:mamorums:20180628090518p:plain]

`GameController` の実装が完全ではないため、今のところはこんな感じです。


## 次回
次は `GameController` をさらに更新して、ゲームを完成に近づけて行こうと思います。

