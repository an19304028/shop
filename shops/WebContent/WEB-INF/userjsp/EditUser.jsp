<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditUser</title>

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

		 <h1>登録内容の編集</h1>
	 <form method="post" action="adduser">
	    <font color="red">${mess}</font><br>
	    <font color="blue">※ユーザー名、パスワードは10字以内の半角英数字のみで作成して下さい。</font><br>
	      名前：<input type="text" name="name" value="" required /><br>
	      ふりがな：<input type="text" name="kana" value="" required /><br>
	      メール：<input type="text" name="mail" value="" required /><br>
	      ログインID：<input type="text" name="loginId" value="" required /><br>
	      パスワード：<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required /><br>
	      <input type="checkbox" id="password-check">パスワードを表示する<br>
	      性別：男<input type="radio" name="gender" value="男" />
	     	    女<input type="radio" name="gender" value="女"/>
	     	    その他<input type="radio" name="gender" value="その他"/><br>
	     誕生日：<input type="text" name="birthday" required /><br>
	     電話番号：<input type="text" name="tell" required /><br>
	     郵便番号:<input type="text" name="postalCode" required /><br>
	     住所:<input type="text" name="address"  required /><br>


      <input type="submit" value="編集" />
    </form>


	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>