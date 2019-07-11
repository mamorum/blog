---
Title: Gradle：Eclipseにインポート
Category:
- etc
Date: 2016-05-14T13:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/gradle/eclipse-import-project
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687179310629
---

Gradle でビルドしている Java アプリ（Java プロジェクト）を、Eclipse にインポートする手順を書いていきます。


## 前提. インポートするアプリ
[SpringBoot入門：JSONの返却](/entry/spring-boot/intro/response-json) で紹介しているアプリをインポートしてみます。ソースコードは、次のリポジトリにもあります。

[gssb - GitHub](https://github.com/mamorum/blog/tree/master/code/gssb)


## 手順1. ビルドファイルの編集
ビルドファイルに次の内容を追加します。

```
apply plugin: 'eclipse'
```

また、provided スコープを定義している場合、Eclipse のクラスパスに追加されるように定義します（次の `eclipse.classpath {...}` の箇所です）。

```
configurations {
    provided
}
sourceSets {
    main.compileClasspath += configurations.provided
    test.compileClasspath += configurations.provided
}
// 以下の定義を追加。
eclipse.classpath {
    plusConfigurations += [configurations.provided]
}
```

※ GitHub 上の `gssb/build.gradle` には、あらかじめ上記２点を追加しています。


## 手順2. eclipse タスクの実行
Gradle コマンドの eclipse タスクを実行します。

```
gssb > gradle eclipse
・・・・
BUILD SUCCESSFUL
```

すると、Eclipse 関連の設定ファイル（.project, .classpath, .settings/*）が生成されます。


## 手順3. Eclipse にインポート
既存プロジェクト（Java プロジェクト）としてインポートします。

![eclipse-import](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160816/20160816104859.png)

上の画面で「次へ」を押して、プロジェクトのディレクトリを選択すればインポートできます。


## 補足1. Eclipse の Gradle プラグイン
Eclipse にいくつかプラグインをインストールしてみましたが、何度かエラーが出たので今回は使わないことにしました（私の操作や設定が悪いだけな気もしますが・・・）。

Buildship Gradle Integration というプラグインは、Eclipse Foundation が公開しているみたいです。Eclipse Mars にもバンドルされていました。


## 補足2. ビルドファイルの更新
build.gradle の依存関係などを更新したら、eclipse タスクを再実行して Eclipse に反映させる必要があります。

今回の手順でインポートした場合、そのあたりがめんどくさそうです。


## 補足3. Eclipse 設定ファイル
eclipse タスクで生成される .classpath には、ドライブ名やユーザ名を含む絶対パスがありました。

```
<classpathentry sourcepath="C:/Users/ユーザ名/.gradle/caches/modules-2/files-2.1/junit/junit/4.12/a6c32b40bf3d76eca54e3c601e5d1470c86fcdfa/junit-4.12-sources.jar" kind="lib" path="C:/Users/ユーザ名/.gradle/caches/modules-2/files-2.1/junit/junit/4.12/2973d150c0dc1fefe998f834810d68f278ea58ec/junit-4.12.jar"/>
```

この内容だと、他の環境ではエラーになる可能性があります。

そこで、eclipse タスクが生成するファイルは、ソース管理システムにコミットしない設定しておくと良さそうです。.gitignore だと、次のような設定で大丈夫です。

```
# gradle, eclipse
.gradle/
.settings/
.classpath
.project
```

もしかしたら、もっと便利にできる方法があるのかもしれません。
