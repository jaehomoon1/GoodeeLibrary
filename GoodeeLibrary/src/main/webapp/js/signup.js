function check(){
	var id = document.getElementById('id').value;
	var password = document.getElementById('password').value;
	var passChk = document.getElementById('passChk').value;
	var name = document.getElementById('name').value;
	var nickname = document.getElementById('nickname').value;
	var phone = document.getElementById('phone').value;
	var chkval = document.getElementById('chkval').value;
	
	var frm = document.forms[0];
	
	console.log(name, id, password, 
				passChk, nickname, phone, 
				chkval, frm);
	
	
	if(password != passChk){
		swal("회원가입 오류", "비밀번호가 잘못되었습니다.");
		return false;
	}else if(chkval == "0"){
		swal("회원가입 오류", "아이디를 확인해 주세요");
		return false;
	}else {
		frm.submit();
	}
}

$(function(){
	$("#id").keyup(function(){
		var idVal = $(this).val();
		console.log(idVal);
		
		if(idVal.indexOf(" ") != -1){
			$("#result").css("color", "red");
			$("#result").html("공백이 포함된 아이디는 사용할 수 없습니다.<br>");
			$("chkval").val("0");			
		}else if(idVal.length < 5 || idVal.length > 20){
			$("#result").css("color", "red");
			$("#result").html("아이디는 5~20자리 만 입력해주세요.<br>");
			$("chkval").val("0");
		}else {
			$("#result").html("");
			jQuery.ajax({
				type:'post',
				url:'./idCheck.do',
				data:"id="+idVal,
				async:true,
				success: function(msg){
					console.log("전달받은 값 : ",msg);

					if(msg.isc == 'true'){
						$("#chkval").val("0");
						$("#result").css("color", "red");
						$("#result").html("사용중인 아이디 입니다.<br>");
					}else {
						$("#chkval").val("1");
						$("#result").css("color", "green");
						$("#result").html("사용가능한 아이디 입니다.<br>");
					}
					
				},
				error: function(){
					alert("잘못된 요청입니다.");
				}
			});
		}
	});
});







