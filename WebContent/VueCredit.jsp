<%@page import="web.CreditModel"%>
<%
	CreditModel mod = (CreditModel)request.getAttribute("mod");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simulateur Credit</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
	<div>
		<form action="controleur.php" method="post">
			<table>
				<tr>
					<td>Montant:</td>
					<td><input type="text" name="montant" value="<%=mod.getMontant()%>"></td>
					<td>DH</td>
				</tr>
				<tr>
					<td>Durée:</td>
					<td><input type="text" name="duree" value="<%=mod.getDuree()%>"></td>
					<td>mois</td>
				</tr>
				<tr>
					<td>Taux:</td>
					<td><input type="text" name="taux" value="<%=mod.getTaux()%>"></td>
					<td>%</td>
				</tr>
				<tr>
					<td><input type="submit" value="calculer"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<table>
			<tr>
				<td>Mensualité:</td>
				<td><%=mod.getMensualite()%></td>
				<td>DH</td>
			</tr>
		</table>
	</div>
</body>
</html>