---
Title: GO：Windowsにインストール
Category:
- etc
Date: 2016-06-21T23:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/golang/install-windows
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178794389
---

Windows に GO（GO言語ツールのバイナリディストリビューション）をインストールする方法を書きます。


## ダウンロード
公式サイト [https://golang.org/dl/](https://golang.org/dl/) から、最新版（執筆時 1.6.2）の msi をダウンロードしました。


## インストール
msi を実行して、画面の指示通りインストールしました。環境変数「GOROOT（`C:\Go`）」「PATH（`%GOROOT％\bin`）」は自動的に設定されました。


## 確認
### プログラムの作成
任意のディレクトリに作成します。

`hello.go`

```go
package main

import "fmt"

func main() {
    fmt.Printf("hello, world\n")
}
```

### GOPATH（環境変数）の設定
プログラムを作成したディレクトリのパスを、GOPATH の値として（一時的に）設定します。例えば、ユーザディレクトリ配下の `gowork` ディレクトリだと、次のように設定できます。

```txt
> set GOPATH=%USERPROFILE%\gowork
```

### プログラムの実行
次のように実行して、メッセージが表示されれば大丈夫です。

```txt
> go run hello.go
hello, world
```


## 参考文献
- [Getting Started - golang.org](https://golang.org/doc/install)
- [インストール - golang-jp.org](http://golang-jp.org/doc/install)

