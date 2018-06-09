---
Title: VirtualBox：Ubuntu16を動かす
Category:
- etc
Date: 2018-01-03T09:00:00+09:00
URL: https://web-dev.hatenablog.com/entry/etc/virtualbox/run-ubuntu16
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812332391748
---

Virtual Box を使って、Windows で Ubuntu16（Xenial Xerus）のサーバーを動かす手順をまとめてみました。


1. [仮想マシンの作成](/entry/env/virtualbox/create-vm)
2. [Ubuntu16のインストール](/entry/env/virtualbox/ubuntu16-install)
3. [Ubuntu16のネットワークとSSH設定](/entry/env/virtualbox/ubuntu16-network-ssh)
4. [Ubuntu16の共有フォルダ設定](/entry/env/virtualbox/ubuntu16-shared-folder)
5. [仮想マシンのバックアップ](/entry/env/virtualbox/backup-vm)


上から順に進めていくと、Ubuntu16 を起動して ssh クライアントから接続できます。最後の２つ（共有フォルダ設定とバックアップ）は任意になります。


## Virtual Box を直接使ってみた感想
やっぱり Vagrant は便利だなぁと思いました。

でも、Virtual Box もバックアップを取れるので、一度 VM の設定してしまえば楽になりそうです。VM の削除と再作成も簡単でした。

Virtual Box の GUI は便利で、vagrant のコマンドを覚えなくても使えるのが嬉しかったです。


## Vagrant を使わなかった理由
今まで Vagrant で仮想マシンを作成してたんですが、以下の理由で Virtual Box を直接使うことにしました。

1. Virtual Box を新しくしたら、Vagrant が動かなかった。
2. Vagrant の Ubuntu16（`ubuntu/xenial64`）を使ったら、vagrant ユーザでログインできなかった。

Vagrant のバージョンが古いと、新しい Virtual Box に対応してなかったりするみたいです。あと、`ubuntu/xenial64` は、ログインユーザが `ubuntu` みたいです。パスワードは、vagrant が生成するファイルに書かれているみたいです。
