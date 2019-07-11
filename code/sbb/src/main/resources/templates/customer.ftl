<#include "/common/doctype.ftl">
<title>顧客管理</title>
<link rel="stylesheet" href="/css/common-table.css">
</head>
<body>
<#include "/common/nav.ftl">
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
					<th class="col-sm-5 col-xs-5">氏名</th>
					<th class="col-sm-5 col-xs-5">ふりがな</th>
					<th class="col-sm-2 col-xs-2">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div><!-- .col-sm-9 -->

	<div id="menu" class="col-sm-3">
		<div id="search-area" class="sub-menu">
			<p>検索（姓を入力しない場合は全件表示）</p>
			<form id="searchForm">
				<input type="text" id="lastName" class="form-control" placeholder="姓">
				<input type="submit" id="search" class="btn btn-default" value="検索">
			</form>
		</div>
		<div id="add-area" class="sub-menu">
			<p>追加</p>
			<form id="addForm">
				<input type="text" id="addLastNameKana" class="form-control" placeholder="すずき" required>
				<input type="text" id="addFirstNameKana" class="form-control" placeholder="たろう" required>
				<input type="text" id="addLastName" class="form-control" placeholder="鈴木" required>
				<input type="text" id="addFirstName" class="form-control" placeholder="太郎" required>
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
						<label for="editLastName" class="control-label">姓（ふりがな）:</label>
						<input type="text" class="form-control" id="editLastNameKana">
					</div>
					<div class="form-group">
						<label for="editFirstName" class="control-label">名（ふりがな）:</label>
						<input type="text" class="form-control" id="editFirstNameKana">
					</div>
					<div class="form-group">
						<label for="editLastName" class="control-label">姓:</label>
						<input type="text" class="form-control" id="editLastName">
					</div>
					<div class="form-group">
						<label for="editFirstName" class="control-label">名:</label>
						<input type="text" class="form-control" id="editFirstName">
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
	<td>{{lastName}} {{firstName}}</td>
	<td>{{lastNameKana}} {{firstNameKana}}</td>
	<td>
		<button class="btn btn-default btn-sm edit">編集</button>
		<button class='btn btn-default btn-sm delete'>削除</button>
	</td>
</tr>
{{/content}}
</script>
<#include "/common/js.ftl">
<script src="/js/common-table.js"></script>
<script src="/js/customer.js"></script>
</body>
</html>
