Eclipse の Javaエディタでファイルを保存する際に、行末尾の空白を自動で削除する方法を書いていきます。

設定前に、メニューバーの ウィンドウ（Window）から、プリファレンス（Preferences）を開いておきます。

## 手順1. Save action の有効化
Preferences で Save Actions を開いて、以下のチェックボックスをチェックします。

- Perform the selected actions ...（一番上）
- Additional actions（一番下）

trim-sp1


## 手順2. 空白削除の有効化
上の画面で Configure ボタンを押すと、新しいウィンドウが開きます。そこで、Remove trailing whitespace にチェックを入れます。

trim-sp2


## 補足. デフォルトの Save action
デフォルトだと、空白削除以外の保管アクション（アノテーションやキャスト関連）が有効になっています。

不要な場合はそれらの設定を削除しておきます。自分も保管アクションは空白削除だけにしています。
