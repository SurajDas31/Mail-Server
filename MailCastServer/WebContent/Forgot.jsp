<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
    alert("Forgot your password");
    function conf(){
   	 var r = confirm("Do you want to continue");	
   		if(r){
   			document.vid.action = "Forgot";
   			document.vid.submit();
   		}else
   			alert("CANCLED");
   	    }
function foc(x){
		
		if(document.getElementById("npassword").value == document.getElementById("cpassword").value){
		x.style.background = "green";	
		}else{
			x.style.background = "red";	
		}
		
	}
</script>
<link rel= "stylesheet" href="verifyidCss.css"/>


</head>
<body>
<body>
     
<div id="verify">
<h1>
	PASSWORD RESET WIZARD !!
</h1>	
</div>
<br clear="all"/>
<div id="box">
	<form name="vid" method="post" >
		<input type="text" name="v" id="v" size="20px"  minlength="9" maxlength="9"  placeholder="Enter your ID" required = "required"/><br/><br/>
		 <input type="password" size="30px" minlength="8" id="npassword" name="npassword" placeholder="Enter new password" required = "required"/><br/><br/>
		  <input type="password" size="30px" minlength="8" id="cpassword" name="cpassword" onChange="foc(this)" placeholder="Enter confirm password" required = "required"/>		
		<br/><br/><br/><br/><br/>
		<input type="image" src="sub.png" name="b1" id="b1" onClick="conf()" size="90px" value="Submit"/>
	</form>
	
</div>




</body>
</html>