---
Title: Struts2の脆弱性調査（参考文献など）
Category:
- Java
Date: 2017-04-06T21:00:33+09:00
URL: http://web-dev.hatenablog.com/entry/java/security/struts2-ognl
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687235180798
---

ちょっと前に、Struts 2 の脆弱性がニュースになったりしてました。その際、色んなニュース・記事・ブログなどを見させて頂きました。今回は、その中でも特に参考になったリンクなどをまとめてみました。


## 概要や事象など
- [Apache Struts 2における脆弱性 (S2-045、CVE-2017-5638)の被害拡大について - 株式会社ラック](https://www.lac.co.jp/lacwatch/alert/20170310_001246.html)
- [Apache Struts2 の脆弱性対策について(CVE-2017-5638)(S2-045)(S2-046) - IPA 独立行政法人 情報処理推進機構](https://www.ipa.go.jp/security/ciadr/vul/20170308-struts.html)

Struts 2 のウェブアプリが動いてるサーバで、任意のコードが実行されてしまうという感じです。


## 原因や分析など
- [Struts2のリモートコード実行可能脆弱性(CVE-2017-5638)を分析した](http://takahashikzn.root42.jp/entry/2017/03/08/132147)

上のブログ記事は、かなり詳しく（コードレベルで）解析されててすごいです。

Struts 2 は、OGNL式という任意のコードを実行させる仕組みを使っているようです。それを第三者が悪用して、任意のコードを実行したようです。


## OGNL式
- [Apache Commons OGNL](https://commons.apache.org/proper/commons-ognl/)
- [OGNL - wikipedia（英語）](https://en.wikipedia.org/wiki/OGNL)

英語のウィキペディアだと、セキュリティ上の問題についても書かれていました。


## 過去の脆弱性など
- [Apache Struts2 の脆弱性対策情報一覧 - IPA](https://www.ipa.go.jp/security/announce/struts2_list.html)
- [Apache Struts 2 DMIへの攻撃増加と、被害発生を確認しました - 株式会社ラック](https://www.lac.co.jp/lacwatch/people/20160428_000343.html)

Struts 2 の利用者も多いのか、過去にも脆弱性が見つかっていたみたいです。


## 興味深かったブログ記事
- [例えば、Strutsを避ける](http://www.scutum.jp/information/waf_tech_blog/2014/04/waf-blog-036.html)

2014年頃の記事みたいですが、その頃から Struts（OGNL式）の危険性を書かれています。先見の明があってすごいなと思いました。
