---
Title: Unity：ウィンドウタイトルの変更
Category:
- Unity
Date: 2019-04-02T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/script/change-window-title-for-standalone-pc
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117126993780448
---

Unityのゲーム（スタンドアロン、Windows向け）で、ウィンドウタイトルを変更する方法を書いていきます。


## 注意事項
これから記載していく方法だと、エクスプローラーのウィンドウタイトルが変わってしまうことがありました。

例えば、

- ゲームの EXE名（Unity の `Product Name`）が `sample-game`
- エクスプローラーで `sample-game` のフォルダを開いている

といった状態だと、ゲームとエクスプローラーのタイトル名が同じになります。その結果、FindWindow関数でエクスプローラーのウィンドウハンドラを取得して、そのタイトルを変更してしまう感じです。

ウィンドウタイトルを変更する場合は、上記の点などにご注意頂ければと思います。


## 変更後イメージ
下の画像の赤枠箇所が変更される感じです。

[f:id:mamorums:20190315130502p:plain]

また、下のように、タスクバーのタイトルも変わります。

[f:id:mamorums:20190315130514p:plain]


## 変更方法
C#スクリプトを用意して、以下のコード例のように書いていきます。

```cs
using UnityEngine;
using System.Runtime.InteropServices;

public class Title : MonoBehaviour {
  public string txt;
  #if UNITY_STANDALONE_WIN
    [DllImport("user32.dll", EntryPoint="FindWindow", CharSet=CharSet.Unicode)]
    static extern System.IntPtr FindWindow(string className, string windowName);
    [DllImport("user32.dll", EntryPoint="SetWindowText", CharSet=CharSet.Unicode)]
    static extern bool SetWindowText(System.IntPtr hwnd, string txt);
    void Start() {
      System.IntPtr hwnd = FindWindow(null, Application.productName);
      SetWindowText(hwnd, txt);
    }
  #endif
}
```

条件付きコンパイル `#if ... #endif` で、スタンドアロンのWindowsだけタイトルを変更するようにしています。

あとは Unity Editor で GameObject を作成して、上のコードをアタッチします。タイトル名は、プロパティ `txt` で設定します。

[f:id:mamorums:20190315130524p:plain]


## 注意1. 日本語について
関数 `SetWindowText` の DllImport で、`CharSet=CharSet.Unicode` を設定しないと、日本語のタイトル名が文字化けしました。

日本語のタイトルを設定する場合は少し注意が必要です。


## 注意2. 変更タイミング
上のコード例だと `Start()` が呼び出されてから、ウィンドウタイトルが変わります。それまでは EXE名がタイトルになるようです。


## 補足1. EXEの名称
今回のような設定をしないと、ウィンドウタイトルはEXEの名称になります。例えば `sample-game.exe` だと、タイトルは `sample-game` のようです。

EXE名の変更方法は以下のリンク先にも書いています。

[https://web-dev.hatenablog.com/entry/unity/build/change-exe-name:embed:cite]


## 参考文献
- [Unityでタイトルバーの文字列を動的に変更する - Qiita](https://qiita.com/broken55/items/5a2faca1a039f47e43f0)
- [Win32 APIやDLL関数を呼び出すには？ - .NET TIPS](https://www.atmarkit.co.jp/ait/articles/0305/09/news004.html)
- [Win32 APIやDLL関数に文字列や文字列バッファを渡すには？ - .NET TIPS](https://www.atmarkit.co.jp/fdotnet/dotnettips/025w32string/w32string.html)
