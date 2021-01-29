<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item</title>
</head>
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

    <c:forEach var="item" items="${item_list}">
		<ul>
			<li>${item.image}</li>
			<li>${item.name}</li>
			<li>${item.code}</li>
			<li>${item.price}(税込み)</li>

		</ul>
	</c:forEach>

	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>