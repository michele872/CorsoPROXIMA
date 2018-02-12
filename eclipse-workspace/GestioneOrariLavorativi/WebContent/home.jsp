<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dipendenti.ConnessDB"%>
<%@ page import="dipendenti.CurrentDate" %>
<%@ page import="dipendenti.Dipendente" %>
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
	ConnessDB cdb = new ConnessDB();	
	
	int id = 1;
	String meseAnno = CurrentDate.dataCorrente();
	int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
	int orario = 0;
	String data = CurrentDate.data();
	HashMap<String, Integer> o = cdb.getPrepopolatedValue();
	
	
	int contatore = 1;
	for(int i=0; i<giorno; i++) {	
		orario = o.get(id+"_"+(contatore+"-"+meseAnno));
		System.out.println("home.jsp - chiave: " + id+"_"+(contatore+meseAnno) + " valore: " + orario);
			//out.print("Data <input type='text' name='giorno"+i+ "' value='0' style='width:150px;' >");
			out.print("<input type='hidden' value='1' >");
			out.print("Data <input type='text' name='giorno"+i+ "' value='"+String.valueOf(contatore)+"-"+meseAnno+"'  style='width:150px;' readonly='readonly'> ");
			//out.print("Ore  Lavorate <input type='text' name='orario"+i+ "' value='0' style='width:40px;' >");
			out.print("Ore  Lavorate <input type='text' name='orario"+i+ "' value='"+orario+"' style='width:40px;' >");
			contatore++;

			%> <br> <%
	}
	
	%>	
	<br>
	<input type="submit" value="CARICA">
</form>		
	
</body>
</html>