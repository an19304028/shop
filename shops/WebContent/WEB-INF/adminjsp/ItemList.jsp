<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItemList</title>
</head>
<body>
	<table id="item-list" border="1">
	<tr>
		<th>商品ID</th>
		<th>商品名</th>
		<th>在庫数</th>
		<th>サイズID</th>
		<th>カラーID</th>
		<th>価格</th>
		<th>カテゴリーID</th>
		<th>詳細</th>
	</tr>
	<c:forEach var="item" items="${data}">
		<tr>
			<td>${item.itemId}</td>
		    <td>${item.itemName}</td>
		    <td>${item.stockCount}</td>
		    <td>${item.sizeId}</td>
		    <td>${item.colorId}</td>
		    <td>${item.price}</td>
		    <td>${item.categoryId}</td>
		    <td>${item.detail}</td>
		    <td>
		    	<form action="removeitem" onSubmit="return checkSubmit()" method="post">
		    		<input type="hidden" name="itemId" value="${item.itemId}">
		    		<input type="submit" value="削除">
		    	</form>
		    </td>
		</tr>
	</c:forEach>
	</table>

	<h2>画像の追加</h2>
	<form>
	画像のパス<input id="imagePath" type='text' name='imagePath' required><br>
	アイテムID<input id="itemId" type='hidden' name='itemId' value=''><br>
	<input type='submit' value='登録'>
	</form>


</body>
</html>