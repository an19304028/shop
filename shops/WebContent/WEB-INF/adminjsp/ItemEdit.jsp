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

	<div id="wrapper">
	<div align="center" class="submit-button" style="width:150px;float:left;"><a href="admininput">管理ページTOP</a></div>
	<div align="center" class="submit-button" style="width:150px;float:left;margin-left:890px;"><a href="getitemlist">アイテム一覧</a></div>
	<br style="clear:left;"><br>
	<h2 align="center" style="margin-top:0;margin-bottom:10px;">商品編集</h2><br>

	<div align="center" style="border:1px solid #000;width:800px;margin:auto;">
	<c:forEach var="item" items="${data}">
		<form method='post' action='edititem'>
		<table class="create-form">
			<input id="itemId" type='hidden' name='itemId' value="${item.itemId}" ><br>
			<tr><th>商品名</th><td><input id="itemName" type='text' name='itemName' value="${item.itemName}" required></td></tr>
			<tr><th>在庫数</th><td><input id="stockCount" type='text' name='stockCount' value="${item.stockCount}" required></td></tr>
			<%-- サイズID<input id="sizeId" type='text' name='sizeId'  value="${item.sizeId}" required></td></tr>
			カラーID<input id="colorId" type='text' name='colorId'  value="${item.Price}" required><br> --%>
			<tr><th>価格</th><td><input id="price" type='text' name='price'  value="${item.price}" required></td></tr>
			<!-- カテゴリーID<input id="categoryId" type='text' name='categoryId' required><br> -->
			<tr><th>詳細</th><td><input id="detail" type='text' name='detail'  value="${item.detail}" required></td></tr>
			<!-- 画像ID<input id="imageId" type='text' name='imageId' required><br> -->
		</table>
		<input class="submit-button" type='submit' value='編集'>

		</form>
	</c:forEach>
	<br>
	</div>
	</div>

		<style>

	body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td {
		margin: 0;
		padding: 0;
	}

	body{
		font-family:Yu Gothic;
	}

	a{
		text-decoration: none;
	}

	#wrapper {
		width: 1300px;
		margin-left: auto;
	    margin-right: auto;
		min-height: 100vh;
	}

		/* ---------- リンク色変更 ---------- */
	a {
		color : #000;
		text-decoration: none;
	}
	a:visited{
		color : #000;
	}

	.submit-button{
		margin : 10px;
		padding : 10px 20px;
		background: #eee;
		border: none;
		border-radius : 20px;
		outline: none;
		-webkit-appearance: none;
		-moz-appearance: none;
		appearance: none;
		cursor: pointer;
	}
	.submit-button a{
		display:block;
	}

	.create-form{
		width : 550px;
		padding:0 20px;
		text-align:center;
	}

	.create-form table {
		margin:auto;
	}

	.create-form table th{
		width:100px;
	}

	.create-form input{
		margin: 10px;
		padding : 5px 10px;
		width : 350px;
		height: 30px;

		border-bottom: 1px solid;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
	}

	</style>
</body>
</html>