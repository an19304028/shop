<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>EditUser</title>

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

		 <h1>登録内容の編集</h1>
	<c:forEach var="item" items="${data}">
	 <form method="post" action="edituser">
	    <font color="red">${mess}</font><br>
	    <font color="blue">※ユーザー名、パスワードは10字以内の半角英数字のみで作成して下さい。</font><br>
	      名前：<input type="text" name="name" value="${item.name}" readonly /><br>
	      ふりがな：<input type="text" name="kana" value="${item.kana}" readonly /><br>
	      メール：<input type="text" name="mail" value="${item.mail}" required /><br>
	      ログインID：<input type="text" name="loginId" value="${item.loginId}" required /><br>

	      性別：<input type="text" name="gender" value="${item.gender}" readonly/><br>
	     誕生日：<input type="text" name="birthday" value="${item.birthday}"  readonly/><br>
	     電話番号：<input type="text" name="tell" value="${item.tell}" required /><br>
	     郵便番号:<input type="text" name="postalCode" value="${item.postalCode}" required /><br>
	     住所:<input type="text" name="address"  value="${item.address}" required /><br>

		パスワード：<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required /><br>
	      <input type="checkbox" id="password-check">パスワードを表示する<br>
	      <input type="hidden" name="userId" value="${sessionScope.userId}">
      <input type="submit" value="編集" />
    </form>
	</c:forEach>
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