---
Title: Bootstrap 4.0.0 がリリースされてました。
Category:
- 日記
Date: 2018-02-07T16:41:52+09:00
URL: http://web-dev.hatenablog.com/entry/diary/2018/0207-bootstrap4-was-released
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812344682599
---

最近、[Bootstrap](https://getbootstrap.com/) のサイトを見たら、4.0.0（v4.0）が安定版としてリリースされてました。気付くのは遅くなりましたが、少しメモみたいなのを書いていこうと思います。


## リリース通知
Twitter だと、2018.01.18 に v4.0 のリリースがアナウンスされてたみたいです。

[https://twitter.com/getbootstrap/status/954061442940002304:embed]

更新内容（Change Log）とか、移行方法とかはまだ全然見れていない状況です。


## jQuery について
旧バージョンの Bootstrap（v3.3.7）だと、JavaScript プラグインを使う際に、jQuery の 1.12.4 を使ってました。

```
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
```

※ コード引用元： [Getting started - Bootstrap 3.3](https://getbootstrap.com/docs/3.3/getting-started/)）


新しい Bootstrap だと、jQuery は 3.2.1 になってました。

```
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
```

※ コード引用元： [Introduction - Bootstrap 4.0](https://getbootstrap.com/docs/4.0/getting-started/introduction/)）


## 当ブログのコード
このブログでは、旧バージョンの Bootstrap を使っていたサンプルコードがいくつかあった気がします。あと、jQuery も 1.*系（1.2.14？）を使っていました。

今後メンテナンスしていく記事は、いつか新しいバージョンにできたら良いなと思いました。
