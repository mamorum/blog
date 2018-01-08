---
Title: MuseScore：ドレミ自動採譜
Category:
- 日記
Date: 2017-07-15T00:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/diary/muse-score/auto-doremi-shakuhachi-notation
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812281165540
---

[MuseScore](https://musescore.org/) で作成した楽譜に、[尺八用プラグイン](http://www-b.uec.tmu.ac.jp/shakuhachi/MuseScore_Shakuhachi/) を使ってドレミを自動採譜する方法を書いていきます。


## 1. 尺八用プラグインのインストール
### 1.1. プラグインのダウンロード
[尺八用プラグインのサイト](http://www-b.uec.tmu.ac.jp/shakuhachi/MuseScore_Shakuhachi/) で公開されている `Shakuhachi_Notation_v2_02.qml` を、`C:\Program Files (x86)\MuseScore 2\plugins`（Windows10 64bit の場合）にコピーします。

※ Mac や Windows 32bit の場合はインストール先が異なります。尺八用プラグインのサイトや、[MuseScoreのサイト](https://musescore.org/ja/%E3%83%8F%E3%83%B3%E3%83%89%E3%83%96%E3%83%83%E3%82%AF/%E3%83%97%E3%83%A9%E3%82%B0%E3%82%A4%E3%83%B3) をご確認ください。


### 1.2. プラグイン有効化
Muse Score を起動して、メニューの「プラグイン→プラグインマネージャ」を選択します。新しいウィンドウが開いたら、`Shakuhachi_Notation_v2_02` のチェックボックスをチェックしてＯＫボタンを押下します。

[f:id:mamorums:20170720105332p:plain]


### 1.3. フォントのインストール
[尺八用プラグインのサイト](http://www-b.uec.tmu.ac.jp/shakuhachi/MuseScore_Shakuhachi/) で公開されている以下のファイルをダウンロードします。

- Doremi.ttf
- Doremib.ttf


ダウンロードしたらファイルを右クリックしてインストールします。

※ 他のフォントファイルも公開されていますが、カタカナのドレミで採譜する場合は上の２つで大丈夫そうです。


## 2. 尺八用プラグインで採譜
メニューの「プラグイン」を押して、`Shakuhachi_Notation` をクリックします。新しいウィンドウが開いたら、Font で `DoReMi (Katakana)` を選択してＯＫボタンを押します。

[f:id:mamorums:20170720105347p:plain]

すると、次のようにドレミが採譜されます。

[f:id:mamorums:20170720105400p:plain]

音符や小節を選択してプラグインを使うと、選択した箇所だけ自動採譜されます。

[f:id:mamorums:20170720105410p:plain]


## 最後に
私は楽器ド素人で、自動採譜ができて本当に嬉しいです。尺八用プラグインを公開して頂き、本当にありがとうございます。
