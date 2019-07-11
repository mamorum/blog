---
Title: Unity UI：三目並べの開発６
Category:
- Unity
Date: 2018-06-29T09:26:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/win-conditions-and-turns
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132596230274
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回は `GameController` を更新して、完成に近づけていこうと思います。


## 1. スクリプトの更新
スクリプト `GameController` を開いて、以下の内容に更新します。

```cs
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {
  public Text[] buttonList;
  private string playerSide;
  void Awake() {
    SetGameControllerReferenceOnButtons();
    playerSide = "X";
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
  }
}
```

変更点は大きく以下の通りです。

### 1.1. 判定ロジックの追加
メソッド `EndTurn()` で、"X" か "O" が３つ並んでいるか判定するようにしました。`EndTurn()` は、ボタンを押したときに実行されます。

### 1.2. ゲームオーバー処理の追加
"X" か "O" が３つ並んでいたときの処理を追加してます。３つ並んだら、全てのボタンを disable にします。

### 1.3. 切替処理の追加
変数 `playerSide` を用意して、メソッド `ChangeSides()` で "X" か "O" を変えれるようにしました。最初は "X" で、ボタンを押したら "O" になります。


## 2. 動作確認
ゲームを実行すると、

"X" の次は "O" が表示されることや、

[f:id:mamorums:20180629092529p:plain]

３つ並ぶとボタンが全て disable になることが確認できます。

[f:id:mamorums:20180629092540p:plain]


## 次回
次は、ゲームオーバーになったときに、どちらが勝ったかを表示してみようと思います。

