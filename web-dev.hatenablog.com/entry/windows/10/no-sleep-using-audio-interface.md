---
Title: Windows10：オーディオIFの接続中にスリープしない
Category:
- OS
Date: 2019-07-05T10:25:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/10/no-sleep-using-audio-interface
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613445075082
---

オーディオインターフェイスを接続するようになってから、Windows10 がスリープしなくなった気がしました。それから、少し調査したのでまとめてみました。

## 注意事項
全てのオーディオインターフェイスで、同じ事象が発生するかは分かりません。あくまで自分の環境に限った内容になります。


## スリープしない原因の調査方法
管理者権限でコマンドプロンプトを表示させて、

```
powercfg /requests
```

を実行すると、スリープを阻止しているもの（アプリやドライバ）が表示されるようです。詳細は以下のサイトを参考にさせて頂きました。

[Windowsが自動でスリープ移行できない時に原因を特定する方法 - deaimobi.com](https://deaimobi.com/windows-auto-sleep/)


## スリープに移行できる状態
コマンドを実行して、

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

全ての項目が「なし」だとスリープに移行できるみたいです。



## スリープに移行しない状態
自分の環境だと、

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

`PERFBOOST` の項目で引っかかってるようでした。

具体的な原因までは分からなかったのですが、オーディオインターフェイスを外すと `PERFBOOST` も「なし」になりました。



