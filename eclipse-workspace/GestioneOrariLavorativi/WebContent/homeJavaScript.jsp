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
WELCOME UTENTE 
<script type="text/javascript">
	function servl() {
		console.log("LUCA TI ODIO");
		document.getElementById("ser").action="/GestioneOrariLavorativi/FormOrari";
		document.getElementById("ser").submit();
	}
	
	var spendTime = null ;

	function executeListRequest() {
		console.log(spendTime);
// 		console.log("called executeListRequest");
		//1. create a new XMLHttpRequest object -- an object like any other!
		var myRequest = new XMLHttpRequest();
		// 2. open the request and pass the HTTP method name and the resource as parameters
		myRequest.open('POST', 'FormOrari');
		// 3. write a function that runs anytime the state of the AJAX request changes
		myRequest.onreadystatechange = function () { 
		    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		    if (myRequest.readyState === 4) {
		        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
		        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
		        //
// 		        console.log(myRequest.responseText)
	 	        spendTime=JSON.parse(myRequest.responseText);
		
		        initializeView() ;
		    }
		    
		};
		
		if(spendTime != null) {
			myRequest.send(JSON.stringify(spendTime));
		} else {
			myRequest.send();
		}
	}
	
		function initializeView() {
//		 	console.log("INITIALIZE VIEW");
			if (spendTime!=null) {
				
		        var spendTimeSize = spendTime.length;
//		         console.log("usersSize: " + spendTimeSize);
		        if (spendTimeSize>0) {
		        	tab = "<table>";
		        	for (var i=0;i<spendTimeSize; i++) {
		     
		        		tab += 
		        		("<tr>"+
		        		 "<td>"+"USER <input type='text' name='userID' value='" + spendTime[i].userID +"' style='width:30px;' readonly='readonly' />") + "&nbsp;" + "</td>" +
		        		("<td>"+"Data <input type='text' name='giorno"+i+ "' value='"+spendTime[i].data+"'  style='width:90px;' readonly='readonly' />" + "</td>")+ "&nbsp;" + "</td>" +
		        		("<td>"+"Ora <input type='text' name='"+i+ "' value='"+spendTime[i].ora+"'  style='width:30px;' onChange='cambioOra(this)' />" + "</td>"+"</tr>");
		        		
		        		
		        		//console.log("<input USER type='text' name='userID' value='" + spendTime[i].userID +"' />"); 
		        		//console.log("Data <input type='text' name='giorno"+i+ "' value='"+spendTime[i].data+"'  style='width:150px;' readonly='readonly' /> ");
		        		//dynamicDiv = dynamicDiv + ("<li>"+ spendTime[i].userID + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].data + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].ora + "</li>");
			        }
		        	tab = tab + "</table>";
		        }
		         console.log(tab);
		         document.getElementById("ser").innerHTML = tab;
		        
		    }
		}
		
		function cambioOra(valore) {
			console.log("######################################################################################################");
			console.log(valore.name + " " + valore.value);
			console.log(parseInt(valore.name, 10));
			console.log(spendTime);
			var index = parseInt(valore.name, 10);
			var valoreOra = parseInt(valore.value, 10);
			spendTime[index].ora = valoreOra;
			
			console.log("######################################################################################################");
		}

</script>
<form id="ser"></form>
		<input  type="button" value="APRI REPORT" onclick="executeListRequest();"/>
		
</body>
</html>