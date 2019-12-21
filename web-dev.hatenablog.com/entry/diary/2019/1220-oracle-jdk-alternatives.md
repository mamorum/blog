---
Title: Oracle JDK の代替
Category:
- 日記
Date: 2019-12-20T00:06:09+09:00
URL: https://web-dev.hatenablog.com/entry/diary/2019/1220-oracle-jdk-alternatives
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613486691769
---

最近 Javaを使ってなかったんですが、無償利用の場合は Oracle JDK を使わないほうが良い感じになっていました。ということで、自分が調べたことや、思ったことをまとめていこうと思います。


## Oracle JDK
無料の JDKも提供してるようですが、セキュリティパッチ適用などのサポート期間が短いみたいです。有償のサブスクも始めたみたいです。

自分が調べたのはそのくらいで、途中で完全無料かつサポート期間の長い JDKがあることに気づきました。それ以降は Oracle JDK のライセンス調査を中断しています。


## 代替のJDK
完全無料のものとしては、Amazon Corretto, AdoptOpenJDK などがあるみたいです。

[https://aws.amazon.com/jp/corretto/:embed:cite]

[https://adoptopenjdk.net/index.html:embed:cite]

他にも色々ありそうですが、自分は Amazon の JDK を選択しました。ブログにもインストール記事を書いてみました。

[https://web-dev.hatenablog.com/entry/java/jdk/corretto/8/windows10-install:embed:cite]


## Javaについて
Oracle のライセンス体系が変わっても、Java 自体には影響なさそうな気がします。Amazon は James Gosling も在籍してますし、頑張ってもらえたら嬉しいです。


## .NET Coreについて
最近は Microsoft の .NET Core に注目しています。クロスプラットフォームで無料っぽいので、サーバーサイド（ASP .NET Core）も試してみたいと思いました。

Windows ユーザーは、企業規模（or ユーザー数）に関わらず Visual Studio 無料とか、そうなったらインパクトありそうな気がします・・。
