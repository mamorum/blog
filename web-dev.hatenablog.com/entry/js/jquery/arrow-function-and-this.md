---
Title: jQuery：アロー関数とthisの注意点
Category:
- JS
Date: 2018-03-02T17:47:10+09:00
URL: http://web-dev.hatenablog.com/entry/js/jquery/arrow-function-and-this
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971621226074
---

jQuery の イベントバインド（`.on`, `.click`, 等）で、アロー関数を渡すようにしたら、`this` を使っているところで不具合が発生しました。

これから、そのときに調べたことなどをまとめていきます。


## function の場合
アロー関数を使う前は、次のように `function` を渡してました。

```javascript
$('#list').on('click', 'a', function(e) {
  e.preventDefault();
  let $li = $(this).parent('li');
  ...
```

`$(this)` と書いたりして、クリックされた要素を操作できます。


## アロー関数の場合
### 良い例
`this` を `e.currentTarget` に置き換えると、上と同じように動作してくれます。

```javascript
$('#list').on('click', 'a', (e) => {
  e.preventDefault();
  let $li = $(e.currentTarget).parent('li');
  ...
```


### 悪い例
アロー関数内で `this` を使うと動作が変わってしまいます。

```javascript
$('#list').on('click', 'a', (e) => {
  e.preventDefault();
  let $li = $(this).parent('li');
  ...
```

アロー関数の `this` は、`function` の `this` とは違うみたいです。


### 補足
`this` を `e.target` にすると動きが変わる可能性があります。

```javascript
$('#list').on('click', 'a', (e) => {
  e.preventDefault();
  let $li = $(e.target).parent('li');
  ...
```

`e.target` は `this` と違うみたいで、`a` タグ以外の要素（例えば子要素）にも関数が実行されることがあります。


## 参考文献
- [ES6のアロー関数を使うとjqueryのon()でthisが効かない - MasKのpermission denied.](http://mask.hatenadiary.com/entry/2017/04/10/175750)
- [アロー関数 - mozilla](https://developer.mozilla.org/ja/docs/Web/JavaScript/Reference/arrow_functions)
- [イベントフロー - jQuery入門講座](http://www.jquerystudy.info/tutorial/applied/flow1.html)
