<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1.0, user-scalable=no">
<title>Admin</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

</script>
</head>
<body>

<br><br>

<div id="wrapper">
	<h1 align="center">管理ページ</h1>

	<div  class="submit-button" style="margin-left:230px;clear:left;background-color:lightsteelblue;width:500px;text-align:center;">
		<a style="color:white;" href="/shops/">サイトページへ</a>
	</div><br>

	<div style="float:left;margin-bottom:20px;">
		<div class="box">
			<p align="center">アイテム管理</p><hr>
			<p style="padding-bottom:10px"></p>
			<div class="submit-button"><a href="getitemlist">アイテム一覧</a></div>
			<div class="submit-button"><a href="inputitemregist">アイテム登録</a></div>
			<p style="padding-bottom:10px"></p>
		</div>

		<div class="box">
			<p align="center">ユーザー管理</p><hr>
			<p style="padding-bottom:10px"></p>
			<div class="submit-button"><a href="getallusers">ユーザー一覧</a></div>
			<p style="padding-bottom:10px"></p>
		</div>
	</div>


	<div style="float:left;margin-bottom:20px;">
		<div class="box">
			<p align="center">カラー管理</p><hr>
			<p style="padding-bottom:10px"></p>
			<div class="submit-button" style="text-align:center;margin-bottom:20px;">
				<a href="getcolors">カラー一覧</a>
			</div>
			<p style="padding-bottom:10px"></p>
			<div style="width:380px;margin:10px auto 10px auto;">
				<p align="center" style="padding-bottom:10px;">カラー登録</p>

				<form method='post' action='addcolor'>
					<table class="item-table" id="table4" border="1">
						<tr><th>カラーID</th><td><input id="colorId" type='text' name='colorId' placeholder=" COからはじめる" required></td></tr>
						<tr><th>カラー名</th><td><input id="colorName" type='text' name='colorName' required></td></tr>
						<tr><th>画像のパス</th><td><input id="colorPath" type='text' name='colorImagePath' value="image/color/" required></td></tr>
					</table>
					<button class="submit-button" id="getColorPath">パス取得</button>
					<input class="submit-button" style="color:white;align:start;background-color:lightsteelblue;" type='submit' value='登録'>
				</form>


				<form method='post' action="getmaxcolorid">
					<input class="submit-button" type="submit"  value="最後のIDのを取得">
					<c:forEach var="color" items="${data}">
						<font color="blue">${color.colorId}</font>
					</c:forEach>
				</form>
			</div>
				<p><font color="red">${mess}</font></p>
				<div id="output_message"></div>
			<p style="padding-bottom:10px"></p>
		</div>
	</div>



	<hr style="clear:left;margin:20px;">


	 <script type="text/javascript">
		  function getColorPath() {
		    var colorId = document.getElementById("colorId").value;
		    colorId = "image/color/"+colorId+".jpg";
		    console.log(colorId);
		    return colorId;
		  }

		  $(function(){
				 $("#getColorPath").on("click",function(){
					 var colorPath=getColorPath();
					 console.log(colorPath);
				     $("#colorPath").val(colorPath)
				    });

			});
  	</script>

	<div id="sitemap">
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
				<li><a href="logininput">LOGIN</a></li>
				<li><a href="getuser?userId=${sessionScope.userId}">MYPAGE</a>
					<ul>
						<li><a href="getuser?userId=${sessionScope.userId}">　ユーザー情報</a></li>
						<li><a href="getfavolist?userId=${sessionScope.userId}">　お気に入り</a></li>
						<li><a href="getorderlist">　購入履歴</a></li>
						<li><a href="logout">　ログアウト</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>



	</div>

	<style>

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

	#wrapper {
		width: 1000px;
		margin-left: auto;
	    margin-right: auto;
		min-height: 100vh;
	}

		/* ---------- リンク色変更 ---------- */
	a {
		color : #000;
		text-decoration: none;
	}
	a:visited{
		color : #000;
	}

	/* ボタン */

	.submit-button{
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

	.submit-button a{
		display: block;
	}

	.box{
		text-align:center;
		margin:10px 10px 30px 10px;
		padding:10px;
		width:450px;
		border 	: 1px solid dimgray;
		border-radius:10px;
	}

	table.item-table {
		width:100%;
		text-align:center;
		border-collapse: collapse;
		border-top	 : none;
		border-left	 : none;
		border-right : none;
		margin-bottom:20px;
	}

	table.item-table th,tr,td{
		padding: 10px 20px;
	}
	input[type="text"]{
		border-top	 : none;
		border-left	 : none;
		border-right : none;
		border-bottom: 1px solid lightgray;
		padding:5px;

	}

	#sitemap {
		margin:10px auto;
		width:900px;
	}

	#sitemap-leftbox {
		width:450px;
		float :left;
	}

	#sitemap-rightbox {
		width:450px;
		float :left;
	}




	</style>

	<br><br><br><br><br>
	<br><br><br><br><br>
	<br><br><br><br><br>

</body>
</html>