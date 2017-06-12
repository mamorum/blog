---
Title: Eclipse：メモリ使用状況の表示
Category:
- Eclipse
Date: 2017-06-12T09:32:35+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/preferences/show-heap-status
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958054926617
---

Eclipse のメモリ使用状況を表示する設定方法を書いていきます。

設定前に、プリファレンス（Preferences）を開いておきます。プリファレンスは、メニューバーの ウィンドウ（Window）から開くことができます。


## 設定方法
Preferences の General をクリックして、Show heap status をチェックします。

![heap-status](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814092756.png)


設定すると、画面下に Eclipse のヒープ使用状況が表示されます。


## 補足
eclipse.ini でヒープの最大値（-Xmx）と最小値（-Xms）を同じにしている場合は、設定しなくても良いかもしれません。
