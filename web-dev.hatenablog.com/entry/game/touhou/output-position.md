---
Title: 東方原作：映像が端に寄る場合の対応
Category:
- ゲーム
Date: 2020-07-18T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/game/touhou/output-position
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613599940615
---

東方Projectの原作をフルスクリーンで起動すると、映像が画面の端に寄ることがありました。

[f:id:mamorums:20200717221844p:plain]

これから、作品の映像を中央に寄せる対応方法を書いていきます。うまくいくと、下の写真のように表示されます。

[f:id:mamorums:20200717221901j:plain]


## 注意事項
他の PC が同じように改善するかは分かりません。また、こちらでは何も責任を取ることができないので、その点はご了承頂ければと思います。


## 対象作品
鬼形獣などの、比較的新しい作品で発生する気がします。


## 発生条件
Windows10 で、以下の条件を満たすと発生しました。

- 映像出力：HDMI
- リフレッシュレート：60p


## 対応方法1. HDMI 59p に変更
インテルの「グラフィックス・コマンド・センター」などを開いて、リフレッシュレートを「59p」に変更します。

[f:id:mamorums:20200717222115j:plain]


## 対応方法2. DisplayPort 60p に変更
出力を DisplayPort に変える対応です。DisplayPort だと「60p」でも端に寄ることはありませんでした。


## 当時の状況
DisplayPort から HDMI に変更した際に、リフレッシュレートも「60p」に変えてしまいました。それで、今回の事象に気付きました。


