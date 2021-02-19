<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Cart</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
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
<div id="wrapper">
<%@ include file="Header.jsp" %>

	<h1 align="center">買い物かご</h1>

	<c:choose>
		<c:when test="${total!=0}">
			<table class="contact-table" border="1">
				<tr>
					<th>商品名</th>
					<th>サイズ</th>
					<th>カラー</th>
					<th>数量</th>
					<th>ポイント</th>
					<th>価格</th>
					<th>　</th>
				</tr>
				<c:forEach var="item" items="${data}">
					<tr>
						<td>${item.itemName}</td>
					    <td>${item.sizeName}</td>
					    <td>${item.colorName}</td>
					    <td>${item.buyCount}</td>
			   		    <td>${item.point}pt</td>
					    <td>${item.price}円</td>
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

			<form action="removeallcart" onSubmit="return checkSubmit()" method="post">
				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input style="flote:right;margin-left:120px;" id="cart-clear-button" type="submit" value="カートを空にする">
			</form>

			<h2 style="flote:right;padding-right:150px;" align="right">${mess}　 ${point}pt</h2>

			<form action="inputorder" method="post">
				<c:forEach var="item" items="${data}">
					<input type="hidden" name="itemId" value="${item.itemId}">
					<input type="hidden" name="buyCount" value="${item.buyCount}">
					<input type="hidden" name="price" value="${item.price}">
				</c:forEach>

				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input type="hidden" name="point" value="${point}">
				<input	style="float: right;margin-right:120px;marginbuttom:30px;" id="next-button" type="submit" value="購入手続きへ進む">
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