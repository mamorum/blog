---
Title: Unity UI：ボタンクリック時の処理
Category:
- Unity
Date: 2020-03-30T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/ui/handle-button-click
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613542229481
Draft: true
---

Unity UI で、ボタンをクリックした時の処理を追加する方法を書いていきます。

※ Unity 2D のプロジェクトで動作確認しています。


## 手順1. ボタンとソースを追加
Unity の開発環境で、Button（GameObject）と C#スクリプトを追加しておきます。スクリプトは以下の通りです。

```cs
using UnityEngine;

public class Btn : MonoBehaviour {
  public void Click() {
    Debug.Log("Button Clicked.");
  }
}
```

ボタンクリック時に実行したい処理を、`public` メソッドで実装しています。`internal` や `private` はダメみたいですが、クラス名やメソッド名は任意で大丈夫です。


## 手順2. OnClick 処理を追加
ボタン（GameObject）にソースをアタッチして、インスペクタで OnClick 処理を追加します。手順は以下の通りです。

[f:id:mamorums:20200329180838p:plain]

1. ボタンにソースをアタッチ
2. `OnClick()` の `+` をクリック
3. `OnClick()` の Object にボタンをアタッチ
4. `OnClick()` の Function で `Btn.Click` を選択


## 手順3. 動作確認
ゲーム実行中にボタンをクリックして、ログ（`Button Clicked.`）が出力されれば成功です。
