

    function getImgPath (currentUser) {
    	
    	
    	var defaultImg = "images/default_image.jpg";
    	
    	
    	if (currentUser.imgpath != undefined) {
    		
    		defaultImg = currentUser.imgpath;
    		
    	}
    	
    	console.log (currentUser.imgpath);
    	
    	return defaultImg;
    	
    	
   }

	function submitForm(){ 
	   
	   console.log("Sono qui nel submitForm");	
		var emailValue=document.getElementById("email").value;
		var passValue=document.getElementById("password").value;
		console.log("lunghezza stringa email: "+emailValue.length);		
		console.log("lunghezza stringa password: "+passValue.length);
		if (!validateEmail(emailValue)) {			
			return false;
		}
		if (!validatePassword(passValue)) {			
			return false;
		}
		//return 
		//document.getElementById("updateForm").="modConfirm.jsp";
		//document.getElementById("updateForm").submit;
	} 
	
	function validateEmail(inputValue){
		var validationCheck=false;
		if ((inputValue==null)||(inputValue.length==0)) {
			document.getElementById("inputErrorMessage").style.display='block';
			validationCheck=false;
		}else {
			document.getElementById("inputErrorMessage").style.display='none';
			validationCheck=true;
		}
		return validationCheck;
	}
	function validatePassword(inputValue){
		var validationCheck=false;
		if ((inputValue==null)||(inputValue.length==0)) {
			document.getElementById("passwordErrorMessage").style.display='block';
			validationCheck=false;
		}else {
			document.getElementById("passwordErrorMessage").style.display='none';
			validationCheck=true;
		}
		return validationCheck;
	}



    var users = null ;
    
    function executeListRequest () {
    	console.log("called executeListRequest");
    	//1. create a new XMLHttpRequest object -- an object like any other!
    	var myRequest = new XMLHttpRequest();
    	// 2. open the request and pass the HTTP method name and the resource as parameters
    	myRequest.open('GET', 'ListServlet');
    	// 3. write a function that runs anytime the state of the AJAX request changes
    	myRequest.onreadystatechange = function () { 
    	    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
    	    if (myRequest.readyState === 4) {
    	        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
    	        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
    	        //
    	        console.log(myRequest.responseText)
//     	        users=JSON.parse("'"+myRequest.responseText+"'");
     	        users=JSON.parse(myRequest.responseText);
    	        console.log("users: " + users);
    	        initializeView () ;
    	    }
    	    
    	}
    	myRequest.send();
    	
    }

    function initializeView() {
    	// 	console.log("INITIALIZE VIEW");
    	if (users != null) {
    		var usersSize = users.length;
    		//         console.log("usersSize: " + usersSize);
    		if (usersSize > 0) {
    			dynamicDiv = "<div class='container bootstrap snippet'>"
    					+ "<div align='center'>"
    					+ "<div class='row'>"
    					+ "<div class='col-lg-12'>"
    					+ "<div class='main-box no-header clearfix'>"
    					+ "<div class=\"main-box-body clearfix\">"
    					+ "<div class=\"table-responsive\">"
    					+ "<div style= \"overflow-x:auto; overflow y: auto\">"
    					+ "<table class=\"table user-list\">"
    					+ "<thead>"
    					+ "<tr>"			
    					+ "<th width= 20%><div align=\"center\"><span>Profile Image</span></div></th>"
    					+ "<th width= 20%><div align=\"center\"><span>Lastname</span></div></th>"
    					+ "<th width= 20%><div align=\"center\"><span>Firstname</span></div></th>"
    					+ "<th width= 20%><div align=\"center\"><span>Registered</span></div></th>"
    					+ "<th width= 20%><div align=\"center\"><span>Action</span></div></th>"
    					+ "</tr>" + "</thead>" + "<tbody>" + "<tr>";
    			for (var i = 0; i < usersSize; i++) {

    				//dynamicDiv = dynamicDiv + ("<li>"+ users[i].firstname + "&nbsp;&nbsp;&nbsp;&nbsp;" +  users[i].lastname + "&nbsp;&nbsp;&nbsp;&nbsp;" +  users[i].email + "&nbsp;&nbsp;&nbsp;&nbsp;" +  users[i].dateOfBirth + "&nbsp;&nbsp;&nbsp;&nbsp;" +  "</li>");
    				dynamicDiv = dynamicDiv
    						+ "<td width= 20% align=\"center\"><img src='"
    						+ getImgPath(users[i])
    						+ "' width='50' height='50'></td>"
    						+ "<td width= 20% align=\"center\"><h4>"
    						+ users[i].lastname
    						+ "</h4></td>"						
    						+ "<td width= 20% align=\"center\"><h4>"
    						+ users[i].firstname					
    						+ "</h4></td>"	
    						+ "<td width= 20% align=\"center\"><h5>"
    						+ users[i].regdate
    						+ "</h5></td>"
    						+ "<td width= 20% align=\"center\"><button type = 'submit' class = 'qualityButton' name = 'button' value = '"
    						+ users[i].id + "' onclick=\"executeUserRequest("
    						+ users[i].id + ")\">Edit </button>" + "</td></tr>";
    			}
    			dynamicDiv = dynamicDiv
    					+ "</tbody></table></div></div></div></div></div></div></div></div>";
    		}
    		//         console.log(dynamicDiv);
    		document.getElementById("content").innerHTML = dynamicDiv;

    	}
    }   
    	        



 
    	
    	
    	
    	 var userToMod = null;
    	    
    	    function executeUserRequest (userId) {
    	    	console.log("called executeUserRequest");
    	    	//1. create a new XMLHttpRequest object -- an object like any other!
    	    	var myRequest = new XMLHttpRequest();
    	    	// 2. open the request and pass the HTTP method name and the resource as parameters
    	    	myRequest.open('GET', 'EditUser'+"?button="+ userId);
    	    	// 3. write a function that runs anytime the state of the AJAX request changes
    	    	myRequest.onreadystatechange = function () { 
    	    	    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
    	    	    if (myRequest.readyState === 4) {
    	    	        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
    	    	        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
    	    	        //
    	    	        console.log(myRequest.responseText);
//    	     	        users=JSON.parse("'"+myRequest.responseText+"'");
    	     	        userToMod=JSON.parse(myRequest.responseText);
    	    	        console.log("user: " + userToMod);
    	    	        initializeUserView () ;
    	    	    }
    	    	    
    	    	}
    	    	myRequest.send(); 	
    	
    	    }
    	    
    	    	function initializeUserView () {
    	    	 	console.log("INITIALIZE USER VIEW");
    	    		if (userToMod!=null) {
    	    	        
    	    			console.log ("carico pagina utente")
    	    	        	
    	    dynamicDiv2= "<div class='container divwidth'>"+"<br><div class='form-group divwidth'><img class= 'avatar' src='"+getImgPath(userToMod)+"' height='100' width='100'/><span class='label label-info'>"+userToMod.email+"</span></div><br>"+
//     	    	        	  "<form class='form-horizontal'name='updateForm' id='updateForm' method='post'>"+
    	    	        	  	"<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='id'>ID:</label>"+
    	    	        	      "<div class='col-sm-9'>"+    
    	    	        	       "<input type='text' class='form-control' id='idf' name='idf'  value='"+userToMod.id+"' disabled>"+
    	    	        	        "<input type='hidden' class='form-control' id='id' name='id'  value='"+userToMod.id+"' >"+
    	    	        	      "</div>"+
    	    	        	    "</div>"+
    	    	        	    "<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='email'>Email:</label>"+
    	    	        	      "<div class='col-sm-9'>"+
    	    	        	        "<input type='text' class='form-control' id='email' name='email' value='"+userToMod.email+"'>"+
    	    	        	      "</div>"+

    	    	        	      "<div class='col-sm-offset-3 col-sm-9'>"+
    	    	        	        "<label id='inputErrorMessage' style='color:red' hidden>Email non corretta</label>"+
    	    	        	      "</div>"+    
    	    	        	    "</div>"+
    	    	        	    "<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='password'>Password:</label>"+
    	    	        	      "<div class='col-sm-9'>"+     
    	    	        	        "<input type='password' class='form-control' id='password' name='password' value='"+userToMod.password+"' >"+
    	    	        	       "</div>"+
    	    	        	      "<div class='col-sm-offset-3 col-sm-9'>"+
    	    	        	        "<label id='passwordErrorMessage' style='color:red' hidden>Password non corretta</label>"+
    	    	        	      "</div>"+
    	    	        	   "</div>"+    
    	    	        	    "<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='firstname'>Firstname:</label>"+
    	    	        	      "<div class='col-sm-9'>"+          
    	    	        	       "<input type=\"text\" class=\"form-control\" id=\"firstname\" name=\"firstname\" value=\""+userToMod.firstname+"\" >"+
    	    	        	      "</div>"+
    	    	        	    "</div>"+    
    	    	        	    "<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='lastname'>Lastname:</label>"+
    	    	        	      "<div class='col-sm-9'>"+          
    	    	        	        "<input type=\"text\" class=\"form-control\" id=\"lastname\" name=\"lastname\" value=\""+userToMod.lastname+"\" >"+
    	    	        	     "</div>"+
    	    	        	    "</div>"+    
    	    	        	    "<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='borndate'>Date of Birth:</label>"+
    	    	        	      "<div class='col-sm-9'>"+       
    	    	        	         "<input type=\"date\" class=\"form-control\" id=\"borndate\" name=\"borndate\" value=\""+ userToMod.dateOfBirth +"\" >"+
    	    	        	      "</div>"+
    	    	        	    "</div>"+    
    	    	        	    "<div class='form-group'>"+
    	    	        	      "<label class='control-label col-sm-3' for='regdate'>Registration Date:</label>"+
    	    	        	      "<div class='col-sm-9'>"+        
    	    	        	        "<input type=\"text\" class=\"form-control\" id=\"regdate\" name=\"regdate\" value=\""+userToMod.regdate+"\" disabled>"+
    	    	        	      "</div>"+
    	    	        	    "</div>"+    
    	    	        	    "<div class='form-group'>"+        
    	    	        	      "<div class='col-sm-offset-3 col-sm-9'>"+
    	    	        	        "<button class='btn btn-default qualityButton' name ='btnmod' id= 'btnmod' onclick = \"executeUpdateRequest ('"+userToMod.id+"', '"+userToMod.email+"', '"+userToMod.password+"', '"+userToMod.firstname+"', '"+userToMod.lastname+"', '"+userToMod.dateOfBirth+"');\"><span class='glyphicon glyphicon-floppy-save'></span>Salva Modifiche</button>"+
    	    	        	        "</div>"+
    	    	        	    "</div>"+
//     	    	        	  "</form>"+
//     	    	        	  "<form class='form-horizontal'>"+
    	    	        				"<div class='form-group'>"+
    	    	        					"<div class='col-sm-12'>"+
    	    	        						"<input type=\"hidden\" name=\"id\" id= 'id' value=\""+userToMod.id+"\">"+
    	    	        					"</div>"+
    	    	        				"</div>"+
    	    	        				"<div class='form-group'>"+
    	    	        				"<label class='control-label col-sm-3' for='borndate'>Delete User: </label>"+
    	    	        					"<div class='col-sm-9'>"+
    	    	        						"<button class=\"btn btn-default qualityButton\" onclick=\"executeDeleteRequest('"+userToMod.id+"');\" type=\"submit\" name='buttondelete' value=\"Elimina Utente\"><span class='glyphicon glyphicon-trash'></span> Elimina Utente</button><br>"+
    	    	        						"<br> <a href='homeManagement.jsp'><span class='glyphicon glyphicon-th-list'></span> Torna all'elenco utenti</a>"+
    	    	        						"</div>"+
    	    	        						"</div>"+

//     	    	        			"</form>"+
    	    	        			
    	    	        			
    	    	        	 	
    	    	        	 "</div>"+
    	    	        	 "<br>";
    	    			                                
   
    	    	        	
//    	     	         console.log(dynamicDiv);
    	    	        document.getElementById("content").innerHTML = dynamicDiv2;
    	    	        
    	    	    }
    	    	}

    	
    	    	var userUpdated = null ;
    	        
    	    	
    	    	
    	       function executeUpdateRequest(id, email, password, firstname, lastname, dateOfBirth) {
    	        	
    	            console.log (id+email+password+firstname+lastname+dateOfBirth)
    	        	console.log("called executeUpdateRequest");
    	            
    	            var id = document.getElementById ("id").value;
    	            var email = document.getElementById ("email").value;
    	            var password = document.getElementById ("password").value;
    	            var firstname = document.getElementById ("firstname").value;
    	            var lastname = document.getElementById ("lastname").value;
    	            var dateOfBirth = document.getElementById ("borndate").value;
    	            var validationCheck=false;
    	    		
    	        	
    	        	//1. create a new XMLHttpRequest object -- an object like any other!
    	        	var myRequest = new XMLHttpRequest();
    	        	
    	        	if ((email==null)||(email.length==0)||(password==null)||(password.length==0)) {
    	        		
    	        		if ((password==null)||(password.length==0)){
    	    			document.getElementById("passwordErrorMessage").style.display='block';
    	    			validationCheck=false;
    	    			}
    	        		
    	        		if ((email==null)||(email.length==0)){
    	        			document.getElementById("inputErrorMessage").style.display='block';
    	        			validationCheck=false;
    	        		}
    	        		
    	        	} else {
    	        		
    	             console.log ("apro una richiesta alla servlet")
    	        	// 2. open the request and pass the HTTP method name and the resource as parameters
    	        	myRequest.open('GET', 'UserModOk'+"?id="+ id + "&email="+email+"&password="+password+"&firstname="+firstname+"&lastname="+lastname+"&borndate="+dateOfBirth);
    	        	// 3. write a function that runs anytime the state of the AJAX request changes
    	        	if (confirm("Are you sure you want to update this user?")) {
    	        	myRequest.onreadystatechange = function () { 
    	        	    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
    	        	    if (myRequest.readyState === 4) {
    	        	        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
    	        	        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
    	        	        //
    	        	        console.log(myRequest.responseText);
//    	         	        users=JSON.parse("'"+myRequest.responseText+"'");
    	         	        userUpdated=JSON.parse(myRequest.responseText);
     	        	        console.log("user: " + userUpdated);     	        	       
    	        	        initializeModView () ;
    	        	    }
    	        	}
    	        	
    	        	myRequest.send();
    	        	} else {
    	    	        return false;
    	    	    }  
    	        }
    	       }
    	       

    	        	function initializeModView () {
    	        	 	console.log("INITIALIZE MOD VIEW");
    	        		if (userUpdated!=null) {
    	        	        
    	        	
    	        	        	
    	        	        	dynamicDiv3= "<meta http-equiv='refresh' content='5; url=homeManagement.jsp' />"+
    	        	        	"<link rel='stylesheet' type='text/css' href='css/confirm.css'><div class = 'main-box.no-header'>"+
    	        	            "<div class='main-box' align='center'>"+
    	        	            "Modifiche effettuate. Sarai reindirizzato entro 5 secondi alla pagina principale, "+
    	        	            "oppure clicca <a href='homeManagement.jsp'>QUI</a> per non attendere.</div></div>";
    	        	            
    	        	        	document.getElementById("content").innerHTML = dynamicDiv3;
    	        	            
    	        		}
    	        		
    	        	}
    	       
    	
    	        	var deletedUser = null ;
        	        
        	    	
        	    	
    	    	       function executeDeleteRequest(id) {
    	    	        	
    	    	            console.log ("utente con id: " + id);
    	    	        	console.log("called executeUpdateRequest");
    	    	            
    	    	            
    	    	            var id = document.getElementById ("id").value;
    	    	          
    	    	            
    	    	        	
    	    	        	//1. create a new XMLHttpRequest object -- an object like any other!
    	    	        	var myRequest = new XMLHttpRequest();
	    	    	    	if (confirm("Are you sure you want to delete this user?")) {
							// 2. open the request and pass the HTTP method name and the resource as parameters
    	    	        	myRequest.open('GET', 'UserDeleteOk'+"?id="+ id);
    	    	        	// 3. write a function that runs anytime the state of the AJAX request changes
    	    	        	myRequest.onreadystatechange = function () { 
    	    	        	    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
    	    	        	    if (myRequest.readyState === 4) {
    	    	        	        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
    	    	        	        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
    	    	        	        //
    	    	        	        console.log(myRequest.responseText);
    	    	        	        console.log(id);
//    	    	         	        users=JSON.parse("'"+myRequest.responseText+"'");
//     	    	         	        userUpdated=JSON.parse(myRequest.responseText);
//     	     	        	        console.log("user: " + deletedUser);
    	    	        	        initializeDeleteView () ;
    	    	        	    }
    	    	        	    
    	    	        	}
    	    	        	myRequest.send();
    	    	        	
	    	    	    	 } else {
	    	    	 	        return false;
	    	    	 	    }    
	    	    	 	}
    	    	        

    	    	        	function initializeDeleteView () {
    	    	        	 	console.log("INITIALIZE DELETE VIEW");
    	    	        		
    	    	        	        
    	    	        	
    	    	        	        	
    	    	        	        	dynamicDiv4= "<meta http-equiv='refresh' content='5; url=homeManagement.jsp' />"+
    	    	        	        	"<link rel='stylesheet' type='text/css' href='css/confirm.css'><div class = 'main-box.no-header'>"+
    	    	        	            "<div class='main-box'>"+
    	    	        	            "Utente cancellato con successo. Sarai reindirizzato entro 5 secondi alla pagina principale, "+
    	    	        	            "oppure clicca <a href='homeManagement.jsp'>QUI</a> per non attendere.</div></div>";
    	    	        	            
    	    	        	        	document.getElementById("content").innerHTML = dynamicDiv4;
    	    	        	            
    	    	        		
    	    	        		
    	    	        	}
    	    	



