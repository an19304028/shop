<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserRegist</title>
</head>
<body>
	 <h1>ユーザー登録</h1>
	 <form method="post" action="adduser">
	    <font color="red">${mess}</font>
	    <font color="blue">※ユーザー名、パスワードは10字以内の半角英数字のみで作成して下さい。</font><br>
	      名前：<input type="text" name="name"  /><br>
	      ふりがな：<input type="text" name="kana" /><br>
	      メール：<input type="text" name="mail" /><br>
	      <font color="red">※</font>
	      ログインID：<input type="text" name="loginId" required /><br>
	      <font color="red">※</font>
	      パスワード：<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required /><br>
	      <input type="checkbox" id="password-check">パスワードを表示する<br>
	      性別：男<input type="radio" name="gender" />
	     	    女<input type="radio" name="gender" />
	     	    その他<input type="radio" name="gender" /><br>
	     誕生日：<input type="text" name="birthday" /><br>
	     電話番号：<input type="text" name="tell" /><br>
	     郵便番号:<input type="text" name="postalCode"  /><br>
	     住所:<input type="text" name="address" /><br>
      	  
      	
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