<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Category</title>
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

	<h2 style="color:#555;margin-bottom:30px;" align="center">${category}</h2>

	<p>${login}</p>
	<p>${mess}</p>



	<c:choose>
	<c:when test="${count>0}">
	<div class="column04">
	<ul>
	<c:forEach var="item" items="${data}">


			<li>
				<div>
				<img src="${item.imagePath}"  width="200px" height="200px"><br>
				${item.itemName}<br>
				${item.price}円 (+tax)
				<form action="getitemdetail" onSubmit="return checkSubmit()" method="post">

					<input type="hidden" name="itemName" value="${item.itemName}">
					<input type="hidden" name="itemId" value="${item.itemId}">
			   		<input id="item-detail-button" type="submit" value="商品詳細へ">

			   </form>
				</div>
			</li>


	</c:forEach>
	</ul>
	</div>
	</c:when>
	</c:choose>



</div>

<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>

</body>
</html>