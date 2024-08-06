<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 보기 </title>
</head>
<body>
	<a href="/board">목록으로</a>
	<h2>게시글 보기</h2>
	
	${data.getTitle() }
	${data.writer }
	${data.content }
	${data.boardPw }
	
</body>
</html>