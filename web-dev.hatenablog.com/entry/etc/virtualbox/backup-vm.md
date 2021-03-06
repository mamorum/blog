---
Title: VirtualBox：仮想マシンのバックアップ
Category:
- etc
Date: 2017-12-29T07:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/virtualbox/backup-vm
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812329318984
---

Virtual Box の仮想マシンをバックアップする方法を書いていきます。ブログ執筆時の環境は以下の通りです。

- Windows10 64bit
- Virtual Box 5.1.30


## 1. バックアップ方法
今回は「仮想アプライアンス」でバックアップを取得しようと思います。仮想アプライアンスの場合、別の端末などでもインポート（リストア）することができます。


## 2. 仮想アプライアンスの取得
仮想マシンを停止して、メニューの「ファイル」から「仮想アプライアンスのエクスポート」を実行します。

[f:id:mamorums:20171224153528p:plain]

実行すると設定用のウィンドウが開きます。設定内容はデフォルトでも大丈夫だと思います。

バックアップは、OVAファイルとして書き出されます。


## 補足. リストアについて
メニューの「ファイル」を選択して「仮想アプライアンスのインポート」を実行するとリストアできます。

Virtual Box を 5.2.4 にアップデートしてからリストアしても問題ありませんでした。


## 補足. スナップショットについて
仮想マシンのバックアップ取得方法は、他にも「スナップショット」というやり方があったりします。


## 参考文献
[VirtualBoxのバックアップとリストア -  w.builwing.info](http://w.builwing.info/2013/10/05/virtualbox%E3%81%AE%E3%83%90%E3%83%83%E3%82%AF%E3%82%A2%E3%83%83%E3%83%97%E3%81%A8%E3%83%AA%E3%82%B9%E3%83%88%E3%82%A2/)

