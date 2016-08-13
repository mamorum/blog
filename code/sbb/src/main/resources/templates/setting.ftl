<#include "/common/doctype.ftl">
<title>ユーザ設定</title>
<link rel="stylesheet" href="/css/setting.css">
</head>
<body>
<#include "/common/nav.ftl">
<div id="main">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div id="submenu">
					<ul class="nav nav-tabs">
						<li role="presentation" class="tab-request active" data-tmpl="#infoTmpl"><a href="/userInfo">名前</a></li>
						<li role="presentation" class="tab-request" data-tmpl="#mailTmpl"><a href="/userMail">メール</a></li>
						<li role="presentation" class="tab-norequest" data-tmpl="#passTmpl"><a href="/userPass">パスワード</a></li>
					</ul>
				</div><!-- .submenu -->
				<form>
					<div id="contents">
					</div><!-- .contents -->
				</form>
			</div>
		</div><!-- .row -->
	</div><!-- .container -->
</div><!-- #main -->

<script id="infoTmpl" type="x-tmpl-mustache">
<div class="form-group">
	<label for="lastNameKana">姓（ふりがな）</label>
	<input type="text" id="lastNameKana" class="form-control" placeholder="さとう" value="{{lastNameKana}}">
</div>
<div class="form-group">
	<label for="firstNameKana">名（ふりがな）</label>
	<input type="text" id="firstNameKana" class="form-control" placeholder="たろう" value="{{firstNameKana}}">
</div>
<div class="form-group">
	<label for="lastName">姓</label>
	<input type="text" id="lastName" class="form-control" placeholder="佐藤" value="{{lastName}}">
</div>
<div class="form-group">
	<label for="firstName">名</label>
	<input type="text" id="firstName" class="form-control" placeholder="太郎" value="{{firstName}}">
</div>
<div class="text-center">
	<button id="saveInfo" class="btn btn-primary">保存</button>
</div>
</script>
<script id="mailTmpl" type="x-tmpl-mustache">
<div class="form-group">
	<label for="mail">メールアドレス</label>
	<input type="email" id="mail" class="form-control" value="{{mail}}">
</div>
<div class="form-group">
	<label for="mailPassword">現在のパスワード</label>
	<input type="password" id="mailPassword" class="form-control">
</div>
<div class="text-center">
	<button id="saveMail" class="btn btn-primary">保存</button>
</div>
</script>
<script id="passTmpl" type="x-tmpl-mustache">
<div class="form-group">
	<label for="nowPass">現在</label>
	<input type="password" id="nowPass" class="form-control">
</div>
<div class="form-group">
	<label for="nextPassword">変更後</label>
	<input type="password" id="nextPass" class="form-control">
</div>
<div class="form-group">
	<label for="nextPasswordRe">変更後（再入力）</label>
	<input type="password" id="nextPassRe" class="form-control">
</div>
<div class="text-center">
	<button id="savePass" class="btn btn-primary">保存</button>
</div>
</script>
<#include "/common/js.ftl">
<script src="/js/setting.js"></script>
</body>
</html>
