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
<form action="/modify" method="post"><br><br>

driver1: <input type="number" name="driver1" max="20" min="1"/><br><br>
driver2: <input type="number" name="driver2" max="20" min="1"/><br><br>
Team: <input type="number" name="team" max="10" min="1"/><hr>
<input type="submit" value="send" />
<input type="button" value="back" onclick= "location.href='http://localhost:8080/listplayers'"/>
	
		<a href="http://localhost:8080">back to the start</a>

</body>
</html>
<style><%@include file="/WEB-INF/styles/tyyli.css"%></style>