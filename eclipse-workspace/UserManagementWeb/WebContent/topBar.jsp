<%@page import="org.db.UserDBManager"%>
<%@page import="org.entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="checkSession.jsp" %> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/userManStyle.css">

</head>
<body onload = "showBarType()">







<div class="topnav" id="topnav">
 <div><a href="http://www.proximainformatica.com/" target="_blank"><img class="img-responsive2"       
       src="images/proxima_logo.png"></a></div>
 <div class = "admin" id = "admin" style="display:none"> <a class="active" href="homeManagement.jsp">Gestione Utenti</a>  </div>
  <div class="right"><div class="dropdown" id= "dropdownAdmin" style = "display:none">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdownAdmin"> Benvenuto, <%=loggedUser.getFirstname()%>
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
  
    <li><a href="#">HTML</a></li>
    <li><a href="#">CSS</a></li>
    <li><a href="#">JavaScript</a></li>
  </ul>
</div></div>

<div class = "user" id = "user" > <a class="active" href="index.jsp">Login</a>  </div>
  <div class="right"><div class="dropdown" id = "dropdownUser" style = "display:none">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Benvenuto, <%=loggedUser.getFirstname()%>
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
  
    <li><a href="#">HTML</a></li>
    <li><a href="#">CSS</a></li>
    <li><a href="#">JavaScript</a></li>
  </ul>
</div></div>
  <div><a href="javascript:void(0);" style="font-size:20px;" class="icon" onclick="myFunction()">&#9776;</a></div>
</div> 

<script>

function myFunction() {
    var x = document.getElementById("topnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
}



function showBarType() {
	
	var role = null 

	var divAdmin = document.getElementById ('admin');
	var dropAdmin = document.getElementById ('dropdownAdmin');
	var divUser = document.getElementById ('user');
	var dropUser = document.getElementById ('dropdownUser');
	
	role = <%=loggedUser.getRole()%>;
	
	console.log (role);
	
	if (role == 0){
		
		divAdmin.style.display = 'block';
		dropAdmin.style.display = 'block';
		divUser.style.display = 'none';	
		dropUser.style.display = 'none';
			
		}else {
			
			divAdmin.style.display = 'none';
			dropAdmin.style.display = 'none';
			divUser.style.display = 'block';	
			dropUser.style.display = 'block';
			
		}
	}
	
	
	
	




</script>

</body>
</html>