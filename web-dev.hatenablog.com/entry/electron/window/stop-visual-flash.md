---
Title: Electron：画面のちらつき防止
Category:
- Electron
Date: 2018-03-12T06:30:00+09:00
URL: http://web-dev.hatenablog.com/entry/electron/window/stop-visual-flash
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/17391345971623234223
---

Electron で背景色が暗いアプリを作っていたら、アプリ起動時と画面遷移の時に画面のちらつきが発生しました。これから、画面のちらつきを抑える方法を書いていきます。


## ちらつきについて
アプリ起動時は、白い画面が表示されて、それから黒い画面になるのでちらつきを感じます。

[f:id:mamorums:20180308125308p:plain]

[f:id:mamorums:20180308125352p:plain]

画面遷移時は、上の白い画面を挟んで次の黒い画面になります。

まとめるとこんな感じです。

- アプリ起動：白 → 黒
- 画面遷移：黒 → 白 → 黒


## ちらつきを抑える方法
メインプロセスの JavaScript で、次のように書いていきます。

```javascript
win = new BrowserWindow(
  "show": false,
  "backgroundColor": "#222"
});
win.once('ready-to-show', () => { win.show(); });
```

### アプリ起動時
`BrowserWindow` に `"show": false` を渡してあげると、すぐにウィンドウが立ち上がらなくなります。`ready-to-show` のタイミングで（画面の準備が整ってから）`win.show()` をすると、起動時の白画面が表示されなくなります。

ただ、画面の準備で時間がかかると、ウィンドウが表示されるタイミングが遅くなります。白い画面を許容して早く立ち上げるか、画面の準備を待つか、一長一短なところがあります。


### 画面遷移時
`BrowserWindow` に `"backgroundColor"` を渡してあげると、画面遷移の白画面が指定した色になります。アプリの背景色が黒かったら、黒い色を指定するとちらつきが解決します。

アプリの画面が白系だったら設定しなくても大丈夫そうな気がします。


## 参考文献
[electron/browser-window](https://github.com/electron/electron/blob/master/docs/api/browser-window.md)
