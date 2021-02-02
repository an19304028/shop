<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
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

	<h1>ログイン</h1>
	<font color="blue">ユーザー名とパスワードを入力してください。</font>
  	<form action="" method="post" >
      ログインID：<input type="text" pattern="^[0-9A-Za-z]+$" name="loginId" required /><br>
      パスワード：<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[A-Za-z]+$" maxlength="10" name="pass" required /><br>
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
	 	<h2>まだ会員登録されていない方</h2>
	 	<p>はじめてご利用の方は、こちらから会員登録をお願いいたします。</p>
	 	<a href="">新規登録</a>


	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>