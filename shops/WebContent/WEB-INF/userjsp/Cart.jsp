<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

	<h1>買い物かご</h1>

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function(){
			$("#header").load("common/Header.html");
		});

		$(function(){
			$("#footer").load("common/Footer.html");
		});
	</script>


	<table id="table" border="1">
		<tr>
			<th>商品名</th>
			<th>サイズ</th>
			<th>カラー</th>
			<th>数量</th>
			<th>ポイント</th>
			<th>価格</th>
		</tr>
		<c:forEach var="item" items="${data}">
			<tr>
				<td>${item.itemName}</td>
			    <td>${item.sizeName}</td>
			    <td>${item.colorName}</td>
			    <td>${item.buyCount}</td>
	   		    <td>${item.point}</td>
			    <td>${item.price}</td>
			</tr>

		</c:forEach>
	</table>
	<form action="addorderdetail" onSubmit="return checkSubmit()" method="post">
		<input type="hidden" name="userId" value="1">
		<input type="submit" value="注文確定">
	</form>



	<br>




	<div id="footer"></div>

</body>
</html>