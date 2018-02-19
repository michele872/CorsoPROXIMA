<%@page import="db.SpendTimeDBManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="db.SpendTimeDBManager"%>
<%@ page import="utility.CurrentDate" %>
<%@ page import="dipendenti.Dipendente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>

   <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/main.css" />
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
	
	function controllaspeciali(campo){
		re=/[&><"']/;
		if(re.test(campo.value)) {
			document.getElementById("error").style.display = 'block';
// 			document.getElementById("form").onChange;
// 			alert("hai inserito un carattere non valido")}
		}	
	
		function toEight() {
			
		}
	</script>
</head>
<body>
<div class="container">
<div class="col-md-6 col-md-offset-3">
<table>
<tr>
<td align="center">
<h3>WELCOME LUCAAAA </h3>
</td>
</tr>
</table>
</div>
<form action="AfterHome">
<div class="col-md-6 col-md-offset-3">
          <table class="table table-striped">
	<%
	SpendTimeDBManager cdb = new SpendTimeDBManager();
	
	
	
	int id = 1;
	String meseAnno = CurrentDate.dataCorrente();
	int giorno = Integer.parseInt(CurrentDate.giornoCorrente());
	int orario;
	String data = CurrentDate.data();
	HashMap<String, Integer> o = cdb.getPrepopolatedValue();
	
	
	int contatore = 1;
	for(int i=0; i<giorno; i++) {	
		if(o.isEmpty()){
			orario = 0;
		} 
		
		else {
			orario = o.get(id+"_"+(contatore+"-"+meseAnno));
		}
		System.out.println("home.jsp - chiave: " + id+"_"+(contatore+"-"+meseAnno) + " valore: " + orario);
			//out.print("Data <input type='text' name='giorno"+i+ "' value='0' style='width:150px;' >");
			out.print("<input type='hidden' value='1' >");
			%> 

            <tbody>          
          	<tr>
			<td> <% 
			out.print("Data <input type='text' name='giorno"+i+ "' value='"+String.valueOf(contatore)+"-"+meseAnno+"'  style='width:150px;' readonly='readonly' /> ");
			//out.print("Ore  Lavorate <input type='text' name='orario"+i+ "' value='0' style='width:40px;' >");
			%>
			<td>
			<% 
			out.print("Ore  Lavorate <input type='text' name='orario"+i+ "' value='"+orario+"' style='width:40px;'  onChange='controllaspeciali(this)' />");
			%> 
			</td>
			<td>
			<label id="error" style="color: red; display:none;">CARATTERE INSERITO NON VALIDO.</label>
			</td>
            </tr>

			<%
			contatore++;

	}
	
	%>	
  </tbody>
          </table>
          	
          	<button type="submit" style="display: block; margin: 0 auto; width: 100px;" class="btn btn-default">CARICA</button>
        </div> 
</form>		
</div>
</body>
</html>