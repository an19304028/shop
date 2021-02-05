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
	<a href="admininput">>> 管理者TOP</a><br><br>
	<p><font color="red">${addimage}</font></p>
	<p>${mess}</p>
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
		<th>パス</th>
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
		    <td>${item.imagePath}</td>
		    <td>
		    	<form action="removeitem" onSubmit="return checkSubmit()" method="post">
		    		<input type="hidden" name="itemId" value="${item.itemId}">
		    		<input type="submit" value="削除">
		    	</form>
		    </td>
		    <td>
		    	<form action="getitem" onSubmit="return checkSubmit()" method="post">
		    		<input type="hidden" name="itemId" value="${item.itemId}">
		    		<input type="submit" value="編集">
		    	</form>
		    </td>
		</tr>
	</c:forEach>
	</table>






</body>
</html>