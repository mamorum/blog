---
Title: SublimeText2：設定（Preferences の Settings - User）
Category:
- etc
Date: 2017-06-16T07:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/sublime-text-2/preferences-setting-user
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812270102743
---

Sublime Text 2 の自分用設定を、忘れないように書いていこうと思います。

今回の設定は「Setting - User」に保存しています。「Setting - User」は、メニューバーの Preferences で開くことができます。


## 設定内容
```
{
  "detect_slow_plugins": false,
  "ignored_packages":["Vintage"],
  "color_scheme": "Packages/Monokai Extended/Monokai Extended.tmTheme",
  "font_face": "Meiryo",
  "font_size": 14,
  "tab_size": 2,
  "word_wrap": true,
  "translate_tabs_to_spaces": true,
  "trim_trailing_white_space_on_save": false
}
```

## メモ
### `detect_slow_plugins`
値が `true` だと、起動時に時間がかかるプラグインを検出して表示します。時間がかかるパッケージ（IME Support 等）をインストールしているので、 `false` に設定しています。

### `trim_trailing_white_space_on_save`
値が `true` だと、行末尾の半角スペースをトリムしてくれます。マークダウンで行末尾スペース２つ（＝改行に変換）を使うことがあります。そのため `false`（デフォルトのまま）に設定しています。
