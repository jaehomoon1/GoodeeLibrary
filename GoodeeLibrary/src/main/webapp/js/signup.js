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
		swal("회원가입 오류", "이메일를 확인해 주세요");
		return false;
	}else {
		frm.submit();
	}
}

$(function(){
	//이메일 유효성검사
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	
	$("#id").keyup(function(){
		var idVal = $(this).val();
		console.log(idVal);
		
		if (idVal == "" || !re.test(idVal)) {
			$("#result").css("color", "red");
			$("#result").html("올바른 이메일 주소를 입력하세요<br>")
			$("chkval").val("0");			
		}else if(idVal.indexOf(" ") != -1){
			$("#result").css("color", "red");
			$("#result").html("공백이 포함된 이메일는 사용할 수 없습니다.<br>");
			$("chkval").val("0");			
		}else if(idVal.length < 5 || idVal.length > 60){
			$("#result").css("color", "red");
			$("#result").html("이메일은 5~60자리 만 입력해주세요.<br>");
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
						$("#result").html("사용중인 이메일 입니다.<br>");
					}else {
						$("#chkval").val("1");
						$("#result").css("color", "green");
						$("#result").html("사용가능한 이메일 입니다.<br>");
					}
					
				},
				error: function(){
					alert("잘못된 요청입니다.");
				}
			});
		}
	});
});







