---
Title: AdSense：レスポンシブ広告の幅や高さを制限する
Category:
- etc
Date: 2019-11-02T02:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/blog/fix-size-of-responsive-ad
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/26006613457406853
---

AdSense のレスポンシブ広告で、幅や高さを制限する方法を書いていきます。


## 背景
レスポンシブ広告のサイズを一定の範囲に収めたいときに、この方法を使いました。固定幅の広告にしても良かったんですが、最近の AdSense は自動広告やレスポンシブ広告を推奨しているようです。


## 参考文献
下のリンク先を参考にしました。リンク先を開くと日本語で表示されました。

### コード修正方法
[https://support.google.com/adsense/answer/9183363:embed:cite]

### 広告サイズ
[https://support.google.com/google-ads/answer/7031480:embed:cite]


## コード例
このブログのヘッダー広告はこんな感じです。

```javascript
<script async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<!-- Dev_Header_Responsive -->
<ins class="adsbygoogle"
     style="display:inline-block;min-width:400px;max-width:970px;width:100%;height:90px;"
     data-ad-client="・・・"
     data-ad-slot="・・・"></ins>
<script>
     (adsbygoogle = window.adsbygoogle || []).push({});
</script>
```

`ins` タグの `style` 属性で制限できるようです。
