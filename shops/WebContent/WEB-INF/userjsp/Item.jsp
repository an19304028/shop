<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Item</title>
</head>
<body>
	<!-- ヘッダー -->
	<div id="header"></div>

	<!-- 買い物かご用 -->
	<a class="mypage_img" href=""><img src="image/header/mypage.png"></a>
	<a class="cart_img" href="getcartlist?userId=${sessionScope.userId}"><img src="image/header/cart.png"></a>

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
	<p>${mess1}</p>
	<table id="item-list" border="1">
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
			    <td id="stock">${item.stockCount}</td>
			    <td>${item.sizeName}</td>
			    <td>${item.colorName}</td>
			    <td>${item.price}</td>
			    <td>${item.categoryName}</td>
			    <td>${item.detail}</td>
			 <%--    <td><img src="image/item/${item.imagePath}"  width="40px" height="40px"></td> --%>
			    <c:choose>
			    <c:when test="${item.stockCount!=0}">
			    <td>
			    	<form name="addcart" action=""  method="post">
			    		<input type="hidden" name="userId" value="${sessionScope.userId}">
			    		<input type="hidden" name="itemId" value="${item.itemId}">
			    		<input type="text" name="buyCount" id="buyCount">
			    		<input type="submit"  onclick="checkStock();" value="カートに追加">
			    	</form>
			    </td>
			    </c:when>
			    <c:otherwise>
			    	<td>在庫がありません<br>
			    	<form name="" action="restock"  method="post">
			    		<input type="hidden" name="userId" value="${sessionScope.userId}">
			    		<input type="hidden" name="itemId" value="${item.itemId}">
			    		<input type="hidden" name="itemName" value="${item.itemName}">
			    		<input type="submit"  onclick="checkStock();" value="再入荷のお知らせを受け取る">
			    	</form>
			    	</td>
			    </c:otherwise>
			    </c:choose>
			    <td>
			    	<c:choose>
			    		<c:when test = "${favoCheck == false}">
			    			<form action="addfavo" onSubmit="return checkSubmit()" method="post">
				    			<input type="hidden" name="userId" value="${sessionScope.userId}">
			    				<input type="hidden" name="itemId" value="${item.itemId}">
			    				<input type="image" src="image/icon/nofavo.png">
			    				<!-- <input type="submit" name="itemId" value="♡"> -->
			    			</form>
			    		</c:when>
			    		<c:otherwise>
			    			<form action="removefavo" method="post">
				    			<input type="hidden" name="userId" value="${sessionScope.userId}">
			    				<input type="hidden" name="itemId" value="${item.itemId}" class="st">
			    				<input type="image" src="image/icon/yesfavo.png">
			    				<!-- <input type="submit" name="itemId" value="削除"> -->
			    			</form>
			    		</c:otherwise>
			    	</c:choose>
			    </td>
			</tr>
		</c:forEach>
</table>
	<script>
		console.log(stock);
		function checkStock(){
			var stock = document.getElementById("stock").textContent;
			var buyCount = document.getElementById("buyCount").value;
			console.log(stock);
			if(Number(stock)<Number(buyCount)){
				alert("在庫数を超えています");
			}else if(buyCount==""){
				alert("入力してください");
			}else{
				document.addcart.action= 'addcart';
			}
		}
	</script>

</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>