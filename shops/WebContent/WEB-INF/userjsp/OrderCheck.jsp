<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>購入手続き確認</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
</head>
<body>
<div id="wrapper">
<jsp:include page="Header.jsp" flush="true" />

				<table class="contact-table" border="1">
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
			   		    <td>${item.point}pt</td>
					    <td>${item.price}円</td>
					</tr>
				</c:forEach>
			</table>

			<form action="addorder" method="post">
				<c:forEach var="item" items="${data}">
					<input type="hidden" name="itemId" value="${item.itemId}">
					<input type="hidden" name="buyCount" value="${item.buyCount}">
					<input type="hidden" name="price" value="${item.price}">
				</c:forEach>

				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input type="hidden" name="usepoint" value="${point}">
				<input type="hidden" name="itempoint" value="${itempoint}">
				<input style="float: right;margin-right:200px;" id="buy-button" type="submit" value="確定">
			</form>

			<div  style="float: right;margin-right:150px;">
			<p>小計：${price}円</p>
			<c:choose>
				<c:when test="${point==0}">
					<p>ポイント利用：利用なし</p>
				</c:when>
				<c:otherwise>
					<p>ポイント利用：${point}</p>
				</c:otherwise>
			
			</c:choose>
			<p>お支払総額：${total}円</p>
			<p>獲得予定ポイント：${itempoint}pt</p>
			</div>

			<br>


</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>