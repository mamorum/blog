<#include "/common/doctype.ftl">
<title>ログイン</title>
<link href="/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form action="/login" method="post" class="form-signin">
		<h3 class="form-signin-heading">Login</h3>
		<#if RequestParameters.logout??>
		<p class="text-info"><strong>ログアウトしました。</strong></p>
		</#if>
		<#if RequestParameters.error??>
		<p class="text-danger"><strong>メールアドレス・パスワードが違います。</strong></p>
		</#if>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="email" name="username" class="form-control" placeholder="メールアドレス" required>
		<input type="password" name="password" class="form-control" placeholder="パスワード" required>
		<div class="checkbox">
			<label><input type="checkbox" name="remember-me"> ログイン状態を保持する</label>
		</div>
		<input type="submit" id="submit" value="ログイン" class="btn btn-lg btn-primary btn-block">
	</form>
</div><!-- container -->
</body>
</html>
