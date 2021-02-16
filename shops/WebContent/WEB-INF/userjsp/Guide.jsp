<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ご利用ガイド</title>
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

	<h1 align="center">ご利用案内</h1>

	<div id="guidejump">
		<ul class="guide-list">
			<li><a href="#link1">ご利用方法</a></li>
			<li><a href="#link2">お支払いについて</a></li>
			<li><a href="#link3">配送について</a></li>
			<li><a href="#link4">消費税について</a></li>
			<li><a href="#link5">返品について</a></li>
		</ul>
	</div>

	<section>
		<h2 style="padding-top:100px;" id="link1">ご利用方法</h2>
		<p>（内容）</p>
		<p style="padding-top:500px;">
	</section>

	<section>
		<h2 style="padding-top:100px;" id="link2">お支払いについて</h2>
		<p>（内容）</p>
		<p style="padding-top:500px;">
	</section>

	<section>
		<h2 style="padding-top:100px;" id="link3">配送について</h2>
		<p>（内容）</p>
		<p style="padding-top:500px;">
	</section>

	<section>
		<h2 style="padding-top:100px;" id="link4">消費税について</h2>
		<p>（内容）</p>
		<p style="padding-top:500px;">
	</section>

	<section>
		<h2 style="padding-top:100px;" id="link5">返品について</h2>
		<p>（内容）</p>
		<p style="padding-top:500px;">
	</section>

</div>

	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>