---
Title: CentOS：日本時刻に設定（ntpd, ntpdate, timezone, localtime）
Category:
- linux
Date: 2016-03-31T18:21:00+09:00
URL: http://web-dev.hatenablog.com/entry/linux/centos/time-jp
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178815983
---

CentOS の時刻を、日本時刻に設定する手順を書いていきます。NTP で日本標準時と同期して、タイムゾーンを JST に変更します。

なお、作業は全て root で実施します。


## 手順1. NTP インストール
`yum` で NTP をインストールします

```
# yum install ntp
```


## 手順2. 時刻合わせ
`ntpdate` で時刻を合わせます。

```
# ntpdate ntp.nict.jp
```

コマンドの引数「ntp.nict.jp」は、[NICT の NTPサーバ](http://www2.nict.go.jp/aeri/sts/tsp/PubNtp/index.html) です。日本標準時に直結しています。


## 手順3. /etc/ntp.conf の編集

vi などで `/etc/ntp.conf` の一部を、次のとおり変更します。

`変更前`

```
server 0.centos.pool.ntp.org iburst
server 1.centos.pool.ntp.org iburst
server 2.centos.pool.ntp.org iburst
server 3.centos.pool.ntp.org iburst
```

`変更後`

```
server -4 ntp.nict.jp
server -4 ntp1.jst.mfeed.ad.jp
server -4 ntp2.jst.mfeed.ad.jp
server -4 ntp3.jst.mfeed.ad.jp
```

変更後の「server -4」は、IPv4 で NTP サーバに接続するということです。

それから「ntp1.jst.mfeed.ad.jp」「ntp2.jst.mfeed.ad.jp」「ntp3.jst.mfeed.ad.jp」は、[MFEED](http://www.jst.mfeed.ad.jp/) の NTP サーバ です。この３つは NICT の NTP サーバ（ntp.nict.jp）と同期しています。


## 手順4. ntpd の起動
次のコマンドで、NTP のデーモンを起動します。

```
# service ntpd start
```


## 手順5. ntpd の起動設定
次のコマンドを実行します。次回のサーバ起動時は、自動で NTP デーモンが起動するようになります。

```
# chkconfig ntpd on
```


## 手順6. タイムゾーンの確認
date コマンドで、タイムゾーンが UTC であることを確認します。

```
# date
Fri Mar 27 03:10:36 UTC 2015
```

UTC の箇所が JST だったら、次の手順は不要になります。


## 手順7. タイムゾーンの変更
まずは、現在のタイムゾーンのバックアップを取ります（任意）。

```
# cp /etc/localtime /etc/localtime.bak
```

それから、タイムゾーンを JST に変更します。

```
# cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
```


## 手順8. 日時の確認
`date` コマンドで、日時が正しいか確認します。

```
# date
Fri Mar 27 12:16:23 JST 2015
```

タイムゾーンも JST になっているので問題なさそうです。


## 参考文献
- [CentOS の Timezone 変更 - Qiita](http://qiita.com/snaka/items/a291423d6ceac9f091a7)
- [CentOSにntpサーバを入れて、日本標準時刻に自動的に合わせるためのメモ - Qiita](http://qiita.com/tsu_nera/items/9be676b04b190e45b281)
- [Technical Note : NTP シリーズ パート 4 ntpd によるローカルホストの時刻同期 - Nature's Linux Tech Portal](http://tech.n-linux.com/index.php?%A5%C6%A5%AF%A5%CB%A5%AB%A5%EB%A5%CE%A1%BC%A5%C8%2FNTP%2FNTP%20%A5%B7%A5%EA%A1%BC%A5%BA%20%A5%D1%A1%BC%A5%C8%204%20ntpd%20%A4%CB%A4%E8%A4%EB%A5%ED%A1%BC%A5%AB%A5%EB%A5%DB%A5%B9%A5%C8%A4%CE%BB%FE%B9%EF%C6%B1%B4%FC)
- [パソコンの時計　ハードウェア クロックとシステム クロック - eの らぼらとり](http://park12.wakwak.com/~eslab/pcmemo/clock/index.html)
