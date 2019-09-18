---
Title: タイピング紅魔郷：操作・ローマ字入力
Category:
- 二次創作
Date: 2019-09-18T23:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/nijisousaku/touhou/game/typing/koumakyou/manual/operation-and-input
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127163667682
---

東方Project の二次創作ゲーム「タイピング紅魔郷」のマニュアル（操作方法、入力方法、等）です。インストール方法は [こちら](/entry/nijisousaku/touhou/game/typing/koumakyou/manual/install-and-start)。


## キーボード操作
- 上下左右: 選択
- Esc: 戻る、一時停止
- Enter: 次へ、決定
- Space: タイピング開始
- S: 押し続けると会話スキップ

画面の動きがない時は、Enter を押すと次に進みます。


## メニュー説明
- Start: ゲームを開始します。６ステージあります。
- Extra: エクストラステージを開始します。
- Practice: ステージを選択してプレイできます。
- Scores: 過去のスコアを見ることができます。
- Config: ローマ字入力の設定ができます。
- Volume: BGMの音量設定ができます。
- Quit: ゲームを終了します。

初回プレイ時は、Config画面を確認して頂くことをお勧めします。



## ローマ字の入力設定
以下の文字は、Config画面でローマ字入力の設定ができます。

### 日本語１文字
- し: "si" or "shi"
- ち: "ti" or "chi"
- つ: "tu" or "tsu"
- ふ: "fu" or "hu"
- ん: "nn" or "n"
- じ: "ji" or "zi"

### 日本語２文字
- しゃ: "sya" or "sha"
- しゅ: "syu" or "shu"
- しょ: "syo" or "sho"
- しぇ: "sye" or "she"
- ちゃ: "tya" or "cha"
- ちゅ: "tyu" or "chu"
- ちょ: "tyo" or "cho"
- ちぇ: "tye" or "che"
- じゃ: "ja" or "zya"
- じゅ: "ju" or "zyu"
- じょ: "jo" or "zyo"
- じぇ: "je" or "zye"

左のローマ字がデフォルト設定になります。


## ローマ字の正誤判定
画面に表示されたローマ字通りに入力すると正解となります。

Config画面で設定したローマ字（or デフォルト設定）が、タイピング画面に表示されます。


## 「ん」の入力について
「ん」の入力を "n" に設定しても、以下の場合は "nn" と入力する必要があります。

### 1. 末尾
例. ほん

- OK: honn -> ほん
- NG: hon -> ほn

### 2. "n" の次が母音
例. はんい

- OK: hanni -> はんい
- NG: hani -> はに

### 3. "n" の次が "n"
例. たまんない

- OK: tamannnai -> たまんない
- NG: tamannai -> たまんあい


## ローマ字入力の受付速度
現在の仕様では、１フレームに１ローマ字（１つのキー）だけ評価しています。１フレームに複数のキーが入力された場合、最初のキーだけが評価されます。

※ このゲームだと、１フレームは約16.6...ミリ秒です（約60fps なので、1000ミリ秒 ÷ 60フレーム）。


## 次のページ
- [アンインストール・移行](/entry/nijisousaku/touhou/game/typing/koumakyou/manual/uninstall-and-data-migration)
