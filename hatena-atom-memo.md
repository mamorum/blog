## はてなの実装
[はてなブログAtomPub](http://developer.hatena.ne.jp/ja/documents/blog/apis/atom)


## Java の AtomPub 実装
[https://abdera.apache.org/](https://abdera.apache.org/)

Getting Started の [AtomPub Client](https://cwiki.apache.org/confluence/display/ABDERA/AtomPub+Client) から始めると良さそう。


## entry タグの更新日
Web で編集すると、app:edited の日時が更新される。

```
<updated>2016-11-14T18:41:15+09:00</updated>
<published>2016-11-14T18:41:15+09:00</published>
<app:edited>2016-11-14T18:42:38+09:00</app:edited>
```

↓ Web（ブラウザ）で編集

```
<updated>2016-11-14T18:41:15+09:00</updated>
<published>2016-11-14T18:41:15+09:00</published>
<app:edited>2016-11-17T21:52:18+09:00</app:edited>
```


## blogsync の仕様
- app:editedの更新日をファイルのタイムスタンプ（更新日時）にしている。
- GETしたXMLの/entry/app:editedとファイルのタイムスタンプを比較している。
- ファイルのタイムスタンプが古ければ、ファイルをXMLの内容に更新しているっぽい。
