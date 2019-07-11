---
Title: Unity：ゲームの二重起動抑止
Category:
- Unity
Date: 2019-03-18T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/script/quit-duplicated-process
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117126988104708
---

Unity で開発したゲーム（アプリ）を、二重起動させない方法を書いていきます。方法としては、C#スクリプトで実装する感じです。


## 参考文献
[hiroakioishi/AvoidDoubleLaunch.cs - GitHub](https://gist.github.com/hiroakioishi/aa4c24788a2e96da7a5a8fecbeede684)


## コード例
ゲームのプロセスが二重起動になるかを判定するメソッド `IsDuplicated()` を用意して、

```cs
bool IsDuplicated() {
  Process[] proc = Process.GetProcessesByName(
    Process.GetCurrentProcess().ProcessName
  );
  if (proc.Length > 1) return true;
  return false;
}
void Start() {
  if (IsDuplicated()) Quit();
  // ・・・省略・・・
}
```

ゲーム開始時の `Start()` から呼び出すようにしてみました。二重起動している場合は `Quit()`（実装は後述）で終了するようにしています。


## 解説
自分の環境だと、

```cs
Process.GetCurrentProcess().ProcessName
```

の戻り値は、EXE名（拡張子なしの `string`）でした。

二重起動させたときの変数 `proc` は長さ `2` の配列で、

```cs
proc[0].ProcessName
proc[1].ProcessName
```

配列要素のプロセス名（上のコードの戻り値）もEXE名でした。


## ゲーム終了方法 - Quit() について
終了方法と`Quit()` メソッドの実装は、以下の記事に書いていました。

[https://web-dev.hatenablog.com/entry/unity/quit-game:embed:cite]


必要に応じて参照して頂けると嬉しいです。
