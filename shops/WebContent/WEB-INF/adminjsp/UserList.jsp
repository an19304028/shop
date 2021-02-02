<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>UserList</title>
<script type="text/javascript">
	function checkSubmit() {
		result = confirm("削除しても良いですか？");
		if (result) {
			document.myform.action = "PostWriteServlet";
			} else {
			alert("キャンセルします。");
			return false;
		}
	}
</script>
</head>
<body>
	<p><font color="red">${mess}</font></p>
	<table id="table" border="1">
	<tr>
		<th>ユーザーID</th>
		<th>名前</th>
		<th>ふりがな</th>
		<th>メール</th>
		<th>ログインID</th>
		<th>パスワード</th>
		<th>性別</th>
		<th>誕生日</th>
		<th>電話番号</th>
		<th>郵便番号</th>
		<th>住所</th>
		<th>ポイント</th>
	</tr>
	<c:forEach var="user" items="${data}">
		<tr>
			<td>${user.userId}</td>
		    <td>${user.name}</td>
		    <td>${user.kana}</td>
		    <td>${user.mail}</td>
		    <td>${user.loginId}</td>
		    <td>${user.password}</td>
		    <td>${user.gender}</td>
		    <td>${user.birthday}</td>
		    <td>${user.tell}</td>
		    <td>${user.postalCode}</td>
		    <td>${user.address}</td>
		    <td>${user.point}</td>
		    <td>
		    	<form action="removeuser" onSubmit="return checkSubmit()" method="post">
		    		<input type="hidden" name="userId" value="${user.userId}">
		    		<input type="submit" value="削除">
		    	</form>
		    </td>
		</tr>
	</c:forEach>
	</table>


	<a href="/shops/">ホームへ</a>
</html>