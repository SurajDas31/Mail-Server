<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="mainPageerrorPage.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css"></link>

<!--  <script>
function func(){
//alert("message send successful");
var a = confirm("do you want to compose mail");
if(a!=0)
{
	document.forral.action="composemail";
	document.forral.submit();
	
	
}
else{
	document.forral.action="mainpage.html";
	document.forral.submit();
}
</script> -->

</head>
<body style="background-image:url('first.jpg')";>
<form name="forra1" action="ComposeMail" method="post">
<span class="tag">
To:</span>
<input type="text" name= "toname" id= "cl" pattern = "[a-zA-Z0-9._]+@techno.com"><br><br>
<!--  <span class="tag">

From:</span>
 <input type="text" name= "fromname"id= "cl" pattern = "[a-zA-Z0-9._]+@techno.com"><br><br>
 -->
 
<span class="tag"> 
Subject:
</span>
<input type="text"name="subname"id="c2">-<br>-<br>
<span class="tag">
Message: <br>
</span>
<textarea rows="30"cols="80 " name="message"></textarea><br></br>
 <input class="button" type="submit" style="background-color:#000080" value= "Send" id="grad"  ">



</form>

</body>
</html>