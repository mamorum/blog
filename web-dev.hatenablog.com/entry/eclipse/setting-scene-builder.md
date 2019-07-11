---
Title: Eclipse：SceneBuilderの設定
Category:
- Java
Date: 2017-03-21T17:28:12+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/setting-scene-builder
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687229303520
---

Eclipse で JavaFX 開発をするために、SceneBuilder の設定をしてみました。今回はその手順を書いていこうと思います。

## 前提
[e(fx)clipse](https://www.eclipse.org/efxclipse/install.html) と [SceneBuilder](http://gluonhq.com/products/scene-builder/) がインストールされていることが前提となります。インストール方法は、以下のリンク先に記載しています。

- [Eclipse：e(fx)clipseのインストール](/entry/eclipse/install-efxclipse)
- [JavaFX：SceneBuilderのインストール](/entry/java/fx/install-scene-builder)

e(fx)clipse は Eclipse のプラグインで、SceneBuilder は JavaFX の開発（主に画面周り）を支援してくれるツールです。


## 手順1. 設定を開く
Eclipse のメニューからプリファレンスを開きます（メニューの `Window` → `Preferences` をクリック）。

開いたら左袖の `JavaFX` を選択します。

[f:id:mamorums:20170321172848p:plain]

それから、上の画面のように `SceneBuilder executable` に SceneBuilder の exe のパスを入力します。


## 手順2. 確認
JavaFX プロジェクトで作成した「fxml ファイル」を右クリックして、`Open with SceneBuilder` を選択します。

[f:id:mamorums:20170321172914p:plain]

すると、下の画像のように SceneBuilder が起動します。

[f:id:mamorums:20170321172924p:plain]


## 補足
JavaFX プロジェクトの作成方法などは、別の記事でまとめていこうと思います。
