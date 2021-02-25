<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>EditUser</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>

	<div class="create-form">

		 <h2 align="center">登録内容の編集</h2>

		<c:forEach var="item" items="${data}">
		 <form method="post" action="edituser">
		    <p align="center"><font color="red" >${mess}</font></p><br>
		    <font color="blue" size="2">※ユーザー名、パスワードは10字以内の半角英数字のみで作成して下さい。</font><br>

		    <table>
		    <tr>
	      <th scope="row"><label>
				名前</label></th>
				<td><input type="text" name="name" id="name" style="color:lightgray;" value="${item.name}" readonly /></td>
		<tr>
	      <th scope="row"><label>
				ふりがな</label></th>
				<td><input type="text" name="kana" id="kana" style="color:lightgray;" value="${item.kana}" readonly /></td>
		<tr>
	      <th scope="row"><label>
				メール</label></th>
				<td><input type="text" name="mail" id="mail" value="${item.mail}" maxlength="300"  required /></td>
		<tr>
	      <th scope="row"><label>
				ログインID</label></th>
				<td><input type="text" name="loginId" id="loginId" value="${item.loginId}" maxlength="20" required /></td>
		<tr>
	      <th scope="row"><label>
				性別</label></th>
				<td><input type="text" name="gender" id="gender" style="color:lightgray;" value="${item.gender}" readonly/></td>
		<tr>
	      <th scope="row"><label>
				誕生日</label></th>
				<td><input type="text" name="birthday" id="birthday" style="color:lightgray;" value="${item.birthday}"  readonly/></td>
		<tr>
	      <th scope="row"><label>
				電話番号</label></th>
				<td><input type="text" name="tell" id="tel" value="${item.tell}" maxlength="20" required /></td>
		<tr>
	      <th scope="row"><label>
				郵便番号</label></th>
				<td><input type="text" name="postalCode" id="postalCode" value="${item.postalCode}"maxlength="7" required /></td>
		<tr>
	      <th scope="row"><label>
				住所</label></th>
				<td><input type="text" name="address" id="address"  value="${item.address}"maxlength="150" required /></td>
		<tr>
	      <th scope="row"><label>
				<!-- パスワード</label></th>
				<td>
					<input type="password" style="font-family:Verdana" class="field" id="password" pattern="^[0-9A-Za-z]+$" maxlength="10" name="password" required /><br>
					<input type="checkbox" id="password-check"><label for="password-check">パスワードを表示する</label><br>
	      		</td> -->
	      	</table>

			<input type="hidden" name="userId" value="${sessionScope.userId}">
	    	<input id="edit-ok-button" type="submit" value="編集" />
	    </form>
		</c:forEach>

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