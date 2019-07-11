---
Title: Java：クライアントロードマップについて
Category:
- 日記
Date: 2018-04-12T00:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/diary/2018/0410-about-java-client-roadmap
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971633563297
---

先日、[aoe-tkさん](http://aoe-tk.hatenablog.com/about) の以下の記事を拝見させて頂きました。

- [Java Client Roadmap Updateによせて (前編)](http://aoe-tk.hatenablog.com/entry/2018/03/11/203708)
- [Java Client Roadmap Updateによせて (後編)](http://aoe-tk.hatenablog.com/entry/2018/03/18/185144)

とても面白くて勉強になったので、自分も Java のクライアント側についてちょっと思うことを書いてみました。

Oracle のホワイトペーパーである [Java Client Roadmap Update](http://www.oracle.com/technetwork/java/javase/javaclientroadmapupdate2018mar-4414431.pdf) は、少しチラ見した程度です。内容に不備などあれば教えて頂けると嬉しいです。


## 前提
これから書いていく内容は、個人的なデスクトップアプリ開発や、業務アプリ開発などを対象としています。それ以外（Android、Java ゲーム、学術的なもの、など）のことはあまり考慮できてないです。


## クライアントロードマップの感想
あくまで個人的な感想ですが、

「Java のクライアントテクノロジーは、なかなか前途多難なのかなぁ。」

と思いました。

### Java FX について
Java FX のデスクトップアプリ開発は、C# など（Visual Studio）に比べると難しい気がしてます。自分は普段 C# 使わないんですが、それでも Visual Studio を使いたいなという感じです。ＰＣを Windows に固定してる会社もあると思うので、そういったところだと C# でデスクトップアプリを作るところが多いのかなと。

### AWT, Swing について
AWT と Swing は、Java 11 でもサポートされるみたいで、ホワイトペーパーには「少なくとも 2026年9月までサポートする（商用の場合？）」と書かれていました。

ただ、ずっと Java SE に梱包してサポートするなら、「何年何月まで」とか書かないような気もしました。もしかしたら、2026年以降も AWT と Swing が Java SE に梱包されるのかは議論されるのかもしれません（疑いすぎかも）。

### Applet について
本来の役割と現状を考えると、Java SE から削除されるのは仕方ないかなと思いました。


## Java 以外のクライアント技術
### Electron
最近流行っている気がします。[Visual Studio Code](https://code.visualstudio.com/), [GitHub Desktop](https://desktop.github.com/), [Atom](https://atom.io/) などが有名どころです。初回起動に少し時間がかかるのと、アプリサイズが大きくなるのがデメリットでしょうか。でも、パフォーマンスの高いPCだと、Code や Desktop はすぐ起動します。

有名なソフトウェアもありますし、GitHub, Microsoft も使っているので、今後も活発な気がします。


### Qt
[Qt](https://ja.wikipedia.org/wiki/Qt) を使うと、C++ でクロスプラットフォームなアプリが作れます。自分は Qt で開発された [MuseScore](https://musescore.org/) を使ってます。かなり良い感じです。

最近だと、Oracle Virtual Box でも使われてました。

[f:id:mamorums:20180409124849p:plain]

Virtual Box の GUI アプリは、もともと Java（Swing？）で作られてた気がしたんですが、変わってしまったみたいです。

Oracle 以外の大手も使ってますし、パフォーマンスが求められるアプリで使われるケースは多いのかと思います。C++ 向けとして、今後も安泰そうな気がします。


### Win32, WinForm, WPF（Visual Studio系）
クロスプラットフォームではないんですが、Windows のシェアなどを考えると、今後も広く使われていく気がします。Win32 もなくならならずに、ハード寄りのプログラムや、DirectX を使うゲームとかで使われ続けるのかと。


## 感想・まとめ
そもそもなんですが、クライアントアプリをクロスプラットフォームで開発する必要性がどこまであるのかは疑問だったりもします。ユーザーがかなり多くて、ユーザーのOSが多様なら検討するんだとは思いますが、それって最大手（Microsoft, Google, GitHub, etc）が開発するようなアプリなのかと思います。

業務が Windows 限定な企業もあると思いますし、個人だと Visual Studio も無償提供されるようになりました。Visual Studio はやっぱり使いやすいですし、見た目のデザインとかも良くなってます。

PCゲームなどは Windows 限定の作品も多いですが、多くのユーザーを獲得できていると思います。

そう考えると、クロスプラットフォームを売りにしている Java のクライアント技術はなかなか前途多難なのかなと思いました。
