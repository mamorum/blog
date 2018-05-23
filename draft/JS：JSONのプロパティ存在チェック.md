/entry/www/js/lang/check-if-json-property-exists


JavaScript で、JSON のプロパティが存在するかチェックする方法を書いていきます。


## 例
サンプルのコードは以下の通りです。

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8" /></head>
<body>
<script>
check({});
check({"name": "Tom"});
function check(json) {  
  if ('name' in json) console.log('name有り。');
  else console.log('name無し。');
}
</script>
</body>
</html>
```

関数 `check` で、引数の JSONプロパティをチェックしてます。実行結果（ログ出力）は次のようになります。

```
name無し。
name有り。
```


## 解説
次のように書けば大丈夫そうです。

```javascript
'プロパティ名' in 検査対象のJSON（オブジェクト）
```

存在する場合は `true`、しない場合は `false` が返ってきます。上の例だと if の括弧内がこれに該当してて、`'name' in json` と書いていました。


## 補足. デフォルトのプロパティを追加
プロパティが存在しない場合に、デフォルトを設定したいことがあるかもしれません。JavaScript だと次のように追加することができそうです。

```html
<!DOCTYPE html>
<html>
<head><meta charset="utf-8" /></head>
<body>
<script>
let empty = {};
let tom = {"name": "Tom"};
setDefault(empty);
setDefault(tom);
console.log('Hello, ' + empty.name);
console.log('Hi, ' + tom.name);
function setDefault(json) {  
  if ('name' in json) return;
  else json.name = 'World';
}
</script>
</body>
</html>
```

実行結果は次のようになります。

```
Hello, World
Hi, Tom
```

プロパティが存在しない `empty` に、デフォルト値 `World` が設定されました。