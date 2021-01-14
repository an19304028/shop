<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="box"></div>

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function(){
			$("#box").load("Header.jsp");
		});
	</script>
	<h1>ホーム</h1>
	<a href="userregistinput">ユーザー登録</a><br>
	<a href="logininput">ログイン</a><br>
	<a href="admininput">管理者画面へ</a><br>
</body>
</html>