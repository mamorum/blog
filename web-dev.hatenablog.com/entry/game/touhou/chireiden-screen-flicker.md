---
Title: 東方地霊殿：画面が乱れる場合の対応
Category:
- ゲーム
Date: 2020-05-02T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/chireiden-screen-flicker
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613553762941
Draft: true
---

Windows10 64bit で「東方地霊殿」をプレイしていたら、画面が少しちらつくことがありました。自分のPCだと、入力のレイテンシを「通常」に変更したら解消したので、これからその手順をまとめていきます。


## 補足
動作確認で使用した端末スペックは以下の通りです。

- CPU：Intel Core i5-7400
- GPU：Intel HD Graphics 630
- メモリ: 8GB
- ストレージ：SSD 250GB

他の実機で改善しなかったらごめんなさい。


## 手順
地霊殿インストール先の `custom.exe` を、ダブルクリックで起動します。

[f:id:mamorums:20200421134021p:plain]

画面が開いたら「入力のレイテンシ」を「通常」に変更して、「保存して終了」をクリックします。

