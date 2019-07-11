---
Title: SpringBoot アプリ開発：7.ＵＩ（CSS, JavaScript）
Category:
- Spring
Date: 2016-06-24T19:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/spring-boot/dev-web-app/ui2
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179185878
---

つぶやきアプリ（[こちら](/entry/spring-boot/dev-web-app/overview) のアプリ）の ＵＩを作成していきます。今回は、CSS と JavaScript を１つずつ作成します。


## CSS の作成
CSS の「作成場所（配置場所）」と「コード（完全版のリンク）」は、以下の通りです。

- 作成場所：`sbt/src/main/resources/public/css/tsubuyaki.css`
- コード：[index.html - GitHub](https://github.com/mamorum/blog-code/tree/master/sbt/src/main/resources/public/css/tsubuyaki.css) 


## CSS の概要
アプリ画面の配色を定義したり、Bootstrap のスタイルを上書きしていたりします。詳細は、上のリンク先コードを参照して頂けると幸いです。


## JavaScript の作成
JavaScript の「作成場所（配置場所）」と「コード（完全版のリンク）」は、以下の通りです。

- 作成場所：`sbt/src/main/resources/public/js/tsubuyaki.js`
- コード：[tsubuyaki.js - GitHub](https://github.com/mamorum/blog-code/tree/master/sbt/src/main/resources/public/js/tsubuyaki.js) 


## JavaScript の概要
JavaScript の内容は、大きく以下のように分けることができます。

- ユーティリティ：共通的な関数を定義しています。
- オンロード時の処理：画面が表示された時の処理を書いています。
- ボタン押下時の処理：つぶやきの投稿・更新・削除等のボタンを押したときの処理を書いています。

これから、分割したコードとメモを一緒に書いていきます。


## コード1. ユーティリティ
```javascript
$(function() {

  // utilities.
  function render(data) {
    var tmpl = $('#tsubuyaki-tmpl').html();
    Mustache.parse(tmpl);
    var rendered = Mustache.render(tmpl, data);
    $('#tsubuyaki-list').prepend(rendered);
  }
  function format(msecString) {
    var d = new Date(Number(msecString));
    if (d.toLocaleDateString() === (new Date()).toLocaleDateString()) {
      // today. return 'hh:mm'.
      return ('0' + d.getHours()).slice(-2) + ':' +
            ('0' + d.getMinutes()).slice(-2);
    }
    // not today. return 'yyyy.mm.dd'.
    return d.getFullYear() + '.' +
          ('0' + (d.getMonth()+1)).slice(-2) + '.' +
          ('0' + d.getDate()).slice(-2);
  }
```

次の２つの関数を実装しています。

- mustache.js を使って、HTML を生成する関数。
- つぶやき日時をフォーマットする関数。


## コード2. オンロード時の処理
```javascript
// onload.
(function() {

  $('#txt').focus();

  // read.
  $.ajax({
    url: '/tsubuyaki',
    method: 'get',
    cache: false
  }).then(function(data, status, jqxhr) {
    render(data);
    $('.date').each(function(index, e) {
      $(e).html(format($(e).html()));
    })
  });
})();
```

次の処理を実装しています。

- つぶやき入力エリア（`.txt`）にフォーカスを当てる。
- つぶやき（の JSON）を取得して画面に表示。


## コード3. ボタン押下時の処理
```javascript
  // create.
  $('#create').click(function() {

    var txt = $('#txt').val();
    if (txt === '') return;

    $.ajax({
      url: '/tsubuyaki',
      data: JSON.stringify({'txt':txt}),
      contentType: 'application/json',
      method: 'post',
      cache: false
    }).then(function(data, status, jqxhr) {
      render(data);
      var $date = $('.tsubuyaki:first').find('.date');
      $date.html(format($date.html()));
      $('#txt').val('').focus();
    });
  });

  // update.
  var $tsubuyaki;
  $('body').on('click', '.edit', function() {
    $tsubuyaki = $(this).closest('.tsubuyaki');
    $('#new-txt').val($tsubuyaki.find('.txt p').html());
    $('#modal').modal();
  });
  $('#modal-update').click(function() {

    var txt = $('#new-txt').val();
    var url = '/tsubuyaki/' + $tsubuyaki.data('id');

    $.ajax({
      url: url,
      data: {'txt':txt},
      method: 'put',
      cache: false
    }).then(function(data, status, jqxhr) {
      $('#modal').modal('hide');
      $tsubuyaki.find('.txt p').html(txt);
    });
  });

  // delete.
  $('body').on('click', '.delete', function() {

    if (!confirm("削除しますか？")) return;

    var $tsubuyaki = $(this).closest('.tsubuyaki');
    var url = '/tsubuyaki/' + $tsubuyaki.data('id');

    $.ajax({
      url: url,
      method: 'delete',
      cache: false
    }).then(function(data, status, jqxhr) {
      $tsubuyaki.remove();
    });
  });
});
```

jQuery を使って、画面のボタンを押したときに、処理が実行されるようにしています。上から順に、投稿（`create`）、編集（`update`）、削除（`delete`）になります。

