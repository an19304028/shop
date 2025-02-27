<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ユーザー登録</title>
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

	<div class="create-form">
	 <h1 align="center">ユーザー登録</h1>
	 <form method="post" action="adduser">
	    <p align="center"><font color="red">${mess}</font></p><br>
	    <font color="blue" size="2">※ログインID、パスワードは6字以上10字以内の半角英数字のみで作成して下さい。</font><br>

	<table>
		<tr>
	      <th scope="row"><label>名前</label></th>
	      <td><input type="text" name="name" value="${user.name}" id="name" maxlength="30" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>ふりがな</label></th>
	      <td><input type="text" name="kana" id="kana" value="${user.kana}" maxlength="60"  /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>メール</label></th>
	      <td><input type="text" name="mail" id="mail"  minlength="6"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" maxlength="300" value="${user.mail}" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>ログインID</label></th>
	      <td><input type="text" name="loginId" id="loginId" minlength="6" pattern="^[0-9A-Za-z]+$"  maxlength="10" value="${user.loginId}" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>パスワード</label></th>
	      <td><input type="password" style="font-family:Verdana " minlength="6"  class="field" id="password" value="${user.password}" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required /></td>
	    </tr>
	    <tr>
	      <th scope="row">
	      <td>　<input type="checkbox" id="password-check"><label for="password-check">パスワードを表示する</label></td>
	    </tr>
	    <tr><th>　</th><td>　</td></tr>
	    <tr>
	      <th scope="row"><label>性別</label></th>
	      <td>
      		<div class="radiobox">
	      	<input id="radio1" class="radiobutton" type="radio" name="gender" value="男" required /><label for="radio1">男</label>
	     	<input id="radio2" class="radiobutton" type="radio" name="gender" value="女" /><label for="radio2">女</label>
	     	<input id="radio3" class="radiobutton" type="radio" name="gender" value="その他" /><label for="radio3">その他</label>
	     	</div>
	      </td>
	     </tr>
	     <tr>
	      <th scope="row"><label>誕生日</label></th>
	      <td><input type="date" name="birthday" min="1900-01-01" max="2020-12-31"  id="birthday" value="${user.birthday}" required /></td>
	     </tr>
	     <tr>
	      <th scope="row"><label>電話番号</label></th>
	      <td><input type="text" name="tell" id="tel" placeholder="ハイフンなしで入力してください" maxlength="20"  pattern="^0\d{9,10}$"  minlength="8"  value="${user.tell}" required /></td>
	     </tr>
	     <tr>
	      <th scope="row"><label>郵便番号</label></th>
	      <td><input type="text" name="postalCode" id="postalCode"  placeholder="ハイフンなしで入力してください"   pattern="^\d{7}$"  minlength="7"  maxlength="7" value="${user.postalCode}" required /></td>
	     </tr>
	     <tr>
	      <th scope="row"><label>住所</label></th>
	      <td><input type="text" name="address" id="address" maxlength="150" value="${user.address}" required /></td>
	     </tr>
	</table>

      <input id="create-ok-button" type="submit" value="送信" />
    </form>
    </div>

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

</div>

<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>