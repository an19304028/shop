<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>サイトマップ</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function(){
			$("#header").load("common/Header.html");
		});

		$(function(){
			$("#footer").load("common/Footer.html");
		});
	</script>

	<ul>
	<li>TOP</li>
	<li><a>CATEGORY</a>
		<ul>
			<li><a href="inputcategory">ALL</a></li>
			<li><a href="">TOPS</a></li>
			<li><a href="">BOTTOMS</a></li>
			<li><a href="">ONEPIECE</a></li>
			<li><a href="">OUTER</a></li>
			<li><a href="">ACCESSORY</a></li>
			<li><a href="">OTHER</a></li>
		</ul>
	</li>
	<li><a href="inputguide">ガイド</a></li>
	<li><a href="inputcontact">お問い合わせ</a></li>
	<li><a href="inputlogin">ログイン</a></li>
	<br>
	<li><a href="inputcart">買い物かご</a></li>
	<br>
	<li><a href="inputlogout">ログアウト</a></li>
	</ul>

	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>