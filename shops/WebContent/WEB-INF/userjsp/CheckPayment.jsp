<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クレカ確認画面</title>

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

	<p>以下の内容で良いですか？</p>

	<table border="1">
		<tr><td>ユーザーID</td><td>${credit.userId}</td></tr>
		<tr><td>カード番号</td><td>${credit.creditNumber}</td></tr>
		<tr><td>セキュリティーコード</td><td>${credit.securityCode}</td></tr>
		<tr><td>有効期限</td><td>${credit.expirationDate}</td></tr>
		<tr><td>支払回数</td><td>${credit.payCount}</td></tr>
	</table>
	<br>

		<input type='button' value='入力画面へ戻る'>
		<input type='submit' value='完了'>


	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>