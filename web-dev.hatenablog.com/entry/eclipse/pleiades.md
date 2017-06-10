---
Title: Eclipse：日本語化手順（Pleiadesプラグイン）
Category:
- Eclipse
Date: 2016-02-06T23:19:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/pleiades
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179019561
---

Pleiades プラグインを使って、Eclipse を日本語化する手順を書いています。日本語化するか迷っている場合は、[こちらの記事](/entry/eclipse/japanese) が参考になるかもしれません。

## 手順1. ダウンロード
[Pleiades のページ](http://mergedoc.osdn.jp/) を開いて、記載されている方法でプラグインをダウンロードします。

![page-pleiades-download](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814091457.png)

最新版・安定版のどちらでも良いと思います。（この記事は、最新版をダウンロードして書きました。）


## 手順2. 解凍
ダウンロードしたファイルを適当な場所で解凍します。


## 手順3. Eclipse インストール先に配置
解凍したら、その中身を Eclipse インストール先（例：C:\eclipse など）に配置します。

![eclipse-directory](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160814/20160814091458.png)


## 手順4. eclipse.ini の設定
Windows の場合、Eclipse インストール先の eclipse.ini を開いて、最終行に以下の２行を追加します。

```txt
-Xverify:none
-javaagent:plugins/jp.sourceforge.mergedoc.pleiades/pleiades.jar
```

Windows 以外の場合は、ini ファイルに追加する内容が違うみたいです。お手数お掛けしますが、Pleiades プラグインの `readme/readme_pleiades.txt` を参照して頂ければ幸いです。


## 手順5. 動作確認
いつもと同じ方法で Eclipse を起動します（eclipse.exe）。日本語の画面が表示されれば成功です。


## 参考文献
[readme_pleiades.txt - Pleiades 日本語化プラグイン](http://svn.sourceforge.jp/svnroot/mergedoc/trunk/Pleiades/readme/readme_pleiades.txt)
