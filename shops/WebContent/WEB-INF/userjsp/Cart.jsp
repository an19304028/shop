<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>お買い物かご</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
<script type="text/javascript">
	function checkSubmit() {
		result = confirm("空にしても良いですか？");
		if (result) {
			document.myform.action = "";
			} else {
			alert("キャンセルします。");
			return false;
		}
	}
</script>
<style>
	#table2 tr:hover {
      background-color: #dcdcdc;
    }
</style>
</head>
<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>

	<h1 align="center">買い物かご</h1>
	<br><p align="center">${edit}</p>
	<c:choose>
		<c:when test="${total!=0}">
			<table id="table2" class="contact-table" border="1">
				<tr>
					<th>商品名</th>
					<th>サイズ</th>
					<th>カラー</th>
					<th>数量</th>
					<th>価格</th>
					<th>ポイント</th>
					<th>　</th>
				</tr>
				<c:forEach var="item" items="${data}">
					<tr>
						<td class="tr1" style="display:none;">${item.itemId}</td>
						<td class="tr1">${item.itemName}</td>
					    <td class="tr1">${item.sizeName}</td>
					    <td class="tr1">${item.colorName} <img src="${item.colorImagePath}" width="10px" height="10px"></td>
					    <td>
					    	<form action="editcart" method="post">
					    		<input type="text" style="width:20px;float:left;" pattern="[1-9][0-9]*" title="0を指定する場合は削除を押してください" value="${item.buyCount}" maxlength="3" size="6" name="buyCount">
					    		<input type="hidden"  name="itemId" value="${item.itemId}" >
					    		<input type="hidden" name="userId" value="${sessionScope.userId}">
					    		<input type="submit" style="float:left;margin:12px 0 0 15px;" value="編集">
					    	</form>
					    </td>
					    <td class="tr1">${item.price}円</td>
					    <td class="tr1">${item.point}pt</td>
					    <td class="tr1">
						    <form action="removecart" method="post">
					    		<input type="hidden" name="itemId" value="${item.itemId}">
					    		<input type="hidden" name="userId" value="${sessionScope.userId}">
					    		<input type="submit" value="削除">
					    	</form>
					    </td>
					</tr>
				</c:forEach>
			</table>

			<form action="removeallcart" onSubmit="return checkSubmit()" method="post">
				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input style="margin-left:110px;" type="button" id="buy-button" onclick="location.href='getcategory?category=new&sort=no'" value="お買い物を続ける">
				<input style="flote:right;margin-left:20px;" id="cart-clear-button" type="submit" value="カートを空にする">
			</form>

			<h2 style="flote:right;padding-right:150px;" align="right">${sessionScope.buyCount}点　${mess}　 ${point}pt</h2>

			<form action="inputorder" method="post">
				<c:forEach var="item" items="${data}">
					<input type="hidden" name="itemId" value="${item.itemId}">
					<input type="hidden" name="buyCount" value="${item.buyCount}">
					<input type="hidden" name="price" value="${item.price}">
				</c:forEach>

				<input type="hidden" name="userId" value="${sessionScope.userId}">
				<input type="hidden" name="point" value="${point}">
				<input	style="float: right;margin-right:120px;marginbuttom:30px;" id="next-button" type="submit" value="購入手続きへ進む">
			</form>

			<br>
	</c:when>
	<c:otherwise>
		<p align="center">${mess} </p>
	</c:otherwise>
	</c:choose>

	<br><br><br><br><br><br><br>
</div>

<div id="footer-wrap">
	<div id="footer"></div>
</div>
<script>
		//アイテム詳細へ飛ばすjs
		$("#table2 .tr1").on('click',function(){
			var id = $(this).closest('tr').children("td")[0].innerText;
			var item = id.substr(0,4);
			var valueId = id.substr(4,1);
			valueId=1;

			console.log(id+" "+item+valueId);
			itemId=item+valueId;
			var itemName = $(this).closest('tr').children("td")[1].innerText;
			console.log(itemId+itemName);
			location.href="getitemdetail?itemId="+itemId+"&itemName="+itemName;

		});
		</script>
</body>
</html>