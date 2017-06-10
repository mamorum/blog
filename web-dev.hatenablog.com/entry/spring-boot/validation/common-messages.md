---
Title: SpringBoot：バリデーションエラーメッセージの共通化
Category:
- Spring Boot
Date: 2015-06-12T15:46:00+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/validation/common-messages
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179545336
---

これから、`ValidationMessages_ja.properties` のエラーメッセージを共通化する手順を書いていきます。今回は例として、共通化前のプロパティファイルの内容が、次のようになっていると仮定します。

```
NotEmpty.customer.lastName = 姓は必須入力です。
NotEmpty.customer.firstName = 名は必須入力です。
Max.customer.lastName = 姓は {max} 文字以内で入力してください。
Max.customer.firstName = 名は {max} 文字以内で入力してください。
```

この書き方だと、次の表現が重複しています。

- 姓
- 名
- …は必須入力です。
- …は {max} 文字以内で入力してください。


## 手順1. ValidationMessages_ja.properties の変更
重複する表現を切り出して共通化します。修正後の内容は次の通りです。

```
lastName = 姓
firstName = 名
NotEmpty = は必須入力です。
Max = は {max} 文字以内で入力してください。
```
  

## 手順2. アノテーションの属性変更
アノテーション（Bean バリデーション：`@NotEmpty`, `@Size`）の message 属性に、新しいメッセージキーを設定します。

```java
public class Customer {

    @NotEmpty(message="{lastName}{NotEmpty}")
    @Size(max=50, message="{lastName}{Max}")
    private String lastName;

    @NotEmpty(message="{firstName}{NotEmpty}")
    @Size(max=50, message="{firstName}{Max}")
    private String firstName;

    // 省略・・・
}
```

message 属性は「`{キー名称}{キー名称}`」といったように、`ValidationMessages_ja.properties` に書いたキーを繋げて書くことができます。


## まとめ
これで、重複を排除しつつ、次のエラーメッセージが取得できます。

### 必須入力エラー（@NotEmpty）

```
姓は必須入力です。
名は必須入力です。
```

### サイズエラー（@Size）

```
姓は 50 文字以内で入力してください。
名は 50 文字以内で入力してください。
```
