<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>ユーザー情報</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

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
	<p>${mess}</p>
	<table id="item-list" border="1">
		<tr>

			<th>名前</th>
			<th>メール</th>
			<th>ログインID</th>
			<th>性別</th>
			<th>誕生日</th>
			<th>電話番号</th>
			<th>郵便番号</th>
			<th>住所</th>
		</tr>
		<c:forEach var="item" items="${data}">
			<tr>

			    <td>${item.userName}</td>
			    <td>${item.mail}</td>
			    <td>${item.gender}</td>
			    <td>${item.birthday}</td>
			    <td>${item.tel}</td>
			    <td>${item.postalCode}</td>
			    <td>${item.address}</td>
			    <td>
			    	<form action="edituser"  method="post">
				    	<input type="hidden" name="userId" value="${sessionScope.userId}">
			    		<input type="submit"  value="編集">
			    	</form>
			    </td>
			</tr>
		</c:forEach>
</table>

</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>