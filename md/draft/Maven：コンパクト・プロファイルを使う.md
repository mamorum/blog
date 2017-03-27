maven/plugin/compiler-compact-profile


Maven のコンパイルで、コンパクト・プロファイルを指定する方法を書いていきます。コンパクト・プロファイルの解説は、[こちら](/entry/java/module/compact-profile) の記事を参照して頂けると嬉しいです。


## 指定方法
`maven-compiler-plugin` のタグ `compilerArgs` で、プロファイルを設定してみました。


__pom.xml（抜粋）__

```
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.6.1</version>
        <configuration>
          <compilerArgs>
            <arg>-profile</arg>
            <arg>compact1</arg>
          </compilerArgs>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
```


## エラーについて
指定したプロファイル以外を使っていると、次のようなエラーが出力されます。

```
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] ・・・省略・・・/src/main/java/C3.java:[7,7] java.lang.management.ManagementFactoryはプロファイル'compact1'で使用できません
[INFO] 1 error
```


## 参考文献
Maven の設定方法は、以下のブログ記事を参考にさせて頂きました。

[Mavenコンパイラープラグインでcompactプロファイルを指定する - argius note](http://argius.hatenablog.jp/entry/2015/08/26/122906)

リンク先の記事は、`maven-compiler-plugin` の `compilerArguments` タグを使っていました。
