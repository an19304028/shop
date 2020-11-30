<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>登録</title>

  </head>
  <body>
    <h1>登録</h1>
    <form method="post" action="SQLServlet">
      　　　名前：<input type="text" name="name" /><br>
      パスワード：<input type="text" name="pass" /><br>
      <input type="submit" value="送信" />
    </form>
     <img id="img" >
         <script>
       
	    var img = document.getElementById('img');
	    console.log(img);
	    var src = img.setAttribute('src','image/sample.jpg');
    </script>
  </body>
</html>
