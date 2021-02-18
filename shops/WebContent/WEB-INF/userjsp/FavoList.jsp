<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>お気に入り一覧</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
</head>
<body>
<div id="wrapper">
<jsp:include page="Header.jsp" flush="true" />

	<h2>お気に入り一覧</h2>

	<table id="favo-list" border="1">
		<tr>
			<th>商品名</th>
			<th>在庫数</th>
			<th>サイズ</th>
			<th>カラー</th>
			<th>価格</th>
			<th>カテゴリー</th>
			<th>詳細</th>
			<!-- <th>画像</th> -->
		</tr>
		<c:forEach var="item" items="${data}">
			<tr>
			    <td>${item.itemName}</td>
			    <td>${item.stockCount}</td>
			    <td>${item.sizeName}</td>
			    <td>${item.colorName}</td>
			    <td>${item.price}</td>
			    <td>${item.categoryName}</td>
			    <td>${item.detail}</td>
			 <%--    <td><img src="image/item/${item.imagePath}"  width="40px" height="40px"></td> --%>
			 	<td>
			    	<form action="removelistfavo" method="post">
				    			<input type="hidden" name="userId" value="${sessionScope.userId}">
			    		<input type="hidden" name="itemId" value="${item.itemId}">
			    		<input type="submit" name="itemId" value="削除">
			    	</form>
			    </td>
			</tr>
		</c:forEach>
	</table>
</div>

<div id="footer-wrap">
	<div id="footer"></div>
</div>/div>
</body>
</html>