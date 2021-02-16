<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>クレカ登録画面</title>
<style>
	#credit_form {
 	 display:none;
	}
</style>

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
	  <table id="table" border="1">
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
	   </table>
   <p>${mess}　 ${point}pt</p>


	<h2>支払方法</h2>

	<div id="Payment_cash">
		<label>
			<input type="radio" name="rs" value="1" onclick="formSwitch();" form="credit_submit" checked>
			現金でのお支払い
		</label>
	</div>

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

		<label>
			<input id="js-check" type="radio" name="rs" value="1" onclick="formSwitch();" form="credit_submit">
			クレジットカードでのお支払い
		</label>
	<div id="credit_form">
	<form method='post' action='addcredit' >
			<input id="userId" type='hidden' name='userId' value='${sessionScope.userId}'><br>
			カード番号<input id="cardNumber" type='text' name='cardNumber'><br>
			<!-- 名義人<input id="name" type='text' name='name' required><br> -->
			セキュリティーコード<input id="securityCode" type='text' name='securityCode'><br>
			<!-- 有効期限<input id="expirationDate" type='text' name='expirationDate' required><br> -->
			有効期限<select name="expirationMonth">
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
					</select> 年
			<!-- ↑ 月/年の表記 -->
			<br>
			支払回数<input id="payCount" type='text' name='payCount'><br>
			<br>


			<input type='submit' value='登録'>
		</form>

		<form method="post" action="getcredit">
			<input type="hidden" name='userId' value="${sessionScope.userId}">
			<input type="submit" value="カード情報を取得">
			<table border="1">
				<tr>
					<th>　</th>
					<th>カード番号</th>
<!-- 					<th>名義人</th> -->
					<th>有効期限</th>
				</tr>
				<c:forEach var="item" items="${data}">
					<tr>
						<td><input type="radio" name="credit" value="1"></td>
						<td>${item.cardNumber}</td>
						<%-- <td>${item.userName}</td> --%>
						<td>${item.expirationDate}</td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="このカードを使用">
		</form>
		<form method="post" action="getordercheck" id="credit_submit">
			<input type="submit" value="確定">
		</form>

		</div>

		<h2>ポイント利用</h2>
		<div id="point_form">
			<p>現在のポイント:${sessionScope.point}pt</p>
			<label>ご利用ポイント</label>
			<input type="text" name="point" value="0">pt <br>
		</div>


	<!-- 支払い方法だけでformが成り立ってるから送信の問題が残る -->
	<!-- もしかしたらコマンド付け足さないとかも -->



	<script type="text/javascript">
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

		    } else if (check.checked==true) {
		        selecterBox.style.display = "block";
		        $('#cardNumber').prop("required", true);
				$('#securityCode').prop("required", true);
				$('#payCount').prop("required", true);

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
	</script>


</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>