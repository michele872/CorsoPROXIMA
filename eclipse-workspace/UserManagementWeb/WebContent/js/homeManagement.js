/**
 * 
 */
var user = null ;
function executeDetailRequest (userId) {
	console.log("called DetailServlet");
	//1. create a new XMLHttpRequest object -- an object like any other!
	var myRequest = new XMLHttpRequest();
	var str="?button=";
	// 2. open the request and pass the HTTP method name and the resource as parameters
	myRequest.open('GET', 'EditUser'+"?button="+userId);
	// 3. write a function that runs anytime the state of the AJAX request changes
	myRequest.onreadystatechange = function () { 
	    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
	    if (myRequest.readyState === 4) {
	        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
	        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
	        //
	        console.log(myRequest.responseText);
// 	        users=JSON.parse("'"+myRequest.responseText+"'");
	        user=JSON.parse(myRequest.responseText);
	        console.log("user: " + user);	        
	        initializeUserView () ;
	    }
	    
	};
	myRequest.send();
	
}

var userToUpdate = null ;
function executeUpdateRequest (userId,email,password,firstname,lastname,borndate) {
// 	function executeUpdateRequest (userId) {	
	console.log("called UpdateServlet");
	console.log("record in entrata: "+userId+email+password+firstname+lastname+borndate);
	var email2 = document.getElementById("email").value;
	
	var password2 = document.getElementById("password").value;	
	var firstname2 = document.getElementById("firstname").value;
	var lastname2 = document.getElementById("lastname").value;
	var borndate2 = document.getElementById("borndate").value;
	console.log("record in uscita: "+email2+password2+firstname2+lastname2+borndate2);
	
	//1. create a new XMLHttpRequest object -- an object like any other!
	var myRequest = new XMLHttpRequest();
	var str="?button=";
// 	if ((inputValue==null)||(inputValue.length==0)) {
// 		document.getElementById("passwordErrorMessage").style.display='block';
// 		validationCheck=false;
// 	}else {
// 		document.getElementById("passwordErrorMessage").style.display='none';
// 		validationCheck=true;
// 	}
	if ((email2==null)||(email2.length==0)||(password2==null)||(password2.length==0)) {
		if(password2.length>0){
			document.getElementById("inputErrorMessage").style.display='block';
			return false;
		}
		if(email2.length>0){
			document.getElementById("passwordErrorMessage").style.display='block';
			return false;
		}
		if ((password2.length==0)&&(email2.length==0)){					
			document.getElementById("inputErrorMessage").style.display='block';
			document.getElementById("passwordErrorMessage").style.display='block';
			return false;
		}
	}else {
		//document.getElementById("inputErrorMessage").style.display='none';
		//return true;
		myRequest.open('GET', 'UserModOk'+"?button2="+userId+"&email="+email2+"&password="+password2+"&firstname="+firstname2+"&lastname="+lastname2+"&borndate="+borndate2);
		//myRequest.open('GET', 'UpdateServlet'+"?button2="+userId+"&email="+email);
		// 3. write a function that runs anytime the state of the AJAX request changes
		
			myRequest.onreadystatechange = function () { 
			    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
			    if (myRequest.readyState === 4) {
			        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
			        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
			        //
			        console.log(myRequest.responseText);
//		 	        users=JSON.parse("'"+myRequest.responseText+"'");
			        userToUpdate=JSON.parse(myRequest.responseText);
			        console.log("user: " + userToUpdate);
			        location.reload();
			        //initializeUserView () ;
			    }
			    
			};
			myRequest.send();
	    
	    }    
	}
	// 2. open the request and pass the HTTP method name and the resource as parameters
	
	



