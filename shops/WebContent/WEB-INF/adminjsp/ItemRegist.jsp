<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItemRegist</title>
</head>
<body>
	<a href="getitemlist">商品一覧</a>
	<h2>商品追加</h2>
	<form method='post' action='additem'>
		商品名<input id="itemName" type='text' name='itemName' required><br>
		在庫数<input id="stockCount" type='text' name='stockCount' required><br>
		サイズID<input id="sizeId" type='text' name='sizeId' required><br>
		カラーID<input id="colorId" type='text' name='colorId' required><br>
		価格<input id="price" type='text' name='price' required><br>
		カテゴリーID<input id="categoryId" type='text' name='categoryId' required><br>
		詳細<input id="detail" type='text' name='detail' required><br>
		画像ID<input id="imageId" type='text' name='imageId' required><br>
		<br>
		<input type='submit' value='登録'>
	</form>

</body>
</html>