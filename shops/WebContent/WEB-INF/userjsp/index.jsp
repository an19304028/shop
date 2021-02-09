<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">

<title>index</title>

<body>

	<!-- ヘッダー -->
	<div id="header"></div>


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

	<h1>ホーム</h1>
	<br>
	<a href="userregistinput">ユーザー登録</a><br><br>
	<a href="logininput">ログイン</a><br>
	<a href="logout">ログアウト</a><br><br>
	<a href="admininput">管理者画面へ</a><br>
	<a href="getuseritemlist">アイテム一覧へ</a><br>
	<a href="getuser?${sessionScope.userId}">ユーザー情報へ</a><br>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</div>

<p id="page-top"><a href="#"><img src="image/header/pagetop.png" height="50" width="50" alt="ページトップボタン"></a></p>

<div id="footer-wrap">
	<!-- フッター -->
	<div id="footer"></div>
</div>



</body>
</html>