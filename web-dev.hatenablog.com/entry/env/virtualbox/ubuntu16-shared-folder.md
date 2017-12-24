---
Title: VirtualBox：Ubuntu16の共有フォルダ設定
Category:
- 環境
Date: 2017-12-28T08:00:00+09:00
URL: http://web-dev.hatenablog.com/entry/env/virtualbox/ubuntu16-shared-folder
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/8599973812329272416
Draft: true
---

Virtual Box 共有フォルダを設定して、Ubuntu16（仮想マシン）と Windows でファイルをやりとりする方法を書いていきます。利用しているプロダクトのバージョンは以下の通りです。

- Windows10 64bit
- Virtual Box 5.1.30
- Ubuntu Server 16.04.3 LTS 


## 1. 仮想マシンの共有フォルダ設定
VirtualBox マネージャーの設定で「共有フォルダ」を選択して、右側のアイコンをクリックします。クリックすると、下の画面が表示されるので、Windows 上のパスを指定します。

[f:id:mamorums:20171224130652p:plain]

上の画像は、適当な場所に「...\vbox\share」というディレクトリを作成して指定してます。


## 2. Ubuntu に Guest Addisions をインストール
Virtual Box の共有フォルダを使う場合、仮想マシンに Guest Addisions（というソフト）をインストールする必要があります。

インストール方法はいくつかあるみたいですが、今回は以下のコマンドでインストールしました。

```
$ sudo apt install virtualbox-guest-dkms
```

インストールが完了したらリブートします。


## 3. Ubuntu でマウント
次に、Ubuntu 上でディレクトリを作って共有フォルダをマウントします。

```
$ sudo su -
# mkdir /share
# chmod 777 /share
# mount -t vboxsf share /share
```

一般ユーザでも自由に書き込んだりできるように、ディレクトリ /share を 777 で用意しました。最後のマウントコマンドは、VirtualBox マネージャの設定で表示されているものです。

[f:id:mamorums:20171224130707p:plain]

これで /share を介して Windows とファイルをやり取りできます。


## 4. Ubuntu でアンマウント
次のコマンドでマウントを解除できます。

```
$ sudo umount share
```

次の自動マウントを設定する場合、事前にアンマウントしておきます。確認のため、共有フォルダを再度マウントします。


## 5. 自動マウントの設定
先ほどのマウント方法だと、シャットダウン時にマウントが外れてしまいます。そこで、Ubuntu が起動したら自動的にマウントするように設定していきます。

まずは fstab を開いて、

```
$ sudo vi /etc/fstab
```

末尾に以下の行を追加します。

```
share /share vboxsf uid=ubuntu,gid=ubuntu,comment=systemd.automount 0 0
```

次は modules を開いて、

```
$ sudo vi /etc/modules
```

末尾に以下の行を追加します。

```
vboxsf
```


## 6. 自動マウントの確認
次のコマンドでマウントしてみます。

```
$ sudo mount share
```

マウントコマンドで share が表示されていれば大丈夫です。

```
$ sudo mount
.....
share on /share type vboxsf (rw,nodev,relatime)
```

OS を再起動すると、自動でマウントされています。


## 参考文献
- [VirtualBoxの共有フォルダの自動マウント - K'zlog](http://kzlog.picoaccel.com/post-968/)
- [VirtualBoxのLinuxゲストにguest-addtionsをインストールして、共有フォルダをマウントする - Qiita](https://qiita.com/seijikohara/items/6bac67de38a2d6838127)
