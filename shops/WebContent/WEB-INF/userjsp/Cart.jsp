<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Cart</title>
<script type="text/javascript">
	function checkSubmit() {
		result = confirm("空にしても良いですか？");
		if (result) {
			document.myform.action = "PostWriteServlet";
			} else {
			alert("キャンセルします。");
			return false;
		}
	}
</script>
</head>
<body>

	<!-- ヘッダー -->
	<div id="header"></div>

	<!-- 買い物かご用 -->
	<a class="mypage_img" href=""><img src="image/header/mypage.png"></a>
	<a class="cart_img" href="getcartlist?userId=${sessionScope.userId}"><img src="image/header/cart.png"></a>

<div id="wrapper">

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

	<c:choose>
		<c:when test="${total!=0}">
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
					    <td>
						    <form action="removecart" method="post">
					    		<input type="hidden" name="itemId" value="${item.itemId}">
					    		<input type="hidden" name="userId" value="${sessionScope.userId}">
					    		<input type="submit" value="削除">
					    	</form>
					    </td>
					</tr>
				</c:forEach>
			</table>

			<p>${mess}　 ${point}pt</p>

			<form action="removeallcart" onSubmit="return checkSubmit()" method="post">
				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input type="submit" value="カートを空にする">
			</form>
			<form action="inputorder" method="post">
				<c:forEach var="item" items="${data}">
					<input type="hidden" name="itemId" value="${item.itemId}">
					<input type="hidden" name="buyCount" value="${item.buyCount}">
					<input type="hidden" name="price" value="${item.price}">
				</c:forEach>

				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input type="hidden" name="point" value="${point}">
				<input type="submit" value="購入手続きへ進む">
			</form>

			<br>
	</c:when>
	<c:otherwise>
		<p>${mess} </p>
	</c:otherwise>
	</c:choose>

</div>

<div id="footer-wrap">
	<div id="footer"></div>
</div>

</body>
</html>