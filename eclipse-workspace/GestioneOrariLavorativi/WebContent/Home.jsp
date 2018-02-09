<%@ page import="dipendenti.CurrentDate" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>
WELCOLME UTENTE
<form action="AfterHome">
	<%
	String meseAnno = CurrentDate.dataCorrente();
	int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
	
	int contatore = 0;
	for(int i=0; i<giorno; i++) {

		//out.print("Data <input type='text' name='giorno"+i+ "' value='0' style='width:150px;' >");
		out.print("<input type='hidden' value='1' >");
		out.print("Data <input type='text' name='giorno"+i+ "' value='"+String.valueOf(giorno+contatore)+"-"+meseAnno+"'  style='width:150px;' readonly='readonly'> ");
		out.print("Ore  Lavorate <input type='text' name='orario"+i+ "' value='0' style='width:40px;' >");
		contatore--;
		%> <br> <%
	}
	
	%>	
	<br>
	<input type="submit" value="CARICA">
</form>		
	
</body>
</html>