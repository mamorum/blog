---
Title: Windows：コマンドの連結
Category:
- Windows
Date: 2016-09-29T13:59:47+09:00
URL: http://web-dev.hatenablog.com/entry/windows/concat-commands
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687186844036
---

Windows のコマンドプロンプトで、連続してコマンドを実行したいことがありました。どうやら、Windows も Linux のように、&& などでコマンドを連結できるようです。今回は、その調査内容をまとめていこうと思います。


## 参考文献
次の Microsoft のページを参考にしました。

[Command shell overview - MS TechNet](https://technet.microsoft.com/en-us/library/bb490954.aspx)

記事は WindowsXP 向けようです（自分の端末は Win7...）。XP 以降の OS の記事で、同じような内容のものは見つかりませんでした。


## コマンドの連続実行
コマンドを && で連結すると、最初のコマンドが成功した場合（おそらく %ERRORLEVEL% が 0 の場合）に、次のコマンドを実行してくれるようです。

```
command1 && command2
```

Win7 でも、連続実行できることを確認しました。

ただ、%ERRORLEVEL% の設定などは微妙な時があるみたいで、ハマるとなかなか辛そうな感じです。


## 補足
Microsoft の記事には、他にも & や || などでコマンドを連結する方法も書かれていました。

