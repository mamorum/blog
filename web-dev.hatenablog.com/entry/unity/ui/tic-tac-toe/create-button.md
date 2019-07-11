---
Title: Unity UI：三目並べの開発３
Category:
- Unity
Date: 2018-06-26T08:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/create-button
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971657824308
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回はゲームボードにボタンを配置して、ユーザーがクリックできるように準備していきます。


## 1. ボタンの作成
UI Buttonを作成して、

[f:id:mamorums:20180626100055p:plain]

次のように設定していきます。

- 名前: Grid Space
- Transform: X=0, Y=0, Z=0（歯車のReset押下）
- Width: 128
- Height: 128
- Normal Color: 0, 204, 204, 255
- Highlighted Color: 128, 255, 255, 255
- Pressed Color: 51, 102, 102, 255
- Disabled Color: 55, 66, 77, 255

[f:id:mamorums:20180626100105p:plain]

全て設定すると、上のような感じになります。


## 2. テキストの設定
UI Button のテキスト（子要素）を選択して、

[f:id:mamorums:20180626100115p:plain]

次のように設定します。

- Text: X
- Font Size: 111
- Color: 255, 0, 102, 255

設定すると、シーンは以下のように表示されます。

[f:id:mamorums:20180626100128p:plain]


## 3. プレハブの作成
先ほど追加したボタンを、以下の手順でプレハブとして保存します。

1. Project ウィンドウで、`Prefabs` フォルダを作成します。
2. Hierarchy ウィンドウの `Grid Space` をドラッグして、`Prefabs` フォルダに移動します。

[f:id:mamorums:20180626100138p:plain]

手順通り進めると、上の画像のようにプレハブが保存されます。

保存されたら、

1. Hierarchy ウィンドウの `Grid Space` を削除します。
2. Project ウィンドウのプレハブ `Grid Space` をドラッグして、削除した場所に移動します。

これで、プレハブから作成された `Grid Space` が配置されます。


## 4. ボタンの複製
Hierarchy ウィンドウの `Grid Space` で右クリックして Duplicate（複製）します。これを８回続けて、ボタンを９つにします。

[f:id:mamorums:20180626100148p:plain]

ボタンの Transform を、それぞれ以下のように設定していきます。

- Grid Space: x=-170, y=170
- Grid Space (1): x=0, y=170
- Grid Space (2): x=170, y=170
- Grid Space (3): x=-170, y=0
- Grid Space (4): x=0, y=0
- Grid Space (5): x=170, y=0
- Grid Space (6): x=-170, y=-170
- Grid Space (7): x=0, y=-170
- Grid Space (8): x=170, y=-170

次に Project ウィンドウの Prefabs で、Grid Space の Text を選択します。

[f:id:mamorums:20180626100158p:plain]

選択したら、Inspector で Text プロパティの値（"X"）を削除します。プレハブのテキストを削除すると、全ての Grid Space から値が削除されます。

[f:id:mamorums:20180626100206p:plain]

上が最終的な表示で、左上から右に、

- 上段：Grid Space, (1), (2)
- 中段：(3), (4), (5)
- 下段：(6), (7), (8)

といった感じで並びます。


## 次回
今回作成したボタンにスクリプトを追加して、ユーザがクリックしたらマスを埋めれるようにしていこうと思います。
