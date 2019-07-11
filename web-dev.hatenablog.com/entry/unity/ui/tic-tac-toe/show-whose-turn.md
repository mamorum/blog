---
Title: Unity UI：三目並べの開発１０
Category:
- Unity
Date: 2018-07-05T08:28:54+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/show-whose-turn
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132598183566
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回は、"X" と "O" のどちらのターンか表示できるようにしていきます。具体的には、画面上部にパネルとテキストを追加して、その色を変更することでターンを示すように実装する感じです。


## 1. パネルの作成
Mainシーンに UI Panel を作成して、

[f:id:mamorums:20180705082439p:plain]

インスペクタで RectTransform の歯車を押して Reset します。

[f:id:mamorums:20180705113224p:plain]

それから、次のように設定します。

- 名前: "Player X"
- RectTransform: X=-206, Y=330, Z=0
- Color: 33, 44, 55, 255


## 2. テキストの追加
先ほどの Panel を選択して、右クリックで UI Text を子要素として作成します。

[f:id:mamorums:20180705082502p:plain]

次に、インスペクタで以下のように設定します。

- Anchor Preset: stretch/stretch
- Text: "X"
- Font Size: 86
- Alignment : middle/center
- Color: 0, 204, 204, 255


## 3. パネルの複製
パネル `Player X` で右クリックして、Duplicate を選択します。

[f:id:mamorums:20180705082538p:plain]

`Player X (1)` が作成されるので、インスペクタで設定を以下の通り変更します。

- 名前: "Player O"
- RectTransform: X= 206, Y=330, Z=0

変更したら、子要素の Text を選択して、インスペクタで設定を次のように変更します。

- Text: "O"

これでパネルが２つ追加されて、表示は次の画像のようになります。

[f:id:mamorums:20180705082550p:plain]


## 4. スクリプトの更新
スクリプト `GameController` を開いて、以下の内容に更新します。

```cs
using UnityEngine;
using UnityEngine.UI;

[System.Serializable]
public class Player {
  public Image panel;
  public Text text;
}
[System.Serializable]
public class PlayerColor {
  public Color panelColor;
  public Color textColor;
}
public class GameController : MonoBehaviour {
  public Text[] buttonList;
  public GameObject gameOverPanel;
  public Text gameOverText;
  public GameObject restartButton;
  public Player playerX;
  public Player playerO;
  public PlayerColor activePlayerColor;
  public PlayerColor inactivePlayerColor;
  private string playerSide;
  private int moveCount;
  void Awake() {
    SetGameControllerReferenceOnButtons();
    playerSide = "X";
    gameOverPanel.SetActive(false);
    moveCount = 0;
    restartButton.SetActive(false);
    SetPlayerColors(playerX, playerO);
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
    if (playerSide == "X") {
      SetPlayerColors(playerX, playerO);
    } else {
      SetPlayerColors(playerO, playerX);
    }
  }
  void SetPlayerColors(Player newPlayer, Player oldPlayer) {
    newPlayer.panel.color = activePlayerColor.panelColor;
    newPlayer.text.color = activePlayerColor.textColor;
    oldPlayer.panel.color = inactivePlayerColor.panelColor;
    oldPlayer.text.color = inactivePlayerColor.textColor;
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
    SetPlayerColors(playerX, playerO);
    SetBoardInteractable(true);
    for (int i = 0; i < buttonList.Length; i++) {
      buttonList[i].text = "";
    }
  }
}
```

ざっくりとした変更点は以下の通りです。

### 4.1. クラスと変数を追加
パネルとテキストをコントロールするための `Player` クラス、パネルとテキストの色を保持するための `PlayerColor` クラスを追加しています。

そして、これらの型の変数を `GameController` クラスで宣言してます。

```cs
public Player playerX;
public Player playerO;
public PlayerColor activePlayerColor;
public PlayerColor inactivePlayerColor;
```

PlayerColor でアクティブな色と非アクティブな色を保持しておいて、それを Player のパネルとテキストに設定する感じです。値（Image, Text, Color）は、あとで Unity エディタを使って設定します。

### 4.2. 色の設定処理を追加
以下のメソッドを追加してます。

```cs
void SetPlayerColors(Player newPlayer, Player oldPlayer) {
  newPlayer.panel.color = activePlayerColor.panelColor;
  newPlayer.text.color = activePlayerColor.textColor;
  oldPlayer.panel.color = inactivePlayerColor.panelColor;
  oldPlayer.text.color = inactivePlayerColor.textColor;
}
```

このメソッドで、追加したパネルとテキスト（"X", "O"）の色を設定します。アクティブな色（`activePlayerColor`）で、現在のターンを示す感じです。

以下のタイミングで、メソッドを呼び出しています。

- ゲーム開始時（メソッド `Awake`）
- ターンが変わるとき（メソッド `ChangeSides`）
- ゲームをリスタートするとき（メソッド `RestartGame`）


## 5. Game Controller の設定
Hierarchy で `Game Controller` を選択して、以下の項目をインスペクタにドラッグ&ドロップします。

- Player X（パネル）
- Player X の Text （パネルの子要素）
- Player O（パネル）
- Player O の Text （パネルの子要素）

[f:id:mamorums:20180705082617p:plain]

上の画像のように、それぞれ対応する public 変数に移動します。

次に、`Active Player Color` のカラーを以下のように設定します。

- Panel Color: 0, 204, 204, 255
- Text Color: 255, 0, 102, 255

最後に、`Inactive Player Color`  を次のように設定します。

- Panel Color: 33, 44, 55, 255
- Text Color: 0, 204, 204, 255

[f:id:mamorums:20180705082631p:plain]


## 6. 動作確認
ゲームを開始直後は "X" のターンなので、

[f:id:mamorums:20180705082650p:plain]

上の画像のように、画面左上の "X" がアクティブになります。

"X" が操作して "O" のターンになると、

[f:id:mamorums:20180705082706p:plain]

上の画像のように、画面右上の "O" がアクティブになります。

勝敗が決まったときは、勝者がアクティブになっています。

[f:id:mamorums:20180705082719p:plain]


## 次回
次は、ユーザーが "X" か "O" か（先攻か後攻か）を、選択できるようにしていこうと思います。

