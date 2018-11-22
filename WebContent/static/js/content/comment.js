function runToPage() {
	var pageNum = $("#currentPageText").val();
	$(".go").attr("href",$("input[name=basepath]").val() + "/comList?pageIndex=" + pageNum);
}

function prePage() {
	var pageIndex = $("#pageIndex").html();
	var comInput = $("input[name=comInput]").val();
	$(".pre").attr("href",$("input[name=basepath]").val() + "/comList?pageIndex=" + (--pageIndex) + "&comInput=" +comInput);
}

function nextPage() {
	var pageIndex = $("#pageIndex").html();
	var comInput = $("input[name=comInput]").val();
	$(".next").attr("href",$("input[name=basepath]").val() + "/comList?pageIndex=" + (++pageIndex) + "&comInput=" +comInput);
}

function firstPage() {
	var comInput = $("input[name=comInput]").val();
	$(".first").attr("href",$("input[name=basepath]").val() + "/comList?pageIndex=1" + "&comInput=" +comInput);
}

function lastPage() {
	var pageCount = $("#pageCount").html();
	var comInput = $("input[name=comInput]").val();
	$(".last").attr("href",$("input[name=basepath]").val() + "/comList?pageIndex=" + pageCount + "&comInput=" +comInput);
}

function search() {
	var comInput = $(".allInput").val();
	window.location.href=$("input[name=basepath]").val() + "/comList?comInput=" + comInput;
}
