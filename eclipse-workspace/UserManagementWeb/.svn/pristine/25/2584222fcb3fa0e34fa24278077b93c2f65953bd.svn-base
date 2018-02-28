<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function insertMessage () {
    	var textToInsert = document.getElementById("messageTextId").value;
    	console.log(textToInsert);
    
    	var myRequest = new XMLHttpRequest();
    	myRequest.open('GET', 'InsertMessageServlet?textMessage='+textToInsert);
    	// 3. write a function that runs anytime the state of the AJAX request changes
    	myRequest.onreadystatechange = function () { 
    	    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
    	    if (myRequest.readyState === 4) {
    	        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
    	        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
    	        //
    	        console.log(myRequest.responseText)
//     	        users=JSON.parse("'"+myRequest.responseText+"'");
    	        var response=JSON.parse(myRequest.responseText);
//     	        console.log("users: " + users);
                console.log(response.code);
                if (response.code=="OK") {
                	document.getElementById("messageTextId").value="" ;
                }
//     	        initializeView () ;
    	    }
    	    
    	};
    	myRequest.send();    	
    }
</script>
</head>
<body>
<input type="text" id="messageTextId"/>
<button onclick="insertMessage()">INSERISCI</button>
</body>
</html>