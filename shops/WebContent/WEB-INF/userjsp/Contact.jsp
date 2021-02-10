<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Contact</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

	<!-- 買い物かご用 -->
	<a class="mypage_img" href=""><img src="image/header/mypage.png"></a>
	<a class="cart_img" href="getcartlist?userId=${sessionScope.userId}"><img src="image/header/cart.png"></a>

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
	<script type="text/javascript">
		var submitted = false;
	</script>
	<iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) {window.location='send-o';}"></iframe>
		<h1>お問い合わせ</h1>
	<p>以下のフォームの項目を入力し、よろしければ「この内容で問い合わせる」ボタンをクリックしてください。</p>
		<form action="https://docs.google.com/forms/u/0/d/e/1FAIpQLSeiUijIrG7X0t_MYjmPfneEB_j8h7hZVMtJCEM-aKZEqRNcOw/formResponse" method="POST" target="hidden_iframe" onsubmit="submitted=true;">

	<table border="1">
		<tr><td>お名前</td><td><input type="text" name="entry.1591633300" id="" placeholder="お名前" required></td></tr>
		<tr><td>メールアドレス</td><td><input type="text" name="entry.326955045" id="" placeholder="件名" required></td></tr>
		<tr><td>お問い合わせ内容</td><td><textarea name="entry.1696159737" id=""  rows="10" cols="60" required></textarea></td></tr>
	</table>
		<input type="submit" value="この内容で問い合わせる">
		</form>

</div>





	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>