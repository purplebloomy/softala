<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lis�� koulutus</title>
</head>
<body>
	
	<h1>Lis�� koulutus</h1>
	<% String lisatty = request.getParameter("lisatty");
	  if(lisatty != null && lisatty.equals("true")){
	  %>
	 	Koulutus lis�tty!
	  <%} %>
	<form action="koulutukset" method="post">
		<table>
			<!--<tr>
				<td>Kouluttaja</td>
				<td><input type="text" name="kouluttaja"
					placeholder="Sy�t� kouluttajan nimi" /></td>
			</tr> -->
			<br>
			<tr>
				<td>Aihe</td>
				<td><input type="text" name="aihe"
					placeholder="Sy�t� koulutuksen aihe" required/></td>
			</tr>
			<br>
			<tr>
				<td>Alkamisaika</td>
				<td><input type="datetime" name="alkamisaika"
					placeholder="Sy�t� koulutuksen alkamisaika" required /></td>
			</tr>
			<br>
			<tr>
				<td>P��ttymisaika</td>
				<td><input type="datetime" name="paattymisaika"
					placeholder="Sy�t� koulutuksen p��ttymisaika" required /></td>
			</tr>
			<br>
			<tr>
				<td>Paikka</td>
				<td><input type="text" name="paikka_id"
					placeholder="Sy�t� koulutuksen paikka" required/></td>
			</tr>
			<br>
			<tr>
				<td>Opettaja</td>
				<td><input type="text" name="opettaja_id"
					placeholder="Sy�t� koulutuksen opettaja" required/></td>
			</tr>
			<br>
			<!--   <tr>
				<td>Kuvaus</td>
				<td><input type="text" name="kuvaus"
					placeholder="Sy�t� koulutuksen kuvaus" /></td>
			</tr>-->
			<br>
			<tr>
				<td><button type="submit">Lis��</button></td>
			</tr>
		</table>
	</form>
</body>
Bits Please 2015
</html>