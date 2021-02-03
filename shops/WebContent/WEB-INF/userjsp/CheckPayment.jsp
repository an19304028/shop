<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
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
		<c:forEach var="credit" items="${data}">
		<tr><td>ユーザーID</td><td>${credit.userId}</td></tr>
		<tr><td>カード番号</td><td>${credit.cardNumber}</td></tr>
		<tr><td>セキュリティーコード</td><td>${credit.securityCode}</td></tr>
		<tr><td>有効期限</td><td>${credit.expirationDate}</td></tr>
		<tr><td>支払回数</td><td>${credit.payCount}</td></tr>
	    <tr><td>
	    	<form action="removecredit" onSubmit="return checkSubmit()" method="post">
	    		<input type="hidden" name="cardNumber" value="${credit.cardNumber}">
	    		<input type="hidden" name="userId" value="${credit.userId}">
	    		<input type="submit" value="削除">
	    	</form>
		  </td></tr>
		</c:forEach>
	</table>
	<br>



	<input type='button' value='入力画面へ戻る'>
	<input type='submit' value='完了'>


	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>