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

	<h1>パスワード変更フォーム</h1>

	<form action="editpass" method="POST">
		<p>ログインID</p>
		<input type="text" style="font-family:Verdana" name="loginId" required>
		<p>変更後のパスワード</p>
		<input type="password" style="font-family:Verdana" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required />
		<input type="checkbox" id="password-check"><label for="password-check">パスワードを表示する</label>
		<p>変更後のパスワード(再入力)</p>
		<input type="password" style="font-family:Verdana" id="confirm" pattern="^[0-9A-Za-z]+$" maxlength="10" name="confirm" oninput="CheckPassword(this)"  required />
		<input type="checkbox" id="confirm-check"><label for="confirm-check">パスワードを表示する</label>

		<input type="submit" value="送信">
	</form>

	<script>
		//パスワード表示
		const pwd = document.getElementById('password');
			const pwdCheck = document.getElementById('password-check');
			pwdCheck.addEventListener('change', function() {
		     if(pwdCheck.checked) {
		         pwd.setAttribute('type', 'text');
		     } else {
		         pwd.setAttribute('type', 'password');
		     }
	 	}, false);
			const confirm = document.getElementById('confirm');
	 		const confirmCheck = document.getElementById('confirm-check');
	 		confirmCheck.addEventListener('change', function() {
			     if(confirmCheck.checked) {
			    	 confirm.setAttribute('type', 'text');
			     } else {
			    	 confirm.setAttribute('type', 'password');
			     }
		 	}, false);

	 		//パスワードが一致してるかのチェック
		function CheckPassword(confirm){
			// 入力値取得
			var input1 = password.value;
			var input2 = confirm.value;
			// パスワード比較
			if(input1 != input2){
				confirm.setCustomValidity("入力値が一致しません。");
			}else{
				confirm.setCustomValidity('');
			}
		}
	</script>


</div>





	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>