---
Title: Unity UI：三目並べの開発７
Category:
- Unity
Date: 2018-07-02T09:36:32+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/create-game-over-panel-and-text
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132597278005
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回は 画面にゲームオーバー（"X" と "O" のどちらが勝ったか）を表示できるようにしていこうと思います。


## 1. Panel の作成
Main シーンで、UI Panel を作成します。

[f:id:mamorums:20180702093348p:plain]

作成したら、インスペクタで以下のように設定していきます。

- 名前: "Game Over Panel"
- Anchor Preset: middle/center
- Width: 440
- Height: 100
- Color: 33, 44, 55, 196


## 2. Text の作成
Hierarchy ウィンドウで、`Game Over Panel` の子要素として UI Text を作成します。下の画像のように、Panel を選択して右クリックで Text を作成すると、子要素として作成できます。

[f:id:mamorums:20180702093358p:plain]

作成したら、インスペクタで以下のように設定していきます。

- Anchor Preset: stretch/stretch
- Text: "Win Text"
- Font Size: 64
- Alignment: middle/center
- Color: 0, 204, 204, 255

設定が完了すると、次のように表示されます。

[f:id:mamorums:20180702093411p:plain]


## 3. スクリプトの更新
GameController を開いて、以下の内容に更新します。

```cs
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {
  public Text[] buttonList;
  public GameObject gameOverPanel;
  public Text gameOverText;
  private string playerSide;
  void Awake() {
    SetGameControllerReferenceOnButtons();
    playerSide = "X";
    gameOverPanel.SetActive(false);
  }
  void SetGameControllerReferenceOnButtons() {
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].GetComponentInParent<GridSpace>()
        .SetGameControllerReference(this);
    }
  }
  public string GetPlayerSide() {
    return playerSide;
  }
  public void EndTurn() {
    //-> ３つ並んでたらゲームオーバー
    if ( ///-> 横をチェック
      (buttonList[0].text == playerSide && buttonList[1].text == playerSide && buttonList[2].text == playerSide) ||
      (buttonList[3].text == playerSide && buttonList[4].text == playerSide && buttonList[5].text == playerSide) ||
      (buttonList[6].text == playerSide && buttonList[7].text == playerSide && buttonList[8].text == playerSide)
    ) { GameOver(); return; }
    if ( ///-> 縦をチェック
      (buttonList[0].text == playerSide && buttonList[3].text == playerSide && buttonList[6].text == playerSide) ||
      (buttonList[1].text == playerSide && buttonList[4].text == playerSide && buttonList[7].text == playerSide) ||
      (buttonList[2].text == playerSide && buttonList[5].text == playerSide && buttonList[8].text == playerSide)
    ) { GameOver(); return; }
    if ( ///-> 斜めをチェック
      (buttonList[0].text == playerSide && buttonList[4].text == playerSide && buttonList[8].text == playerSide) ||
      (buttonList[2].text == playerSide && buttonList[4].text == playerSide && buttonList[6].text == playerSide)
    ) { GameOver(); return; }
    //-> ３つ並んでいない
    ChangeSides();
  }
  void ChangeSides() {
    playerSide = (playerSide == "X") ? "O" : "X";
  }
  void GameOver() {
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].GetComponentInParent<Button>().interactable = false;
    }
    gameOverPanel.SetActive(true);
    gameOverText.text = playerSide + " Wins!";
  }
}
```

Panel と Text の public変数を追加しています。メソッド `Awake()` でパネルを非表示にして、ゲームオーバーになったら表示するようにしてます。


## 4. インスペクタの設定
ユニティの開発環境に戻って、GameObject をスクリプト `GameController` に設定します。

- `Game Over Panel` をドラッグして、変数 `gameOverPanel` に移動
- `Text` をドラッグして、変数 `gameOverText` に移動

[f:id:mamorums:20180702093425p:plain]


## 5. 動作確認
ゲームを実行して、３つ並べるとパネルが表示されるようになりました。

[f:id:mamorums:20180702093435p:plain]


## 次回
次は引き分けを判定できるようにして、今回のパネルとテキストで通知してみようと思います。

