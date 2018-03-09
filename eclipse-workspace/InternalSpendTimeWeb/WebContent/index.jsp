<%@page import="org.entities.User"%>
<%@ page import="org.proxima.spendtime.entities.SpendTime" %>
<%@ page import="org.proxima.spendtime.entities.SpendTimeTip" %>
<%@ page import="org.proxima.spendtime.spendtime.utils.CurrentDate" %>
<%@ page import="org.proxima.spendtime.db.HibernateDBManager" %>
<%@ page import="java.util.List"%>
<%@ page import="com.google.gson.Gson" %>
<% 


User currentUser = new User (); 
currentUser.setId(0);
currentUser.setEmail("maurizio.franco@ymail.com");
currentUser.setFirstname("Maurizio");
currentUser.setLastname("Franco");

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
<script type="text/javascript" src="js/dateFormat.js"></script>
</head>
<body onload="initializePage()">
WELCOME UTENTE <%=(currentUser.getFirstname() + " " + currentUser.getLastname())%>
<script type="text/javascript">

    function initializePage () {
    	console.log("called initializePage");
    	tabSptt();    	   	
    }

	var spendTime = null ;
	var spendTT = null;
	
	function executeListRequest() {
		console.log(spendTime);
// 		console.log("called executeListRequest");
		//1. create a new XMLHttpRequest object -- an object like any other!
		var myRequest = new XMLHttpRequest();
		// 2. open the request and pass the HTTP method name and the resource as parameters
		myRequest.open('POST', 'FormOrari');
		//myRequest.open('POST', 'SpendTimeTipsSelect');
		// 3. write a function that runs anytime the state of the AJAX request changes
		myRequest.onreadystatechange = function () { 
		    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		    if (myRequest.readyState === 4) {
		        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
		        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
		        //
// 		        console.log(myRequest.responseText)
	 	        spendTime=JSON.parse(myRequest.responseText);
				//spendTT=JSON.parse(myRequest.responseText);
	 	    	tabSptt();
		    }
		    
		};
		
		if(spendTime != null) {
			myRequest.send(JSON.stringify(spendTime));
			//myRequest.send(JSON.stringify(spendTT));
		} else {
			myRequest.send();
		}
	}
	
	function tabSptt() {
		console.log("called spendTT");
// 		console.log("called tabSptt");
		//1. create a new XMLHttpRequest object -- an object like any other!
		var myRequest2 = new XMLHttpRequest();
		// 2. open the request and pass the HTTP method name and the resource as parameters
		myRequest2.open('POST', 'SpendTimeTipsSelect');
		// 3. write a function that runs anytime the state of the AJAX request changes
		myRequest2.onreadystatechange = function () { 
		    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		    if (myRequest2.readyState === 4) {
		        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
		        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
		        //
		        console.log("myRequest2.responseText " + myRequest2.responseText)
	 	        spendTT=JSON.parse(myRequest2.responseText);
				console.log("spendTT: " + spendTT);
				initializeWeek();
// 	 	       initializeView() ;
		    }
		    
		};
		
// 		if(spendTT != null) {
// 			myRequest2.send(JSON.stringify(spendTT));
// 		} else {
			myRequest2.send();
// 		}
	}
	
// 		function initializeView() {
					
// 			if (spendTime!=null) {
				
// 		        var spendTimeSize = spendTime.length;
// //		         console.log("usersSize: " + spendTimeSize);
// 		        if (spendTimeSize>0) {
// 		        	tab = "<table>";
// 		        	//form = "<form>";
// 		        	for (var i=0;i<spendTimeSize; i++) {
		     	
