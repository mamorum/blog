---
Title: C#：Hello World プログラムの作成
Category:
- C#
Date: 2019-06-24T01:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/csharp/hello-world
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127192835994
---

C# を使って、Hello World プログラムを作成する手順を書いていきます。


## 詳細
今回のアプリはコンソールアプリで、

[f:id:mamorums:20190609171342p:plain]

コマンドプロンプトに文字列を出力する感じです。


## 環境
ブログ執筆中の環境は以下の通りです。

- Windows10 64bit
- Visual Studio 2019


## 手順1. プロジェクトの作成
Visual Studio を起動して、C# の「空のプロジェクト」を選択します。

[f:id:mamorums:20190609171357p:plain]

ボタン「次へ」を押して、

[f:id:mamorums:20190609171407p:plain]

任意のプロジェクト名と保存場所を入力します。それから、ボタン「作成」を押します。


## 手順2. クラスの追加
メニューの「プロジェクト」をクリックして、「クラスの追加」を選択します。

[f:id:mamorums:20190609171415p:plain]

追加用のウィンドウが開いたら、C# のクラスを追加します。


## 手順3. コード作成
追加したクラスの名前を `Program` に変更して、

```cs
using System;

class Program {
  static void Main() {
    Console.WriteLine("Hello World !");
    Console.WriteLine("\r\n何かキーを押してください．．．");
    Console.ReadKey();
  }
}
```

上のコードを書いて保存します。


## 手順4. プログラムの実行
Visual Studio のメニューの下に「▶ 開始」ボタンがあるので、それをクリックすると実行できます。

コンソールに文字列が表示されれば成功です。
