//paging submit 공통
function frmPaging() {
	document.getElementById("frmPaging").submit();
}

//몇개씩 보여줄 것인지 
function listCnt(){
	document.getElementById("index").value=0;
	document.getElementById("pageStartNum").value=1;
	document.getElementById("listCnt").value=document.getElementById("listCount").value
	frmPaging();
}

function pageFirst() {
	var index = document.getElementById("index");
	var pageStartNum = document.getElementById("pageStartNum");
	index.value = 0;
	pageStartNum.value = 1;
	frmPaging();
}

//pagePrev(1,5)
function pagePre(num, pageCnt) { //num: 출력한 페이지의 시작번호, pageCnt: 출력할 페이지 번호 개수
	if (0 < num - pageCnt) {
		num -= pageCnt;
		var index = document.getElementById("index");
		var pageStartNum = document.getElementById("pageStartNum");
		index.value = num-1;
		pageStartNum.value = num;
	}
	frmPaging();
}

//pageIndex
function pageIndex(idx) {
	var index = document.getElementById("index");
	index.value = idx-1;
	frmPaging();
}

//출력할 페이지의 시작번호, 리스트의 총 개수, 출력할 리스트의 개수, 출력한 페이지번호 개수
function pageNext(num, total, listNum, pageCnt) {
	var index = Math.ceil(total / listNum);
	var max = Math.ceil(index / pageCnt);

	if (max * pageCnt > num + pageCnt) {
		num += pageCnt;
		var index = document.getElementById("index");
		var pageStartNum = document.getElementById("pageStartNum");
		
		index.value = num-1;
		pageStartNum.value = num;

	}
	console.log(" index : " + index +" startNum : "+ pageStartNum);
	frmPaging();
}

function pageLast(num, total, listNum, pageCnt) {
	var index = Math.ceil(total / listNum);
	var max = Math.ceil(index / pageCnt);

	while(max * pageCnt > num + pageCnt) {
		num += pageCnt;
	}
	var index = document.getElementById("index");
	var pageStartNum = document.getElementById("pageStartNum");
	
	index.value = index-1;
	pageStartNum.value = num;
	frmPaging();
}

