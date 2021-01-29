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
		<tr>
			<th>ユーザーID<th><td>${credit.userId}</td><br>
			<th>カード番号</th><td>${credit.creditNumber}</td><br>
			<th>セキュリティーコード</th><td>${credit.securityCode}</td><br>
			<th>有効期限</th><td>${credit.expirationDate}</td><br>
			<th>支払回数</th><td>${credit.payCount}</td><br>
		</tr>
	</table>

		<input type='button' value='入力画面へ戻る'>
		<input type='submit' value='完了'>


	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>