<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ログイン</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
<%
	String itemId = (String)request.getAttribute("itemId");
	String buyCount = (String)request.getAttribute("buyCount");
	String itemName = (String)request.getAttribute("itemName");
%>
</head>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>
	<div id="login-form">

	<div id="login-box">
		<h1 style="margin:10px;">ログイン</h1>
		<p><font color="red">${login}</font></p>
		<font color="dimgray" size="2">ユーザー名とパスワードを入力してください</font>
	  	<form action="login" method="post" >
	  		<input type="hidden" name="itemId" value=<%= itemId %> />
			<input type="hidden" name="buyCount" value=<%= buyCount %> />
			<input type="hidden" name="itemName" value=<%= itemName %> />
			ログインID<input type="text" pattern="^[0-9A-Za-z_]+$" name="loginId" id="loginId" maxlength="20" required /><br>
			パスワード<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[A-Za-z]+$" maxlength="10" name="pass" required /><br>
			 <input type="checkbox" id="password-check"><label for="password-check">パスワードを表示する</label><br>
			<input type="submit" id="login-button" value="ログイン" />
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

		 	<a style="font-size:80%;" href="inputremindpass">パスワードをお忘れの方はこちら</a>
	</div>

	<div id="create-account">
	 	<h2 style="margin-bottom:20px;">まだ会員登録されていない方</h2>
	 	<p style="font-size:80%;">はじめてご利用の方は、こちらから会員登録をお願いいたします。</p>
	 	<input type="button" onclick="location.href='userregistinput'" id="create-button" value="新規登録">
		 </div>
	</div>
</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>