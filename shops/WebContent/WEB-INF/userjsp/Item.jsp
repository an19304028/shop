<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.3.3/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.3.3/js/swiper.min.js"></script>
<title>Item</title>
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

	<p><font color="red">${mess1}</font></p>


	<br>


	<div id="item-leftbox">

		<p style="padding-bottom:35px;"></p>


		<div class="swiper-container">
			<!-- メイン表示部分 -->
			<div class="swiper-wrapper">
				<!-- 各スライド -->
				<c:forEach var="image" items="${image}" >
					<div class="swiper-slide">
			 			<img src="${image.imagePath}" width="450px" >
			 		</div>
				</c:forEach>
			</div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>

			<script>
		var mySwiper = new Swiper('.swiper-container', {
			navigation: {
				nextEl: '.swiper-button-next',
				prevEl: '.swiper-button-prev'
			}
		});
	</script>



		<%-- <c:forEach var="image" items="${image}" >
			 <img src="${image.imagePath}"  width="100px" height="100px">
		</c:forEach> --%>



	</div>




	<div id="item-rightbox">
		<h2 class="item-name">${itemName}</h2>
		<div id="favo-button">
			<c:choose>
				  <c:when test = "${favoCheck == false}">
				  	<form action="addfavo" onSubmit="return checkSubmit()" method="post">
					   	<input type="hidden" name="userId" value="${sessionScope.userId}">
				    	<input type="hidden" name="itemId" value="${itemId}">
				    	<input width="150px" type="image" src="image/icon/nofavo.png">
				    	<input type="hidden" name="itemName" value="${itemName}">
				    	<!-- <input type="submit" name="itemId" value="♡"> -->
				    </form>
				   </c:when>
				   <c:otherwise>
				   	<form action="removefavo" method="post">
						<input type="hidden" name="userId" value="${sessionScope.userId}">
				    	<input type="hidden" name="itemId" value="${itemId}" class="st">
				    	<input type="hidden" name="itemName" value="${itemName}">
				    	<input width="150px" type="image" src="image/icon/yesfavo.png">
				    	<!-- <input type="submit" name="itemId" value="削除"> -->
				   	 </form>
				    </c:otherwise>
			</c:choose>
		</div>

		<br style="clear:left;">
		<hr style="clear:left;">
		<br style="clear:left;">

		<h3>価格：${price}円(税込)</h3>
		<p>ポイント：${point}pt</p>
		<br>
		<p>${detail}</p>
		<br>
		<form name="addcart" action=""  method="post">
			<input type="hidden" name="userId" value="${sessionScope.userId}">
			<input type="hidden" name="itemName" value="${itemName}">
			数量：<input type="text" name="buyCount" value="1" id="buyCount" class="buyCount"><br>
			<br>
			<table class="item-table" border="1">
				<tr>
					<th>サイズ/カラー</th><th>選択</th>
				</tr>
				<c:forEach var="item" items="${data}" varStatus="status">
			  		<p style="display: none" id="stock"  class="stockCount${status.count}">${item.stockCount}</p>
					<tr>
						<td>${item.sizeName}/${item.colorName}</td>
			  				 <c:choose>
		 						<c:when test="${item.stockCount!=0}">
				    				<td><input type="radio" class="radio${status.count}" name="itemId" value="${item.itemId}" required></td>

			    				</c:when>
			    				<c:otherwise>
				    				<td>
							    		<input type="hidden" name="userId" value="${sessionScope.userId}" form="restock">
							    		<input type="hidden" name="itemId" value="${item.itemId}" form="restock">
							    		<input type="hidden" name="itemName" value="${itemName}" form="restock">
							    		<p><font color="red" >×売り切れ</font></p>
							    		<input type="hidden" class="radio${status.count}" value="no" style="display:none;">
							    		<input id="restock-button" type="submit"  value="再入荷のお知らせを受け取る" form="restock">

							    		<input type="hidden" name="itemName" value="${itemName}">
			   						</td>
			    				</c:otherwise>
				  			</c:choose>
					</tr>
					<script>

						var radio1 = document.getElementsByClassName("radio${status.count}")[0].value;
						console.log(radio1);
						var className = document.getElementsByClassName("stockCount${status.count}")[0].innerHTML;
						var buy = document.getElementsByClassName("buyCount")[0].value;
						console.log(className+" "+buy)
						function checkStock(){
							var stock = document.getElementsByClassName("stockCount${status.count}")[0].innerHTML;
							var buyCount = document.getElementsByClassName("buyCount")[0].value;
							var radio = document.getElementsByClassName("radio${status.count}")[0].value;
							console.log(stock+" "+buyCount);
							if(Number(stock)<Number(buyCount)){
								alert("在庫数を超えています");
								document.addcart.action= 'getitemdetail?itemId=${itemId}';
							}else if(buyCount==""){
								alert("入力してください");
							}else{
								document.addcart.action= 'addcart';
							}
						}
					</script>
				</c:forEach>
			</table>
				<input id="addcart-button" type="submit"  onclick="checkStock();" value="カートに入れる">

		</form>

		<script type = "text/javascript">
		    function restockForm(){
		        document.deleteForm.mode.value = "deleteText";
		        document.deleteForm.submit();
		    }
		</script>
		<form id="restock" action="restock"  method="post">
		</form>

	</div>


	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br><br><br><br>
	<br><br><br>

</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>