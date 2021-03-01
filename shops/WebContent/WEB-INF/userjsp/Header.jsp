<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@ page pageEncoding="UTF-8" %>
<title>${itemName}</title>
<script src="//code.jquery.com/jquery-2.2.0.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0">


<script>
	$(function(){
	  var pagetop = $('#page-top');
	  pagetop.hide();
	  $(window).scroll(function () {
	     if ($(this).scrollTop() > 100) {
	          pagetop.fadeIn();
	     } else {
	          pagetop.fadeOut();
	     }
	  });
	  pagetop.click(function () {
	     $('body, html').animate({ scrollTop: 0 }, 500);
	     return false;
	  });
	});

	$(function(){
	  var pagetop = $('#page-top');
	  pagetop.hide();
	  $(window).scroll(function () {
	     if ($(this).scrollTop() > 100) {
	          pagetop.fadeIn();
	     } else {
	          pagetop.fadeOut();
	     }
	  });
	  pagetop.click(function () {
	     $('body, html').animate({ scrollTop: 0 }, 500);
	     return false;
	  });
	});
</script>
</head>
<body>
	<!-- バナー クリックするとTOPにもどる  -->
	<a href=""><img src=""/></a>


		<form id="search" action="searchitem" method="post">
			<input type="text" name="key" class="searchText">
			<input type="image" src="image/header/search.png" class="searchButton">
		</form>

		<!-- logo -->
		<div class="logo_img">
			<a href="/shops/"><img width="180px" src="image/header/logo.png"></a>
		</div>
		<c:choose>
			<c:when test="${sessionScope.userId==null}">

			</c:when>
			<c:otherwise>
				<!-- 買い物かご用 -->
				<div class="point_pos">
				<p>${sessionScope.userPoint}pt　</p>
				</div>
				<div class="cart_img"  >
				<a href="getcartlist"><img src="image/header/cart.png"></a>
				<c:choose>
				<c:when test="${sessionScope.cartCount==null}">
				</c:when>

				<c:when test="${sessionScope.cartCount==0}">
    			</c:when>

				<c:otherwise>
				<p class="navCartIcon"  align="center">${sessionScope.cartCount}</p>
				</c:otherwise>
				</c:choose>
				</div>

			</c:otherwise>
		</c:choose>


	<!-- ここからヘッダー -->

	<div id="wrap">

	<nav>
	<ul class="header__menu">
	<li class="mega__menu"><a href="getcategory?category=new&sort=no">TOP</a></li>
	<li class="mega__menu"><a href="getcategory?category=new&sort=no">CATEGORY</a>
		<ul class="mega__menu-second">
		<li><a href="getcategory?category=ALL&sort=no">ALL</a></li>
		<li><a href="getcategory?category=TOPS&sort=no">TOPS</a></li>
		<li><a href="getcategory?category=BOTTOMS&sort=no">BOTTOMS</a></li>
		<li><a href="getcategory?category=ONEPIECE&sort=no">ONEPIECE</a></li>
		<li><a href="getcategory?category=OUTER&sort=no">OUTER</a></li>
		<li><a href="getcategory?category=ACCESSORY&sort=no">ACCESSORY</a></li>
		<li><a href="getcategory?category=OTHER&sort=no">OTHER</a></li>
		</ul>
	</li>
	<li class="mega__menu"><a href="inputguide">GUIDE</a></li>
	<li class="mega__menu"><a href="inputcontact">CONTACT</a></li>
	<c:choose>
		<c:when test="${sessionScope.userId==null}">
		<li class="mega__menu"><a href="logininput">LOGIN</a></li>
		</c:when>
		<c:otherwise>
		<li class="mega__menu"><a href="getuser">MYPAGE</a>
			<ul class="mega__menu-second">
				<li><a href="getuser">ユーザー情報</a></li>
				<li><a href="getfavolist">お気に入り</a></li>
				<li><a href="getorderlist">購入履歴</a></li>
				<li><a href="logout">ログアウト</a></li>

			</ul>
		</li>
		</c:otherwise>
	</c:choose>


	</ul>
	</nav>

	<!-- header_img -->
	<div class="header_img">
	<img src="image/header/header.png"  onselectstart="return false;" onmousedown="return false;" />
	</div>



	<p id="page-top"><a href="#"><img src="image/header/pagetop.png" height="50" width="50" alt="ページトップボタン"></a></p>

	<br><br>

	</div>

	<style>

	/* 全体の padding margin を0にする */
	body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td {
		margin: 0;
		padding: 0;
	}

	body{
		font-family:Yu Gothic;
	}

	a{
		text-decoration: none;
	}

 	/* ---------- スクロールバー ---------- */

 	body{
 		overflow-x: hidden;
 	}

	::-webkit-scrollbar{
	  width: 13px;
	}
	::-webkit-scrollbar-track{
	  background: rgba(255,255,255,0.1);
	  border: none;
	  border-radius: 10px;
	}
	::-webkit-scrollbar-thumb{
	  background: #ccc;
	  border-radius: 10px;
	  box-shadow: none;
	}


	#wrapper {
		width: 1200px;
		margin-left: auto;
	    margin-right: auto;
		min-height: 100vh;
		padding-bottom: 150px;
	}

	#footer-wrap {
		position: relative;
		box-sizing: border-box;/*←全て含めてmin-height:100vhに*/
	}

	/* ---------- リンク色変更 ---------- */
	a {
		color : dimgray;
		text-decoration: none;
	}
	a:visited{
		color : dimgray;
	}

	/* ｰｰｰｰｰｰｰｰｰｰ header img ---------- */

	.logo_img{
		position       : absolute;
		top:15px;
		left: 50%;
		transform: translateX(-50%);
		-webkit-transform: translateX(-50%);
		-ms-transform: translateX(-50%);
	}

	.cart_img{
		position       : absolute;
		top:35px;
		margin-left    : 1165px;
	}
	.point_pos{
		position       : absolute;
		top:40px;
		margin-left    : 1100px;
	}
	.cart_img img{
		height : 35px;
	}

	div.header_img img{
	margin: 0 calc(50% - 50vw);
	width:100vw;
	}



	/* ---------- メニュー ---------- */

	.header__menu {
		position: relative;
		width: 100%;
		background: rgba(255,255,255,0.1);
		text-align: center;
		list-style: none;
		padding: 0;
	}
	.header__menu li {
		width:120px;
		height : 70px;
		display: inline-block;
	}

	.header__menu li a {
		line-height : 70px;
		display:block;
    	width:100%;

    	font-size : 110%;
		color: dimgray;
		text-decoration: none;
	}

	.header__menu li a:hover {
		color: lightgray;
		text-decoration: none;
	}

	ul.header__menu ul li a {
		font-size : 85%;
	}

	ul.mega__menu-second {
		visibility: hidden;
		opacity: 0;
	}

	.header__menu li:hover {
		-webkit-transition: all 0.5s;
		transition: all 0.5s;
	}

	li.mega__menu ul.mega__menu-second {
		position: absolute;
		top: 45px;
		left: 0;
		width: 100vw;
		background: rgba(255,255,255,0.9);
		padding: 0px;
		box-sizing: border-box;
		margin: 0 calc(50% - 50vw);
		transition: all 0.2s ease;
		-webkit-transition: all 0.2s ease;

	}

	li.mega__menu:hover ul.mega__menu-second {
		top: 70px;
		visibility: visible;
		opacity: 1;
	}


	/* ---------- 検索フォーム ---------- */

	#search{
	  display        : inline-block;
	  width          : 180px;
	  height         : 29px;
	  margin-top	 : 3%;
	  letter-spacing : 0.1em;
	  font-weight    : bold;
	  line-height    : 0;
	  border 		 : 1px solid dimgray;
	  border-top	 : none;
	  border-left	 : none;
	  border-right	 : none;
	}
	#search .searchText {
	  display        : block;
	  float          : left;
	  box-sizing     : border-box;
	  height         : 29px;
	  width          : 150px;
	  margin         : 0;
	  padding        : 0 5px;
	  border		 : none;
	  outline        : 0;
	  font-size      : 12px;
	}
	#search .searchButton {
	  float          : left;
	  box-sizing     : border-box;
	  height         : 25px;
	  margin         : 0;
	  padding        : 0px;
	  border		 : none;
	  color          : dimgray;
	  cursor         : pointer;
	  line-height    : 17px;
	  font-size      : 12px;
	  border : 1px;
	}

	 /* 入力エリア右側×消し */
	#search .searchText::-ms-clear {
	  display        : none;
	}

	#search input[type="text"] {
		background-color:white;
	}

	/* ---------- 上へ戻るボタン ---------- */
	#page-top {
	  position: fixed;
	  bottom: 20px;
	  right: 20px;
	  font-size: 14px;
	  line-height: 1;
	  z-index: 99;
	}

	/* ---------- ログイン ---------- */

	#login-form{
		width : 500px;
		padding : 40px;
		margin : auto;
		border : 0.5px solid #555;
	}

	#login-box {
		text-align : center;
		padding-bottom:30px;
	}

	#create-account {
		text-align : center;
		border-top : 0.5px solid #555;
	}

	#loginId, #password{
		margin: 10px;
		padding : 5px 10px;
		width : 300px;
		height: 30px;

		border-bottom: 1px solid;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
	}

	#login-button, #create-button, #create-ok-button, #contact-button,
	#cart-clear-button, #next-button, #buy-button, #creditRegist-button,
	#payment-ok-button, #user-edit-button, #user-delete-button, #edit-ok-button,
	#item-detail-button, #addcart-button, #restock-button,.sort-button,.submit-button {
		margin : 10px;
		padding : 10px 20px;
		background: #eee;
		border: none;
		border-radius : 20px;
		outline: none;
		-webkit-appearance: none;
		-moz-appearance: none;
		appearance: none;
		cursor: pointer;
	}

	#addcart-button {
		text-align:center;
	}

	#user-delete-button {
		background: lightslategray;
		color:white;
	}

	#item-detail-button {
		width:80%;
		background: whitesmoke;
	}

	#create-account {
		padding-top : 30px;
	}


	input[type="checkbox"]{
	    display: none;
	}

	/* チェックボックスの代わり */
	input[type="checkbox"]+label{
	    display: none;
	    cursor: pointer;
	    display: inline-block;
	    position: relative;
	    padding-left: 25px;
	    padding-right: 10px;
	}
	/* ボックス□ */
	input[type="checkbox"]+label::before{
	    content: "";
	    position: absolute;
	    display: block;
	    box-sizing: border-box;
	    width: 20px;
	    height: 20px;
	    margin-top: -10px;
	    left: 0;
	    top: 50%;
	    border: 1px solid;
	    border-color:  #585753;
	    background-color: #FFF;
	}
	/* レ点 */
	input[type="checkbox"]:checked+label::after{
	    content: "";
	    position: absolute;
	    display: block;
	    box-sizing: border-box;
	    width: 11px;
	    height: 7px;
	    margin-top: -9px;
	    top: 62%;
	    left: 4px;
	    transform: rotate(-45deg);
	    border-bottom: 3px solid;
	    border-left: 3px solid;
	    border-color:  #585753;
	}

	/* ---------- ユーザー登録 ---------- */

	.create-form{
		width : 550px;
		padding : 40px;
		margin : auto;
		border : 0.5px solid #555;
		text-align:center;
	}

	.create-form table {
		margin:auto;
	}

	.create-form table th{
		width:100px;
	}

	.create-form #loginId,#password,#name,#kana,#mail,#birthday,#tel,#postalCode,#address,#gender,#confirm{
		margin: 10px;
		padding : 5px 10px;
		width : 300px;
		height: 30px;

		border-bottom: 1px solid;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
	}

	.input-area,.buyCount{
		margin: 10px;
		padding : 5px 10px;
		height: 30px;
		width:50px;

		border-bottom: 1px solid;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
	}


	.radiobutton {
	  opacity:0;
	}
	.radiobox label {
	  background-color: whitesmoke;
	  border-radius:20px;
	  margin-right:5px;
	  padding: 7px 15px;
	}
	.radiobutton:checked + label {
	  background-color: darksalmon;
	}

	/* ---------- お問い合わせ ---------- */

	table.contact-table {
		border-collapse: collapse;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
	}

	table.contact-table p {
		font-size: 16px;
		font-weight: bold;
		text-align: center;
		margin: 60px auto 40px;
	}

	table.contact-table textarea{
		resize: none;
	}

	table.contact-table input[type="submit"],
	input[type="text"],
	select,
	textarea,
	button {
		-moz-appearance: none;
		-webkit-appearance: none;
		-webkit-box-shadow: none;
		box-shadow: none;
		outline: none;
		border: none;
		background-color:#f8f8f8;
	}
	#password{
		background-color:#f8f8f8;
	}

	table.contact-table input[type="text"],
	textarea {
		background: #f8f8f8;
		display: block;
		font-size: 16px;
		padding: 12px 15px;
		width: 480px;
		border-radius: 0;
	}

	table.contact-table input[type="text"]:focus,
	textarea:focus {
		background: #fcfcfc;
	}

	table.contact-table textarea[name="content"] {
		display: inline-block;
		width: 100%;
		height: 200px;
	}

	table.contact-table input::placeholder,
	textarea::placeholder {
		color: #ccc;
	}

	::-webkit-input-placeholder {
		color: #ccc;
		opacity: 1;
	}

	::-moz-placeholder {
		color: #ccc;
		opacity: 1;
	}

	:-ms-input-placeholder {
		color: #ccc;
		opacity: 1;
	}

	.contact-table {
		width: 750px;
		margin: 30px auto;
	}

	.contact-table th,
	.contact-table td {
		border-top: 1px solid #555;
		border-bottom: 1px solid #555;
		padding: 20px;
		min-width:100px;
	}

	.contact-table th {
		background: whitesmoke;
		padding: 20px;
		position: relative;
		text-align: center;
		width: 200px;
		border-right:none;
	}

	div#contact-button{
		text-align:center;
	}

	/* ---------- ガイドリスト ---------- */

	#guidejump .guide-list{
		padding-top:20px;
		text-align: center;
	}
	#guidejump .guide-list li{
		display: inline-block;
		/display: inline;
		/zoom: 1;
		margin:5px;

		background: #eee;
		border-radius:20px;
		list-style: none;
	}

	#guidejump .guide-list li a{
		padding:7px 15px;
		display:block;
	}

	/* ---------- payment ---------- */

	#payment-form{
		width : 750px;
		padding : 40px;
		margin : auto;
		border : 0.5px solid #555;
	}

	#point-form{
		margin:10px 0px;
		border-top : 0.5px solid #555;
	}

	/* ---------- itemlist ---------- */

	#sort-area{
		display:flex;
		justify-content: center;
	}
	.sort-button{
		margin:0px 10px;
	}

	.column04 ul {
		width: calc(100% + 20px);
		margin: 0 -10px;
		display: flex;
		flex-wrap: wrap;
		list-style: none;
	}

	.column04 li {
		padding:10px;
	}

	.column04 img {
		text-align:center;
	}

	.column04 li div {
		text-align:center;
		font-size: 100%;
		display: block;
	}

	.column04 li {
		width: calc(25% - 20px);
	}

	/* ---------- item ---------- */

	#item-leftbox{
		width:600px;
		float:left;
		margin:10px;
	}

	#item-rightbox{
		position:relative;
		width:550px;
		float:left;
	}

	table.item-table {
		width:100%;
		text-align:center;
		border-collapse: collapse;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
	}

	table.item-table th,tr,td{
		padding: 10px 20px;
	}

	.item-name{
		float:left;
		padding-left:10px;
	}

	#favo-button {
		position:absolute;
		float:left;

		border:1px solid darkgray;
		border-radius:20px;
		padding:3px 15px;
		right:10px;

	}

	#favo-button input[type="image"]{
		vertical-align:middle;
	}

	#addcart-button {
		position:absolute;
		right:0;
		margin-top:20px;
	}

	/* ---------- item img ---------- */


	/* 全体のスタイル */
	.swiper-wrapper {
		width: 100%;
		height: 100%;
	}
	/* 全スライド共通スタイル */
	.swiper-slide {
		color: #ffffff;
		width: 100%;
		height: 100%;
		text-align: center;
		line-height: 100%;
	}

	div.swiper-button-prev{
		filter:saturate(0%);
	}

	div.swiper-button-next{
		filter:saturate(0%);
	}



	/* ---------- sitemap ---------- */

	#sitemap-leftbox {
		float :left;
		padding:0 0 0 300px;

	}

	#sitemap-rightbox {
		float :left;
		padding:0 0 0 300px;
	}

	/* ---------- カートの中の数 ---------- */

	li.navCart{
	position: relative;
	}
	.navCartIcon{
		position: absolute;
		right: 20px;
		top: -3px;
		width: 17px;
		height: 17px;
		font-size: 11px;
		border-radius: 9px;
		background: #c7004c;/*商品数〇色の指定 */
		box-shadow: 0px 1px 2px #ccc;
		line-height: 17px;
		text-aligen: center;
		color: #fff;/*商品数文字色の指定 */

	}



</style>

</body>
</html>

