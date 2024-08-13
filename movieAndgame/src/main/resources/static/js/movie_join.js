/**
 * 
 */

$(function(){
	$("#email").focus();
	
	$(".inputField input").on("focus", function(){
		$(this).addClass("active");
		$(this).next().addClass("focus");
	});
	
	$(".inputField input").on("blur", function(){
		var text = $(this).val();	// input 태그 value값 가져오기
		if(	text == ''){
			$(this).removeClass("active");
			$(this).next().removeClass("focus");
		}
	});
});