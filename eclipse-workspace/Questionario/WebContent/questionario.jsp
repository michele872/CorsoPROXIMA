<%@page import="java.util.ArrayList"%>
<%@ page import="JSP.CaricaDomande" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="risposte.jsp">
<% 

	ArrayList<CaricaDomande> domande = CaricaDomande.caricaDomanda();
	session.setAttribute("size", domande.size());
	int i = 1;

	for(CaricaDomande s : domande) {
		out.print(s.domande);
		
		%> <br> <%
		for(String r: s.risposte) {
		out.print("<input type='checkbox' name='risp" + String.valueOf(i) + "' value='" + String.valueOf(r) +"' >" + r);
		%> <br> <%
		} 		
		i++;
		%> <br> <%
		}
%>
		<input type="submit" value="RISPONDI">
</form>
		

</body>
</html>