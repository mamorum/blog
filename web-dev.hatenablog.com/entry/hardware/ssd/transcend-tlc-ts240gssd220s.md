---
Title: Transcend の TLC SSD に交換（TS240GSSD220S）
Category:
- etc
Date: 2017-11-17T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/hardware/ssd/transcend-tlc-ts240gssd220s
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812318203201
Draft: true
---

ノートPC が古くなってきて、もうちょっと速くならんかなと思い、SSD を使ってみることにしました。SSD に交換した後は、速さや静音性に感動して、はやく交換すれば良かったと思いました。

これから交換したらSSDや、交換時に使ったツール、それからもう少し細かい感想などを書いていこうと思います。


## 補足
交換自体は 2017年2月くらいにしているので、SSD を 10ヶ月くらい使ってみた感じで書いています。


## SSD
交換後のディスクは Transcend の TLC 採用 SSD で、240GB 2.5インチのものになります。型番は「TS240GSSD220S」です。

[asin:B01DRWWNX4:detail]

当時は一番新しそうでしたが、今は 3D TLC NAND のほうが新しい気がします。

[asin:B01MEGCFEP:detail]


## SSD利用環境
- 2017年2月〜：Windows7 64bit（ノートPC）
- 2017年6月〜：Windows10 64bit（デスクトップPC）

途中でPCを変えて、Windows10 になりました。そのときは、OS をアップグレードせず、SSD に Win10 をゼロから入れ直しました。SSD を一度まっさらにした感じです。


## 接続ケーブル（を含む移行キット）
Transcend の純正キットを使いました。

[asin:B01F2F5PKW:detail]

接続ケーブルやドライバー（ネジ回し）も付属してます。やっぱり純正だと安心感があって、それで Transcend にした感もあります。

あと、このキットを使うと古い HDD を外部ドライブとして活用できるみたいです。自分は活用してないんですが、ドライバー（ネジ回し）も使いやすかったので満足してます。


## 交換方法
以下の手順で Windows7 のデータを移行して交換しました。データ移行には、Transcend の [SSD Scope](https://jp.transcend-info.com/Support/Software-10/) を使いました。

1. PC（移行元の磁気HDD）に SSD Scope をインストール
2. SSD と PC をケーブルで繋げる
3. SSD Scope の システムクローンを実行
4. PCの磁気HDDをSSDを交換（物理的に）

SSD Scope のシステムクローンは、ちょっと日本語が化けたりしてたんですが、なんとかなりました。時間もそれなりにかかったんですが、磁気ディスクのIOで時間かかってたのかなぁと。

SSD に Windows10 をインストールしたときは、とても速かったような気がします。


## 感想
SSD関連のエラーとかは出たことなくて、安定して速い気がします。ちょっと前だと、SSD の寿命とか気にする傾向もありましたが、寿命短くてもSSD を使いたい感じです。

ただ、容量デカイと SSD の価格が高くなるので、その場合は磁気ディスクも検討したほうが良いかもしれません。最近だと SSD と磁気ディスクのハイブリッドとかも見かけました。
