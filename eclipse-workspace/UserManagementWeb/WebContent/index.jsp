<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>Proxima Centauri Milan Accademy - Welcome</title>
			<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
				<link rel="stylesheet" href="css/main.css">

					<head>
						<title>FORM JAVASCRIPT LOGIN</title>

						<script>
						
							//Submit form con la funzione id.
							function submit_by_id() {
								console.log("CIAO");
								var email = document.getElementById("email").value;
								var password = document.getElementById("password").value;

								console.log(email + password);

								if (validation()) { // Calling validation function
									executeLogin(email, password);
								}

							}
							
							
							//Funzione di Validazione Email e Password
							function validation() {

								var email = document.getElementById("email").value;
								var password = document.getElementById("password").value;

								if (email == '' || password == '') {
									alert("I CAMPI NON SONO RIEMPITI CORRETTAMENTE. RIEMPI TUTTI I CAMPI.");
									return false;
								} else if (email.length > 50 || password.length > 15) {

									alert("UNO O TUTTI E DUE I CAMPI CONTENGONO UNA STRINGA TROPPO LUNGA. CONTROLLA I CAMPI");
									return false;
								} else {
									return true;
								}
							}
  
							
							var res= null;
							 
							function executeLogin(email, password) {
								console.log("called executeLogin");
								//1. create a new XMLHttpRequest object -- an object like any other!
								var myRequest = new XMLHttpRequest();
								// 2. open the request and password the HTTP method name and the resource as parameters
								myRequest.open('GET', "LoginServlet?email=" + email + "&password=" + password);
								// 3. write a function that runs anytime the state of the AJAX request changes
								myRequest.onreadystatechange = function () {
									// 4. check if the request has a readyState of 4, which indicates the server has responded (complete)
									if (myRequest.readyState === 4) {
										// 5. insert the text sent by the server into the HTML of the 'ajax-content' document.getElementById('ajax-content').innerHTML = myRequest.responseText;
										//
										console.log("###### " + myRequest.responseText);
										res=JSON.parse(myRequest.responseText); 	
										
										if (res.code == "OK"){
													    
// 											       console.log("user: " + res); 
// 											       alert("myRequest.responseText: " + myRequest.responseText);
											       window.location.href = 'home.jsp';
										
										}
										
									}

								};
// 								console.log ("invio");
								myRequest.send();
								
							}
							
						
								
							

							
						</script>
					</head>
					<body>

							<div class="container">

<!-- 								<form class="form-horizontal divwith" method="get" name="form_name" id="form_id"> -->
									<div class="form-group">
										<h2>PAGINA DI LOGIN</h2>
										<input class="form-control" type="text" name="email" id="email" placeholder="Enter email"/>
									</div>
									<div class="form-group">
										<input class="form-control" type="password" name="password" id="password" placeholder="Enter password"/>
									</div>
									<div class="form-group">
										<input class="btn btn-primary" type="button" name="submit_id" id="btn_id" value="LOGIN" onclick="submit_by_id()"/>
									</div>
									<div class="form-group">
										<a href="reg.jsp">REGISTRATI</a>
									</div>
								</div>
<!-- 							</form> -->
<!-- 						</div> -->

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
              <script src="bootstrap/js/bootstrap.min.js"></script>

					</body>
				</html>
