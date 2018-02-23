<%@ page import="org.entities.Spendtime" %>
<%@ page import="org.entities.Spendtimetip" %>
<%@ page import="utility.CurrentDate" %>
<%@ page import="db.HibernateDBManager" %>
<%@ page import="java.util.List"%>
<%@ page import="com.google.gson.Gson" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>

<script type="text/javascript">
	function servl() {
		console.log("LUCA TI ODIO");
		document.getElementById("ser").action="/GestioneOrariLavorativi/FormOrari";
		document.getElementById("ser").submit();
	}
	
	var spendTime = null ;
	function executeListRequest() {
		console.log("called executeListRequest");
		//1. create a new XMLHttpRequest object -- an object like any other!
		var myRequest = new XMLHttpRequest();
		// 2. open the request and pass the HTTP method name and the resource as parameters
		myRequest.open('GET', 'FormOrari');
		// 3. write a function that runs anytime the state of the AJAX request changes
		myRequest.onreadystatechange = function () { 
		    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		    if (myRequest.readyState === 4) {
		        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
		        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
		        //
		        console.log(myRequest.responseText)
	 	        spendTime=JSON.parse(myRequest.responseText);
		
		        initializeView() ;
		    }
		    
		};
		myRequest.send();
	}
	
		function initializeView() {
//		 	console.log("INITIALIZE VIEW");
			if (spendTime!=null) {
		        var spendTimeSize = spendTime.length;
//		         console.log("usersSize: " + spendTimeSize);
		        if (spendTimeSize>0) {
		        	dynamicDiv="<ul>";
		        	for (var i=0;i<spendTimeSize; i++) {
		        		
		        		dynamicDiv = dynamicDiv + ("<li>"+ spendTime[i].userID + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].data + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].ora + "</li>");
			        }
		        	dynamicDiv = dynamicDiv + "</ul>";
		        }
//		         console.log(dynamicDiv);
		        document.getElementById("ser").innerHTML = dynamicDiv;
		        
		    }
		}

</script>
<form id="ser"></form>
		<input  type="button" value="SO CAZZI" onclick="executeListRequest();"/>
		
</body>
</html>