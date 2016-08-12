---
Title: Linux：コマンドの連結
Category:
- linux
Date: 2016-03-30T17:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/linux/concat-commands
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178814725
---

Linux のコマンドで、&& や || で連結している表現を見かけました。ちょっと気になって調べたので、その内容をまとめてみました。


## コマンド && コマンド
直前のコマンドが成功した（結果が０の）場合に、次（右方向）のコマンドが実行されます。

```
command1 && command2
command1 && command2 && command3
```


## コマンド || コマンド
直前のコマンドが失敗した（結果が０ではない）場合に、次（右方向）のコマンドが実行されます。

```
command1 || command2
command1 || command2 || command3
```


## 例
次の文は「変数 RETVAL が０だったら、touch コマンドを実行する」ことになります。

```
[ $RETVAL = 0 ] && touch "/var/lock/subsys/springboot"
```

## 参考文献
[UNIX & Linux コマンド・シェルスクリプト リファレンス](http://shellscript.sunone.me/exit_status.html)
