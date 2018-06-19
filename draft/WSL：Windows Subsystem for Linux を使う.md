
## Ubuntu のバージョン
Ubuntu のバージョンを調べたら 16 の xenial でした。

```
~$ cat /etc/lsb-release
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=16.04
DISTRIB_CODENAME=xenial
DISTRIB_DESCRIPTION="Ubuntu 16.04.4 LTS"
```


## 5. sudo の設定（任意）
デフォルトだと sudo で毎回パスワードが求められそうなので、自分のユーザーはパスワード入力を不要にする方法を書いておきます。

下のコマンドを実行すると、

```
$ sudo visudo
```

設定ファイルが開くので、末尾に以下の文言を追加します。

```
ユーザ名 ALL=(ALL) NOPASSWD: ALL
```


## 6. パッケージの更新（任意）
念のため、`apt` を使って更新しておきました。

```
$ sudo su -
# apt update
# apt upgrade
```

最近は、`apt-get` よりも `apt` が推奨されているようです。
