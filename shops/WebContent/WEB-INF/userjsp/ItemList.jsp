<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>アイテム一覧</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

<div id="wrapper">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

	<script>
		$(function(){
			$("#header").load("common/Header.html");
		});

		$(function(){
			$("#footer").load("common/Footer.html");
		});
	</script>
	<p>${mess}</p>
	<c:choose>
		<c:when test="${count>0}">
			<table id="item-list" border="1">
			<tr>

				<th>商品名</th>
				<th>画像</th>
			</tr>
			<c:forEach var="item" items="${data}">
				<tr>

				    <td>${item.itemName}</td>
				    <td><img src="image/item/${item.imagePath}"  width="40px" height="40px"></td>
				    <td>
				    	<form action="getitemdetail" onSubmit="return checkSubmit()" method="post">

				    		<input type="hidden" name="itemId" value="${item.itemId}">

				    		<input type="submit" value="商品詳細へ">
				    	</form>
				    </td>
				</tr>
			</c:forEach>
			</table>
		</c:when>
	</c:choose>
</div>

<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>




</body>
</html>