---
Title: SpringBoot：アプリの起動・停止シェルスクリプト
Category:
- Spring
Date: 2016-12-19T14:15:07+09:00
URL: http://web-dev.hatenablog.com/entry/spring-boot/start-stop-script-chkconfig
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687199812058
---

以前、Spring Boot のアプリを CentOS のサービスとして起動・停止するシェル（スクリプト）を作成したことがありました。これからその内容を書いていこうと思います。


## 補足
最近の SpringBoot だと、アプリのサービス登録もサポートしているみたいです。詳細は、SpringBoot のドキュメント（以下のリンク）を参照して頂ければ幸いです。

[Unix/Linux services - Spring Boot Reference Guide](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#deployment-service)

※ 今回のスクリプトは不要になりそうですが、ブログに残してみようと思いました。別のサービスを登録するときに使えるかもしれないので・・・。


## スクリプトの内容
作成したスクリプトの内容は次の通りです。

```
#!/bin/bash
# chkconfig: 345 99 1
# description: sbb
# processname: sbb

. /etc/init.d/functions

progname=sbb
pidfile=/var/run/sbb.pid
lockfile=/var/lock/subsys/sbb
cmdmvn="cd sbb && mvn spring-boot:run > /home/vagrant/sbb.log &"
cmdjava=/usr/java/jdk1.8.0_40/bin/java


RETVAL=0

start() {
  echo -n "Starting Spring Boot Application ..."
  su -l vagrant -c "$cmdmvn"
  RETVAL=$?
  sleep 10s
  pgrep -f "$cmdjava" > $pidfile
  echo
  [ $RETVAL -eq 0 ] && touch $lockfile || RETVAL=1
  return $RETVAL
}
 
stop() {
  echo -n "Shutting down Spring Boot Application ..."
  killproc -p $pidfile sbb
  RETVAL=$?
  echo
  [ $RETVAL -eq 0 ] && rm -f $lockfile
  return $RETVAL
}
 
show_status() {
  status -p $pidfile -l $lockfile sbb
}
 
case "$1" in
  start)
    start
    ;;
  stop)
    stop
    ;;
  status)
    show_status
    ;;
  *)
    echo "Usage: sbb {start|stop|status}"
    exit 1
    ;;
esac
exit $?
```

アプリ名とディレクトリ名は `sbb` です。サービス起動時は、そのディレクトリに移動して、`mvn` コマンドでアプリを実行しています。

あと、PID ファイルや Lock ファイルも作成しています。


## サービスの登録方法
CentOS のコマンド `chkconfig` で登録しました。

すみません、`chkconfig` の詳細については割愛させてください。Google 等で検索すると分りやすい記事が出てくると思います。

