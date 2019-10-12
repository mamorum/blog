---
Title: Linux：プロンプトを短くする
Category:
- Linux
Date: 2017-03-17T09:08:55+09:00
URL: https://web-dev.hatenablog.com/entry/linux/short-prompt
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687227825705
---

Vagrant の `ubuntu/trusty64`（Ubuntu 14）で、プロンプト（$ の前）が長かったので、短くする方法を調べてみました。


## 短くする設定
ホームディレクトリで `$ vi .bashrc` を実行して、一番下の行に次の文言を追加しました。

```
export PS1="\w\$ "
```

以下の内容だけ表示させるようにしています。

- \w: カレントディレクトリ
- \$: コマンド入力前の記号（$ or #）


## 設定の反映
`source` コマンドで反映できます。

```
vagrant@vagrant-ubuntu-trusty-64:~$ source .bashrc
```

もしくは、再ログインでも反映されます。


## 変更前
```
vagrant@vagrant-ubuntu-trusty-64:~$
```


## 変更後
```
~$
```

## 補足. Cent OS の場合
Cent OS でも、同じように `~/.bashrc` に追加すれば大丈夫だと思います。


## 参考文献
[Linuxのプロンプトの表示を変更する - Qiita](http://qiita.com/katsukii/items/da37d1fdf974bd0e4c2f)
