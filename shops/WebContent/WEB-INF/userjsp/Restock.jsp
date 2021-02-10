<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String userId = (String)session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>再入荷</title>
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
	<script type="text/javascript">
		var submitted = false;
	</script>
	<iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) {window.location='send-o';}"></iframe>
	<h1>再入荷のお知らせ</h1>
	<p>こちらの商品が入荷した際、メールにてお知らせをいたします。</p>
	<c:forEach var="item" items="${data}">
	<p>商品名：${item.itemName}</p>
	<p>サイズ/カラー：${item.sizeName}/${item.colorName}</p>
	<form action="https://docs.google.com/forms/u/0/d/1nPy_OpDr8lnFsJGcioGTVDz6NPM6act8jlZSByMI5Xk/prefill" method="post" target="hidden_iframe" onsubmit="submitted=true;">
		<input type="hidden" name="entry.2081137255" value= <%=userId %> readonly />
		　　　　　　お名前：<input type="text" name="entry.983308274" /><br>
		通知メールアドレス：<input type="text" name="entry.102717670" /><br>
		<input type="hidden" name="entry.1770593522" value="${item.itemId}" readonly />
		　　　　　　商品名：<input type="text" name="entry.298775810" value= "${item.itemName}" readonly />
		<input type="submit">
	</form>
	</c:forEach>

</div>


	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>