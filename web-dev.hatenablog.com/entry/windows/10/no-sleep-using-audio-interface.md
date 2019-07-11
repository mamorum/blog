---
Title: Windows10：オーディオIFの接続中にスリープしない
Category:
- OS
Date: 2019-07-05T10:25:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/10/no-sleep-using-audio-interface
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127152376405
---

PCにオーディオインターフェイスを接続するようになってから、Windows10 がスリープしなくなった気がしました。それから、少し調査したのでまとめてみました。


## 使用中のオーディオインターフェイス
今は、M-AUDIO の M-TRACK HUB を使用しています。

[asin:B01BYIP4IE:detail]


## 2019.07.05 追記
Windows10 を再インストールしたところ、オーディオインターフェイスの接続中もスリープに移行してくれるようになりました。音声出力があるアプリを立ち上げてなければ大丈夫そうなので、PCと常時繋いでおくようにしました。

以下の調査方法と結果は、Windows10 を再インストールする前の状態になります。


## スリープしない原因の調査方法
管理者権限でコマンドプロンプトを表示させて、

```
powercfg /requests
```

を実行すると、スリープを阻止しているもの（アプリやドライバ）が表示されるようです。詳細は以下のサイトを参考にさせて頂きました。

[Windowsが自動でスリープ移行できない時に原因を特定する方法 - deaimobi.com](https://deaimobi.com/windows-auto-sleep/)


## M-TRACK HUB 使用中（USB接続中）
コマンドを実行すると、

```
>powercfg /requests
DISPLAY:
なし。

SYSTEM:
なし。

AWAYMODE:
なし。

実行:
なし。

PERFBOOST:
[DRIVER] レガシー カーネルの呼び出し元
Power Manager

ACTIVELOCKSCREEN:
なし。
```

となっていました。全ての項目が「なし」だとスリープに移行するんですが、`PERFBOOST` の項目で引っかかってるようです。


## M-TRACK HUB 未使用（USB切断中）
上の結果だとオーディオインターフェイスがスリープを妨げているのか分からない感じです。ただ、オーディオインターフェイスを切断してからコマンドを実行すると、

```
>powercfg /requests
DISPLAY:
なし。

SYSTEM:
なし。

AWAYMODE:
なし。

実行:
なし。

PERFBOOST:
なし。

ACTIVELOCKSCREEN:
なし。
```

という結果になりました。そして、一定時間経過するとスリープに移行してくれました。

