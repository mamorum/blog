---
Title: Maven：ライセンスの設定
Category:
- Java
Date: 2016-10-09T12:02:37+09:00
URL: https://web-dev.hatenablog.com/entry/maven/license
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687188528834
---

Maven の pom.xml では、ライセンスの設定をすることができます。Central Repository に jar をデプロイしたり、ソースを公開したりするときに設定するようです。

これから、ライセンスの設定方法について調べたことを書いこうと思います。なお、ライセンスの種類（MIT, Apache, etc）や特徴についての説明は割愛させて頂きます。


## 設定方法
参考文献（記事末尾）によると、次のような内容で大丈夫そうです。

```
<licenses>
  <license>
    <name>MIT License</name>
    <url>http://www.opensource.org/licenses/mit-license.php</url>
  </license>
</licenses>
```

適用するライセンスの種類によって、`name`, `url` タグの値が変わります。


## distribution, comments について
`license` タグには、`distribution`, `comments` タグを追加することができます。

```
<license>
    ・・・
    <distribution>repo</distribution>
    <comments>A business-friendly OSS license</comments>
</license>
```

こちらは省略しても大丈夫そうな感じでした。


## distribution の詳細
`distribution` は、プロダクトの配布形式を設定するみたいです。自分が把握している設定値は次の通りです。

- `repo`：Maven Central リポジトリからダウンロード
- `manual`：利用者が手動でインストール

Maven に公開しているオープンソースだと、ダウンロードと手動（GitHub 等から資源を取得して）のどちらでもインストールできそうです。なので、先ほど述べたとおり省略で良いのかなと思いました。


## 補足
ちなみに、Maven 本体の [pom.xml](https://github.com/apache/maven/blob/master/pom.xml) には、ライセンスのタグ自体なさそうでした・・・。コード内のコメントや、他の場所でライセンスを宣言してれば不要なのかもしれません。


## 参考文献
- [License Information - The Central Repository](http://central.sonatype.org/pages/requirements.html#license-information)
- [Licenses - Maven](https://maven.apache.org/pom.html#Licenses)


## 関連記事
[GitHub：ライセンスを追加する](/entry/etc/github/add-license)
