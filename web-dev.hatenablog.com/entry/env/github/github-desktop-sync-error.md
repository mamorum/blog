---
Title: GitHub Desktop で Sync できないエラー
Category:
- 環境
Date: 2017-11-07T16:20:39+09:00
URL: https://web-dev.hatenablog.com/entry/env/github/github-desktop-sync-error
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812315334818
---

[GitHub Desktop](https://desktop.github.com/) を使っていたら、リポジトリを Sync できないエラーが発生しました。端末（Win10）を再起動したら解決したんですが、念のためそのときの事象とかメモっておきます。


## 事象
Sync ボタンを押すと、プログレスバーが途中で止まって、Failed to sync this branch と表示されました。

[f:id:mamorums:20171107162027p:plain]


## 環境
- Windows10 64bit
- GitHub Desktop 3.3.4.0

GitHub Desktop のバージョンはブログ執筆当時（2017.11.07）の最新でした。確認画面だと「Chocolate-Covered Yaks (3.3.4.0) 50415df」と表示されていました。


## ログ・原因
ログの内容は以下の通りで、ちょっと原因が分からない感じでした。

```
2017-11-07 15:50:09.9857|WARN|thread: 1|StandardUserErrors|Showing user error You might need to open a shell and debug the state of this repo.
GitHub.IO.ProcessException: From https://github.com/mamorum/feed-paper
 * branch            master     -> FETCH_HEAD
      0 [main] sh (6032) C:\Users\m\AppData\Local\GitHub\PortableGit_f02737a78695063deace08e96d5042710d3e32db\usr\bin\sh.exe: *** fatal error - cygheap base mismatch detected - 0x1287408/0x12B7408.
This problem is probably due to using incompatible versions of the cygwin DLL.
Search for cygwin1.dll using the Windows Start->Find/Search facility
and delete all but the most recent version.  The most recent version *should*
reside in x:\cygwin\bin, where 'x' is the drive on which you have
installed the cygwin distribution.  Rebooting is also suggested if you
are unable to find another cygwin DLL.
      0 [main] sh 468 fork: child -1 - forked process 6032 died unexpectedly, retry 0, exit code 0xC0000142, errno 11
/mingw32/libexec/git-core/git-sh-setup: fork: retry: No child processes
      1 [main] sh (7312) C:\Users\m\AppData\Local\GitHub\PortableGit_f02737a78695063deace08e96d5042710d3e32db\usr\bin\sh.exe: *** fatal error - cygheap base mismatch detected - 0x1287408/0x13B7408.
This problem is probably due to using incompatible versions of the cygwin DLL.
・・・省略・・・
15212663 [main] sh 468 fork: child -1 - forked process 6016 died unexpectedly, retry 0, exit code 0xC0000142, errno 11
/mingw32/libexec/git-core/git-sh-setup: fork: Resource temporarily unavailable
```


## GitShell は大丈夫
Git Shell では `push`, `pull` が成功しました。
```
~\git\feed-paper [master ≡]> git push
Everything up-to-date
~\git\feed-paper [master ≡]> git pull
Already up-to-date.
```


## 対応方法
端末再起動で回復。
