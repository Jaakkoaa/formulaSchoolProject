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
<h1>Players</h1>

<a href="http://localhost:8080/addplayers">add a player</a>
	<table class="table table_striped" >
		<tr>
			<th>name</th>
			<th>first driver</th>
			<th>second driver</th>
			<th>team</th>	
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${players}" var="player">
			
			<tr class="table">
				<td><c:out value="${player.name}" /></td>  
				<td><c:out value="${player.driver1}" /></td> 
				<td><c:out value="${player.driver2}" /></td> 
				<td><c:out value="${player.team}" /></td>
				<td><a href="/delete-player?name=<c:out value='${player.name}'/>"> delete </a></td>
				<td><a href="/modify?name=<c:out value='${player.name}'/>"> modify </a></td>
			</tr>
		</c:forEach>
		
	

	</table>
	
		<a href="http://localhost:8080">back to the start</a>

</body>
</html>
<style><%@include file="/WEB-INF/styles/tyyli.css"%></style>