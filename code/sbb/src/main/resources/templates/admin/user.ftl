<#include "../common/doctype.ftl">
<title>ユーザ管理</title>
<link rel="stylesheet" href="/css/common-table.css">
</head>
<body>
<#include "../common/nav.ftl">
<div id="main">
	<div id="table" class="col-sm-9">
		<nav>
			<div class="btn-group hidden-sm hidden-md hidden-lg">
  				<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
    				メニュー&ensp;<span class="caret"></span>
  				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#search-area">検索</a></li>
					<li><a href="#add-area">追加</a></li>
				</ul>
			</div>
			<ul id="pager" class="pager">
				<li id="page">1 / 1</li>
    			<li><button class="btn btn-default disabled" id="prev">前へ</button></li>
    			<li><button class="btn btn-default disabled" id="next">次へ</button></li>
  			</ul>
		</nav>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="col-sm-4 col-xs-4">メールアドレス</th>
					<th class="col-sm-3 col-xs-3">ログイン可否</th>
					<th class="col-sm-3 col-xs-3">権限</th>
					<th class="col-sm-2 col-xs-2">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div><!-- .col-sm-9 -->

	<div id="menu" class="col-sm-3">
		<div id="search-area" class="sub-menu">
			<p>検索</p>
			<form id="searchForm">
				<input type="text" id="username" class="form-control" placeholder="メールアドレス">
				<input type="submit" id="search" class="btn btn-default" value="検索">
			</form>
		</div>
		<div id="add-area" class="sub-menu">
			<p>追加</p>
			<form id="addForm">
				<input type="email" id="addUsername" class="form-control" placeholder="メールアドレス" required>
				<input type="password" id="addPassword" class="form-control" placeholder="パスワード" required>
				<select class="form-control" id="addEnabled">
					<option value="true">ログイン可能</option>
					<option value="false">ログイン停止</option>
				</select>
				<select class="form-control" id="addAuthority">
					<option value="ROLE_USER">ROLE_USER</option>
					<option value="ROLE_ADMIN">ROLE_ADMIN</option>
				</select>
				<input type="submit" value="追加" id="add" class="btn btn-default">
			</form>
		</div>
	</div><!-- .col-sm-3 -->
</div><!-- #main -->

<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="modalLabel">編集</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="editUsername" class="control-label">メールアドレス:</label>
						<input type="text" class="form-control" id="editUsername">
					</div>
					<div class="form-group">
						<label for="editPassword" class="control-label">パスワード:</label>
						<input type="password" class="form-control" id="editPassword">
					</div>
					<div class="form-group">
						<label for="editEnabled" class="control-label">利用可能:</label>
						<select class="form-control" id="editEnabled">
							<option value="true">ログイン可能</option>
							<option value="false">ログイン停止</option>
						</select>
					</div>
					<div class="form-group">
						<label for="editAuthority" class="control-label">権限:</label>
						<select class="form-control" id="editAuthority">
							<option value="ROLE_USER">ROLE_USER</option>
							<option value="ROLE_ADMIN">ROLE_ADMIN</option>
						</select>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
				<button type="button" id="update" class="btn btn-primary">更新</button>
			</div>
		</div>
	</div>
</div>
<script id="trTmpl" type="x-tmpl-mustache">
{{#content}}
<tr data-id="{{id}}">
	<td>{{username}}</td>
	<td>{{enabled}}</td>
	<td>{{authority}}</td>
	<td>
		<button class="btn btn-default btn-sm edit">編集</button>
		<button class='btn btn-default btn-sm delete'>削除</button>
	</td>
</tr>
{{/content}}
</script>
<#include "../common/js.ftl">
<script src="/js/common-table.js"></script>
<script src="/js/admin/user.js"></script>
</body>
</html>
