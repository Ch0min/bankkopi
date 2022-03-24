<%--
  Created by IntelliJ IDEA.
  User: marklundgaard
  Date: 23/03/2022
  Time: 16.47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brugerside</title>

</head>
<body>
<h1> Velkommen ${sessionScope.name}, du er nu logget ind på din konto.</h1>
Din saldo: ${sessionScope.konto.saldo}
<br>
<br>

<h4>Indsæt</h4>
<h1>${requestScope.fejl}</h1>
<form action="ServletTransaction">
    <label for="fname">Angiv beløb:</label><br>
    <input type="text" id="fname" name="amount" value=0><br>
    <input type="submit" value="Indsæt">
</form>
<br>
<h4>Hæv</h4>
<h1>${requestScope.fejl}</h1>
<form action="ServletWithdrawal" method="POST">
    <label for="withname">Angiv beløb:</label><br>
    <input type="text" id="withname" name="amount" value=0><br>
    <input type="submit" value="Hæv">
</form>

<br>
<br>
<a href="ServletLogoff">Log af</a>

</body>
</html>
