<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

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

	<h1>ホーム</h1>
	<a href="userregistinput">ユーザー登録</a><br>
	<a href="logininput">ログイン</a><br>
	<a href="admininput">管理者画面へ</a><br>

	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>