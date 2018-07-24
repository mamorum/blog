## 概要
Windows PC のモニターをオフにするプログラムです。


## 実行環境
Windows7 64bit（ノートＰＣ）で動作確認済み。


## コンパイル方法
```
> C:\Windows\Microsoft.NET\Framework64\v4.0.30319\csc.exe /out:moff.exe MonitorOff.cs
```

※ 上の例は、OS 標準付属の `csc.exe` を使用。


## 参考文献
- [WM_SYSCOMMAND message - Windows Dev Center](https://msdn.microsoft.com/en-us/library/windows/desktop/ms646360%28v=vs.85%29.aspx?f=255&MSPPError=-2147217396)
- [SC_MONITORPOWER - Windows Dev Center](https://msdn.microsoft.com/en-us/library/windows/desktop/ms646360%28v=vs.85%29.aspx?f=255&MSPPError=-2147217396#SC_MONITORPOWER)
- [OSに標準付属のC#／VBコンパイラーでソースコードをコンパイルするには？ - @IT](http://www.atmarkit.co.jp/ait/articles/1504/15/news019.html)
