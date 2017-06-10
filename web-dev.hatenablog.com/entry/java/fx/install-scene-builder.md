---
Title: JavaFX：SceneBuilderのインストール
Category:
- Java
Date: 2017-03-20T09:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/java/fx/install-scene-builder
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687228522867
---

JavaFX の GUI 周りを開発するために、SceneBuilder をインストールしてみました。これからその手順を書いてみようと思います。


## 補足. インストーラについて
SceneBuilder のインストーラは、[GLUON](http://gluonhq.com/) が配布しているものを使いました。詳細は、記事「[JavaFX：SceneBuilderの入手方法](/entry/java/fx/get-scene-builder)」に記載しています。


## 手順1. ダウンロード
[GLUON のダウンロードページ](http://gluonhq.com/products/scene-builder/#download) から、Windows Installer をダウンロードします。

[f:id:mamorums:20170319131139p:plain]

※ Eclipse から SceneBuilder を起動したいので、Windows Installer（exe 有り）を選択しました。PC に JDK がインストールされていて、java コマンドから起動する場合は、 Executable Jar でも大丈夫だと思います。


## 手順2. インストール
インストーラをダブルクリックして、インストールを始めます。

自分の場合、インストール先だけ変更してみました（`C:\opt\SceneBuilder`）。他はインストーラの指示通り進めました。


## 手順3. 確認
インストールが完了すると、インストール先に資源が展開されています。

```
C:\>tree /f C:\opt\SceneBuilder
C:\OPT\SCENEBUILDER
│  msvcp120.dll
│  msvcr100.dll
│  msvcr120.dll
│  packager.dll
│  SceneBuilder.exe
│  SceneBuilder.ico
│  unins000.dat
│  unins000.exe
│
├─app
│      dist.jar
│      LICENSE
│      SceneBuilder.cfg
│
└─runtime
    │  COPYRIGHT
    │  LICENSE
    │  README.txt
（省略）
```

Java のランタイムも含まれているので、少しサイズが大きくなっています。`SceneBuilder.exe` を実行すると、SceneBuilder が起動しました。

[f:id:mamorums:20170319131146p:plain]
