<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
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
<style>
	#table1 tr:hover {
      background-color: #dcdcdc;   
    }
</style>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>

	<h2 align="center">お気に入り一覧</h2>

	<c:choose>
	<c:when test="${favo==0}">
		<p align="center">お気に入りに登録しているものはありません</p>
	</c:when>
	<c:otherwise>
	<table id="table1"  class="contact-table" border="1">
		<tr>
			<th>商品名</th>
			<th>画像</th>
			<th>サイズ</th>
			<th>カラー</th>
			<th>価格</th>
			<th>カテゴリー</th>
			<th></th>
			<!-- <th>画像</th> -->
		</tr>
	
		<c:forEach var="item" items="${data}">
		
			
			<tr>
				<td style="display:none;">${item.itemId}</td>
			    <td>${item.itemName}</td>
			     <td><img src="${item.imagePath}"  width="40px" height="40px"></td>
			    <td>${item.sizeName}</td>
			    <td>${item.colorName}</td>
			    <td>${item.price}円</td>
			    <td>${item.categoryName}</td>
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
	</c:otherwise>
	</c:choose>
</div>
	<script>
		$("#table1 tr").on('click',function(){
			var itemId = $(this).closest('tr').children("td")[0].innerText;
			var itemName = $(this).closest('tr').children("td")[1].innerText;
			console.log(itemId+itemName);
			location.href="getitemdetail?itemId="+itemId+"&itemName="+itemName;
			
		});
		</script>

<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>