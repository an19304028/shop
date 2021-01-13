<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accessory</title>
</head>
<body>
	<ul>
	<li>並び替え:</li>
	<!-- ソートの仕方どうしましょうか(それによってhrefの中身の書き方が変わるかもしれん) -->
	<li><a href="">新着</a></li>
	<li><a href="">オススメ</a></li>
	<li><a href="">価格</a></li>
	</ul>
	<c:forEach var="item" items="${item_list} }">
		<ul>
			<li>${item.image}</li>
			<li>${item.name}</li>
			<li>${item.price}(税込み)</li>
		</ul>
	</c:forEach>
</body>
</html>