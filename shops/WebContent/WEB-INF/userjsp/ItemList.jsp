<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>アイテム一覧</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
</head>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>
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
				    <td><img src="${item.imagePath}"  width="40px" height="40px"></td>
				    <td>
				    	<form action="getitemdetail" onSubmit="return checkSubmit()" method="post">

				    		<input type="hidden" name="itemId" value="${item.itemId}">
				    		<input type="hidden" name="itemName" value="${item.itemName}">

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