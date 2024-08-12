<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커피정보 보기</title>

<!-- jquery CDN-->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/info.css">
<script src="/javascript/info.js"></</script>

<script>
	inputType=["text", "number", "number"];
	inputName=["itemName", "price", "decaffein"];
</script>

</head>
<body>
		<form id="fm" method="get" action="/coffe/delete">
			<input type="hidden" name="id" value="${coffe.coffeId}">
			<div id="wrap">
				<a href="/coffe">←뒤로</a>
				<table id="viewBox">
					<tr>
						<td class="fieldName">커피 제목</td>
						<td class="value">${coffe.getItemName()}</td>
					</tr>
					<tr>
						<td class="fieldName">가격</td>
						<td class="value">
							<fmt:setLocale value="en_us"/>
							<fmt:formatNumber value="${coffe.price}" type="currency"/>
						</td>
					</tr>
					<tr>
						<td class="fieldName">카페인 여부</td>
						<td class="value">
							<fmt:formatNumber value="${coffe.decaffein}" pattern="#,###"/>
						</td>
					</tr>
					
					<tr>
						<td cospan="2">
							<button type="button" id="modify">수정</button>
							<button type="button" id="del" data-id="${coffe.coffeId}">삭제</button>
						</td>
					</tr>
				</table>
			</div>
		</form>
</body>
</html>