<%@page import="linkedin.LinkedinConnection"%>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%
	LinkedinConnection liConnection = new LinkedinConnection();
%>
			<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
			<html>
				<head>
					<meta charset="UTF-8">
						<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
							<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
								<title>Insert title here</title>
								<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
									<link rel="stylesheet" href="css/main.css"></head>
									<body>

										<%@include file="topbarreg.jsp" %>

											<div class="container">
												<form class="form-horizontal divwith" method="post" action="Registration">
													<!-- <div class="container-fluid"> -->
													<div class="form-group">
														<h4 class="lead">Enter Information Here</h4>
														<input type="text" class="form-control" name="fname" placeholder="First Name*" required="required"></div>
														<div class="form-group">
															<input type="text" class="form-control" name="lname" placeholder="Last Name"></div>
															<div id="email1" class="form-group">
																<input type="text" class="form-control" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" placeholder="Enter email">
																	<label id='erremail'></label>
																</div>
																<div class="form-group">
																	<input type="password" class="form-control" name="pass" id="pass1" placeholder="Password" minlength="8" maxlength="50" required="required"></div>
																	<label id="pasw1format" style="color: red; display: none">la passoword deve essere lunga minimo 8 caratteri</label>
																	<div class="form-group">
																		<input type="password" class="form-control" name="passrep" id="pass2" placeholder="Ripeti passowrd" minlength="8" maxlength="50" required="required"></div>
																		<label id="pswErrorMessage" style="color: red; display: none">le password non corrispondono</label>

																		<div class="form-group">
																			<input type="date" class="form-control" name="dateOfBirth" placeholder="dateOfBirth"></div>
																			<div class="form-group">
																				<div class="form-check">
																					<input class="form-check-input" type="checkbox" id="gridCheck" required="required">
																						<label class="form-check-label" for="gridCheck">Consenso utilizzo dati personali
																						</label>
																					</div>
																				</div>
																				<div class="form-group row">
																					<div class="col-sm-10">
																						<input type="submit" value="Submit" class="btn btn-primary">
																							<input type="reset" value="Reset" class="btn btn-primary">
																								<a href="<%=liConnection.getLIAuthUrl()%>">
																									<img border="0" src="images/Logo-linkedin.png" alt="logolinkdin" height="47px" width="40px"></a>
																								</div>
																							</div>

																						</form>

																					</div>
																					<script>

																						var pass = document.getElementById('pass1');
																						var passrep = document.getElementById('pass2');
																						pass.addEventListener("input", validationpsw);
																						passrep.addEventListener("input", validationpsw);

																						function validationpsw() {
																							if (pass.value.length < 8 || pass.value.length > 50) {
																								document.getElementById("pasw1format").style.display = 'block';
																							} else {
																								document.getElementById("pasw1format").style.display = 'none';
																							}

																							if (pass.value != passrep.value && passrep.value != "") {
																								document.getElementById("pswErrorMessage").style.display = 'block';

																							} else {
																								document.getElementById("pswErrorMessage").style.display = 'none';
																							}
																						}
																					</script>

																					<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
																					<script src="bootstrap/js/bootstrap.min.js"></script>

																					<script src="js/validateemail.js"></script>
																				</body>
																			</html>
