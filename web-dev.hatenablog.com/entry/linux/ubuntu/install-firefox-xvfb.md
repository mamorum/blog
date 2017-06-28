---
Title: Ubuntu：xvfbとfirefoxのインストール
Category:
- OS
Date: 2016-11-18T17:45:39+09:00
URL: http://web-dev.hatenablog.com/entry/linux/ubuntu/install-firefox-xvfb
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687194917557
---

Ubuntu 14（Vagrant Box の `ubuntu/trusty64`）で Selenium 関連のテストをしたくて、Xvfb と FireFox をインストールすることがありました。今回は、そのインストール方法と利用手順を書いていきます。 


## インストール
apt-get コマンドでインストールします。

```
$ sudo apt-get update
$ sudo apt-get install firefox xvfb
```


### 補足１：フォントのインストール
Xvfb とfirefox の利用時に、エラーが出たことがありました。そのときは、次のようにフォントをインストールしたら解消しました。

```
$ sudo aptitude install xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic
```

### 補足２：日本語フォントのインストール
FireFoxの画面（Selenium のキャプチャ）で、日本語の文字化けが発生したことがありました。そのときは、次のようにフォントをインストールしました。

```
$ sudo apt-get install fonts-ipafont-gothic fonts-ipafont-mincho
```


## 利用手順
Selenium のテストを実行する前（FireFox をヘッドレスで起動する前）に、「1. Xvfb を起動」して、「2. ユーザのディスプレイを設定」しました。

### 1. Xvfb の起動
次のコマンドで起動しました（バックグラウンドでのコマンド実行）。

```
$ sudo Xvfb :99 -ac -screen 0 1024x768x8 &
```

手動での起動が面倒な場合は、起動スクリプト（`/etc/init.d/` 配下等）を仕込むことになりそうです。

### 2. ディスプレイの設定
Xvfb を起動したときの番号（上の `99`）で設定します。

```
$ export DISPLAY=:99
```

手動での設定が面倒な場合は、`.profile`  などに書くことになりそうです。

