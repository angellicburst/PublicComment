function runToPage() {
	var pageNum = $("#currentPageText").val();
	$(".go").attr("href",$("input[name=basepath]").val() + "/orderList?pageIndex=" + pageNum);
}

function prePage() {
	var pageIndex = $("#pageIndex").html();
	var phoneInput = $("input[name=phoneInput]").val();
	$(".pre").attr("href",$("input[name=basepath]").val() + "/orderList?pageIndex=" + (--pageIndex) + "&phoneInput=" +phoneInput);
}

function nextPage() {
	var pageIndex = $("#pageIndex").html();
	var phoneInput = $("input[name=phoneInput]").val();
	$(".next").attr("href",$("input[name=basepath]").val() + "/orderList?pageIndex=" + (++pageIndex) + "&phoneInput=" +phoneInput);
}

function firstPage() {
	var phoneInput = $("input[name=phoneInput]").val();
	$(".first").attr("href",$("input[name=basepath]").val() + "/orderList?pageIndex=1" + "&phoneInput=" +phoneInput);
}

function lastPage() {
	var pageCount = $("#pageCount").html();
	var phoneInput = $("input[name=phoneInput]").val();
	$(".last").attr("href",$("input[name=basepath]").val() + "/orderList?pageIndex=" + pageCount + "&phoneInput=" +phoneInput);
}

function search() {
	var phoneInput = $(".allInput").val();
	window.location.href=$("input[name=basepath]").val() + "/orderList?phoneInput=" + phoneInput;
}
