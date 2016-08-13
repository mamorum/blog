$(function() {

	Create = function(baseUrl, postData) {

		var done = function(data, status, jqxhr) {

			$('tbody tr').removeClass('info');
			$tr = renderTr(data).addClass('info');
			$('tbody').prepend($tr);

			$('#addForm')[0].reset();
			Alert.info("追加しました。追加行は青色です。");
		};

		Ajax.send("post", baseUrl, postData, done);
	}
	function renderTr(data) {
		var trTmpl = $('#trTmpl').html();
		Mustache.parse(trTmpl);  // optional, speeds up future uses
		var rendered = Mustache.render(trTmpl, data);
		return $(rendered);
	}

	Read =  function(getData, baseUrl) {
		Ajax.send("get", baseUrl, getData, function(data, status, jqxhr) {
			if (data.totalElements === 0) {
				Alert.info("該当する検索結果が存在しませんでした。");
				$("tbody").empty();
				renderPage(1, 1);
				return;
			}
			renderTbody(data);
			renderPage(data.number + 1, data.totalPages);
		});
	}
	function renderTbody(data) {
		$("tbody").empty().append(renderTr(data));
	}
	function renderPage(nowPage, totalPage) {
		$("#page").empty().text(nowPage + " / " + totalPage);
		if (nowPage == 1) $('#prev').addClass('disabled');
		else $('#prev').removeClass('disabled');
		if (nowPage == totalPage) $('#next').addClass('disabled');
		else $('#next').removeClass('disabled');
	}

	var $tr, id;
	Update = {
		modal : function($button, baseUrl, prepare) {
			$tr = $button.closest('tr');
			id = $tr.data("id");
			Ajax.send("get", toUrl(baseUrl, id), {}, prepare);
		},
		save : function(baseUrl, postData) {
			var done = function(data, status, jqxhr) {
				$tr.html(renderTr(data).html());
				$('tbody tr').removeClass('info');
				$tr.addClass('info');

				$('#modal').modal('hide');
				Alert.info('更新しました。青色が更新行です。');
			};
			var fail = function(data, status, jqxhr) {
				$('tbody tr').removeClass('warning');
				$tr.addClass('warning');
				$('#modal').modal('hide');
				Alert.warn(data.responseJSON.message);
			};
			Ajax.send("post", toUrl(baseUrl, id), postData, done, fail);
		}
	}
	function toUrl(baseUrl, id) {
		return baseUrl + "/" + id;
	}

	Delete = function($button, baseUrl) {

		if (!confirm("削除しますか？")) return;

		var $tr = $button.closest('tr');
		var id = $tr.data('id');
		var url = baseUrl + "/" + id;

		Ajax.send("delete", url, {}, function(data, status, jqxhr) {
			$tr.remove();
			Alert.info("削除しました。");
		});
	}
});