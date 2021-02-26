<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>購入履歴</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
<style>
	#table5 tr:hover {
      background-color: #dcdcdc;   
    }
</style>
</head>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>

	<h2 align="center">購入履歴</h2><br>
	<c:choose>
		<c:when test="${history==0}">
			<p align="center">注文履歴がありません</p>
		</c:when>
		<c:otherwise>

	<table  id="table5" class="contact-table" border="1">
		<tr>
			<th></th>
			<th>商品名</th>
			<th>サイズ</th>
			<th>色</th>
			<th>値段</th>
			<th>購入日</th>

		</tr>
		<c:forEach var="item" items="${data}">
		<tr>
			<td style="display:none;">${item.itemId}</td>
			<td><img src="${item.imagePath}"  width="40px" height="40px"></td>
			<td>${item.itemName}</td>
			<td>${item.sizeName}</td>
			<td>${item.colorName}<img src="${item.colorImagePath}" width="10px" height="10px"></td>
			<td>${item.price}円</td>
			<td>${item.buyDate}</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
	</c:choose>
</div>
<script>
		$("#table5 tr").on('click',function(){
			var itemId = $(this).closest('tr').children("td")[0].innerText;
			var itemName = $(this).closest('tr').children("td")[2].innerText;
			console.log(itemId+itemName);
			location.href="getitemdetail?itemId="+itemId+"&itemName="+itemName;
			
		});
		</script>

<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>




</body>
</html>