var userToDelete = null ;
function executeDeleteRequest (userId) {
// 	function executeUpdateRequest (userId) {	
	console.log("called DeleteServlet");
	console.log("record in entrata: "+userId);		
	//1. create a new XMLHttpRequest object -- an object like any other!
	
	var myRequest = new XMLHttpRequest();	
	// 2. open the request and pass the HTTP method name and the resource as parameters
	myRequest.open('GET', 'UserDeleteOk'+"?button="+userId);
	//myRequest.open('GET', 'UpdateServlet'+"?button2="+userId+"&email="+email);
	// 3. write a function that runs anytime the state of the AJAX request changes
	
		myRequest.onreadystatechange = function () { 
		    // 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		    if (myRequest.readyState === 4) {
		        // 5. insert the text sent by the server into the HTML of the 'ajax-content'
		        //document.getElementById('ajax-content').innerHTML = myRequest.responseText;
		        //
		        console.log(myRequest.responseText);
		        console.log(userId);
//	 	        users=JSON.parse("'"+myRequest.responseText+"'");
// 		        userToDelete=JSON.parse(myRequest.responseText);
// 		        console.log("user: " + userToDelete);
		        location.reload();
		        //initializeUserView () ;
		    }
		    
		};
		myRequest.send();
    } 
	


function deleteControl() {
	
    if (confirm("Are you sure you want to delete this user?")) {
        
    } else {
        return false;
    }    
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
		//document.getElementById("updateForm").action="modConfirm.jsp";
		//document.getElementById("updateForm").submit;
	} 
	
