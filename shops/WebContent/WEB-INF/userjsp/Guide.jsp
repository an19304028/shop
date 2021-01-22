<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guide</title>
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

	<h1>ご利用案内</h1>

	<h2>ご利用方法</h2>
	<h2>お支払いについて</h2>
	<h2>配送について</h2>

	<!-- フッター -->
	<div id="footer"></div>

</body>
</html>