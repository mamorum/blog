---
Title: Unity UI：三目並べの開発８
Category:
- Unity
Date: 2018-07-03T08:27:16+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/draw-condition
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132597580082
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回は、画面に引き分け（３マス並ばずに終了）を表示できるようにしていこうと思います。


## 1. スクリプトの更新
スクリプト `GameController` を開いて、以下の内容に更新します。

```cs
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {
  public Text[] buttonList;
  public GameObject gameOverPanel;
  public Text gameOverText;
  private string playerSide;
  private int moveCount;
  void Awake() {
    SetGameControllerReferenceOnButtons();
    playerSide = "X";
    gameOverPanel.SetActive(false);
    moveCount = 0;
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
    moveCount++;
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
    if (moveCount == 9) { ///-> 引き分け
      SetGameOverText("It's a draw!");
    } else { ///-> ゲーム継続
      ChangeSides();
    }
  }
  void ChangeSides() {
    playerSide = (playerSide == "X") ? "O" : "X";
  }
  void GameOver() {
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].GetComponentInParent<Button>().interactable = false;
    }
    SetGameOverText(playerSide + " Wins!");
  }
  void SetGameOverText(string value) {
    gameOverPanel.SetActive(true);
    gameOverText.text = value;
  }
}
```

ざっくりとした変更点は以下の通りです。

### 1.1. 変数 moveCount の追加
クリック回数を保持する変数 `moveCount` を追加しました。メソッド `Awake()` で初期値を０に設定して、`EndTrun()` が呼ばれるたびに１増加させています。この変数が 9 になったら、全てのマスが埋められたことになります。

### 1.2. 引き分け判定の追加
以下の条件を満たしたときは引き分けとしています。

「３マス並ばないで、９マスが全て埋まった場合」

この場合は "It's a draw!" を表示するようにしています。

### 1.3. ゲームオーバー処理の共通化
メソッド `SetGameOverText(string value)` を作成して、処理を共通化させています。勝敗が決まったときも、引き分けの時も同じメソッドを呼び出して、テキストを表示させています。


## 2. 動作確認
ゲームを実行して、３つ並ばずに終えると "It's a draw!"（引き分け）が表示されるようになりました。

[f:id:mamorums:20180703082600p:plain]


## 次回
次は、ゲームが終了したときにリスタートできるようにしていこうと思います。

