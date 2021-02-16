<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ユーザー登録</title>
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

	<div id="create-form">
	 <h1 align="center">ユーザー登録</h1>
	 <form method="post" action="adduser">
	    <font color="red">${mess}</font><br>
	    <font color="blue" size="2">※ユーザー名、パスワードは10字以内の半角英数字のみで作成して下さい。</font><br>

	<table>
		<tr>
	      <th scope="row"><label>名前</label></th>
	      <td><input type="text" name="name" id="name" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>ふりがな</label></th>
	      <td><input type="text" name="kana" id="kana" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>メール</label></th>
	      <td><input type="text" name="mail" id="mail" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>ログインID</label></th>
	      <td><input type="text" name="loginId" id="loginId" required /></td>
	    </tr>
	    <tr>
	      <th scope="row"><label>パスワード</label></th>
	      <td><input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required /></td>
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
	      	<input id="radio1" class="radiobutton" type="radio" name="gender" value="男" /><label for="radio1">男</label>
	     	<input id="radio2" class="radiobutton" type="radio" name="gender" value="女"/><label for="radio2">女</label>
	     	<input id="radio3" class="radiobutton" type="radio" name="gender" value="その他"/><label for="radio3">その他</label>
	     	</div>
	      </td>
	     </tr>
	     <tr>
	      <th scope="row"><label>誕生日</label></th>
	      <td><input type="text" name="birthday" id="birthday" required /></td>
	     </tr>
	     <tr>
	      <th scope="row"><label>電話番号</label></th>
	      <td><input type="text" name="tell" id="tel" required /></td>
	     </tr>
	     <tr>
	      <th scope="row"><label>郵便番号</label></th>
	      <td><input type="text" name="postalCode" id="postalCode" required /></td>
	     </tr>
	     <tr>
	      <th scope="row"><label>住所</label></th>
	      <td><input type="text" name="address" id="address" required /></td>
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