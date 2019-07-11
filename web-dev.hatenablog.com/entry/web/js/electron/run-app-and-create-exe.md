---
Title: Electron：アプリの実行とexe作成
Category:
- JS/CSS/HTML
Date: 2018-02-27T10:49:42+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/electron/run-app-and-create-exe
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971620120212
---

[Electron](https://electronjs.org/) のアプリを実行する方法と、[Electron Packager](https://github.com/electron-userland/electron-packager) で exeを作成する方法を書いていきます。

ブログ執筆時に使った環境は以下の通りです。

- Windows10 64bit
- Node.js 8.9.4
- npm 5.6.0



## Electron のインストール
Electron とパッケージングツールをグローバルでインストールしました。

```
> npm install electron -g
> npm install electron-packager -g
```

インストールしたときのバージョンは以下の通りでした。

- electron 1.8.2
- electron-packager 11.0.0


## アプリの準備
今回のアプリは [electron-quick-start](https://github.com/electron/electron-quick-start) を使おうと思います。アプリをクローンして、そのディレクトリに移動しておきます。

```
> git clone https://github.com/electron/electron-quick-start
> cd electron-quick-start
```


## 実行 
アプリを実行するコマンドは以下の通りです。

```
> electron .
```

実行すると画面が表示されます。


## exeの作成
アプリの exeを作成するコマンドは以下の通りです。

```
> electron-packager . --electronVersion=1.8.2
```

これで、`.\electron-quick-start-win32-x64` の下に exe が作成されます。


## exe の実行
作成された exe を実行するとウィンドウが表示されます。

```
> .\electron-quick-start-win32-x64\electron-quick-start.exe
```


## 補足
`electron` と `electron-packager` をグローバルでインストールしていないと、今回の記事とは違う手順（コマンド）になるかもしれません。
