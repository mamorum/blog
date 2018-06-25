---
Title: Unity UI：三目並べの開発１
Category:
- Unity
Date: 2018-07-02T07:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/tic-tac-toe/intro-and-create-project
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971657550482
---

Unity の UI（GameObject）を使って、三目並べゲームを開発してみることにしました。三目並べのルールなどは、Wikipedia などのページを参照して頂ければと思います。

[三目並べ - Wikipedia](https://ja.wikipedia.org/wiki/%E4%B8%89%E7%9B%AE%E4%B8%A6%E3%81%B9)

日本は「三目並べ」で、アメリカだと「Tic tac toe」、イギリスだと「Noughts and Crosses 」と呼ばれているみたいです。


## 参考文献
ゲーム開発の内容は、[Unity UI の公式チュートリアル](https://unity3d.com/jp/learn/tutorials/s/user-interface-ui) の「Creating a Tic-Tac-Toe game using only the UI」を参考にさせて頂きました。

作成する三目並べの画面などは、[Introduction and setting-up the project ](https://unity3d.com/jp/learn/tutorials/tic-tac-toe/introduction-and-setting-project?playlist=17111) に掲載されています。


## 環境
以下の環境で開発してみました。

- Windows10 Home 64bit
- Unity 2018.1.1f1


## 目次
- １．概要・プロジェクトの作成
- ２．ゲームボードの作成
- ３．ゲームボードを動かす
- ・・・作成中・・・

今回の記事は目次の一番目で、ゲームの概要を書きつつ、Unity のプロジェクトを作成していきます。


## 1. ゲームの概要
ゲームのプレイヤーは２人で、四角形を９つのマスに分けて、そこに「X」と「O」を埋めていくゲームです。縦横もしくは斜めに「X」か「O」を３つ並べたほうが勝ちになります。


## 2. プロジェクトの作成
Unity（開発環境）を起動して、新規プロジェクトを作成します。

[f:id:mamorums:20180625125415p:plain]

TicTacToe という名前で、２Dを選択しました。保存先（Location）は好きな場所で大丈夫です。

プロジェクトが表示されたら、Assets/Scenes にある Scene の名前を Main に変更しておきます。

[f:id:mamorums:20180625125428p:plain]


## 次回
今回はここまでで、次はゲームで使うボード（四角形と９個のマス）を作成していこうと思います。
