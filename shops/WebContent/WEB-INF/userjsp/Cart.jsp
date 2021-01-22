<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<th>注文番号</th>
			<th>商品情報</th>
			<th>注文日</th>
			<th>価格</th>
			<th>数量</th>
		</tr>

		<tr>
			<td>${order.orderId}</td>
			<td>${order.userId}</td>
			<td>${order.buyDate}</td>
			<td>${order.price}</td>
			<td>${order.itemCount}</td>
		</tr>
	</table>

	<a href="">買い物に戻る</a>
	<a href="">カートを空にする</a>
	<br>

	<a href="">購入手続きに進む</a>



	<div id="footer"></div>

</body>
</html>