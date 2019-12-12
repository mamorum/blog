---
Title: Windows7：curl のインストール
Category:
- Windows
Date: 2019-12-11T22:55:00+09:00
URL: https://web-dev.hatenablog.com/entry/windows/7/install-curl
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179200904
---

curl は、色んなプロトコルでデータをやりとりできるツールです。今回は、curl を Windows 7（64bit）にインストールする手順を書きます。


## 2019.12.11 追記
Windows 10（64bit）の最新バージョンだと、インストールしなくても curl が使えました。

```
>where curl
C:\Windows\System32\curl.exe

>curl --version
curl 7.55.1 (Windows) libcurl/7.55.1 WinSSL
```


## 手順1. ダウンロード
[curl のダウンロードページ](http://curl.haxx.se/download.html) で、Win64 2000/XP x86_64 zip の「バージョン番号（今回は 7.45.0）」をクリックします。

![page-download-win64-2000-xp](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815154413.png)

クリックして開いたページで、Files Only (free) の ZIPファイルをダウンロードします。

![curl-files-only](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815154414.png)

ダウンロードしたら、ZIP を任意の場所（例：C:\curl）に解凍します。フォルダ構成は次のようになります。

```txt
C:\curl
  - bin
    - curl.exe
    - curl-ca-bundle.crt
  - dlls
  ...
  ...
```


## 手順2. 環境変数の設定
システムの環境変数 Path に「C:\curl\bin」を追加します。

![setting-path](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815154415.png)


## 手順3. 動作確認
コマンドラインを起動して、curl で Google にリクエストを投げてみます。

```txt
C:\>curl https://www.google.co.jp/
<!doctype html><html itemscope="" itemtype="http://schema.org/WebPage" lang="ja"><head><meta content="世界中のあらゆる情報を検索するためのツールを提供しています。・・・省略・・・
```

上記のようにレスポンスが返ってくれば成功です。


## 補足：実行時のエラー対応
「Visual C++ 再頒布可能パッケージ」がインストールされていないと、エラーメッセージ（コンピューターに VCRUNTIME140.dll がないため、プログラムを開始できません。この問題を解決するには、・・・）が表示されました。

![install-error-window](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815154416.png)

このパッケージのインストーラは、[Microsoft のダウンロードページ](https://www.microsoft.com/ja-jp/download/details.aspx?id=48145) にあります（64bit向け：vc\_redist.x64.exe、32bit向け：vc\_redist.x86.exe）。

インストール後に curl を実行すると、上記のエラーが出なくなりました。
