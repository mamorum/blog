<nav id="nav" class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">SBB</a>
		</div><!-- .navbar-header -->
		<div class="collapse navbar-collapse" id="navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="nav-customer"><a href="/customer">顧客</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li id="nav-setting"><a href="/setting"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 設定</a></li>
				<li>
					<a id="logout" href="">ログアウト</a>
					<form class="hidden" action="/logout" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</li>
			</ul>
		</div><!-- .navbar-collapse -->
	</div><!-- .container-fluid -->
</nav><!-- #nav -->

<div id="alert" class="alert alert-top" role="alert">
	<button type="button" class="close alert-close" aria-label="Close"><span aria-hidden="true">×</span></button>
	<span id="alert-msg"></span>
</div>
