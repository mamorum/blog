---
Title: Eclipse更新 Mars→Oxygen
Category:
- Eclipse
Date: 2017-11-27T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/eclipse/update/mars-to-oxygen
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812318909695
---

Eclipse の 新バージョン [Oxygen](https://www.eclipse.org/oxygen/) をインストールして使ってみることにしました。もともと Mars.3 を使っていたので、Mars.3 から Oxygen.1a に更新した方法（自己流）を書いていこうと思います。

※ Oxygen.1a からは [Java9, JUnit5 がサポートされる](https://www.eclipse.org/eclipse/news/4.7/) ようです。


## 手順1. インストール
[Oxygen の Java Developers](https://www.eclipse.org/downloads/eclipse-packages/) をダウンロードしてインストールしました。


## 手順2. ワークスペースのコピー
Mars.3 で使ってたワークスペースをコピーしました。

- コピー元: `C:\Users\...\workspace`
- コピー先: `C:\Users\...\workspace-oxygen`

Eclipse が作成する `workspace` 配下の、

- `.metadata`
- `.recommenders`

をコピーする感じです。


## 手順3. Oxygen の起動
Oxygen を起動するとワークスペースの選択画面が出るので、先ほどコピーしたディレクトリに設定します。

[f:id:mamorums:20171118184819p:plain]

すると、以下の警告が出ます。

[f:id:mamorums:20171118185220p:plain]

要約すると「ワークスペースが古いからアップデートします。アップデート後は古いバージョン用に戻せませんが良いですか？」みたいな感じだと思います。

先ほどワークスペースをコピーしたので、コピー元の資源を使えば古い Eclipse に戻すこともできます。

ということで「OK」を押します。


## 手順4. 画面確認
なんだか設定はそこそこ引き継がれてそうでした。

[f:id:mamorums:20171118184855p:plain]

Maven プロジェクトでエラー出てたんですが、Update Project（Alt + F5）をすると解消されました。

これから使いながら細かいとこも確認していこうと思います。
