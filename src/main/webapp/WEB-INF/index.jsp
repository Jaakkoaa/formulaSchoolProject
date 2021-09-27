<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
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
<p>Harjoitustyö on fantasialiiga sovellus</p>

<p>ALOITA PAINAMALLA START SEASON</p>

<p>Ideana on valita formulakauden alkaessa kaksi kuskia ja yhden auton.
Se pelaaja, jonka valinnat ovat parantuneet eniten kauden lopussa on voittaja.</p>

<p>Tietokantaan on siis lisättävä viime kauden kuskit ja tiimit ja niiden sijoitukset toisiinsa. Tämä tehdään Start the season kohdasta. 
</p>

<p>Pelaaja luodaan list players sivulla. </p>

<p>See result kohdassa ohjelma kysyy kauden lopussa olevia sijoituksia ja laskee kaikille pelaajille
pisteet riippuen kuinka heidän valintansa on parantuneet tai huonontuneet</p>

<p>Start the season sivulla ohjelma poistaa vanhat taulut ja luo uudet.</p>

</div>





</body>
</html>
<style><%@include file="/WEB-INF/styles/tyyli.css"%></style>