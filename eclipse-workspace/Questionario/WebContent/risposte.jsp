<%@page import="JSP.CaricaDomande"%>
<%@ page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risposte Corrette</title>
</head>
<body>
<%
	int size = (Integer) session.getAttribute("size");
	int giuste = 0;
	String[] corretta = new String[size];
	String[] risp = new String[size];
	for (int i=0; i<size; i++) {
		corretta = (String[]) session.getAttribute("corretta"+i);
		risp = (String[]) request.getParameterValues("risp"+i);	
		
		System.out.println("A" + Arrays.toString(corretta));
		System.out.println("B" + Arrays.toString(risp));
		
			if(risp != null && Arrays.equals(risp, corretta)) {
				giuste++;
			}
	}
	
	System.out.print(giuste);
%>
RISPOSTE CORRETTE:
<% out.println(giuste); %>

<form action="questionario.jsp">
	<input type="submit" name="reload" value="Riprova!!!">
</form>

</body>
</html>