<%@page import="testJSP.DataBManager"%>
<%@page import="testJSP.Topic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Topic[] topics = DataBManager.getTopics();
	int topicsSize = topics.length;
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> Domanda numero 1: Che squadra preferisci?? </p>
<form>
<div class="checkbox">
	<label><input type="checkbox" name="chesquadra1" value="Juventus">Juventus</label>
	</div>
</form>
<form>
<div class="checkbox">
	<label><input type="checkbox" name="chesquadra1" value="Juventus">Milan</label>
	</div>
</form>
<form>
<div class="checkbox">
	<label><input type="checkbox" name="chesquadra1" value="Juventus">Inter</label>
	</div>
</form>

<%
for (int i=0; i<topicsSize; i++) {
%>
<form>
<p>
<%
out.println(topics[i].getQuestion());

%></p>
<%
int availableRepliesLenght = topics[i].getAvailableReplies().length;
String [] availableReplies = topics[i].getAvailableReplies();
for (int y=0;y<availableRepliesLenght; y++) {
	out.print("<div class='checkbox'><label><input type='checkbox' name='chesquadra1' value='" + availableReplies[y]);
	out.print(availableReplies[y]);
	out.print("</label></div>");
}
%>
<div class="checkbox">
	<label><input type="checkbox" name="chesquadra1" value="Juventus">Juventus</label>
	</div>
</form>
<form>
<div class="checkbox">
	<label><input type="checkbox" name="chesquadra1" value="Juventus">Milan</label>
	</div>
</form>
<form>
<div class="checkbox">
	<label><input type="checkbox" name="chesquadra1" value="Juventus">Inter</label>
	</div>
</form>
<%
}
%>


</body>
</html>