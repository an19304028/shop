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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(function(){
		$("#footer").load("common/Footer.html");
	});
</script>
</head>
<body>
<div id="wrapper">
<jsp:include page="Header.jsp" flush="true" />
	<script type="text/javascript">
		var submitted = false;
	</script>
	<iframe name="hidden_iframe" id="hidden_iframe" style="display:none;" onload="if(submitted) {window.location='send-o';}"></iframe>
	<h1>再入荷のお知らせ</h1>
	<p>こちらの商品が入荷した際、メールにてお知らせをいたします。</p>
	<c:forEach var="item" items="${data}">
	<p>商品名：${item.itemName}</p>
	<p>サイズ/カラー：${item.sizeName}/${item.colorName}</p>
	<form action="https://docs.google.com/forms/u/0/d/e/1FAIpQLScf0hRD9zG7tnof6JfRKlskSwdiQ7u8C9FahSCaWAPR-z-Avg/formResponse" method="post" target="hidden_iframe" onsubmit="submitted=true;">
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