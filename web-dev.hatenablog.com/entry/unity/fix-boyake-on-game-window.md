---
Title: Unity開発環境：Gameウィンドウがぼやける場合の対処
Category:
- Unity
Date: 2018-11-05T06:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/fix-boyake-on-game-window
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10257846132658396044
---

Unityエディタを使っていて、Gameウィンドウに表示される文字（UI）や画像（Sprite）がぼやけたりにじんだりすることがありました。

これからその対処方法などを書いていきます。


## 前提
OS と Unity のバージョンは以下の通りでした。

- Windows10 64bit（表示スケール125%）
- Unity 2018.2.13f1


## 対処方法
Gameウィンドウの Scale を `1.x` に変更したところ、問題が解消されました。

[f:id:mamorums:20181023142033p:plain]

`Low Resolution Aspect Ratios` のチェックを外して、Scale のバーを一番左に動かしました。

上のチェックボックスは、アスペクト比の箇所（16:9 などが表示されるところ）をクリックすると出てきます。


## 対処前
アスペクト比の `Low Resolution Aspect Ratios` にチェックが入っていて、Scale は `1.25x` となっていました。

[f:id:mamorums:20181023142042p:plain]


## 参考文献
[Game Window Scale - Unity Forum](https://forum.unity.com/threads/game-window-scale.539919/)
