---
Title: Unity UI：三目並べの開発９
Category:
- Unity
Date: 2018-07-04T11:31:16+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/create-restart-button
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132597919667
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回はゲームが終了したときに、リスタートできるようにしていこうと思います。


## 1. ボタンの追加
Mainシーンに UI Button を作成して、

[f:id:mamorums:20180704112830p:plain]

インスペクタで以下のように設定していきます。

- 名前: "Restart Button"
- RectTransform: X=0, Y=330, Z=0
- Width: 200
- Width: 60
- Normal Color: 0, 204, 204, 255
- Highlighted Color: 128, 255, 255, 255
- Pressed Color: 51, 102, 102, 255
- Disabled Color:33, 44, 55, 255

あとは、UI Button の子要素 Text を選択して、

[f:id:mamorums:20180704112931p:plain]

以下のように設定します。

- Text: "Play Again?"
- Font Size: 18

全部設定すると、次のような感じになります。

[f:id:mamorums:20180704112943p:plain]


## 2. スクリプトの更新
スクリプト `GameController` を開いて、以下の内容に更新します。

```cs
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {
  public Text[] buttonList;
  public GameObject gameOverPanel;
  public Text gameOverText;
  public GameObject restartButton;
  private string playerSide;
  private int moveCount;
  void Awake() {
    SetGameControllerReferenceOnButtons();
    playerSide = "X";
    gameOverPanel.SetActive(false);
    moveCount = 0;
    restartButton.SetActive(false);
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
    ) { GameOver(playerSide); return; }
    if ( ///-> 縦をチェック
      (buttonList[0].text == playerSide && buttonList[3].text == playerSide && buttonList[6].text == playerSide) ||
      (buttonList[1].text == playerSide && buttonList[4].text == playerSide && buttonList[7].text == playerSide) ||
      (buttonList[2].text == playerSide && buttonList[5].text == playerSide && buttonList[8].text == playerSide)
    ) { GameOver(playerSide); return; }
    if ( ///-> 斜めをチェック
      (buttonList[0].text == playerSide && buttonList[4].text == playerSide && buttonList[8].text == playerSide) ||
      (buttonList[2].text == playerSide && buttonList[4].text == playerSide && buttonList[6].text == playerSide)
    ) { GameOver(playerSide); return; }
    //-> ３つ並んでいない 
    if (moveCount == 9) { ///-> 引き分け
      GameOver(null);
    } else { ///-> ゲーム継続
      ChangeSides();
    }
  }
  void ChangeSides() {
    playerSide = (playerSide == "X") ? "O" : "X";
  }
  void GameOver(string winner) {
    SetBoardInteractable(false);
    if (winner == null) SetGameOverText("It's a Draw!");
    else SetGameOverText(winner + " Wins!");
    restartButton.SetActive(true);
  }
  void SetGameOverText(string value) {
    gameOverPanel.SetActive(true);
    gameOverText.text = value;
  }
  void SetBoardInteractable(bool toggle) {
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].GetComponentInParent<Button>().interactable = toggle;
    }
  }
  public void RestartGame() {
    playerSide = "X";
    moveCount = 0;
    gameOverPanel.SetActive(false);
    restartButton.SetActive(false);
    SetBoardInteractable(true);
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].text = "";
    }
  }
}
```

ざっくりとした変更点は以下の通りです。

### 2.1. 変数の追加
リスタートボタンを操作するために変数を追加しています。

```cs
public GameObject restartButton;
```

ゲームオーバーになったときだけ表示させたいので、メソッド `Awake()` で表示させないようにしています。

```cs
restartButton.SetActive(false);
```

### 2.2. ゲームオーバー処理の変更
ゲームオーバー処理を以下の通り変更しました。

```cs
void GameOver(string winner) {
  SetBoardInteractable(false);
  if (winner == null) SetGameOverText("It's a Draw!");
  else SetGameOverText(winner + " Wins!");
  restartButton.SetActive(true);
}
```

引数に応じたテキストを表示して、リスタートボタンをアクティブにしています。ボード上（マス）のボタンは、`SetBoardInteractable(false);` でクリックできないようにしています。


### 2.3. リスタート処理の追加
リスタートボタンがクリックされたときに実行されるメソッドを追加しました。

```cs
public void RestartGame() {
  playerSide = "X";
  moveCount = 0;
  gameOverPanel.SetActive(false);
  restartButton.SetActive(false);
  SetBoardInteractable(true);
  for (int i = 0; i < buttonList.Length; i++) {
    buttonList[i].text = "";
  }
}
```

ゲームで使う変数やパネルなどを初期状態に戻しています。こちらは `SetBoardInteractable(true);` を使って、ボード上（マス）のボタンをクリックできるようにしています。


## 3. OnClick() の設定
Hierarchy で `Restart Button` を選択して、インスペクタの OnClick を設定します。

[f:id:mamorums:20180704113010p:plain]

上の画像のように、`+` ボタンを押して OnClick の要素を追加します。それから `Game Controller` をドラッグして `Runtime Only` の下のボックスに移動します。最後に、右側のボックスで `GameController.RestartGame` を選択します。

これでボタンを押したときに、メソッドが実行されるようになります。


## 4. Game Controller の変数設定
Hierarchy で `Game Controller` を選択してインスペクタを表示しておきます。それから `Restart Button` をドラッグして、インスペクタの `Restart Button` に移動します。

[f:id:mamorums:20180704113023p:plain]

これで、スクリプトからリスタートボタンをコントロールできるようになります。


## 5. 動作確認
ゲームを実行すると、

最初はリスタートボタンが消えていて、

[f:id:mamorums:20180704113039p:plain]

ゲームオーバーになるとリスタートボタンが表示されます。

[f:id:mamorums:20180704113054p:plain]

リスタートボタンをクリックすると、ゲームをやり直すことができます。


## 次回
次は、ターン（O の番か？X の番か？）を表示できるようにしていこうと思います。
