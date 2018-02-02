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
	for (int i=0; i<size; i++) {
		String[] corretta = (String[]) session.getAttribute("corretta"+(i+1));
		String[] risp = (String[]) request.getParameterValues("risp"+(i+1));	
		
			if(risp != null && Arrays.equals(risp, corretta)) {
				giuste++;
			}
	}
	System.out.print(giuste);
%>

</body>
</html>