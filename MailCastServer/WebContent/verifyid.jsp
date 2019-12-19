<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>VERIFY ID</title>
<script>
	function conf(){
	 var r = confirm("Do you want to continue");	
		if(r){
			document.vid.action = "verifyID";
			document.vid.submit();
		}else
			alert("CANCLED");
	}
	
	</script>
<link rel="stylesheet" href="verifyidCss.css"/>

</head>
<body>
<div id="verify">
<h1>
	EMPLOYEE ID VERIFICATION !!
</h1>	
</div>
<br clear="all"/>
<div id="box">
	<form name="vid" method="post" >
		<input type="text" name="v" id="v" minlength="9" maxlength="9" size="20px" placeholder="Enter your ID" required = "required"/>
		<br/><br/><br/><br/><br/>
		<input type="image" src="sub.png" name="b1" id="b1" onClick="conf()" size="90px" value="Submit"/>
	</form>
	
</div>
</body>
</html>