// 		        		tab += 
// // 		        		("<tr>"+
// // 		        		 "<td>"+"USER <input type='text' name='userID' value='" + spendTime[i].userID +"' style='width:30px;' readonly='readonly' />") + "&nbsp;" + "</td>" +
// 		        		("<tr><td>"+"Data <input type='text' name='giorno"+i+ "' value='"+spendTime[i].data+"'  style='width:90px;' readonly='readonly' />" + "</td>")+ "&nbsp;" + "</td>" +
// 		        		("<td>"+"Ora <input type='text' name='"+i+ "' value='"+spendTime[i].ora+"'  style='width:30px;' onChange='cambioOra(this)' />" + "</td>") + 
// 		        		("<td>"+"<select id='spendTimeTipsSelect_" + i + "' name='"+i+"' onchange='cambioTipoOra(this)' >");
// 		        		if(spendTT != null) {
// 		        			console.log(spendTT);
// 		        			console.log(spendTT.length);
// 			        		for (var x=0;x<spendTT.length;x++) {
// 			        			tab +=("<option name='" + x +"' value='" + spendTT[x].id + "' >" + spendTT[x].label + " </option>");
// // 			        			document.addEventListener('DOMContentLoaded',function() {
// // 			        			    document.querySelector('select[name="(this)"]').onchange=cambioOra();
// 	// 		        			},false);
// 			        		}
// 		        		}
// 		        		tab += ("</select></td>");
// 		        		//console.log("Data <input type='text' name='giorno"+i+ "' value='"+spendTime[i].data+"'  style='width:150px;' readonly='readonly' /> ");
// 		        		//dynamicDiv = dynamicDiv + ("<li>"+ spendTime[i].userID + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].data + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].ora + "</li>");
// 			        }
// 		        	tab = tab + "</tr></table>";
// 		        }
// 		         console.log(tab);
// 		         document.getElementById("ser").innerHTML = tab;		        
// 		    }
// 		}
		
		
		
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
		
		function cambioTipoOra(label) {
			console.log("######################################################################################################");
			console.log(label.name + " " + label.value);
			console.log(parseInt(label.name, 10));
			console.log(spendTT);
			var index = parseInt(label.name, 10);
			var descrizione = parseInt(label.name, 10);
			spendTT[index].label = descrizione;
			console.log("######################################################################################################");
		}
		
		function getDateOfWeek(w, y) {
		    var d = (1 + (w - 1) * 7); // 1st of January + 7 days for each week
            console.log(new Date(y, 0, d));
		    return new Date(y, 0, d);
		}
		
		var data = new Date();
		var currentYear = data.getFullYear();
		var currentWeek = data.getMonth();
		var firstDayOfTheWeek = getDateOfWeek(currentWeek, currentYear);
		var currentRowId;
		
		function initializeWeek () {
// 			var firstDayOfTheWeek = getDateOfWeek(09, 2018);
// 			console.log currentWeek;
			firstDayOfTheWeek = getDateOfWeek(currentWeek, currentYear);
			var htmlContent = "<form id='spendTimeForm' action='submitSpendTime()' ><table id='stiCazzi'>" ;
			var currentDayOfWeek = firstDayOfTheWeek ;
			for (var i=0;i<7; i++) {				
				if (i!=0) {
				    currentDayOfWeek.setDate(currentDayOfWeek.getDate() + 1);
				}
                
				var text = dateFormat(currentDayOfWeek, "dddd, dS mmmm yyyy");
				htmlContent += "<tr><td>" + text + "</td>";
				var currentRowId = currentDayOfWeek.getFullYear()+"_"+currentDayOfWeek.getMonth()+"_"+currentDayOfWeek.getDate() ;
				htmlContent += ("<td><input type='number' name='"+currentRowId+"_hourNumber' value=''  style='width:30px;' />" + "</td>") ;
				htmlContent += ("<td>"+"<select name='"+currentRowId+"_hourType' >");
	    		if(spendTT != null) {
	    			console.log("CREO SELECT" + spendTT);
// 	    			console.log(spendTT.length);
	        		for (var x=0;x<spendTT.length;x++) {
	        			var currentOption = ("<option name='" + x +"' value='" + spendTT[x].id + "' >" + spendTT[x].label + " </option>"); 
	        			console.log("currentOption" + currentOption);
	        			htmlContent += currentOption ;
//		        			document.addEventListener('DOMContentLoaded',function() {
//		        			    document.querySelector('select[name="(this)"]').onchange=cambioOra();
//	 		        			},false);
	        		}
	    		}
	    		htmlContent += ("</select></td>");
				htmlContent += "</tr>" ; 
			}
			
			htmlContent += "</table><input  type='button' value='CARICA REPORT' onclick='submitSpendTime();'/></form>" ;
			document.getElementById("daysSelection").innerHTML = htmlContent;	
		}
		
		function submitSpendTime() {
			console.log("submitSpendTime invoked!!!");
// 			document.getElementById("spendTimeForm").submit();
				var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
				xmlhttp.open("POST", "/ReceiveJson");
				xmlhttp.setRequestHeader("Content-Type", "application/json");
				console.log(spendTime + " " + spendTT);
				var jsonToSend = convertToTable(el, numberOfColumns, columnNames);
				console.log(jsonToSend);

// 					xmlhttp.send(JSON.stringify(jsonToSend));
// 					console.log("submitted!!!!");
		}

		var contatore = 1;
		function minusWeek () {
			console.log("currentWeek: " + currentWeek);
			if (contatore < 5) {
				currentWeek--;
				contatore++;
				console.log("currentWeek2: " + currentWeek);
				initializeWeek ();
			} else {
				contatore=1;
				return;
			}
		}
		function plusWeek () {
			console.log("currentWeek: " + currentWeek);
			if (contatore < 5) {
				currentWeek++;
				contatore++;
				console.log("currentWeek2: " + currentWeek);
				initializeWeek ();
			} else {
				contatore=1;
				return;
			}
		}
		
		function convertToTable(el, numberOfColumns, columnNames) {
// 		    var columnsToIgnore = [numberOfColumns-2, numberOfColumns-1];
		    var table = el.tableToJSON(
		        {
// 		            ignoreColumns:columnsToIgnore, 
		            headings: columnNames
		        });
		    var result = $.map(table, function(e){
		        return (e['data'] == "ora") ? null : e;
		    });
		    var conv = (JSON.stringify(result));
		}

		$('#convert-table').click( function() {
		    var $table = $('#stiCazzi');
		    var columns = $table.find('td');
		    var numberOfColumns = columns.length;    
		    var columnNames = columns.map(function(index) {
		        var text = $(this).text();
		        return text == 'data' ? text + index : text;
		    }).get();

		  convertToTable($table, numberOfColumns, columnNames); 
		});
		
</script>

    <form id="ser" ></form>
    <input  type="button" value="CARICA REPORT" onclick="submitSpendTime();"/>
    
<button onclick="minusWeek()">-</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="plusWeek()">+</button>
<div id="daysSelection"></div>		
</body>
</html>