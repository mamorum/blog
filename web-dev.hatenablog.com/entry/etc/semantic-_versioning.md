---
Title: バージョン番号の振り方（GitHub推奨）
Category:
- etc
Date: 2017-05-15T14:31:41+09:00
URL: http://web-dev.hatenablog.com/entry/etc/semantic-_versioning
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687246536763
---

バージョン番号の振り方を調べていたら、GitHub推奨の [セマンティック バージョニング（Semantic Versioning）](http://semver.org/lang/ja/) を見つけることができました。

今後はその仕様どおりバージョンを振っていこうと思いつつ、自分が忘れないように簡単なメモを書いてみました。


## 著者
セマンティック バージョニング著者は、GitHub共同設立者の [Tom Preston-Werner](https://github.com/mojombo) さんでした。[TOML](https://github.com/toml-lang/toml) という設定ファイルの作者だったりもします。


## 概要・要約
次のように採番するみたいです。

```
メジャー.マイナー.パッチ
```

それぞれの番号は半角ピリオドで区切られます。バージョン（番号）の上げ方は、要約するとこんな感じみたいです。

- 後方互換のない変更 -> メジャーをあげる
- 後方互換ありの機能追加 -> マイナーをあげる
- 後方互換ありのバグ修正 -> パッチをあげる


## 将来性
現在も似たような採番ルールにしているソフトも多い気がします（ルールを合わせやすそう）。また、GitHub のリリースページ（バージョンの入力欄あり）では、下の画像ように Semantic versioning の記載があります。

[f:id:mamorums:20170515143124p:plain]

今後、GitHub を利用している多くのソフトウェアが準拠していくのではないか（or すでに準拠している）と思っています。


## 補足
### 開発の初期段階
メジャーバージョンがゼロ（0.x.y）の場合は、開発初期段階と考えるようです。API は安定してなくて、いかなる変更も起こりうる感じです。

### アルファ版・ベータ版
アルファ版（例：1.0.0-alpha）や、ベータ版（例：1.0.0-beta）の採番方法も、[セマンティック バージョニングのページ](http://semver.org/lang/ja/) に記載されていました。
