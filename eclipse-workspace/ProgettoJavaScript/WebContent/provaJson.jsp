<%@page import="dip.EsempioJSON"%>
<%@page import="dip.UserDBManager"%>
<%@page import="dip.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dip.UserDBManager"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	var ciao = <% out.print("'"+ EsempioJSON.toJson1()+"'");%>;
	console.log(ciao);
	
	var array = JSON.parse(ciao);
	console.log(array);
</script>
</head>
<body>
	<script type="text/javascript">
		for(var i=0; i<array.length; i++) {
			document.write("<input ID type='text' name='id' value='"+ array[i].id +"' />");
			document.write("<input DATA type='text' name='id' value='"+ array[i].data +"' />");
			document.write("<input ORA type='text' name='id' value='"+ array[i].ora +"' />");
			document.write("<br>");
		}
	
	</script>	
</body>
</html>