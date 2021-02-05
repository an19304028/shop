<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ItemEdit</title>
</head>
<body>
	<a href="admininput">>> 管理者TOP</a>
	<a href="getallitems">商品一覧</a>
	<h2>商品 編集</h2>
	<c:forEach var="item" items="${data}">
		<form method='post' action='edititem'>
			<input id="itemId" type='hidden' name='itemId' value="${item.itemId}" ><br> 
			商品名<input id="itemName" type='text' name='itemName' value="${item.itemName}" required><br>
			在庫数<input id="stockCount" type='text' name='stockCount' value="${item.stockCount}" required><br>
			<%-- サイズID<input id="sizeId" type='text' name='sizeId'  value="${item.sizeId}" required><br>
			カラーID<input id="colorId" type='text' name='colorId'  value="${item.Price}" required><br> --%>
			価格<input id="price" type='text' name='price'  value="${item.price}" required><br>
			<!-- カテゴリーID<input id="categoryId" type='text' name='categoryId' required><br> -->
			詳細<input id="detail" type='text' name='detail'  value="${item.detail}" required><br>
			<!-- 画像ID<input id="imageId" type='text' name='imageId' required><br> -->
			<br>
			<input type='submit' value='編集'>
			
		</form>
	</c:forEach>

</body>
</html>