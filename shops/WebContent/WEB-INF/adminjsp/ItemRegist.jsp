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
	<a href="admininput">>> 管理者TOP</a><br><br>
	<a href="getitemlist">商品一覧</a>
	<h2>商品追加</h2>

	<form method='post' action="getmaxitemid">
		<input type="submit"  value="最後のIDのを取得">
		<c:forEach var="item" items="${data}">
			<font color="blue">${item.itemId}</font>
		</c:forEach>
	</form>

	<div id="output_message"></div>

	<script type="text/javascript">
		  function getColorPath() {
		    var colorId = document.getElementById("itemId").value;
		    colorId = "image/color/"+colorId+".jpg";
		    console.log(colorId);
		    return colorId;
		  }


  	</script>

	<form method='post' action='additem'>
		商品名<input id="itemName" type='text' name='itemName' required><br>
		在庫数<input id="stockCount" type='text' name='stockCount' required><br>
		サイズID<input id="sizeId" type='text' name='sizeId' required><br>
		カラーID<input id="colorId" type='text' name='colorId' required><br>
		価格<input id="price" type='text' name='price' required><br>
		カテゴリーID<input id="categoryId" type='text' name='categoryId' required><br>
		詳細<input id="detail" type='text' name='detail' required><br>
		<br>
		<input type='submit' value='登録'>
	</form>
	<h2>画像の追加</h2>
	<form action="addimage" method="post">
	画像のパス<input id="imagePath" type='text' name='imagePath' required><br>
	アイテムID<input id="itemId" type='text' name='itemId' required><br>
	<input type='submit' value='登録'>
	</form>

</body>
</html>