<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<h1>管理者</h1>
	<p>${mess}</p>
	<form method='post' action='addcolor'>
		カラーID<input type='text' name='colorId'><br>
		カラー名<input type='text' name='colorName'><br>
		<input type='hidden' name='colorImagePath' value="C:\Users\koyama\git\shop\shops\WebContent\WEB-INF\image"><br>
		<input type='submit' value='登録'>
	</form>
	<a href="getcolors">カラー一覧</a>
</body>
</html>