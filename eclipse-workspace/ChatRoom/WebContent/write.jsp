<%@ page import= "test.Message" %>
<%@page import="chat.ThreadClientRead"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages</title>
<link rel="stylesheet" type="text/css" href="css/write.css" />
	<style type="text/css">
		
	</style>
</head>
<body>
	<div>
		<div>
			<form action="">
				<input type="text" value="<% ) {
					System.out.format("UserName: %-15s Messaggio: %-20s data: %-10s \n", m.getUsername(), m.getTextMessage(), m.getLastTimeActive());
				}%>" >
			</form>
		</div>
	</div>
	<div class="login-page">
		<div class="form">
			<form class="login-form" action="write" >			
				<input type="text" value="Inserisci username" name ="username">
				<input type="text" value="Inserisci messaggio" name="message" />
				<input type="submit" name="Invio" value="Invia messaggio"/>
			</form>
		</div>
	</div>

</body>
</html>