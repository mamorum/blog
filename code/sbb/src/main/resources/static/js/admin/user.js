$(function() {

	var baseUrl = "/admin/users";

	$('#addForm').submit(function(event) {
		event.preventDefault();
		var data = {
			username:$('#addUsername').val(),
			password:$('#addPassword').val(),
			enabled:$('#addEnabled').val(),
			authority:$('#addAuthority').val()
		};
		Create(baseUrl, data);
	});

	var username, page;
	$('#searchForm').submit(function(event) {
		event.preventDefault();
		username = $("#username").val();
		page = 1;
		search();
	});
	$("#prev").click(function() {
		page = page - 1;
		search();
	});
	$("#next").click(function() {
		page = page + 1;
		search();
	});
	function search() {
		var data = { username:username, page:page };
		Read(data, baseUrl);
	}

	$('body').on('click', '.edit', function() {
		var prepareModal = function(data, status, jqxhr) {
			$('#editUsername').val(data.username);
			$('#editPassword').val(data.password);
			$('#editEnabled').val(data.enabled.toString());
			$('#editAuthority').val(data.authority);
			$('#modal').modal();
		};
		Update.modal($(this), baseUrl, prepareModal);
	});
	$('#update').click(function() {
		var data = {
				username: $('#editUsername').val(),
				password: $('#editPassword').val(),
				enabled: $('#editEnabled').val(),
				authority: $('#editAuthority').val()
		};
		Update.save(baseUrl, data);
	})

	$('body').on('click', '.delete', function() {
		Delete($(this), baseUrl);
	});
});