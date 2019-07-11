---
Title: Java：MP3のタグを編集
Category:
- Java
Date: 2016-08-11T15:33:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/edit-mp3-tag
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178773357
---

MP3ファイルのタグ情報には、タイトル・アーティスト・アルバム・ジャンル・・・、などがあります。このタグ情報を一括で編集したくて、Javaでやってみることにしました。今回は、そのときのメモを書いていきます。


## ID3タグについて
MP3のタグ情報は、ID3タグという規格に従っているようです。

[ID3タグ - Wikipedia](https://ja.wikipedia.org/wiki/ID3%E3%82%BF%E3%82%B0)

ID3には色々なバージョンがあるみたいです。自分の端末（Windows 7）の場合、バージョン「ID3v2.3」で情報を書き込むと良さそうでした。


## Java のライブラリ
ID3タグのJava実装は、[ID3.org の Implementations](http://id3.org/Implementations) で紹介されていました。

その中でも、[jaudiotagger](http://www.jthink.net/jaudiotagger/)、[Beaglebuddy](http://www.beaglebuddy.com/) は、2015年も更新・リリースが行われていました。


## jaudiotagger を採用
今回は、MP3に保存されている既存のタグを削除して、バージョン「ID3v2.3」でタグ情報を書き込みたいと思っていました。色々調べていくと、jaudiotagger はそれを実現できそうでした。

Beaglebuddy は、既存のタグが削除できなさそうでした。でも、使いやすくて、ドキュメントも読みやすかったです。こういったプロダクトを作る人は、ID3の仕様を深く理解していて本当にスゴイです。


## jaudiotagger のサンプルコード
jaudiotagger を使って、既存のタグを削除するのはこんな感じでした。

```java
AudioFile f = AudioFileIO.read(file);
AudioFileIO.getDefaultAudioFileIO().deleteTag(f);
```

次のコードは、新しいタグ（ID3v2.3）に情報を設定して、MP3に書き込む例になります。

```java
ID3v23Tag t = new ID3v23Tag();
t.setField(FieldKey.ARTIST,"Artist");

// ... 省略

AudioFile f = AudioFileIO.read(file);
f.setTag(t);
f.commit();
```

`AudioFileIO.read(file)` で読み込む file を増やせば、一括編集が実現できそうでした。
