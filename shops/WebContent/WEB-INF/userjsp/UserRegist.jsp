<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserRegist</title>
</head>
<body>
	 
	 <form method="post" action="">
	    <font color="red">${mess}</font><br>
	    <font color="blue">※ユーザー名、パスワードは10字以内の半角英数字のみで作成して下さい。</font><br>
	      ユーザー名：<input type="text" pattern="^[0-9A-Za-z]+$" name="name" required /><br>
      	  パスワード：<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="pass" required /><br>
      	<input type="checkbox" id="password-check">パスワードを表示する<br>
      <input type="submit" value="ユーザー作成" />
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
    
</body>
</html>