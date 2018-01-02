DXライブラリで、以下のパッドのキー（コード）を確認した。

[iBUFFALO USBゲームパッド 8ボタン スーパーファミコン風 グレー BSGP815GY](http://buffalo.jp/product/input/gamepad/bsgp815/)


## 確認コード
関数 `GetJoypadInputState` を利用。

```
int key;
・・・
key = GetJoypadInputState(DX_INPUT_KEY_PAD1);
```

## 確認結果
左がパッドのボタン名。右の数値が int の値（上の変数 `key`の値）で、`PAD_ ・・・` がDXライブラリの定数名。

- 上ボタン: 8, `PAD_INPUT_UP`
- 下ボタン: 1, `PAD_INPUT_DOWN`
- 左ボタン: 2, `PAD_INPUT_LEFT`
- 右ボタン: 4, `PAD_INPUT_RIGHT`

- Aボタン: 16, `PAD_INPUT_1`（キーボードZ）
- Bボタン: 32, `PAD_INPUT_2`（キーボードX）
- Xボタン: 64, `PAD_INPUT_3`（キーボードC）
- Yボタン: 128, `PAD_INPUT_4`（キーボードA）

- Lボタン: 256, `PAD_INPUT_5`（キーボードS）
- Rボタン: 512, `PAD_INPUT_6`（キーボードD）

- SELECT: 1024, `PAD_INPUT_7`（キーボードQ）
- START: 2048, `PAD_INPUT_8`（キーボードW）


※ 十字キー（上下左右）は、斜めのコードもありそう。
