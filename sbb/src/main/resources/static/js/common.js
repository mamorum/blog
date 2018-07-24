$(function() {

	// for spring csrf support
	$(document).ajaxSend(function(e, xhr, options) {
		var header = $("meta[name='_csrf_header']").attr("content");
		var token = $("meta[name='_csrf']").attr("content");
		xhr.setRequestHeader(header, token);
	});

	// for ajax
	Ajax = {
		warn : function(data, status, jqxhr) {
			Alert.warn(data.responseJSON.message);
		},
		send : function(method, url, data, done, error) {
			var fail = error ? error : this.warn;
			$.ajax({
				url: url,
				data: data,
				method: method,
				cache: false
			}).then(done, fail);
		}
	}

	// for alert
	Alert = {
		show: function(cssClass, msg) {
			var $alert = $('#alert');
			$alert.removeClass('alert-info alert-warning').addClass(cssClass);
			$('#alert-msg').text(msg);
			if ($alert.css('display') === 'none') {
				$alert.show();
			}
		},
		info: function(msg) {
			this.show('alert-info', msg);
		},
		warn: function(msg) {
			this.show('alert-warning', msg);
		}
	}
	$('body').on('click', '.alert-close', function() {
		$(this).parents('.alert').hide();
	});

	/// for nav
	Ajax.send('get', '/auth/nav', {}, function(data, status, jqxhr) {
		$('.navbar-right').prepend(data);
		if (location.pathname === '/admin/user') {
			$('#nav-admin-user').addClass('active');
		}
	});

	// for logout
	$("#logout").click(function(event) {
		event.preventDefault();
		$(this).next('form').submit();
	});
});
