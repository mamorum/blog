---
Title: Unity UI：三目並べの開発４
Category:
- Unity
Date: 2018-06-27T11:06:30+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/create-script-for-button
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971658147903
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回はボタン（プレハブ）のスクリプトを作成して、ユーザがマスをクリックしたら "X" で埋めるようにしていきます。


## 1. スクリプトの作成
Hierarchey ウィンドウで、プレハブ `Grid Space` を選択しておきます。それから、下の画像のように Inspector の `Add Component` を押して、スクリプト `GridSpace` を作成します。

[f:id:mamorums:20180627110528p:plain]

次に、Project ウィンドウで Assets フォルダを開きます。

[f:id:mamorums:20180627110539p:plain]

フォルダ `Scripts` を作成して、スクリプト `GridSpace` をドラッグ＆ドロップで移動します。


## 2. スクリプトの編集
スクリプト `GridSpace` をダブルクリックで開いて、以下の内容を保存します。

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
}
```

## 3. インスペクタの設定
Unity の Projectウィンドウで、プレハブ `Grid Space` を選択して、インスペクタのスクリプトを以下の通り設定します。

- Button: プレハブの Grid Space をドラッグ＆ドロップ
- ButtonText: プレハブの Text をドラッグ＆ドロップ
- PlayerSide: "X"

[f:id:mamorums:20180627110551p:plain]

次は、OnClick() の設定をします。

下の画像のように、インスペクタ上のプラス「＋」ボタンを押して、追加された箇所（None）にプレハブ自身をドラッグ＆ドロップします。

[f:id:mamorums:20180627112439p:plain]

それから、NoFunctionの欄をクリックして、GridSpace の SetSpace() を選択します。

[f:id:mamorums:20180627110610p:plain]


## 4. 動作確認
最後に、再生ボタンを押して動作確認をします。

[f:id:mamorums:20180627110619p:plain]

UI Button（Grid Space）をクリックすると、色が変わって `X` が表示されます。また、一度クリックするとボタンが無効になるので、２回目のクリックは反応がない感じになります。


## 5. 次回
次回は、ゲームをコントロールするスクリプトを作成していきます。
