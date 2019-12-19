<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>VIEW EMPLOYEE</title>
<link rel="stylesheet" href = "ViewDetailsPage.css"/>
	<script>
	function full(){
		document.ViewBox.action = "ViewDetails"
		document.ViewBox.submit();
		
	}
	function stat(){
		document.ViewBox.action = "StatusDetails"
		document.ViewBox.submit();
		
	}
	function fullDetail(){
		document.ViewBox.action = "fullDetails"
		document.ViewBox.submit();
		
	}
	function fullStatusDetail(){
		document.ViewBox.action = "fullStatusDetails"
		document.ViewBox.submit();
		
	}
	
	
	</script>

</head>
<body>
<header id ="head">
<h1> Admin Home Page</h1>
<h2> Welcome To The Mail Services</h2>
</header>
<marquee  id="mark" > **Only Admin Can Handle**</marquee>

<form name="ViewBox" method="post">	
	
<div id="empid">	
<input type="text" minlength="9" maxlength="9" name="empid" id="name" size="20px" placeholder="Enter Employee ID" required = "required"/>
	
</div>	
	
<div id="box">
<h1>View Employee Details</h1><br/><br/><br/><br/><br/>
	
		<input type="button" value="View Emp Personal Details"  name="b1" id="b1" onClick="full()"/>		
		<br/><br/><br/>
		<input type="button" value="View full Emp Details Table"  name="b3" id="b1" onClick="fullDetail()" />
	    <br/><br/><br/>
		<input type="button" value="View Emp Status Details"  name="b2" id="b1" onClick="stat()" />
	    <br/><br/><br/>
	    <input type="button" value="View full Emp Status Table"  name="b2" id="b1" onClick="fullStatusDetail()" />
	    <br/><br/><br/>
		
	</form>
	
</div>


<div style ="display : inline-block; border: 3px groove;">
<a href="AdminPage.jsp"><button class="button ">Home</button></a><br/>
<a href="AddEmp.jsp"><button class="button">Add Employee</button></a><br/>
<a href="UpdateEmpDetails.jsp"><button class="button ">Update Detail</button></a><br/>
<a href="block.jsp"><button class="button ">Block</button></a><br/>
<a href="Unblock.jsp"><button class="button ">unblock</button></a><br/>
<a href="mainpage.jsp"><button class="button ">Compose Mail</button></a><br/>
<a href="viewdetails.jsp"><button class="button ">View Details</button></a><br/>
<a href="IndexPage.jsp"><button class="button ">SignOut</button></a><br/>
<a href="contactus.jsp"><button class="button ">Contact Us</button></a><br/>
</div>

<hr/>
</body>

</html>