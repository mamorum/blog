---
Title: SpringBoot アプリ開発：5. ＵＩ（HTML, mustache）
Category:
- spring-boot-アプリ開発
Date: 2016-06-23T22:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/ui1
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179183836
---

つぶやきアプリ（[こちら](/entry/spring-boot/dev-web-app/table-of-contents) のアプリ）の ＵＩを作成していきます。HTML ファイルは１つで、その中にマークアップと mustache のテンプレートを書いていきます。


## HTML の作成
HTML の「作成場所（配置場所）」と「コード（完全版のリンク）」は、以下の通りです。

- 作成場所：`sbt/src/main/resources/public/index.html`
- コード：[index.html - GitHub](https://github.com/mamorum/blog/blob/master/code/sbt/src/main/resources/public/index.html) 


## HTML の概要
HTML の内容は、大きく以下のように分けることができます。

- head：meta情報、タイトル、使用する CSS などの宣言。
- header：画面最上部のナビゲーションバー。
- section：つぶやきの投稿欄と表示欄。
- footer：コピーライトの宣言。
- mustache：動的に生成する部分の mustache テンプレート。
- modal：つぶやき更新時に表示するモーダル。
- script：使用する JavaScript の宣言。

これから、分割したコードとメモを一緒に書いていきます。


## コード1. head
```html
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>つぶやき</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="css/tsubuyaki.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
```

内容は、Bootstrap の [Basic template](http://getbootstrap.com/getting-started/#template) とほぼ同じです。自前の CSS `tsubuyaki.css` も宣言しています。


## コード2. header
```html
<header>
<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <div id="brand">
        <img alt="brand" width="40" height="40" src="img/tsubuyaki.png">
      </div>
    </div>
  </div>
</nav>
</header>
```

Bootstrap のナビゲーションバーを利用しています。その中に次の画像を追加しています。

`sbt/src/main/resources/public/img/tsubuyaki.png`

![img-logo](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160815/20160815122745.png)


## コード3. section
```html
<section>
<div class="container">
  <div class="row">
    <div class="col-sm-6 col-sm-offset-3">
        <div id="tsubuyaki-form">
          <form class="form-horizontal">
            <div class="form-group">
              <textarea class="form-control" id="txt" rows="3" placeholder="ひとこと"></textarea>
              </div>
              <div class="form-group">
                <input type="button" id="create" class="btn btn-success pull-right" value="つぶやく">
              </div>
          </form>
        </div><!--  tsubuyaki-form -->
        <div id="tsubuyaki-list"></div>
      </div><!-- .col-sm-6 -->
  </div>
</div>
</section>
```

つぶやき投稿欄（`#tsubuyaki-form`）と表示欄（`#tsubuyaki-list`）を定義しています。表示欄は、後程出てくる mustache で動的に生成します。


## コード4. footer
```html
<footer>
<p>&copy; 2016 web-dev</p>
</footer>
```

コピーライトを書いています。


## コード5. mustache
```html
<script id="tsubuyaki-tmpl" type="x-tmpl-mustache">
{{#tsubuyaki}}
<div class="tsubuyaki" data-id="{{id}}">
  <div class="txt"><p>{{txt}}</p></div>
  <span class="action">
    <button type="button" class="btn btn-default edit">
      <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 編集
    </button>
    <button type="button" class="btn btn-default delete">
      <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 削除
    </button>
  </span>
  <span class="date">{{updatedTime}}</span>
</div>
{{/tsubuyaki}}
</script>
```

[mustache.js](https://github.com/janl/mustache.js/) のテンプレートです。サーバサイドから取得する JSON を使って、つぶやき表示欄のマークアップを生成します。

`{{#tsubuyaki}}` は、JSON の `tsubuyaki` プロパティの数だけ繰り返すという意味です。`{{txt}}`, `{{updatedTime}}` には、同じプロパティ名の値が入ります。


## コード6. modal
```html
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modal-label" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="modal-label">編集</h4>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <textarea class="form-control" rows="3" id="new-txt"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
        <button type="button" id="modal-update" class="btn btn-success">更新</button>
      </div>
    </div>
  </div>
</div>
```

つぶやき更新時に表示するモーダルです。Bootstrap のモーダルを利用しています。


## コード7. script
```html
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.2.0/mustache.min.js"></script>
<script src="js/tsubuyaki.js"></script>
</body>
</html>
```

最後に、利用する JavaScript を宣言しています。
