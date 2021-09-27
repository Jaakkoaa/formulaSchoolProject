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
<h1>Teams</h1>
	<table class="table table_striped" >
		<tr>
			<th>name</th>
			<th>standing</th>
			<th>price</th>	
		</tr>
		<c:forEach items="${teams}" var="team">
			
			<tr>
				<td><c:out value="${team.name}" /></td>  <%-- lyhennysmerkintä metodikutsulle ${asiakas.getAsiakastunnus()} --%>
				<td><c:out value="${team.standing}" /></td> 
				<td><c:out value="${team.price}" /></td> 	
			</tr>
		</c:forEach>

	</table>


	
	
	<h1>Drivers</h1>
	<table class="table table_striped" >
		<tr>
			<th>name</th>
			<th>standing</th>
			<th>price</th>	
		</tr>
		<c:forEach items="${drivers}" var="Driver">
			
			<tr>
				<td><c:out value="${Driver.name}" /></td>  <%-- lyhennysmerkintä metodikutsulle ${asiakas.getAsiakastunnus()} --%>
				<td><c:out value="${Driver.standing}" /></td> 
				<td><c:out value="${Driver.price}" /></td> 	
			</tr>
		</c:forEach>

	</table>
	<a href="http://localhost:8080">back to the start</a>
</body>
</html>
<style><%@include file="/WEB-INF/styles/tyyli.css"%></style>