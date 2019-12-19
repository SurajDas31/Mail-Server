<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mail page</title>
<link rel="stylesheet" href="style.css"></link>
<script>
function hom(){
    alert("Home");
	document.formhome.action="mainpage.jsp";
	document.formhome.submit();}

function comp(){
	alert("compose a mail");
	document.formmail.action="Composemail.jsp";
	document.formmail.submit();}
function show(){
	alert("show a mail");
	document.formmail.action="Inboxpage.jsp";
	document.formmail.submit();}
function sen(){
	alert("sent mail");
	document.formmail.action="Sentmail.jsp";
	document.formmail.submit();}
function log(){
    var a = confirm("Do you want to logout");
	if(a){
	document.formlogout.action="IndexPage.jsp";
	document.formlogout.submit();
	}
}	
	function prof(){
		alert("Profile");
		document.formmail.action="Profile.jsp";
		document.formmail.submit();}

	function contact(){
		alert("Admins");
		document.formlogout.action="contactus.jsp";
		document.formlogout.submit();}
	
	
	

</script>

</head>
<body style="background-image: url('bgimg.jpg')">

<%
String n = (String)session.getAttribute("uname");
if(n.equals("admin@techno.com")){
	out.print("<font color='white'>");
	out.print("<b>Admin logged in with ID</b> : "+n);
	out.print("</font>");
}

%>

<h1>WELCOME TO THE MAILING BOX</h1>
<form name="formhome">
<input type="button" value="Home" class="button" onclick="hom()" style="fontsize:150%" id="h"> <br><br>
</form>
<form name="formmail" target="ifram_a">
<input type="button" value="Compose" class="button" onclick="comp()" style="fontsize:150%" id="1"/> <br><br>
<input type="button" value="Inbox" onclick="show()" class="button" id="2" style="fontsize:150%"/> <br><br>
<input type="button" value="Sent" onclick="sen()" class="button" id="3" style="fontsize:150%"/> <br><br>
<input type="button" value="Profile" class="button" onclick="prof()" style="fontsize:150%" id="4"/><br>
<iframe height="600px" width="70%" src="first.jsp" name="ifram_a" style="margin-top:-15%;margin-left:20%"></iframe>
</form>
<form name="formlogout">
<input class="button" type="Button" onclick="log()" id="logout" name="logout" value="Log out"/><br><br> 
<input type="button" value="Contact Us" class="button" onclick="contact()" style="fontsize:150%" id="5"/>
</form>

</body>
</html>