## 概要
このリポジトリには、[Web系開発メモ（はてなブログ）](http://web-dev.hatenablog.com/)の資源（記事・コードなど）を置いています。


### 記事（Markdown）
ディレクトリ [md](https://github.com/mamorum/blog/tree/master/md) で管理しています。記事は [blogsync](https://github.com/motemen/blogsync) で取得してコミットしています。

### コード
ディレクトリ [code](https://github.com/mamorum/blog/tree/master/code) で管理しています。ブログに掲載したコードなどを置いています。

### 画像
はてなフォトライフで管理しています。


### blogsync について
はてなブログの記事「[blogsync ではてなブログのエントリをローカルと同期する](http://motemen.hatenablog.com/entry/2014/12/22/blogsync)」で紹介されていたツールです。

ブラウザで投稿した記事を取得するために使っています。


#### 利用前準備
1. GO インストール
2. GOPATH 設定
3. blogsync インストール
4. 設定ファイル作成（config.yaml）

#### コマンド例
```
> blogsync pull web-dev.hatenablog.com
```



