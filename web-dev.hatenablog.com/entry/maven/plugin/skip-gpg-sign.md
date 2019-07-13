---
Title: Maven：GPGプラグインのスキップ
Category:
- Java
Date: 2016-10-23T19:50:19+09:00
URL: https://web-dev.hatenablog.com/entry/maven/plugin/skip-gpg-sign
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687190886861
---

[Maven GPG Plugin](http://maven.apache.org/plugins/maven-gpg-plugin/) を使うと、Maven のアーティファクト（jar などの生成物）を GnuPG でサインすることができます。このサインですが、必要になるのは Maven Central にアップロードするときなのかなと思います。

そこで、サイン（GPGプラグインの処理）をスキップする方法をまとめてみようと思います。


## 方法1. プロパティ gpg.skip を使う
普段は `gpg.skip` を `true` にしておいて、サインするときに `-Dgpg.skip=false` を渡します。

```
<properties>
  <gpg.skip>true</gpg.skip>
</properties>

<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-gpg-plugin</artifactId>
  <version>1.6</version>
  <executions>
    <execution>
      <id>sign-artifacts</id>
      <phase>verify</phase>
      <goals><goal>sign</goal></goals>
    </execution>
  </executions>
</plugin>
```

### 1.1. サインなしコマンド（普段）
```
mvn <goal>
```

### 1.2. サインありコマンド（デプロイ等）
```
mvn -Dgpg.skip=false deploy
```


## 方法2. profile タグを使う
Maven のタグを使って、普段は GPG プラグインを実行しないようにしておきます。サインするときだけ、コマンドで `-DperformRelease=true` を渡します。

```
<profiles>
  <profile>
    <id>release-sign-artifacts</id>
    <activation>
      <property>
        <name>performRelease</name>
        <value>true</value>
      </property>
    </activation>
    <build>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-gpg-plugin</artifactId>
          <version>1.6</version>
          <executions>
            <execution>
              <id>sign-artifacts</id>
              <phase>verify</phase>
              <goals><goal>sign</goal></goals>
            </execution>
          </executions>
        </plugin>
      </plugins>
    </build>
  </profile>
</profiles>
```

### 2.1. サインなしコマンド（普段）
```
mvn <goal>
```

### 2.2. サインありコマンド（デプロイ等）
```
mvn -DperformRelease=true deploy
```


## 最後に
`profile` は分りやすい気もしますが、タグ（記述量）は多くなっちゃいますね。他にも良さそうな方法があれば、教えて頂けると嬉しいです。


## 参考文献
- [Apache Maven GPG Plugin - gpg:sign](http://maven.apache.org/plugins/maven-gpg-plugin/sign-mojo.html)
- [Suppressing GPG signing ... - Stack Overflow](http://stackoverflow.com/questions/14825039/suppressing-gpg-signing-for-maven-based-continous-integration-builds-travis-ci)
