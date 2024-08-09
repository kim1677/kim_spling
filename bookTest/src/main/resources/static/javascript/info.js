/**
 * 
 */

let inputType=[];
let inputName=[];

$(function(){
	// 삭제버튼
	$("#del").on("click", function(){
		var isOk = confirm("정말로 삭제하시겠습니까?");
		if(isOk){
			$("#fm").submit();
		}
	});
	
	// 수정버튼
	$("#modify").on("click", function(){
		$.each( $(".value"), function(i, v){	// i - 인덱스, v - i인덱스의 값
			var text = $(v).text().trim();
			if(inputType[i] ==="number"){
				text = text.replace(/[^0-9]/g,"");
			}
		
			$(v).html("<input tpye='"+inputType[i]+"' name='"+inputName[i]+"' value='"+text+"'> ")
		});		// 클래스명이 value인 td 내부 설정
		
		$(this).attr("id", "mod");
		var url = $("#fm").attr("action");	// form action값 가져오기
		url = url.substring(0, url.lastIndexOf("/") )+"/update";	// 주소 변경
		// 주소 : /book/updat 또는 /coffe/update 로 변경된다.
		$("#fm").attr("action", url);
		
		$(this).off("click");
		
		$("#mod").on("click", function(){	$("#fm").submit(); });
		
	});
		
});
