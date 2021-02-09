<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ログイン</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

	<!-- 買い物かご用 -->
	<a class="mypage_img" href="">${SessionScope.userPoint}</a>
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

	<div id="login-form">
		<h1>ログイン</h1>
		<font color="blue">ユーザー名とパスワードを入力してください。</font>
	  	<form action="login" method="post" >
			ログインID<input type="text" pattern="^[0-9A-Za-z_]+$" name="loginId" required /><br>
			パスワード<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[A-Za-z]+$" maxlength="10" name="pass" required /><br>
			 <input type="checkbox" id="password-check">パスワードを表示する<br>
			<input type="submit" value="ログイン" />
	  	</form>
	  		<script>
		 		const pwd = document.getElementById('password');
		 		const pwdCheck = document.getElementById('password-check');
		 		pwdCheck.addEventListener('change', function() {
				     if(pwdCheck.checked) {
				         pwd.setAttribute('type', 'text');
				     } else {
				         pwd.setAttribute('type', 'password');
				     }
			 	}, false);
		 	</script>

		 	<a href="">パスワードをお忘れの方はこちら</a>

		<br>

		<hr style="border: 0.5px solid #555;" width="95%">
	 	<h2>まだ会員登録されていない方</h2>
	 	<p>はじめてご利用の方は、こちらから会員登録をお願いいたします。</p>
	 	<a href="">新規登録</a>
		 </div>
</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>