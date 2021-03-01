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

	<div id="wrapper">

	<div align="center" class="submit-button" style="width:150px;float:left;"><a href="admininput">管理ページTOP</a></div>
	<br style="clear:left;">
	<h2 align="center" style="margin-top:0;margin-bottom:20px;">ユーザー一覧</h2>

	<p><font color="red">${mess}</font></p>
	<div align="center">
	<table id="item-list">
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
		<th></th>
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
	</div>

	</div>

	<style>
	body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td {
		margin: 0;
		padding: 0;
	}

	body{
		font-family:Yu Gothic;
	}

	a{
		text-decoration: none;
	}

	#wrapper {
		width: 1300px;
		margin-left: auto;
	    margin-right: auto;
		min-height: 100vh;
	}

		/* ---------- リンク色変更 ---------- */
	a {
		color : #000;
		text-decoration: none;
	}
	a:visited{
		color : #000;
	}

	.submit-button{
		margin : 10px;
		padding : 10px 20px;
		background: #eee;
		border: none;
		border-radius : 20px;
		outline: none;
		-webkit-appearance: none;
		-moz-appearance: none;
		appearance: none;
		cursor: pointer;
	}
	.submit-button a{
		display:block;
	}

	table#item-list{
	  border-collapse: collapse; /* セルの境界線を共有 */
	}
	#item-list td {
	  border: 1px solid black;  /* 表の罫線(=セルの枠線) */
	  padding: 10px;       /* セル内側の余白量 */
	}
	#item-list th {
		border:1px solid #000;
		background-color:#eee;
		padding: 10px;
	}



	</style>
</body>
</html>