---
Title: GitHub：ライセンス情報を追加する
Category:
- Git
Date: 2016-10-04T17:31:01+09:00
URL: http://web-dev.hatenablog.com/entry/env/github/add-license
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687187754681
---

GitHub でリポジトリのライセンス（MIT, Apache 2.0, etc）を設定すると、リポジトリのページにライセンスを表示できるようです。イメージは下のような感じです。

![Github Repository License](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20161004/20161004163903.png?1475566759)

これから、既存のリポジトリにライセンスを設定する手順を書いていきます。


## 手順の概要
GitHub の Webページから LICENSE ファイルを追加します。

※ これ以外の設定方法もあるかと思います。今回の手順は、あくまで一例として見て頂ければ幸いです。


## 手順1. 追加画面の表示
次の URL をブラウザで表示します。`{ユーザ名}` と `{リポジトリ名}` は、GitHub の情報に応じて可変になります。

```
https://github.com/{ユーザ名}/{リポジトリ名}/new/master
```

リポジトリのトップ画面の URL末尾に `/new/master` を付けたものです。


## 手順2. ファイルの追加
画面を表示するとファイル名の入力エリアが表示されるので、そこに `LICENSE` と入力します。すると、その右にライセンスを選択するセレクトボックスが出てきます。

![Github Adding License](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20161004/20161004163904.png?1475568069)

設定したいライセンスを選ぶと、`Edit new file` にその条文が入力されます。必要に応じて編集して、コミット（とプッシュ）をすれば完了です。コミットボタンは画面の下にあります。


## 補足. ライセンスについて
この記事では、ライセンス自体の説明は割愛させて頂きました。Google 等で検索すると、各ライセンスの特徴や比較などの記事が見つかると思います。


## 参考文献
[Open source licensing - GitHub](https://help.github.com/articles/open-source-licensing/)
