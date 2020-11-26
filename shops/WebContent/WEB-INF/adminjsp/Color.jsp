<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Color</title>
</head>
<body>
	<table border="1">
	<tr><th>カラーID</th><th>カラー名</th><th>画像のパス</th></tr>
	<c:forEach var="color" items="${data}">
		<tr><td>${color.colorId}</td><td>${color.colorName}</td><td>${color.colorImagePath}</td></tr>
	</c:forEach>
	</table>
	<a href="/shops/">ホームへ</a>
</body>
</html>