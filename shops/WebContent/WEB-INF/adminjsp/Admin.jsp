<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>

</script>
</head>
<body>
	<h1>管理者</h1>
	<a href="getallusers">ユーザー一覧</a>
	<h2>カラー追加</h2>
	<p><font color="red">${mess}</font></p>

	<p><font color="red">IDはCOから始める</font></p>
	<form method='post' action='addcolor'>
		カラーID<input id="colorId" type='text' name='colorId' required><br>
		カラー名<input id="colorName" type='text' name='colorName' required><br>
		画像のパス<input id="colorPath" type='text' name='colorImagePath' value="image/color/" required>
		<br>
		<input type='submit' value='登録'>
	</form>
	<button id="getColorPath">パス取得</button>
	<form method='post' action="getmaxcolorid">
		<input type="submit"  value="最後のIDのを取得">
		<c:forEach var="color" items="${data}">
			<font color="blue">${color.colorId}</font>
		</c:forEach>
	</form>

	<div id="output_message"></div>

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


<p>---------------------------------------------------------</p>

<h1>リンク一覧</h1>

	<h2>Admin</h2>
	<ul>
		<li><a href="inputitemregist">アイテム登録</a></li>
		<li><a href="getitemlist">アイテム一覧</a></li>
		<br>
		<li><a href="getcolors">カラー一覧</a></li>
	</ul>
	<br>

	<h2>Page</h2>
	<ul>
		<li><a href="">CATEGORY		（カテゴリー）</a></li>
		<li><a href="">LOGIN		（ログイン）</a></li>
		<li><a href="">GUIDE		（ご利用内容）</a></li>
		<li><a href="">CONTACT		（お問い合わせ）</a></li>
		<br>
		<li><a href="">クレカ入力画面</a></li>
		<br>
		<li><a href="">カート</a></li>
		<li><a href="">お気に入り一覧</a></li>
		<li><a href="">商品ページ</a></li>
		<li><a href="">サイトマップ</a></li>
		<li><a href="">売り切れページ</a></li>
		<li><a href="">ユーザー登録</a></li>


	</ul>

</body>
</html>