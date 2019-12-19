<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<link rel="stylesheet" href="IndexCss.css"></link>
<script rel="text/javascript" src="SignUpScript.js"></script>
</head>
<body>
<div id="home">
	<h1>HOME</h1>
	
</div>
<br clear="all"/>
<p>*(username may contain uppercase,lowercase,symbol(._),number and domain must be @techno.com)</p>
	<form name="login1" method = "post">
    <div id="login">
       <h1>LOGIN</h1>
	    <ul>
	    <li>
		<input type="text" id="t1" pattern="[a-zA-Z0-9._]+@techno.com" name="t1" placeholder="EnterUsername@techno.com" />	
         </li>
         <li>
	    <input type="password" id="t2" minlength="8" name="t2" placeholder="Enter Password" /><br/>
	    <a href="Forgot.jsp">forgot your password?</a>
	    </li>
	    <li>
	    <input type="image" src="login.png" onClick="log()" id="b1" name="b2" width="90px "  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="image" src="register.png" id="b3" name="b3" width="90px" onClick="reg()"/>	
	    </li>
	    </ul>
	</div>    
	 
	</form>


</body>
</html>