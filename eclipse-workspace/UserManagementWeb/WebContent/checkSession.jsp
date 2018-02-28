<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="org.entities.User"%>

<%

User loggedUser = (User) session.getAttribute("loggedUser");

if (loggedUser!=null) {
	
} else {

	response.sendRedirect("index.jsp");
	
}

%>
