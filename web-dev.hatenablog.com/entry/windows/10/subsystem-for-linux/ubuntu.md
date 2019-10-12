---
Title: WSL：Windows Subsystem for Linux を使う
Category:
- Windows
Date: 2018-06-22T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/10/subsystem-for-linux/ubuntu
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971655889514
---

WSL（Windows Subsystem for Linux）を使って、Windows10 で Ubuntu を動かす方法を書いていきます。


## 前提
動作確認で使用した Windows のバージョンは以下の通りです。

- エディション：Windows 10 Home
- バージョン：1803
- インストール日：2018/05/09
- OS ビルド：17134.112


## 手順1. WSL の有効化
最初にコントロールパネルの「プログラム」を開いておきます。そこで「Windows の機能の有効化または無効化」をクリックします。

[f:id:mamorums:20180620133414p:plain]

新しいウィンドウ「Windows の機能」が開くので、「Windows Subsystem for Linux」にチェックを入れて「OK」ボタンを押します。

[f:id:mamorums:20180620133425p:plain]

再起動を求められるので、指示通り再起動します。


## 手順2. Ubuntu のインストール
Microsoft ストアを開いて、文字列「linux」などで検索します。

[f:id:mamorums:20180620133437p:plain]

検索するとディストリビューション（Ubuntu や SUSE Linux など）が表示されるので、Ubuntu を選択してインストールします。

※ インストールするには、Microsoft アカウントが必要になりそうです。


## 手順3. Ubuntu の起動
インストールが完了すると、スタートメニューに Ubuntu が追加されます。

[f:id:mamorums:20180620133453p:plain]

これをクリックして、Ubuntu を起動します。

[f:id:mamorums:20180620133506p:plain]

上の画像は起動後の画面です。初回起動は少し時間がかかるのと、ユーザー設定が必要になります。ユーザー名とパスワードは自由に設定して良さそうです。


## 補足1. Ubuntu の起動方法
コマンドプロンプトで `bash` を実行しても、Ubuntu を起動することができました。

```
c:\ > bash
/mnt/c $
```

## 補足2. Cドライブへのアクセス方法
Ubuntu 側の `/mnt/c` が、Windows 側の Cドライブみたいです。Windows 側のファイルを操作したい場合などは、`/mnt/c` 経由でアクセスすると良さそうです。


## 補足3. Ubuntu のバージョン
Ubuntu のバージョンを調べたら 16（xenial）でした。

```
~$ cat /etc/lsb-release
DISTRIB_ID=Ubuntu
DISTRIB_RELEASE=16.04
DISTRIB_CODENAME=xenial
DISTRIB_DESCRIPTION="Ubuntu 16.04.4 LTS"
```


## 補足4. sudo の設定（任意）
デフォルトだと sudo で毎回パスワードが求められそうなので、自分のユーザーはパスワード入力を不要にする方法を書いておきます。

下のコマンドを実行すると、

```
$ sudo visudo
```

設定ファイルが開くので、末尾に以下の文言を追加します。

```
ユーザ名 ALL=(ALL) NOPASSWD: ALL
```

設定を保存すると、sudo のパスワード入力が不要になります。


## 補足5. パッケージの更新（任意）
念のため、`apt` を使って更新しておきました。

```
$ sudo su -
# apt update
# apt upgrade
```

最近は、`apt-get` よりも `apt` が推奨されているようです。
