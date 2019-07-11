---
Title: JS：FetchAPIでJSONを受信
Category:
- JS/CSS/HTML
Date: 2017-12-31T18:19:05+09:00
URL: https://web-dev.hatenablog.com/entry/web/js/fetch-api-get
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812331788710
---

最近のブラウザで実装されている Fetch API を使って JSON を受信してみました。Fetch API は、XMLHttpRequest の代替として Ajax 通信ができたりします。


## コード
`/app/hello` から JSON を受け取って、 `#msg` のテキストを入れ替える感じで書いてみました。


```html
<!DOCTYPE html>
<html>
<head>
<title>Index</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<p id="msg">Loading...</p>
<script type="text/javascript">
(function() {
  fetch('/app/hello'
    ).then(res => res.json()
    ).then(json => {
      var msg = document.getElementById('msg');
      msg.textContent = json.msg;
    });
})();
</script>
</body>
</html>
```


## 動作
下のような JSON を受け取ると、

```
{"msg":"Hello, World."}
```

画面に表示されていた `Loading...` が、 `Hello World.` に代わります。
