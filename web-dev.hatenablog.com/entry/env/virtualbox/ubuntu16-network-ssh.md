---
Title: VirtualBox：Ubuntu16のネットワークとSSH設定
Category:
- 環境
Date: 2017-12-26T07:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/env/virtualbox/ubuntu16-network-ssh
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812329267872
Draft: true
---

仮想マシンのネットワークとSSHを設定して、Windows の SSHクライアントから接続する方法を書いていきます。仮想マシンは Windows の VirtualBox 上に作成していて、その OS は Ubuntu16 になります。

詳細なバージョンは以下の通りです。

- Windows10 64bit
- Virtual Box 5.1.30
- Ubuntu Server 16.04.3 LTS 


## 1. 仮想マシンのネットワークの設定
設定で「ネットワーク」を選択して、アダプター２を有効化します。それから「ホストオンリーアダプター」を割り当てます。

[f:id:mamorums:20171224124625p:plain]

※ アダプター１は、デフォルトだと「NAT」になっていると思います。こちらはそのまままにしておきます。


## 2. 仮想マシンの起動
仮想マシンを「通常起動」して、コンソールにログインしておきます。


## ネットワークインターフェイスの確認
コマンドプロンプトで `ifconfig -a` を実行して、設定したホストオンリーアダプタを確認します。

```
$ ifconfig -a
enp0s3 ...

enp0s8 ...

lo ...
``` 

自分の環境だと、enp0s3 が NAT、enp0s8 がホストオンリーアダプタでした。心配な場合は、MACアドレスで確認できます（`ifconfig -a` のアドレスと、VirtualBox のネットワーク設定のアドレスを比較）。


## 3. NIC の IP設定
ホストオンリーアダプタ（`enp0s8`）に IP を設定するため、vi 等で以下のファイルを開きます。

```
$ sudo vi /etc/network/interfaces
```

末尾に次の内容を追加して保存します。

```
# The host only network interface
auto enp0s8
iface enp0s8 inet static
address 192.168.56.10
netmask 255.255.255.0
```

今回は `192.168.56.10` を割り当ててみました。Virtual Box の初期設定だと、192.168.56.2 - 192.168.56.99 を割り当ててよいみたいです。


## 4. Open SSH のインストール
SSHクライアントから Ubuntu に接続できるように、Open SSH をインストールします。

```
$ sudo apt install openssh-server
```


## 5. Ubuntuの再起動
次のコマンドを実行して再起動します。

```
$ sudo shutdown -r now
```

再起動後は、SSHクライアント（PuTTYなど）から 192.168.56.10 にログインできます。ログインしてから`ifconfig` を実行すると、ネットワーク設定を確認できます。


## 補足. 仮想マシンのヘッドレス起動
SSHクライアントを使う場合、VirtualBoxマネージャ（GUI）の「ヘッドレス起動」が便利だったりします。

[f:id:mamorums:20171224124647p:plain]

ヘッドレス起動だと、VirtualBoxマネージャ（GUI）がコンソールを立ち上げなくなります。


## 参考文献
- [VirtualBox上のUbuntuでNAT+ホストオンリーネットワーク構成にするメモ - Qiita](https://qiita.com/hnw/items/77be84138f5ec48353da)
- [Ubuntu16.04 LTS 初期設定 - Qiita](https://qiita.com/ftakao2007/items/c88103b5bc01b790263a)
