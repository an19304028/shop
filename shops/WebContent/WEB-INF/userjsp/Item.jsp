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
	<p><font color="red">${mess1}</font></p>
	<p>商品名：${itemName}
		
	</p>
	<p>価格：${price}円(税込)</p>
	<p>ポイント：${point}pt</p>
	<form name="addcart" action=""  method="post">
		<input type="hidden" name="userId" value="${sessionScope.userId}">
		<input type="hidden" name="itemName" value="${itemName}">
		数量：<input type="text" name="buyCount" value="1" id="buyCount" class="buyCount${status.count}"><br>
		<table id="item-list" border="1">
			<tr>
				<th>サイズ/カラー</th><th>選択</th>
			</tr>
			<c:forEach var="item" items="${data}" varStatus="status">
		  		<p style="display: none" id="stock"  class="buyCount${status.count}">${item.stockCount}</p>
				<tr>
					<td>${item.sizeName}/${item.colorName}</td>
		  				 <c:choose>
		 						<c:when test="${item.stockCount!=0}">
				    				<td><input type="radio" name="itemId" value="${item.itemId}" required></td>
				    			
			    				</c:when>
			    				<c:otherwise>
				    				<td>
							    		<input type="hidden" name="userId" value="${sessionScope.userId}" form="restock">
							    		<input type="hidden" name="itemId" value="${item.itemId}" form="restock">
							    		<input type="hidden" name="itemName" value="${itemName}" form="restock">
							    		<p><font color="red">×売り切れ</font></p>
							    		<input type="submit"  onclick="checkStock();" value="再入荷のお知らせを受け取る" form="restock">
			    						
			   						</td>
			    				</c:otherwise>
			  				</c:choose>
				</tr>
				<script>
					console.log(stock);
					var className = document.getElementsByClassName("buyCount${status.count}")[0];
					console.log(className)
					function checkStock(){
						var stock = document.getElementsByClassName("buyCount${status.count}")[0];
						var buyCount = document.getElementsByClassName("buyCount${status.count}")[1];
						console.log(stock+" "+buyCount);
						if(Number(stock)<Number(buyCount)){
							alert("在庫数を超えています");
						}else if(buyCount==""){
							alert("入力してください");
						}else{
							document.addcart.action= 'addcart';
						}
					}
				</script>
			</c:forEach>
		</table>
		<input type="submit"  onclick="checkStock();" value="カートに追加">
	</form>
	<c:choose>
			  <c:when test = "${favoCheck == false}">
			  	<form action="addfavo" onSubmit="return checkSubmit()" method="post">
				   	<input type="hidden" name="userId" value="${sessionScope.userId}">
			    	<input type="hidden" name="itemId" value="${itemId}">
			    	<input type="image" src="image/icon/nofavo.png">
			    	<input type="hidden" name="itemName" value="${itemName}">
			    	<!-- <input type="submit" name="itemId" value="♡"> -->
			    </form>
			   </c:when>
			   <c:otherwise>
			   	<form action="removefavo" method="post">
					<input type="hidden" name="userId" value="${sessionScope.userId}">
			    	<input type="hidden" name="itemId" value="${itemId}" class="st">
			    	<input type="hidden" name="itemName" value="${itemName}">
			    	<input type="image" src="image/icon/yesfavo.png">
			    	<!-- <input type="submit" name="itemId" value="削除"> -->
			   	 </form>
			    </c:otherwise>
		</c:choose>
	<script type = "text/javascript">
	    function restockForm(){
	        document.deleteForm.mode.value = "deleteText";
	        document.deleteForm.submit();
	    }
	</script>
	<form id="restock" action="restock"  method="post">
	</form>
	
	<%-- <table id="item-list" border="1">
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
		<tr>
			 <td>${itemName}</td>
			 <td>${price}</td>
			 <td id="stock">${data.stockCount}</td>
			 <td>${data.sizeName}</td>
			 <td>${data.colorName}</td>
			 <td>${data.price}</td>
			 <td>${data.categoryName}</td>
			 <td>${data.detail}</td>
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
			    <td><img src="image/item/${item.imagePath}"  width="40px" height="40px"></td>
			    <c:choose>
			    <c:when test="${item.stockCount!=0}">
			    <td>
			    	<form name="addcart" action=""  method="post">
			    		<input type="hidden" name="userId" value="${sessionScope.userId}">
			    		<input type="hidden" name="itemId" value="${item.itemId}">
			    		<input type="hidden" name="itemName" value="${item.itemName}">
			    		<input type="text" name="buyCount" >
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
			    	
			    </td>
			</tr>
		</c:forEach>
</table> --%>
	

</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>