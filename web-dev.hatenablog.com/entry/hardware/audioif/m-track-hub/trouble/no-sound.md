---
Title: M-Track Hub：音が出ない場合の対応
Category:
- ハード
Date: 2019-06-27T12:55:00+09:00
URL: https://web-dev.hatenablog.com/entry/hardware/audioif/m-track-hub/trouble/no-sound
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17680117127208947794
---

M-Audio のオーディオインターフェイス「M-Track Hub」から音が出なくなったことがありました。そのとき運よく解決できたので、対応方法をまとめていきます。

[asin:B01BYIP4IE:detail]

※ 他の環境で改善しなかったらごめんなさい。


## 事象
自分の場合、OSを再インストールしたら音がでなくなりました。そのときの操作は以下の通りです。

1. Windows10 64bit をクリーンインストール
2. M-Track Hub のドライバインストール
3. M-Track Hub を接続


## 原因
原因は不明ですが、USB接続するとPCに認識されていました。ハードやドライバ的な問題はなさそうな気がします。


## 対応方法
デバイスのプロパティで「既定の形式（ビットの深さ・サンプルレート）」を変更したら音が出るようになりました。変更内容は以下の通りです。

- 変更前：32ビット、44100Hz
- 変更後：16ビット、44100Hz

変更手順は、以下の記事にまとめています。

[https://web-dev.hatenablog.com/entry/windows/10/change-sound-bit-depth:embed:cite]


## 補足
一度音が出たら、変更前の値（32ビット、44100Hz）に戻しても音が出ました。ただ、32ビットだと、音が飛ぶことがありました。

もし、音飛びで悩んでいたら以下の記事が参考になるかもしれません。

[https://web-dev.hatenablog.com/entry/hardware/audioif/ototobi-otoware:embed:cite]

