---
Title: Unity：C#ソリューション名の変更
Category:
- Unity
Date: 2019-03-11T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/script/change-csharp-solution-file-name
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117126988056713
---

Unity のプロジェクトで、C#ソリューション（*.sln ファイル）の名称を変更する方法を書いていきます。


## ソリューション名について
ソリューション名は、プロジェクトのルートディレクトリと同じ名称になるみたいです。

```
tht06/
  - tht06.sln
  - Assets/
    - Scenes/
      - Main.unity
    - Scripts/
      ・・・
```

上のフォルダ階層の例だと、ルートディレクトリ名が「tht06」なので、ソリューションファイル名が「tht06.sln」になります。


## 変更方法
プロジェクトのルートディレクトリ名を変更すると、ソリューション名が変わります。

ソリューションファイル（*.sln）は、Unity が自動生成してくれます。


