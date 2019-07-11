---
Title: Unityのバージョン番号とリリースプラン
Category:
- Unity
Date: 2019-02-04T06:30:00+09:00
URL: https://web-dev.hatenablog.com/entry/unity/version-and-release-plan
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/98012380841952529
---

Unity（開発環境）のリリースサイクルと、バージョン番号について調べたのでまとめていきます。


## １年間で４つのメジャーバージョン
今後は１年間に４つのメジャーバージョンがリリースされるみたいです。

2019年の場合は、

- 2018.4：LTSストリーム
- 2019.1, 2019.2, 2019.3：TECHストリーム

といった感じです。


## LTSストリーム（長期サポート）
西暦の後に `.4` が付くバージョンは、２年間の長期サポートになるみたいです。

マイナーバージョン（例：2018.4.x）のリリースは続きますが、新機能の追加や、APIの変更などはないみたいです。


## TECHストリーム（最新版）
西暦の後に `.1`, `.2`, `.3` が付くものは、新機能が盛り込まれる最新版になるみたいです。

こちらもマイナーバージョンのリリースは随時行われるみたいです。


## まとめ
安定版で開発したい場合は LTS（yyyy.4）、それ以外は最新版（yyyy.1-3）で良いのかと思います。

LTS もサポート期間は２年なので、それ以上長く続くようなゲームは、どこかでバージョンアップすることになるかもしれません。


## 参考文献
[https://blogs.unity3d.com/jp/2018/04/09/new-plans-for-unity-releases-introducing-the-tech-and-long-term-support-lts-streams/:embed:cite]

