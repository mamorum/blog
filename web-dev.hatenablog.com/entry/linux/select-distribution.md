---
Title: Linux：どのディストリビューションを使うか？
Category:
- OS
Date: 2017-12-03T19:25:00+09:00
URL: http://web-dev.hatenablog.com/entry/linux/select-distribution
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178813966
---

Linux を使ったり勉強するときに、どのディストリビューション（≒OS）にするか迷うことがあります。今回は「個人利用」と「仕事の勉強」という観点から、おすすめの OS を考えてみました。


## 個人利用は Ubuntu がおすすめ
Ubuntu は最新の機能を取り込むのが早かったり、パッケージ管理システム（apt-get）でインストールするソフトのバージョンも新しかったりします。

[Ubuntu - Wikipedia](https://ja.wikipedia.org/wiki/Ubuntu)

[Vagrant](https://www.vagrantup.com/) などで仮想環境を構築する場合にもおすすめです。Vagrant Box のランキング（下の画像、ダウンロード数順）を見ても、Ubuntu が人気だったりします。

[f:id:mamorums:20171203192606p:plain]


## 仕事の勉強なら CentOS が良いかも
会社とかで使う可能性があって、そのために勉強するのであれば、CentOS が良いかもしれません。

[CentOS - Wikipedia](https://ja.wikipedia.org/wiki/CentOS)


### 理由1. CentOS は商用に近い。
会社（特に大きな会社）では、商用ディストリビューション（有料の Linux）を使うことが多いと思います。CentOS は、国内商用として有名な Red Hat Enterprise Linux（RHEL）の完全互換を目指したフリーのＯＳです。

CentOS を使っていれば、会社で使う可能性の高い RHEL の勉強になりそうです。


### 理由2. VPS でも CentOS が使える。
VPS（やレンタルサーバ）を使っている企業も多いと思います。有名な「さくらの VPS」でも、CentOS は標準OS として採用されています。

[料金・仕様一覧｜VPS（仮想専用サーバ）はさくらインターネット](http://vps.sakura.ad.jp/specification/)


### 補足. Cent OS と Fedora 違い
Fedora も Red Hat 系統ですが、最新の技術を取り込む姿勢が強く、その点が CentOS や RHEL と違うようです。


## 参考文献
[有償linux ディストリビューション](https://jp.linux.com/resources/use/commercial-distribution)
