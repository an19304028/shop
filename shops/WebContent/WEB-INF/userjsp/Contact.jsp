<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Contact</title>
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
		<h1 align="center">お問い合わせ</h1>
		<p align="center">以下のフォームの項目を入力し、よろしければ「この内容で問い合わせる」ボタンをクリックしてください。</p>
		<form action="https://docs.google.com/forms/u/0/d/e/1FAIpQLSeiUijIrG7X0t_MYjmPfneEB_j8h7hZVMtJCEM-aKZEqRNcOw/formResponse" method="POST" target="hidden_iframe" onsubmit="submitted=true;">

			<table class="contact-table" border="1">
				<tr><th>お名前</th><td><input type="text" name="entry.1591633300" id="" placeholder="" required></td></tr>
				<tr><th>メールアドレス</th><td><input type="text" name="entry.326955045" id="" placeholder="" required></td></tr>
				<tr><th>お問い合わせ内容</th><td><textarea name="entry.1696159737" id=""  rows="10" cols="60" required></textarea></td></tr>
			</table>

			<div align="center"><input id="contact-button" type="submit" value="この内容で問い合わせる"></div>
		</form>
	</div>

</div>





	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>