<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>クレカ登録画面</title>

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

	<h2>クレジットカードでのお支払い</h2>

	<form method='post' action='addcredit'>
		ユーザーID<input id="userId" type='hidden' name='userId' value='1'><br>
		カード番号<input id="cardNumber" type='text' name='cardNumber' required><br>
		<!-- 名義人<input id="name" type='text' name='name' required><br> -->
		セキュリティーコード<input id="securityCode" type='text' name='securityCode' required><br>
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
		支払回数<input id="payCount" type='text' name='payCount' required><br>
		<br>

		<input type='submit' value='入力内容を確認する'>

	</form>


	<!-- フッター -->
	<div id="footer"></div>
</body>
</html>