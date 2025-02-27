<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="image/header/favicon.png">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>サイトマップ</title>
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

	<h2 align="center">サイトマップ</h2>
	<br><br>

	<div id="sitemap-leftbox">
		<ul>
		<li><a href="getcategory?category=new&sort=no">TOP</a></li>
		<li><a href="getcategory?category=new&sort=no">CATEGORY</a>
			<ul>
			<li><a href="getcategory?category=ALL&sort=no">　ALL</a></li>
			<li><a href="getcategory?category=TOPS&sort=no">　TOPS</a></li>
			<li><a href="getcategory?category=BOTTOMS&sort=no">　BOTTOMS</a></li>
			<li><a href="getcategory?category=ONEPIECE&sort=no">　ONEPIECE</a></li>
			<li><a href="getcategory?category=OUTER&sort=no">　OUTER</a></li>
			<li><a href="getcategory?category=ACCESSORY&sort=no">　ACCESSORY</a></li>
			<li><a href="getcategory?category=OTHER&sort=no">　OTHER</a></li>
			</ul>
		</li>
		<li><a href="inputguide">GUIDE</a></li>
		<li><a href="inputcontact">CONTACT</a></li>
		</ul>
	</div>

	<div id="sitemap-rightbox">
		<ul>
		<c:choose>
			<c:when test="${sessionScope.userId==null}">
			<li><a href="logininput">LOGIN</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="getuser">MYPAGE</a>
				<ul>
					<li><a href="getuser">　ユーザー情報</a></li>
					<li><a href="getfavolist">　お気に入り</a></li>
					<li><a href="getorderlist">　購入履歴</a></li>
					<li><a href="logout">　ログアウト</a></li>
				</ul>
			</li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</div>
	<!-- フッター -->
<div id="footer-wrap">
	<div id="footer"></div>
</div>
</body>
</html>