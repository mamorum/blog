---
Title: GO：Workspace と GOPATH
Category:
- etc
Date: 2016-06-22T22:10:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/golang/gopath-workspace
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178794571
---

GO言語の Workspace と、環境変数「GOPATH」についてのメモを書いていきます。ちょっと長くなりそうなので、最初に「今回のまとめ（調査結果）」を書いておきます。


## 今回のまとめ
- 環境変数 GOPATH の値は、Workspace のパス。
- Workspace は、ディレクトリ src, pkg, bin を含む。
- 多くのプログラマは、Workspace が１つ。つまり、GOPATH も１つ。
- Workspace（の src）には、複数のパッケージ（複数のリポジトリ）が含まれる。


## Workspace
ワークスペースはディレクトリで、次の３つのディレクトリを含むようです。

- src：Go言語のソースが入る。
- pkg：パッケージオブジェクトが入る。
- bin：実行形式ファイルが入る。

パッケージオブジェクト・実行形式ファイルは、`go install` (or `go get`) を実行すると生成されるようです。


## src
開発するソース（パッケージ）は、他のライブラリと衝突しないパスを選ぶ必要があります。そのため、src は次のように構成されるみたいです。

```txt
src/
	golang.org/x/image/
		...
	github.com/user/package-path/
		main.go
		...
	github.com/user/package-path/
		...
```

次のような具体的な条件だと、

- GitHub ユーザは、`mamorum`。
- GitHub で管理するパッケージ `hello` と `stringutil` 作る。

下のような構成になります。

```txt
src/
	github.com/mamorum/hello/
		main.go
		...
	github.com/mamorum/stringutil/
		...
```

`hello` と `stringutil` は、それぞれ別の GitHub リポジトリとして管理されます。 


## 環境変数 GOPATH 
GOPATH の値には、Workspace のパスを指定するようです。

多くの Go言語プログラマは、１つの GOPATH（１つの Workspace）で、複数（or 全て）の ソース・パッケージ・リポジトリ・依存性を管理しているようです。


## 参考文献
- [How to Write Go Code - golang.org](https://golang.org/doc/code.html)
- [Goコードの書き方 - golang-jp.org](http://golang-jp.org/doc/code.html)

