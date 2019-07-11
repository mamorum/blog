---
Title: PowerShell：Zip作成時のダイアログ
Category:
- OS
Date: 2018-06-29T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/power-shell/zip-dialog-using-compress-archive
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971656500723
---

Windows の PowerShell で Zip を作成していたら、コマンドプロンプトの上に青いダイアログ（通知のような表示）がちらつくことがありました。その画面ハードコピーを取得できたので、忘れないようにメモっておきます。


## Zip 作成方法
ダイアログ（通知）が表示されたときは、PowerShell の `Compress-Archive` を使って Zip を作成していました。


## ダイアログ（通知）の内容
次のような青いダイアログで、

[f:id:mamorums:20180622083035p:plain]

```
アーカイブファイル '・・・' を作成しています．．．
```

と書かれていました。

ファイル圧縮の状況を知らせてくれる、プログレスバーのような感じでした。

