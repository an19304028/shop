<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template</title>

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

	<h2>クレジットカードでのお支払い</h2>

	<form method='post' action=''>
		カード番号<input id="creditNumber" type='text' name='creditNumber' required><br>
		名義人<input id="name" type='text' name='name' required><br>
		セキュリティーコード<input id="securityCode" type='text' name='securityCode' required><br>
		有効期限<input id="expirationDate" type='text' name='expirationDate' required><br>
		<!-- ↑ 月/年の表記 -->
		支払回数<input id="payCount" type='text' name='payCount' required><br>
		<br>
		<!-- 戻るボタンも必要かな -->
		<input type='submit' value='入力内容を確認する'>
	</form>

	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>