function valForm(){
	var x = document.forms["updateForm"]["email"].value;
    if (x == "") {
        alert("email must be filled out");
        return false;
    }
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

function getImgPath(currentUser) {
	var defaultImg = "images/default_image.jpg";

	if (currentUser.imgpath != undefined) {
		defaultImg = currentUser.imgpath;
	}
	console.log(currentUser.imgpath);
	return defaultImg;

}

var users = null;
function executeListRequest() {
	console.log("called executeListRequest");
	showBarType();
	//1. create a new XMLHttpRequest object -- an object like any other!
	var myRequest = new XMLHttpRequest();
	// 2. open the request and pass the HTTP method name and the resource as parameters
	myRequest.open('GET', 'ListServlet');
	// 3. write a function that runs anytime the state of the AJAX request changes
	myRequest.onreadystatechange = function() {
		// 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
		if (myRequest.readyState === 4) {
			// 5. insert the text sent by the server into the HTML of the 'ajax-content'
			//document.getElementById('ajax-content').innerHTML = myRequest.responseText;
			//
			console.log(myRequest.responseText)
			// 	        users=JSON.parse("'"+myRequest.responseText+"'");
			users = JSON.parse(myRequest.responseText);
			console.log("users: " + users);
			initializeView();
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
					+ "<th width= 20%><div align=\"center\"><span>"+profileImage+"</span></div></th>"
					+ "<th width= 20%><div align=\"center\"><span>"+firstNameLabel+"</span></div></th>"
					+ "<th width= 20%><div align=\"center\"><span>"+lastNameLabel+"</span></div></th>"
					+ "<th width= 20%><div align=\"center\"><span>"+registeredLabel+"</span></div></th>"
					+ "<th width= 20%><div align=\"center\"><span>"+actionLabel+"</span></div></th>"
					+ "</tr>" + "</thead>" + "<tbody>" + "<tr>";
			for (var i = 0; i < usersSize; i++) {

				//dynamicDiv = dynamicDiv + ("<li>"+ users[i].firstname + "&nbsp;&nbsp;&nbsp;&nbsp;" +  users[i].lastname + "&nbsp;&nbsp;&nbsp;&nbsp;" +  users[i].email + "&nbsp;&nbsp;&nbsp;&nbsp;" +  users[i].dateOfBirth + "&nbsp;&nbsp;&nbsp;&nbsp;" +  "</li>");
				dynamicDiv = dynamicDiv
						+ "<td width= 20% align=\"center\"><img class='avatar' src='"
						+ getImgPath(users[i])
						+ "' width='50' height='50'>"
                        
                        + "<div class='dropdown'>"
                        // <!-- Link o pulsante per l'attivazione del dropdown -->
                        + "<a data-toggle='dropdown' href='#' class='btnDrop'><span class='glyphicon glyphicon-menu-down'></span></a>"
                        //<!-- Menu dropdown -->
                        + "<ul class='dropdown-menu'>"
                        + "<li><button type = 'submit' class = 'editDrop' name = 'button' value = '"+ users[i].id + "' onclick=\"executeDetailRequest("
			            + users[i].id + ")\">"+editButtonLabel+"</button>"
                        + "</ul>"
                        + "</div>"
                        + "</div></td>"
						+ "<td width= 20% align=\"center\"><h4>"
						+ users[i].firstname
						+ "</h4></td>"						
						+ "<td width= 20% align=\"center\"><h4>"
						+ users[i].lastname						
						+ "</h4></td>"	
						+ "<td width= 20% align=\"center\"><h5>"
						+ users[i].regdate
						+ "</h5></td>"
						+ "<td width= 20% align=\"center\"><button type = 'submit' class = 'qualityButton' name = 'button' value = '"
						+ users[i].id + "' onclick=\"executeDetailRequest("
						+ users[i].id + ")\">"+editButtonLabel+"</button>" + "</td></tr>";
				
				
				
				
			}
			dynamicDiv = dynamicDiv
					+ "</tbody></table></div></div></div></div></div></div></div></div>";
		}
		
		
		
		
		
		//         console.log(dynamicDiv);
		document.getElementById("content").innerHTML = dynamicDiv;
		}
	
	}



function initializeUserView() {

	dynamicDiv = "<div class=\"container divwidth\">"
			+ "<br><div class='form-group divwidth'><img class='avatar' id='myImg' alt='"+user.firstname+ " " +user.lastname+"' src='"
			+ getImgPath(user)
			+ "' height='100' width='100'>"
			+ "<div id='myModal' class='modal'>"
			+ "<span class='close'>&times;</span>"
			+ "<img class='modal-content' id='img01'>"
			+ "<div id='caption'></div>"
			+ "</div>"
			+"<span class='label label-info'>"
			+ user.email
			+ "</span>"
			+"</div><br>"
			+ "<div class='form-group '>"
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"id\">"+idLabel+"</label>"
			+ "<div class=\"col-sm-9\">"
			+ "<input type='text' class='form-control' id='idf' name='idf'  value='"+user.id+"' disabled>"
			+ "<input type='hidden' class='form-control' id='id' name='id'  value='"+user.id+"' >"
			+ "</div>"
			+ " </div>    "
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"email\">"+emailLabel+"</label>"
			+ " <div class=\"col-sm-9\">"
			+ "<input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\" value=\""+user.email+"\"\">"
			+ "</div>"
			+ "<div class=\"col-sm-offset-3 col-sm-9\">"
			+ "<label id=\"inputErrorMessage\" style=\"color:red\" hidden>"+incorrectEmailLabel+"</label>"
			+ "</div>  "
			+ " </div>"
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"password\">"+passwordLabel+"</label>"
			+ " <div class=\"col-sm-9\">"
			+ "<input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" value=\""+user.password+"\">"
			+ "</div>"
			+ "<div class=\"col-sm-offset-3 col-sm-9\">"
			+ "<label id=\"passwordErrorMessage\" style=\"color:red\" hidden>"+incorrectPasswordLabel+"</label>"
			+ "</div>"
			+ "</div> "
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"firstname\">"+firstNameLabel+"</label>"
			+ "<div class=\"col-sm-9\">"
			+ "<input type=\"text\" class=\"form-control\" id=\"firstname\" name=\"firstname\" value=\""+user.firstname+"\" >"
			+ "</div>"
			+ "</div>"
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"lastname\">"+lastNameLabel+"</label>"
			+ "<div class=\"col-sm-9\">"
			+ "<input type=\"text\" class=\"form-control\" id=\"lastname\" name=\"lastname\" value=\""+user.lastname+"\" >"
			+ "</div>"
			+ "</div>"
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"borndate\">"+dateofbirthLabel+"</label>"
			+ "<div class=\"col-sm-9\">"
			+ "<input type=\"date\" class=\"form-control\" id=\"borndate\" name=\"borndate\" value=\""+user.dateOfBirth+"\" >"
			+ "</div>"
			+ "</div> "
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"regdate\">"+registeredLabel+"</label>"
			+ "<div class=\"col-sm-9\"> "
			+ "<input type=\"date\" class=\"form-control\" id=\"regdate\" name=\"regdate\" value=\""+user.regdate+"\" disabled>"
			+ "</div>"
			+ "</div> "
			+ "<div class=\"form-group\">"
			+ "<div class=\"col-sm-offset-3 col-sm-9\">"
			+ "<button type=\"submit\" class=\"btn btn-default qualityButton\" name = 'button2' value = '"
			+ user.id + "'onclick=\"document.getElementById('id01').style.display='block'\"><span class=\"glyphicon glyphicon-floppy-save\"></span> "+saveupdatesLabel+"</button></div>"
			+"<div id='id01' class='w3-modal'>"
            +"<div class='w3-modal-content w3-animate-top w3-card-4'>"
            +"<header class='w3-container w3-teal'>"
            +"<span onclick=\"document.getElementById('id01').style.display='none'\" class='w3-button w3-display-topright'>&times;</span>"
            +"<h2><div align='center'>"+confirmLabel+"</div></h2>"
            +"</header>"
            +"<div class='w3-container' align='center'>"
            +"<br><p>"+updateAlert+"</p><br>"
            +"</div>"
            +"<footer class='w3-container w3-teal'>"
            +"<br><p><button class='modalBtn' name ='btnmod' id= 'btnmod' onclick = \"executeUpdateRequest ('"+user.id+"', '"+user.email+"', '"+user.password+"', '"+user.firstname+"', '"+user.lastname+"', '"+user.dateOfBirth+"');\">"+confirmModal+"</button></p>"
            +"<p><button class='modalBtn' name ='btncanc' id= 'btncanc' onclick = \"document.getElementById('id01').style.display='none'\">"+cancelModal+"</button></p>"
            +"</footer>"
            +"</div>"
			+ "</div>"
			+ "</div>"
			+ "</div>"
			+ "</div>"
			+ "<div class=\"container divwidth\">"
// 			+ "<div >"
			+ "<div class=\"form-group\">"
			+ "<div class=\"col-sm-12\">"
			+ "<input type=\"hidden\" name=\"id\" value=\""+user.id+"\">"
			+ "</div>"
			+ "</div>"
			+ "<div class=\"form-group\">"
			+ "<label class=\"control-label col-sm-3\" for=\"borndate\">"+deleteuserLabel+"</label>"
			+ "<div class=\"col-sm-9\">"
			+ "<button class=\"btn btn-default qualityButton\" onclick=\"document.getElementById('id02').style.display='block'\" type=\"submit\" name='buttondelete'><span class='glyphicon glyphicon-trash'></span> "+deleteuserLabel+"</button>"
			+ "<br> <h4><a href=\"homeManagement.jsp\"><span class=\"glyphicon glyphicon-th-list\"></span> "+userslistLabel+"</a></h4>"
			+ "<div id='id02' class='w3-modal'>"
            + "<div class='w3-modal-content w3-animate-top w3-card-4'>"
            + "<header class='w3-container w3-teal'>"
            + "<span onclick=\"document.getElementById('id02').style.display='none'\" class='w3-button w3-display-topright'>&times;</span>"
            + "<h2><div align='center'>"+confirmLabel+"</div></h2>"
            + "</header>"
            + "<div class='w3-container' align='center'>"
            + "<br><p>"+deleteAlert+"</p><br>"
            + "</div>"
            + "<footer class='w3-container w3-teal'>"
            + "<br><p><button class='modalBtn' name ='btnmod' id= 'btnmod' onclick = \"executeDeleteRequest('"+user.id+"');\"\">"+deleteModal+"</button></p>"
            + "<p><button class='modalBtn' name ='btncanc' id= 'btncanc' onclick = \"document.getElementById('id02').style.display='none'\">"+cancelModal+"</button></p>"
            + "</footer>"
            + "</div>"
			+ "</div>"
			+ "</div>"
			

			+"</div>"
			
			+

			"</div>";

	console.log(dynamicDiv);

	document.getElementById("content").innerHTML = dynamicDiv;
	
	var modal = document.getElementById("myModal");

	//Get the image and insert it inside the modal - use its "alt" text as a caption
	var img = document.getElementById("myImg");
	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("caption");
	img.onclick = function(){
	 modal.style.display = "block";
	 modalImg.src = this.src;
	 captionText.innerHTML = this.alt;
	}

	//Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	//When the user clicks on <span> (x), close the modal
	span.onclick = function() { 
	 modal.style.display = "none";
	}



     }

