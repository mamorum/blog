---
Title: Eclipse：Windows10 にインストール
Category:
- Java
Date: 2019-12-07T00:45:00+09:00
URL: https://web-dev.hatenablog.com/entry/eclipse/windows10-install
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/13355765958054457803
---

Eclipse IDE for Java Developers 2019-09 R を、Windows10 64bit にインストールする手順を書いていきます。

## 前提
JDK がインストールされていることが前提となります。インストールしていない場合は、以下の記事などを参考にして頂けると嬉しいです。

[https://web-dev.hatenablog.com/entry/java/jdk/corretto/8/windows10-install:embed:cite]


## 手順1. ZIPのダウンロード
<a target="_blank" href="https://www.eclipse.org/downloads/packages/">Eclipse のダウンロードページ</a> を開いて、「for Java Developers」 の「Windows 64bit」をクリックします。

[f:id:mamorums:20191207004718p:plain]

次のページに遷移したら、Downloadボタンを押して、ZIPファイルを任意の場所に保存します。


## 手順2. ZoneID の削除
起動を速くしたいので、アクセスのブロックを解除しておきます。

手順は、

1. ダウンロードしたZIPを右クリックしてプロパティを選択
2. セキュリティの「許可する」をチェック
3. OKボタンをクリック

といった感じで、下がそのイメージです。

[f:id:mamorums:20191207010305p:plain]

ZoneID の詳細は以下の記事にも記載しています。

[https://web-dev.hatenablog.com/entry/windows/10/delete-zoneid:embed:cite]


## 手順3. ZIPの解凍
ZIPファイルを解凍して、中身を任意の場所（今回は C:\opt\eclipse ）に配置します。

[f:id:mamorums:20170611120149p:plain]


## 手順4. メモリ設定（任意）
次の手順で、Eclipse の最少メモリサイズを１ＧＢに設定します。

1. `C\opt\eclipse\eclipse.ini` を開きます。
2. ファイル内の `-Xms256m` を `-Xms1024m` に変更して保存します。

Eclipse の使用中にメモリを拡張しなくなるので、動作速度が改善され（ると言われて）ます。


## 手順４. 動作確認
`C:\opt\eclipse\eclipse.exe` を実行して、画面が表示されれば成功です。Welcom（ようこそ）のビューは閉じて大丈夫です。
