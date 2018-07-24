$(function() {

	$('#nav-customer').addClass('active');

	var baseUrl = "/customers";

	$('#addForm').submit(function(event) {
		event.preventDefault();
		var data = {
			lastNameKana:$('#addLastNameKana').val(),
			firstNameKana:$('#addFirstNameKana').val(),
			lastName:$('#addLastName').val(),
			firstName:$('#addFirstName').val()
		};
		Create(baseUrl, data);
	});

	var lastName, page;
	$('#searchForm').submit(function(event) {
		event.preventDefault();
		lastName = $("#lastName").val();
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
		var data = { lastName:lastName, page:page };
		Read(data, baseUrl);
	}

	$('body').on('click', '.edit', function() {
		var prepareModal = function(data, status, jqxhr) {
			$('#editLastNameKana').val(data.lastNameKana);
			$('#editFirstNameKana').val(data.firstNameKana);
			$('#editLastName').val(data.lastName);
			$('#editFirstName').val(data.firstName);
			$('#modal').modal();
		};
		Update.modal($(this), baseUrl, prepareModal);
	});
	$('#update').click(function() {
		var data = {
				lastNameKana: $('#editLastNameKana').val(),
				firstNameKana: $('#editFirstNameKana').val(),
				lastName: $('#editLastName').val(),
				firstName: $('#editFirstName').val()
		};
		Update.save(baseUrl, data);
	})

	$('body').on('click', '.delete', function() {
		Delete($(this), baseUrl);
	});
});