---
Title: Ubuntu：xvfbの起動スクリプト
Category:
- Linux
Date: 2016-12-06T22:12:04+09:00
URL: http://web-dev.hatenablog.com/entry/linux/ubuntu/script-xvfb
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687197661249
---

今回は、Ubuntu 14（Vagrant Box の `ubuntu/trusty64`）にインストールした Xvfb の起動スクリプトについて書いていきます。具体的には、

1. 起動スクリプトの内容（紹介）
2. 起動スクリプトの登録方法
3. 起動スクリプトの解除方法

といった内容になります。

※ Xvfb のインストール手順は、記事「[Ubuntu：xvfbとfirefoxのインストール](http://web-dev.hatenablog.com/entry/linux/ubuntu/install-firefox-xvfb)」を参考にして頂けると幸いです。


## 1. 起動スクリプトの内容
あくまで一例ですが、自分は次のようなスクリプトを作成しました。

```
### BEGIN INIT INFO
# Provides: Xvfb
# Required-Start: $local_fs $remote_fs
# Required-Stop:
# X-Start-Before:
# Default-Start: 2 3 4 5
# Default-Stop: 0 1 6
# Short-Description: Loads X Virtual Frame Buffer
### END INIT INFO
 
XVFB=/usr/bin/Xvfb
XVFBARGS=":99 -ac -screen 0 1024x768x24"
PIDFILE=/var/run/xvfb.pid
case "$1" in
  start)
    echo -n "Starting virtual X frame buffer: Xvfb"
    start-stop-daemon --start --quiet --pidfile $PIDFILE --make-pidfile --background --exec $XVFB -- $XVFBARGS
    echo "."
    ;;
  stop)
    echo -n "Stopping virtual X frame buffer: Xvfb"
    start-stop-daemon --stop --quiet --pidfile $PIDFILE
    echo "."
    ;;
  restart)
    $0 stop
    $0 start
    ;;
  *)
        echo "Usage: /etc/init.d/xvfb {start|stop|restart}"
        exit 1
esac
 
exit 0
```

ファイル名は `xvfb` としました。


## 2. 起動スクリプトの登録方法
起動スクリプトを登録すると、ＯＳが起動時にスクリプトを実行してくれるようになります。以下に、コマンド `update-rc.d` で登録する手順を書いていきます。

### 手順1. スクリプトのコピー
カレントディレクトリのファイル `xvfb` を、`/etc/init.d/` にコピーします。

```
$ sudo cp -p xvfb /etc/init.d/
```

### 手順2. スクリプトの登録
次のコマンドで登録します。

```
$ sudo update-rc.d xvfb defaults
```

実行される（実行されない）ランレベルは、スクリプトの冒頭に書いてあります。


## 3. 起動スクリプトの解除方法
Xvfb を起動したくなくなったら、次のコマンドで解除することができます。

```
$ sudo update-rc.d -f xvfb remove
```

