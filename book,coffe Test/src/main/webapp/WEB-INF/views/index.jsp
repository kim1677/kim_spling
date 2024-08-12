<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>

<link rel="stylesheet" href="/css/default.css">

</head>
<body>
	<div id="wrap">
		<h2> 도서관리 </h2>
		
		<div id="mainTitle">
			<h3>등록 도서 목록</h3>
			<a href="/bookWrite" id="enroll">도서등록</a>
		</div>
		
		<div id="bookListWrap">
			<ul id="bookList">
				<c:forEach var="row" items="${list }">
					<li class="blist">
						<span class="title">
							<a href="/book/view?id=${row.bookId }">${row.bookTitle }</a>     
						</span>
						<span class="auth">${row.bookAuthor }</span>
						<span class="bookCode">${row.bookId }</span>
						<span class="category">${row.publisher }</span>
					</li>
				</c:forEach>
			
				<li class="blist">
					<span class="title">자바의 기초</span>
					<span class="auth">홍길동</span>
					<span class="bookCode">ㅈc03홍2934</span>
					<span class="category">컴퓨터 프로그램언어</span>
				</li>
				<li class="blist">
					<span class="title">안드로이드sdk</span>
					<span class="auth">김유신</span>
					<span class="bookCode">ㅇc04김9384</span>
					<span class="category">컴퓨터 운영체제</span>
				</li>
				<li class="blist">
					<span class="title">C언어도장깨기</span>
					<span class="auth">최배달</span>
					<span class="bookCode">ㅆc12최2384</span>
					<span class="category">컴퓨터 프로그램언어</span>
				</li>
				<li class="blist">
					<span class="title">Who Am I</span>
					<span class="auth">토비 맥과이어</span>
					<span class="bookCode">ㅎg11토0084</span>
					<span class="category">철학</span>
				</li>
				<li class="blist">
					<span class="title">카카오는 왜 노랑색인가</span>
					<span class="auth">카카오안티</span>
					<span class="bookCode">ㅋr90카1123</span>
					<span class="category">미술</span>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>