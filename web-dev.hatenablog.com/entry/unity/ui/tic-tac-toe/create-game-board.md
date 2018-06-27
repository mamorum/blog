---
Title: Unity UI：三目並べの開発２
Category:
- Unity
Date: 2018-06-24T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/create-game-board
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971657566938
---

前回に引き続き、Unity UI で三目並べゲームを開発していきます。今回は背景とゲームボードを作成して、ゲームボードを９つのマスに分けていきます。


## 1. 背景の作成
前回作成した Mainシーンに、背景用の UI Panel を追加します。

[f:id:mamorums:20180625141541p:plain]

Panel を追加すると、Canvas と EventSystem も一緒に追加されます。

Panel は背景として使うので、名前を Background にして、色を黒（0, 0, 0, 255）に設定します。

[f:id:mamorums:20180625141601p:plain]


## 2. ゲームボードの作成
先ほどと同じように、ボード用の UI Panel を追加します。

[f:id:mamorums:20180625141614p:plain]

追加したら名前を Board にして、Inspector の四角い図形をクリックします。

[f:id:mamorums:20180625141625p:plain]

クリックしたら Shift+Alt を押しながら、middle/center の四角をクリックします。

[f:id:mamorums:20180625141635p:plain]

それから、Width と Height を 512 に設定して、カラーをダークブルー（33, 44, 55, 255）に設定します。カラーは使いまわせるように、「Click to add new preset」にチェックを入れておきます。

[f:id:mamorums:20180625141646p:plain]

背景とボードをを作成してゲームを実行すると、以下のように表示されます。

[f:id:mamorums:20180625141656p:plain]

黒背景の真ん中がボードになります。


## 3. マスの作成
９個のマスが必要になるので、３×３の格子を作成していきます。まずは UI Panel を作成して、

- 名前: Grid
- Anchor: middle/center
- Width:  5
- Height: 512
- Position X: -85.33
- Color: 255, 0, 102, 255（プリセットに追加）

[f:id:mamorums:20180625141711p:plain]

といった感じで設定します。

設定すると、下のような感じで表示されます。

[f:id:mamorums:20180625141722p:plain]

次に、Hierarchy で Grid を選択して Duplicate します。Grid(1) が複製されるので、以下のように設定を変えます。

- Position X: 85.33

設定したら Grid(1) を複製して、Grid (2) を以下のように設定します。

- Position X: 0
- Position Y: 85.33
- Width: 512
- Height: 5

最後に Grid(2) を複製して、Grid(3) を以下のように設定します。

- Position Y: -85.33

設定が完了すると、以下のように９つのマスが表示されます。

[f:id:mamorums:20180625141734p:plain]


## 次回
次回は、ボード上のマスをクリックできるようにボタンを配置していきます。

