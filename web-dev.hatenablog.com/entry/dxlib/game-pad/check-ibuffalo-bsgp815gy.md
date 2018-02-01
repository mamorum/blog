---
Title: DxLib：iBUFFALOゲームパッドの入力値
Category:
- DxLib
Date: 2018-01-28T12:50:22+09:00
URL: http://web-dev.hatenablog.com/entry/dxlib/game-pad/check-ibuffalo-bsgp815gy
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812341525037
---

[DXライブラリ](http://dxlib.o.oo7.jp/) の [関数 GetJoypadInputState](http://dxlib.o.oo7.jp/function/dxfunc_input.html) を使って、iBUFFALOゲームパッド BSGP815GY の入力値（入力状態）を確認したのでまとめていきます。


ゲームパッドの情報はこちら。

[asin:B06XWD8QQJ:detail]


## 確認用コード（一部）
関数 `GetJoypadInputState` の戻り値（`key` の値）を確認しました。

```
int key;
・・・
key = GetJoypadInputState(DX_INPUT_KEY_PAD1);
・・・
```

引数に `DX_INPUT_KEY_PAD1` を渡すと、パッドとキーボードの入力が拾えるみたいです。

ボタンが押されているか確認するには、戻り値（上の `key`）と DXライブラリの定数（`PAD_INPUT_*`）を使って、

```
if (key & PAD_INPUT_UP) {
  // 上ボタンが押されている
} else {
  // 押されていない
}
```

といった感じで書くことができます。


## 確認結果
パッドのボタンが押されているときの戻り値はこんな感じでした。

| パッド    | キーボード | 値       | DXライブラリの定数     |
|-----------|-------------|--------|--------------------------|
| 下          | 下             | 1        | `PAD_INPUT_DOWN` |
| 左          | 左             | 2        | `PAD_INPUT_LEFT`   |
| 右          | 右             | 4        | `PAD_INPUT_RIGHT` |
| 上          | 上             | 8        | `PAD_INPUT_UP`      |
| A           | Z              | 16      | `PAD_INPUT_1`        |
| B           | X              | 32      | `PAD_INPUT_2`        |
| X           | C              | 64      | `PAD_INPUT_3`        |
| Y           | A              | 128    | `PAD_INPUT_4`        |
| L           | S               | 256     | `PAD_INPUT_5`       |
| R           | D              | 512     | `PAD_INPUT_6`       |
| SELECT  | Q              | 1024   | `PAD_INPUT_7`       |
| START    | W             | 2048    | `PAD_INPUT_8`      |


## 補足. 同時押しの場合
キーを同時に押している場合は、各キーの値が加算されて戻ってきます。

（例）下と左の同時押し -> 戻り値 3（1 + 2）

下の例だと、左下が押されている場合は 1 と 2 の両方を通ります。

```
if (key & PAD_INPUT_DOWN) {
  // 1.下ボタンが押されている
} else {
  // 押されていない
}
if (key & PAD_INPUT_LEFT) {
  // 2.左ボタンが押されている
} else {
  // 押されていない
}
```

それぞれをチェックするように書いておけば大丈夫そうです。
