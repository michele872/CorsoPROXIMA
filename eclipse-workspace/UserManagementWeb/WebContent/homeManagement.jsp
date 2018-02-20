<%@page import="org.apache.log4j.Logger"%>
<%@page import="sun.font.Script"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="jdk.nashorn.internal.parser.JSONParser"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.commons.UserImg"%>
<%@page import="org.db.UserDBManager"%>
<%@page import="org.bean.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Users Management </title>

<link rel="stylesheet" type="text/css">

<script>
<%

 

 List <User> users = UserDBManager.getUsers();
 Gson gson = new GsonBuilder().setPrettyPrinting().create();


 String usersJ = gson.toJson(users);
 
 
 
 
%>


var Jusers = <%=usersJ%>


console.log (Jusers);
 


</script>


</head>

<link rel="stylesheet" type="text/css" href="css/userManStyle.css">

<hr>

 <div class="topnav" id= "topnav">
  <a href="http://www.proximainformatica.com/" target="_blank"><img class="img-responsive2"       
       src="./proxima_logo.png"></a>
  <a class="active" href="homeManagement.jsp">Gestione Utenti</a>
  <a href="http://blog.proximainformatica.com/" target="_blank">Blog</a>
  <a href="http://www.proximainformatica.com/proxima-informatica-academy/corsojava/" target="_blank">Centauri</a>
  <a href="/index.html">Logout</a>
  <a href="javascript:void(0);" style="font-size:20px;" class="icon" onclick="myFunction()">&#9776;</a>
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
</script>

<div class="container bootstrap snippet">


<div align="center">
    <div class="row">
        <div class="col-lg-12">
           <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                    <div class="table-responsive">
                    <div style="overflow-x:auto; overflow-y: auto;">
                        <table class="table user-list">
                            <thead>
                                <tr>
                                <th width= 40%><span>User</span></th>
                                <th width= 20%><span>Created</span></th>
                                <th width= 30%><span>Email</span></th>
                               
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                
                          <script> 
                          
                                 for (var i = 0; i < Jusers.length; i++) {
                        	

                        	
                        document.write ("<form action= 'userDetails.jsp' method = 'post'><td><img src='"+ Jusers[i].imgPath + "' style='width:100'> <class='user-link'><a href='mailto:"+ Jusers[i].email +"' class='user-link'>"+ Jusers[i].firstname +"</a>");
                        document.write ("<td>"+ Jusers[i].regdate +"</td>");	
                        document.write ("<td><a href= 'mailto: "+ Jusers[i].email +"'>"+ Jusers[i].email +"</a></td>");           
                        document.write ("<td><Button type = 'submit' class = 'qualityButton' name = 'button' value = '"+ Jusers[i].id +"'>Edit </Button></td></a>");      
                        document.write ("</tr></form> ");            
                                   
                                       
                        } 
                                 
                        </script>
                                                            
                                   
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</div>
</html>