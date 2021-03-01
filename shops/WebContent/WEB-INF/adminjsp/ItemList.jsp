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

	<div id="wrapper">
	<div align="center" class="submit-button" style="width:150px;float:left;"><a href="admininput">管理ページTOP</a></div>
	<div align="center" class="submit-button" style="width:150px;float:left;margin-left:890px;"><a href="inputitemregist">アイテム登録</a></div>
	<br style="clear:left;">
	<h2 align="center" style="margin-top:0;margin-bottom:10px;">アイテム一覧</h2>

	<p><font color="red">${addimage}</font></p>
	<p>${mess}</p>
	<table id="item-list">
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
		<th></th>
		<th></th>
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

	table#item-list{
	  border-collapse: collapse; /* セルの境界線を共有 */
	}
	#item-list td {
	  border: 1px solid black;  /* 表の罫線(=セルの枠線) */
	  padding: 5px;       /* セル内側の余白量 */
	}
	#item-list th {
		border:1px solid #000;
		background-color:#eee;
	}

	</style>




</body>
</html>