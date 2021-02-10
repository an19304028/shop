<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>再入荷</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

	<!-- 買い物かご用 -->
	<a class="mypage_img" href=""><img src="image/header/mypage.png"></a>
	<a class="cart_img" href="getcartlist?userId=${sessionScope.userId}"><img src="image/header/cart.png"></a>

<div id="wrapper">
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function(){
			$("#header").load("common/Header.html");
		});

		$(function(){
			$("#footer").load("common/Footer.html");
		});
	</script>
	
	<h1>再入荷のお知らせ</h1>
	<p>こちらの商品が入荷した際、メールにてお知らせをいたします。</p>
	<c:forEach var="item" items="${data}">
	<p>商品名：${item.itemName}</p>
	<p>サイズ/カラー：${item.sizeName}/${item.colorName}</p>
	</c:forEach>
	<form action="" method="post">
		　　　　　　お名前：<input type="text" name="name"><br>
		通知メールアドレス：<input type="text" name="mail"><br>
		<input type="submit">
	</form>

</div>

	
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>