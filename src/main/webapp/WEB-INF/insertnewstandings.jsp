<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Formulaleague</title>
</head>
<body>

<div id="linkit">
<ul>
<li><a href="http://localhost:8080/startseason">start the season</a></li>
<li><a href="http://localhost:8080/listplayers">list players</a></li>
<li><a href="http://localhost:8080/standings">standings</a></li>
<li><a href="http://localhost:8080/results">see results</a></li>
</ul>
</div>

<div id="teksti">
<form action="/results" method="post"><br><br>
<a href="http://localhost:8080">back to the start</a>

<h1>teams</h1>
team 1 <input type="text" name="team1" /><br><br>
team 2 <input type="text" name="team2" /><br><br>
team 3 <input type="text" name="team3" /><br><br>
team 4 <input type="text" name="team4" /><br><br>
team 5 <input type="text" name="team5" /><br><br>
team 6 <input type="text" name="team6" /><br><br>
team 7 <input type="text" name="team7" /><br><br>
team 8 <input type="text" name="team8" /><br><br>
team 9 <input type="text" name="team9" /><br><br>
team 10 <input type="text" name="team10" /><br><br>

<h1>drivers</h1>
driver 1 <input type="text" name="driver1" /><br><br>
driver 2 <input type="text" name="driver2" /><br><br>
driver 3 <input type="text" name="driver3" /><br><br>
driver 4 <input type="text" name="driver4" /><br><br>
driver 5 <input type="text" name="driver5" /><br><br>
driver 6 <input type="text" name="driver6" /><br><br>
driver 7 <input type="text" name="driver7" /><br><br>
driver 8 <input type="text" name="driver8" /><br><br>
driver 9 <input type="text" name="driver9" /><br><br>
driver 10 <input type="text" name="driver10" /><br><br>
driver 11 <input type="text" name="driver11" /><br><br>
driver 12 <input type="text" name="driver12" /><br><br>
driver 13 <input type="text" name="driver13" /><br><br>
driver 14 <input type="text" name="driver14" /><br><br>
driver 15 <input type="text" name="driver15" /><br><br>
driver 16 <input type="text" name="driver16" /><br><br>
driver 17 <input type="text" name="driver17" /><br><br>
driver 18 <input type="text" name="driver18" /><br><br>
driver 19 <input type="text" name="driver19" /><br><br>
driver 20 <input type="text" name="driver20" /><br><br>

<input type="submit" value="send" />
<input type="button" value="back" onclick= "location.href='http://localhost:8080'"/>

</body>
</html>
<style><%@include file="/WEB-INF/styles/tyyli.css"%></style>