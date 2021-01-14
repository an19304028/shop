<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item</title>
</head>
<body>
    <c:forEach var="item" items="${item_list} }">
		<ul>
			<li>${item.image}</li>
			<li>${item.name}</li>
			<li>${item.code}</li>
			<li>${item.price}(税込み)</li>

		</ul>
	</c:forEach>
</body>
</html>