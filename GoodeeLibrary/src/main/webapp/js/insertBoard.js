
var isShow = true;
function validateForm(){
	var form = document.forms[0]; //name이 없어서 이렇게 잡음
	console.log(form);
	
	var id = document.getElementById("id");
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	
	// dom 탐색에서 값을 가져올때 javascript는 undefined 확인할 필요 없음
	if(id.value == "" || title.value == "" || content.value == ""){
		alert("필수값을 입력해주세요");
	}else{
		var str = content.value;
		str = str.replace(/\r\n|\r|\n|\n\r/g, '<br>');
		//content.innerContent = str;
		//content.textContent = str;
		content.value = str;
		//document.getElementById("changeTextArea").textContent=str; // innerContent >> 테스트
		isShow = false;
		form.submit();
	}
	
}

window.onbeforeunload = function(){
	if(isShow){
		return "화면을 벗어납니다";	
	}
}