---
Title: CentOS：日本語環境に設定
Category:
- Linux
Date: 2016-03-29T17:51:00+09:00
URL: https://web-dev.hatenablog.com/entry/linux/centos/lang-jp
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178815300
---

CentOS で、特定のユーザを日本語環境にする手順を書きます。


## 手順1. 日本語関連パッケージのインストール
次のコマンドで、パッケージをインストールします。

```bash
$ sudo yum -y groupinstall "Japanese Support"
```


## 手順2. 環境変数の設定
vi などで `~/.bash_profile` を開いて、最終行に次の文言を追加します。

```bash
export LANG=ja_JP.UTF-8
```

この設定が反映されるのはユーザ単位です。対象ユーザが多い場合などは、別の方法を検討したほうが無難だと思います。


## 補足. 環境変数の反映
次のコマンドで、追加した環境変数を反映できます（次回ログイン時は、自動で反映されます）。

```bash
$ source ~/.bash_profile
```

反映してから `date` コマンドなどを実行すると、日本語が表示されるようになります。
