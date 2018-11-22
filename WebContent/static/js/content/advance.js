function runToPage() {
	var pageNum = $("#currentPageText").val();
	var titleInput = $("input[name=titleInput]").val();
	//console.log(pageNum);
	$(".go").attr("href",$("input[name=basepath]").val() + "/adList?pageIndex=" + pageNum);
}

function prePage() {
	var pageIndex = $("#pageIndex").html();
	var titleInput = $("input[name=titleInput]").val();
	//console.log(pageIndex);
	$(".pre").attr("href",$("input[name=basepath]").val() + "/adList?pageIndex=" + (--pageIndex) + "&titleInput=" +titleInput);
}

function nextPage() {
	var pageIndex = $("#pageIndex").html();
	var titleInput = $("input[name=titleInput]").val();
	//console.log(pageIndex);
	$(".next").attr("href",$("input[name=basepath]").val() + "/adList?pageIndex=" + (++pageIndex) + "&titleInput=" +titleInput);
}

function firstPage() {
	var titleInput = $("input[name=titleInput]").val();
	$(".first").attr("href",$("input[name=basepath]").val() + "/adList?pageIndex=1" + "&titleInput=" +titleInput);
}

function lastPage() {
	var pageCount = $("#pageCount").html();
	//console.log(pageCount);
	var titleInput = $("input[name=titleInput]").val();
	//console.log(pageIndex);
	$(".last").attr("href",$("input[name=basepath]").val() + "/adList?pageIndex=" + pageCount + "&titleInput=" +titleInput);
}

function search() {
	var titleInput = $(".allInput").val();
	//console.log(titleInput);
	
	//console.log($("input[name=titleInput]").val());
	window.location.href=$("input[name=basepath]").val() + "/adList?titleInput=" + titleInput;
	//$("input[name=titleInput]").attr("value",titleInput);
}
