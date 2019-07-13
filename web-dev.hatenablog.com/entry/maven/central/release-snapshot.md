---
Title: Maven：SNAPSHOTのリリース方法
Category:
- Java
Date: 2017-12-05T07:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/maven/central/release-snapshot
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812321481536
---

Maven で SNAPSHOT をリリースする方法を書いていきます。


## SNAPSHOT とは？
`SNAPSHOT` とは、開発中のコードであることを示す値です。`-SNAPSHOT` というサフィックスがつけられたプロダクト（例：`sample-1.0.0-SNAPSHOT.jar` など）は、まだ安定してなくて、今後も更新される可能性がある、ということになります。


## リリース方法
`pom.xml` の `version` タグで、`-SNAPSHOT` 付きのバージョンを定義します。

```
  <groupId>com.github.mamorum</groupId>
  <artifactId>kaze</artifactId>
  <version>0.2.4-SNAPSHOT</version>
  <packaging>jar</packaging>
```

あとは、`pom.xml` で `distributionManagement/snapshotRepository` を定義しておきます。

```
  <distributionManagement>
    <snapshotRepository>
      <id>ossrh</id>
      <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    </snapshotRepository>
    <repository>
      <id>ossrh</id>
      <url>https://oss.sonatype.org/service/local/staging/deploy/maven2/</url>
    </repository>
  </distributionManagement>
```

その状態でデプロイ（`mvn deploy`）すると、Maven が勝手に `snapshotRepository` にリリースしてくれます。

上の定義だと、

- `-SNAPSHOT` あり
  - 名称例：`sample-1.0.0-SNAPSHOT.jar`
  - デプロイ先：`https://oss.sonatype.org/content/repositories/snapshots`
- `-SNAPSHOT` なし
  - 名称例：`sample-1.0.0.jar`
  - デプロイ先：`https://oss.sonatype.org/service/local/staging/deploy/maven2/`

となります。


## Central リポジトリの場合
Maven Central にリリースするときは、以下の URL をスナップショットのリポジトリーに指定することが多いと思います。

[https://oss.sonatype.org/content/repositories/snapshots](https://oss.sonatype.org/content/repositories/snapshots) 

スナップショットをリリースすると、上の URL から自分のリリースした資源を辿ることができます。ブラウザとかで開いてリンクをクリックしていく感じです。

また、スナップショットの場合は、[Nexus Repository Manager](https://oss.sonatype.org/#welcome) での作業は不要みたいです。リリースするとすぐ反映されました。


## 参考文献
[What is a SNAPSHOT version? - Maven](https://maven.apache.org/guides/getting-started/index.html#What_is_a_SNAPSHOT_version)
