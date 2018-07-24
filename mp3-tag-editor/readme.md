## 概要
このアプリは、MP3（複数）のタグ情報を設定します。設定項目と値は次の通りです。

- アーティスト：MP3 が保存されているディレクトリ名。
- アルバム：アーティストと同じ。
- 曲タイトル：MP3 ファイル名（拡張子は除く）。
- ジャンル：そのまま

これ以外のタグ情報は消去されます。


## 使用方法
### 前提
Java 1.8 以上がインストールされていること。

### 起動
`dist/tagedit.bat` を実行すると起動します。もしくは、`dist/mp3-tag-editor-0.0.3.jar` を java コマンドで実行します。

```
> java -jar mp3-tag-editor-0.0.3.jar
```

### ディレクトリ入力
起動すると、対象のディレクトリを聞かれます。

```
Input artist directory path.
>
```

MP3 が存在するディレクトリをフルパスで入力して Enter を押します。

```
Input artist directory path.
> C:\users\admin\music\artist

```

これで、ディレクトリ内の MP3 が更新されます。上の場合だと、アーティストとアルバムには、「artist」が設定されます。


## ビルド方法（FatJar作成方法）

```
> gradle fatJar
```
