<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ユーザー情報</title>
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
	<h2 align="center">アカウント情報</h2>
	<p align="center"><font color="red">${mess}</font></p>
	<table  class="contact-table" border="1">
		<c:forEach var="item" items="${data}">
		    <tr><th>名前</th><td>${item.name}</td></tr>
		    <tr><th>ふりがな</th><td>${item.kana}</td></tr>
		    <tr><th>メール</th><td>${item.mail}</td></tr>
		    <tr><th>ログインID</th><td>${item.loginId}</td></tr>
		    <tr><th>性別</th><td>${item.gender}</td></tr>
		    <tr><th>誕生日</th><td>${item.birthday}</td></tr>
		    <tr><th>電話番号</th><td>${item.tell}</td></tr>
		    <tr><th>郵便番号</th><td>${item.postalCode}</td></tr>
		    <tr><th>住所</th><td>${item.address}</td></tr>
		</c:forEach>
</table>
			<div align="center">
		    	<form action="getuseredit"  method="post">
			    	<input type="hidden" name="userId" value="${sessionScope.userId}">
		    		<input id="user-edit-button" type="submit"  value="編集">
		    	</form>

		    	<form action="withdrawal" onSubmit="return checkSubmit()" method="post">
		    		<input type="hidden" name="userId" value="${sessionScope.userId}">
		    		<input id="user-delete-button" type="submit" value="退会">
		    	</form>
			</div>
</div>
<script type="text/javascript">
	function checkSubmit() {
		result = confirm("本当に退会しても良いですか？(退会したらユーザー情報はすべて削除されます)");
		if (result) {
			document.myform.action = "";
			} else {
			alert("キャンセルします。");
			return false;
		}
	}
</script>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>