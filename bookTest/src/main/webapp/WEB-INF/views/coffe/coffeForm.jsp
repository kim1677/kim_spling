<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div id="wrap">
		<a href="/">HOME</a>	
		<form method="post" action="/coffesave">
			<div id="fromWrap">
				<div class="inputField">
					<label for="itemName">커피</label>
					<input type="text" name="itemName" id="itemName">
				</div>
				<div class="inputField">
					<label for="price">가격</label>
					<input type="text" name="price" id="price">
				</div>
				<div class="inputField">
					<label for="decaffein">카페인여부</label>
					<input type="text" name="decaffein" id="decaffein">
				</div>
				<button id="bt">주문</button>
			</div>
		</form>
</body>
</html>