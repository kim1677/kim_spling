/* default.js */
$(function() {
    $("#delete").on("click", function() {
        var bid = $(this).data("bid");
        var isOk = confirm("정말로 삭제하십니까?");
        if (isOk) {
            location.href="/delete?bid="+bid;
        }
    });
	
	$("#modify").on("click",function(){
		$("#fm").submit();
	});
});
