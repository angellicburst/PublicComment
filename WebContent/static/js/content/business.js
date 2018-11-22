function runToPage() {
	var pageNum = $("#currentPageText").val();
	var titleInput = $("input[name=titleInput]").val();
	$(".go").attr("href",$("input[name=basepath]").val() + "/busList?pageIndex=" + pageNum);
}

function prePage() {
	var pageIndex = $("#pageIndex").html();
	var titleInput = $("input[name=titleInput]").val();
	$(".pre").attr("href",$("input[name=basepath]").val() + "/busList?pageIndex=" + (--pageIndex) + "&titleInput=" +titleInput);
}

function nextPage() {
	var pageIndex = $("#pageIndex").html();
	var titleInput = $("input[name=titleInput]").val();
	$(".next").attr("href",$("input[name=basepath]").val() + "/busList?pageIndex=" + (++pageIndex) + "&titleInput=" +titleInput);
}

function firstPage() {
	var titleInput = $("input[name=titleInput]").val();
	$(".first").attr("href",$("input[name=basepath]").val() + "/busList?pageIndex=1" + "&titleInput=" +titleInput);
}

function lastPage() {
	var pageCount = $("#pageCount").html();
	var titleInput = $("input[name=titleInput]").val();
	$(".last").attr("href",$("input[name=basepath]").val() + "/busList?pageIndex=" + pageCount + "&titleInput=" +titleInput);
}

function search() {
	var titleInput = $(".allInput").val();
	window.location.href=$("input[name=basepath]").val() + "/busList?titleInput=" + titleInput;
}
