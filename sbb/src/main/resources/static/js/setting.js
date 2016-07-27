$(function() {

	$('#nav-setting').addClass('active');

	// dispay contents of first tab.
	(function() {
		var $li = $('#submenu').find('li:first-child');
		renderTmplFor($li);
	})();

	// functions and events for .nav-tabs li.
	function isActive($li) {
		return $li.hasClass('active');
	}
	function activate($li) {
		$li.closest('ul').find('li').removeClass('active');
		$li.addClass('active');
	}
	function renderHtmlFor($li) {
		var id = $li.data('tmpl');
		var html = $(id).html();
		changeContentsTo(html);
	}
	function renderTmplFor($li) {
		var uri = $li.find('a').attr('href');
		var id = $li.data('tmpl');
		Ajax.send("get",uri, {}, function(data, status, jqxhr) {
			renderTmpl(id, data, status, jqxhr);
		});
	}
	function renderTmpl(id, data, status, jqxhr) {
		var tmpl = $(id).html();
		Mustache.parse(tmpl);  // optional, speeds up future uses
		var rendered = Mustache.render(tmpl, data);
		changeContentsTo(rendered);
	}
	function changeContentsTo(html) {
		$('#contents').empty().html(html);
	}
	$('.tab-request').click(function(event) {
		event.preventDefault();
		if (isActive($(this))) return;
		activate($(this));
		renderTmplFor($(this));
	});
	$('.tab-norequest').click(function(event) {
		event.preventDefault();
		if (isActive($(this))) return;
		activate($(this));
		renderHtmlFor($(this));
	});

	$('body').on('click', '#saveInfo', function(event) {
		event.preventDefault();
		var postData = {
			lastNameKana: $('#lastNameKana').val(),
			firstNameKana: $('#firstNameKana').val(),
			lastName: $('#lastName').val(),
			firstName: $('#firstName').val()
		};
		Ajax.send("post", "/userInfo", postData, function() {
			Alert.info("名前を更新しました。");
		});
	});

	$('body').on('click', '#saveMail', function(event) {
		event.preventDefault();
		var postData = {
			mail: $('#mail').val(),
			password: $('#mailPassword').val()
		};
		Ajax.send("post", "/userMail", postData, function() {
			Alert.info("メールアドレスを更新しました。");
			$('#mailPassword').val('');
		});
	});

	$('body').on('click', '#savePass', function(event) {
		event.preventDefault();
		var postData = {
			nowPass: $('#nowPass').val(),
			nextPass: $('#nextPass').val(),
			nextPassRe: $('#nextPassRe').val()
		};
		Ajax.send("post", "/userPass", postData, function() {
			$('#main form')[0].reset();
			Alert.info("パスワードを更新しました。");
		});
	});
});