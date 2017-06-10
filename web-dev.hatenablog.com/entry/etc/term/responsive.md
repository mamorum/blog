---
Title: 用語：レスポンシブ, レスポンシブWebデザイン
Category:
- etc
Date: 2016-03-22T16:35:00+09:00
URL: http://web-dev.hatenablog.com/entry/etc/term/responsive
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178928484
---

レスポンシブWebデザインとは、マルチデバイスに対応するWebサイトの実装手法です。Ethan Marcotte氏が提唱したもので、次の技術（テクニック）を使ってWebサイトを実装していきます。

- Fluid Grids
- Flexible Images
- CSS3 Media Queries

この３つの技術について、少しまとめてみました。


## Fluid Grids
Webページの横幅を100%として、いくつかのグリッドに分けてレイアウトする手法です。例えば、グリッドの横幅を「%」や「em」などの相対値で指定します。

```css
.col-1 {
	width: 25%;
	float: left;
}
.col-2 {
	width: 50%;
	float: left;
}
.col-3 {
	width: 25%;
	float: left;
}
```

横幅を「px（ピクセル）」などの固定値で指定すると、ディスプレイが大きくて不自然な余白が生まれたり、ディスプレイが小さくてコンテンツがはみ出たりします。

相対値で指定すると、コンテンツの大きさが変化するので、色んなディスプレイに丁度よくおさまることができます。


## Flexible Images
グリッド（や親要素）のサイズに応じて、メディア要素のサイズを変化させる手法です。例えば、画像要素のスタイルを、次のように指定することがあります。

```css
img {
	max-width: 100%
	height: auto;
}
```

`height: auto;` とすることで、アスペクト比も維持されます。


## CSS3 Media Queries
ブラウザの横幅などに応じて、ページのスタイルを切り替える手法です。例えば、次のように `@media` を使って記述します。

```css
@media (min-width: 768px) {
	
	/* ブラウザ幅768px以上に適用されるスタイル */
	p {
		・・・
	}

	・・・
}
```
