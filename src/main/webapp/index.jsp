<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Din Bank</title>
</head>
<body>
<h1><%= "Velkommen til Banken!" %>
</h1>
<br/>
<a href="ServletKontosFront">Klik her for at få en oversigt over kontoerne</a>
<br>
<br>
${requestScope.msg}
<br>
<br>
<c:forEach items="${applicationScope.kontosMap}" var="item">
    ${item.value.name}: ${item.value.saldo} <br>
</c:forEach>

<form action="ServletLogin">
    <label for="fname">Angiv dit brugernavn:</label><br>
    <input type="text" id="fname" name="name" value="t"><br>
    <label for="lname">Skriv kode:</label><br>
    <input type="text" id="lname" name="password" value="t"><br><br>
    <input type="submit" value="Log ind">
</form>
</body>
</html>