<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Contact</title>
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

		<h1>お問い合わせ</h1>
	<p>以下のフォームの項目を入力し、よろしければ「この内容で問い合わせる」ボタンをクリックしてください。</p>
		<form action="" method="">

	<table border="1">
		<tr><td>お名前</td><td><input type="text" name="name" id="" placeholder="お名前"></td></tr>
		<tr><td>件名</td><td><input type="text" name="question" id="" placeholder="件名"></td></tr>
		<tr><td>お問い合わせ内容</td><td><textarea type="text" name="content" id=""  rows="6" cols="30"></textarea></td></tr>
	</table>
		<input type="submit" value="この内容で問い合わせる">
		</form>

</div>





	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>