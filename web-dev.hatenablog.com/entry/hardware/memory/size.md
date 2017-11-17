---
Title: PCのメモリサイズについて
Category:
- etc
Date: 2017-11-30T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/hardware/memory/size
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812318510610
Draft: true
---

最近の Windows PC を購入する場合、メモリ（RAMの）容量は４～３２GBの間で選べたりします（一般的に 4GB, 8GB, 16GB, 32GB）。ただ、容量が大きくなると値段が高くなるので、PC購入前にメモリ使用容量をタスクマネージャーで調べておきました。

これからその調査結果を書いていこうと思います。


## 起動アプリが多い場合
以下のタスクを起動していると、使用メモリは約6GBでした。

- Chrome（ウィンドウ２つ、タブ１０以上）
- FireFox（ウィンドウ２つ、タブ１０以上、youtubeで動画視聴）
- iTunes
- GitHub Desktop（Windows版）
- PostgreSQL, pgAdmin4
- Vagrant (Virtual Box で Ubuntu), Putty
- Eclipse（Min Heap 1GB）, Jetty サーバ
- Sublime Text

[f:id:mamorums:20171117095939p:plain]

これだけ同時に使うこともあまりなかったりします。ブラウザはいつもより激しい使い方をしてます。


## 起動アプリが普段程度の場合
以下のタスクを起動していると、使用メモリは約3.8GBでした。

- Chrome（ウィンドウ１つ、タブ数個）
- FireFox（ウィンドウ１つ、タブ数個、youtubeで動画視聴）
- Eclipse（Min Heap 1GB）
- Sublime Text

[f:id:mamorums:20171117095951p:plain]

簡単なプログラム書いたり、開発ブログ書いたりすると、こんな感じですかね。


## 起動アプリが少ない場合
以下のタスクを起動していると、使用メモリは約2.8GBでした。

- FireFox（ウィンドウ１つ、タブ数個、youtubeで動画視聴）
- Sublime Text

[f:id:mamorums:20171117100004p:plain]

ネットやテキスト書くだけだと、こんくらいですね。


## まとめ
自分は8GBを選択することにしました。今のところ、8GB以上にしても速くならない気がしてます。


## 補足. メモリの価格（2017.11.17 時点）
メモリ容量が倍になると、価格も倍程度になりそうでした。

### 8GB：約1万円
[https://shop.tsukumo.co.jp/goods/4988755031196/201020050000000:title]

### 16GB：約2万円
[https://shop.tsukumo.co.jp/goods/4988755031189/201020050000000:title]

### 32GB：約3.8万円
[https://shop.tsukumo.co.jp/goods/0649528774286/201010013000000:title]
