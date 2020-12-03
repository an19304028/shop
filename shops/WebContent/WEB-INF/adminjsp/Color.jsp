<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Color</title>
<style>
	#table{
		background-color: beige;
	}
</style>
</head>
<body>
	<p><font color="red">${mess}</font></p>
	<table id="table" border="1">
	<tr><th>カラーID</th><th>カラー名</th><th>画像のパス</th><th>画像</th></tr>
	<c:forEach var="color" items="${data}">
		<tr><td>${color.colorId}</td>
		    <td>${color.colorName}</td>
		    <td>${color.colorImagePath}</td>
		    <td><img src="${color.colorImagePath}" width="10px" height="10px"></td>
		    <td>
		    	<form action="removecolor" method="post">
		    		<input type="hidden" name="colorId" value="${color.colorId}">
		    		<input type="submit" value="削除">
		    	</form>
		    </td>
		
		</tr>
	</c:forEach>
	</table>
	
	<a href="/shops/">ホームへ</a>
</body>
</html>