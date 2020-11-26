<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>結果</title>
  </head>
  <body>
    <h1>結果</h1>
    <table border="1">
      <tr>
        <th>名前</th><th>パスワード</th>
      </tr>
      <c:forEach var="p" items="${list}">
        <tr>
          <td>${p.name}</td><td>${p.pass}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
