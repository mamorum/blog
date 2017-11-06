## 元ネタ記事
http://web-dev.hatenablog.com/entry/heroku/toolbelt/deploy-commands

## 0
git clone 

## 1
heroku のリポジトリと関連付ける。

`heroku git:remote -a Herokuアプリ名`


## 2
`git push heroku master` でエラー

~/heroku/feed-paper$ git push heroku master
To https://git.heroku.com/feed-paper.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://git.heroku.com/feed-paper.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.


## 3
`git pull heroku master` をするとコンフリクトが発生


## 4
git push --force heroku master


## 参考文献
https://stackoverflow.com/questions/28528912/git-push-heroku-master-error-with-rails