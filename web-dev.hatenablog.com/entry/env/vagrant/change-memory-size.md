---
Title: Vagrant：仮想マシンのメモリサイズ変更
Category:
- 環境
Date: 2018-01-02T14:52:00+09:00
URL: http://web-dev.hatenablog.com/entry/env/vagrant/change-memory-size
EditURL: https://blog.hatena.ne.jp/mamorums/web-dev.hatenablog.com/atom/entry/10328749687178930175
---

Vagrant で作成した仮想マシンの、メモリサイズ変更方法を書いていきます。


## 手順1. メモリサイズ設定の有効化
Vagrantfile を開いて、次の箇所を表示します。

`変更前`

```
  # config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
  # end
```

そして、以下３行のコメント記号 `#` を削除します。

- `config.vm.・・・`
- `vb.memory ・・・`
- `end`

`変更後`

```
  config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
    vb.memory = "1024"
  end
```

これでメモリサイズ設定が有効になります。


## 手順2. メモリサイズの設定
メモリサイズは、変更後 Vagrantfile の `1024` の箇所で設定できます。上の例だと、1024MB（1GB）になります。


## 手順3. 確認
設定変更した仮想マシンを起動します（`vagrant up`）。

それから、VirtualBox の GUI を立ち上げてメモリを確認します。

![virtualbox-gui-cheking-memory](http://cdn-ak.f.st-hatena.com/images/fotolife/m/mamorums/20160813/20160813162956.png)

`vb.memory = "1024"` で起動したら、設定通り 1024MB（1GB）になっていました。


## 参考文献
[Configuration - VirtualBox Provider - Vagrant Documentation](https://www.vagrantup.com/docs/virtualbox/configuration.html)
