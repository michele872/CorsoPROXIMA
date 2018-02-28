<%@ page import="org.proxima.spendtime.entities.SpendTime" %>
<%@ page import="org.proxima.spendtime.entities.SpendTimeTip" %>
<%@ page import="org.proxima.spendtime.spendtime.utils.CurrentDate" %>
<%@ page import="org.proxima.spendtime.db.HibernateDBManager" %>
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

//     var spendtimetips = [{"id":1,"descrizione":"aaa","label":"permesso","spendtimes":[]},{"id":2,"descrizione":"bbb","label":"lavorativo","spendtimes":[]}] ;

//     var spendtimetipsLength = spendtimetips.length ;

//     console.log ("spendtimetipsLength: " + spendtimetipsLength) ;
//     function initDropdownList(id) {
//         var select, i, option;

//         select = document.getElementById( id );
//         for ( i = 0; i < spendtimetipsLength; i ++ ) {
//             option = document.createElement( 'option' );
//             option.value = spendtimetips[i].id;
//             option.text = spendtimetips[i].label;
//             select.add( option );
//         }
//     }
    function doppiaServlet() {
    	executeListRequest();
    }
// 	function spt() {
// 		console.log("PROVO A PRENDERE LA SPENDTIMETIPS");
// 		document.getElementById("sp").action="/GestioneOrariLavorativi/SpendTimeTipsSelect";
// 		document.getElementById("sp").submit();
// 	}

// 	function servl() {
// 		document.getElementById("ser").action="/GestioneOrariLavorativi/SpendTimeTipsSelect";
// 		document.getElementById("ser").action="/GestioneOrariLavorativi/FormOrari";
// 		document.getElementById("ser").submit();
// 	}
	
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
		console.log(spendTT);
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
		        console.log("LUCA MALEDETTO" + myRequest2.responseText)
	 	        spendTT=JSON.parse(myRequest2.responseText);
				console.log("LUCA MALEDETTO" + spendTT);
	 	       initializeView() ;
		    }
		    
		};
		
		if(spendTT != null) {
			myRequest2.send(JSON.stringify(spendTT));
		} else {
			myRequest2.send();
		}
	}

// 	function viewSptt() {

// 			if (spendTT!=null) {
				
// 		        var spendTTSize = spendTT.length;
// //		         console.log("usersSize: " + spendTimeSize);
// 		        if (spendTTSize>0) {
// 		        	//form = "<form>";
// 		        	for(var i=0; i<spendTTSize; i++) {
// 		        		//form += 
		        			
// 						document.write("<input ID type='text' name='id' value='"+ spendTT[i].id +"' />");
// 		    			document.write("<input LABEL type='text' name='id' value='"+ spendTT[i].label +"' />");
// 		    			document.write("<input DESCRIZIONE type='text' name='id' value='"+ spendTT[i].descrizione +"' />");
// 		    			document.write("<br>");
// 					}
// 		        	//form = form + "</form>";
// 		        }
// // 		         console.log(form);
// // 		         document.getElementById("sp").innerHTML = form;
// 		    }
// 		}
	
		function initializeView() {
					
			if (spendTime!=null) {
				
		        var spendTimeSize = spendTime.length;
//		         console.log("usersSize: " + spendTimeSize);
		        if (spendTimeSize>0) {
		        	tab = "<table>";
		        	//form = "<form>";
		        	for (var i=0;i<spendTimeSize; i++) {
		     	
		        		tab += 
		        		("<tr>"+
		        		 "<td>"+"USER <input type='text' name='userID' value='" + spendTime[i].userID +"' style='width:30px;' readonly='readonly' />") + "&nbsp;" + "</td>" +
		        		("<td>"+"Data <input type='text' name='giorno"+i+ "' value='"+spendTime[i].data+"'  style='width:90px;' readonly='readonly' />" + "</td>")+ "&nbsp;" + "</td>" +
		        		("<td>"+"Ora <input type='text' name='"+i+ "' value='"+spendTime[i].ora+"'  style='width:30px;' onChange='cambioOra(this)' />" + "</td>") + 
		        		("<td>"+"<select id='spendTimeTipsSelect_" + i + "' name='"+i+"' onchange='cambioTipoOra(this)' >");
		        		if(spendTT != null) {
		        			console.log(spendTT);
		        			console.log(spendTT.length);
			        		for (var x=0;x<spendTT.length;x++) {
			        			tab +=("<option name='" + x +"' value='" + spendTT[x].id + "' >" + spendTT[x].label + " </option>");
// 			        			document.addEventListener('DOMContentLoaded',function() {
// 			        			    document.querySelector('select[name="(this)"]').onchange=cambioOra();
	// 		        			},false);
			        		}
		        		}
		        		tab += ("</select></td>");
		        		//console.log("Data <input type='text' name='giorno"+i+ "' value='"+spendTime[i].data+"'  style='width:150px;' readonly='readonly' /> ");
		        		//dynamicDiv = dynamicDiv + ("<li>"+ spendTime[i].userID + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].data + "&nbsp;&nbsp;&nbsp;&nbsp;" +  spendTime[i].ora + "</li>");
			        }
		        	tab = tab + "</tr></table>";
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

</script>

<form id="ser" ></form>
		<input  type="button" value="APRI REPORT" onclick="doppiaServlet();"/>

<form id="sp"></form>
		<input  type="button" value="APRI SPT" onclick="tabSptt();" />


		
</body>
</html>