<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>クレカ登録画面</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
<style>
	#credit_form {
 	 display:none;
	}
	#nowpoint{
		display:inline;
	}
</style>

</head>

<body>
<div id="wrapper">
<%@ include file="Header.jsp" %>
	 <%--  <table id="table" border="1">
	    <tr>
	     <th>商品名</th>
	     <th>サイズ</th>
	     <th>カラー</th>
	     <th>数量</th>
	     <th>ポイント</th>
	     <th>価格</th>
	    </tr>
	    <c:forEach var="item" items="${data}">
	     <tr>
	      	<td>${item.itemName}</td>
	         <td>${item.sizeName}</td>
	         <td>${item.colorName}</td>
	         <td>${item.buyCount}</td>
	          <td>${item.point}</td>
	         <td>${item.price}</td>
	      </tr>
	    </c:forEach>
	   </table> --%>
   <p>${mess}</p>

	<div id="payment-form">

	<h2 align="center">支払方法</h2>


<%-- 	<div id="Payment_Exist">
		<label>
			<input type="radio" name="rs" value="1" onclick="formSwitch();">
			既存のクレジットカードでのお支払い
		</label>
		<table>
		<tr>
			<th>カード番号</th>
			<th>名義人</th>
			<th>有効期限</th>
		</tr>
			<c:forEach var="item" items="${data}">
				<input type="radio" name="credit" value="1">
				<tr>
					<td>${item.cardNumber}</td>
					<td>${item.userName}</td>
					<td>${item.expirationDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div> --%>
		<br>
		<label>
			<input id="js-check" type="radio" name="rs" value="1" onclick="formSwitch();" form="getordercheck" required>
			クレジットカードでのお支払い
		</label>
	<div id="credit_form">
	<form method='post' action='addcredit' >
		<input type='hidden' name='userId' value='${sessionScope.userId}'><br>
		<table class="contact-table">

			<tr><th>カード番号</th><td><input id="cardNumber" type='text' name='cardNumber' maxlength=20></td></tr>
			<!-- 名義人<input id="name" type='text' name='name' required><br> -->
			<tr><th>セキュリティー<br>コード</th><td><input id="securityCode" type='text' name='securityCode' maxlength="4"></td></tr>
			<!-- 有効期限<input id="expirationDate" type='text' name='expirationDate' required><br> -->
			<tr><th>有効期限</th><td><select name="expirationMonth">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select> 月 /
					<select name="expirationYear">
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
					</select> 年</td></tr>
			<!-- ↑ 月/年の表記 -->
			<tr><th>支払回数</th><td><input id="payCount" type='text' name='payCount'></td></tr>
		</table>
			<div align="center" style="margin-bottom:30px;">
			<input type="hidden" name="point" value="${requestScope.itempoint}">
			<input id="creditRegist-button"type='submit' value='登録'>
			</div>
		</form>

		<h3>既存のクレジットカードから選択</h3>
<%-- 		<form method="post" action="getcredit">
			<input type="hidden" name='userId' value="${sessionScope.userId}">
			<input type="submit" value="カード情報を取得"> --%>
			<table class="contact-table" border="1">
				<tr>
					<th>　</th>
					<th>カード番号</th>
<!-- 					<th>名義人</th> -->
					<th>有効期限</th>
				</tr>
				<c:forEach var="item" items="${data}">
					<tr>
						<td><input type="radio" name="credit" form="getordercheck"></td>
						<td>${item.cardNumber}</td>
						<%-- <td>${item.userName}</td> --%>
						<td>${item.expirationDate}</td>
					</tr>
				</c:forEach>
			</table>
			<!-- <input type="submit" value="このカードを使用"> -->
<!-- 		</form> -->
		</div>

		<br>
		<div id="Payment_cash">
		<label>
			<input type="radio" name="rs" value="1" onclick="formSwitch();" form="getordercheck" required>
			現金でのお支払い<br><br>
		</label>
		</div>

			<c:forEach var="item" items="${userInfo}">
				<label><input type="radio" name="addressCheck" >登録された住所を指定</label><br>
				名前：<input type="text" name="name" value="${item.name}" form="getordercheck" readonly><br>
				住所：<input type="text" name="address"  form="getordercheck" value="${item.address}" readonly><br>
				<label><input type="radio" name="addressCheck" >他の住所を指定</label><br>
				名前：<input type="text" name="name"  form="getordercheck"><br>
				住所：<input type="text" name="address"  form="getordercheck"><br>

			</c:forEach>
		<div id="point-form">
			<br>
			<h3>ポイント利用</h3>
			現在のポイント:<p id="nowpoint">${sessionScope.userPoint}</p>pt<br>
			<label>ご利用ポイント</label>
			<input type="text" name="usepoint" id="usepoint" form="getordercheck" value="0">pt <br>
		</div>



		<form align="center" method="post" name="ordercheck" action="" id="getordercheck">
			<input type='hidden' name='userId' value='${sessionScope.userId}'><br>
			<input type="hidden" name="itempoint" value="${requestScope.itempoint}">
			<input id="payment-ok-button" onclick="checkPoint();" type="submit" value="確定">
		</form>

		</div>




	<script>
		var selecterBox = document.getElementById('credit_form');
		var selecterBox2 = document.getElementById('point_form');
		//var check = false;
		//クレジット
		function formSwitch() {
		    check = document.getElementById('js-check');
		    if (check.checked=='' || check.checked==false) {
		        selecterBox.style.display = "none";
		        $('#cardNumber').removeAttr("required");
				$('#securityCode').removeAttr("required");
				$('#payCount').removeAttr("required");
				$('input[name="credit"]').removeAttr("required");
		    } else if (check.checked==true) {
		        selecterBox.style.display = "block";
		        $('#cardNumber').prop("required", true);
				$('#securityCode').prop("required", true);
				$('#payCount').prop("required", true);
				$('input[name="credit"]').prop("required", true);
		    } else {
		        selecterBox.style.display = "none";
		    }
		}

		window.addEventListener('load', formSwitch());

		function entryChange2(){
		    if(document.getElementById('changeSelect')){
		    id = document.getElementById('changeSelect').value;
		}
		}
		//point
		function checkPoint(){
			var point = document.getElementById("nowpoint").textContent;
			var usepoint = document.getElementById("usepoint").value;
			console.log("point:"+point+"\t usepoint"+usepoint);
			if(Number(point)<Number(usepoint)){
				alert("ポイントが不足しています");
			}else if(usepoint == ""){
				alert("ポイントを入力してください");
			}else{
				document.ordercheck.action= 'getordercheck';
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