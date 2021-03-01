<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ItemRegist</title>
</head>
<body>

	<script type="text/javascript">
		  function getColorPath() {
		    var colorId = document.getElementById("itemId").value;
		    colorId = "image/color/"+colorId+".jpg";
		    console.log(colorId);
		    return colorId;
		  }
  	</script>

	<div id="wrapper">
	<div align="center" class="submit-button" style="width:150px;float:left;"><a href="admininput">管理ページTOP</a></div>
	<div align="center" class="submit-button" style="width:150px;float:left;margin-left:770px;"><a href="getitemlist">アイテム一覧</a></div>
	<br style="clear:left;">
	<h2 align="center" style="margin-top:0;">アイテム登録</h2>

	<div id="output_message"></div>



		<div class="box" style="border:1px solid #000;width:550px;float:left;margin-bottom:20px;">

			<h3 align="center" style="margin:10px;">商品登録</h3><hr>

			<form method='post' action="getmaxitemid">
				<input class="submit-button" type="submit"  value="最後のIDのを取得">
				<c:forEach var="item" items="${data}">
					<font color="blue">${item.itemId}</font>
				</c:forEach>
			</form>


			<form method='post' action='additem'>
			<table class="create-form">
				<tr><th>アイテムID</th><td><input id="itemId" type="text" name="itemId" required></td></tr>
				<tr><th>商品名</th><td><input id="itemName" type='text' name='itemName' required></td></tr>
				<tr><th>在庫数</th><td><input id="stockCount" type='text' name='stockCount' required></td></tr>
				<tr><th>サイズID</th><td><input id="sizeId" type='text' name='sizeId' required></td></tr>
				<tr><th>カラーID</th><td><input id="colorId" type='text' name='colorId' required></td></tr>
				<tr><th>価格</th><td><input id="price" type='text' name='price' required></td></tr>
				<tr><th>カテゴリーID</th><td><input id="categoryId" type='text' name='categoryId' required></td></tr>
				<tr><th>詳細</th><td><input id="detail" type='text' name='detail' required></td></tr>
			</table>
			<input class="submit-button" type='submit' value='登録'>
			</form>
			<br>
		</div>

		<div class="box" style="border:1px solid #000;width:550px;float:left;margin-bottom:20px;">
			<h3 align="center" style="margin:10px;">画像の追加</h3><hr>
			<form action="addimage" method="post">
			<table class="create-form">
				<tr><th>画像のパス</th><td><input id="imagePath" type='text' name='imagePath' required></td></tr>
				<tr><th>アイテムID</th><td><input id="itemId" type='text' name='itemId' required></td></tr>
			</table>
			<input class="submit-button" type='submit' value='登録'>
			</form>
		</div>


	</div>

	<style>

	body{
		font-family:Yu Gothic;
	}

	a{
		text-decoration: none;

		color : #000;
		text-decoration: none;
	}
	a:visited{
		color : #000;
	}



	#wrapper {
		width: 1200px;
		margin-left: auto;
	    margin-right: auto;
		min-height: 100vh;
		padding-bottom: 150px;
	}

	.box{
		text-align:center;
		margin:10px 10px 30px 10px;
		padding:10px;
		width:450px;
		border 	: 1px solid dimgray;
		border-radius:10px;
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

	.submit-button {
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
		display: block;
	}



	</style>

</body>
</html>