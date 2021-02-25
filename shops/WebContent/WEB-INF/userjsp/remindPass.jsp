<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>パスワードの再設定</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
</head>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>
	<script type="text/javascript">
		var submitted = false;
	</script>
	<iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) {window.location='send-o';}"></iframe>
	<div id="contact-form">
		<h1 align="center">パスワードの再設定</h1>
		<p align="center">会員登録時に登録されたお名前とメールアドレスをご入力の上、「送信」をクリックしてください。</p>
		<form action="https://docs.google.com/forms/u/0/d/e/1FAIpQLSe7DNv6a1zdyR-vtMN3qpQxcK59xTAxw9qQJJQv6j6BZdYq8g/formResponse
" method="POST" target="hidden_iframe" onsubmit="submitted=true;">

			<table class="contact-table">
				<tr><th>お名前</th><td><input type="text" name="entry.1331742073" id="" placeholder="" required></td></tr>
				<tr><th>メールアドレス</th><td><input type="text" name="entry.148043242" id="" placeholder="" required></td></tr>
			</table>
			<div><input id="contact-button" type="submit" value="送信"></div>
		</form>
	</div>

</div>





	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>