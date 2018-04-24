---
Title: Vanilla.js 入門
Category:
- JS/CSS/HTML
Date: 2017-01-18T19:19:49+09:00
URL: https://web-dev.hatenablog.com/entry/js/vanilla-js
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687207755545
---

JavaScript のことを調べていたら、[Vanilla JS](http://vanilla-js.com/) というものに出会いました。なかなか興味深かったので、これから Vanilla JS についてまとめていこうと思います。


## Vanilla JS はジョーク
[Vanilla JS](http://vanilla-js.com/) は、速くて軽い JavaScript フレームワークとして紹介されています。

ですが、実際のところ Vanilla JS というフレームワーク（の実体, JSファイル）は存在しないみたいです。ダウンロードはできますが、ファイルの内容は空っぽでした。


## Vanilla JS の伝えたいこと
じゃあ何がしたいんだ？（何を伝えたいんだ？）ってことになりますが、

「フレームワークを使わずに、JavaScript の標準的なメソッドや構文をそのまま使うと速い。」

と言ってる感じです。


## 速さの比較
Vanilla JS のページには、他のフレームワークとの比較が掲載されてます。DOM の取得（by ID）だと、次のような結果みたいです。

### Vanilla JS
- Code:`document.getElementById('test-table');`
- ops / sec: 12,137,211

### jQuery
- Code:`$jq('#test-table');`
- ops / sec: 350,557

### MooTools
- Code:`document.id('test-table');`
- ops / sec: 78,802

ちょっと環境とかは分んないですが、結果としては jQuery の 約35倍、MooTools の 約154倍でした（ops / sec ＝ １秒間の実行回数）。


## Vnilla JS のドキュメント
ドキュメントのリンクをクリックすると、[mozilla の JavaScript ページ](https://developer.mozilla.org/en-US/docs/JavaScript) が開きました。


## 補足
コンピュータ関連の場合、バニラという単語は「提供された状態のまま」「普通の・平凡な」といったことを指すことがあるみたいです。

[バニラ (ソフトウェア) - Wikipedia](https://ja.wikipedia.org/wiki/%E3%83%90%E3%83%8B%E3%83%A9_\(%E3%82%BD%E3%83%95%E3%83%88%E3%82%A6%E3%82%A7%E3%82%A2\))

自分も初めて知りました。


## 参考文献
[Vanilla JS - 公式サイト](http://vanilla-js.com/)
