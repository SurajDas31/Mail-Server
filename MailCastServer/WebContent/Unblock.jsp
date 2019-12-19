<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>ADD EMPLOYEE</title>
<link rel="stylesheet" href = "AddEmpCss.css"/>
</head>
<body>
<header id ="head">
<h1> Admin Home Page</h1>
<h2> Welcome To The Mail Services</h2>
</header>
<marquee  id="mark" > **Only Admin Can Handle**</marquee>

<div id="box">
<h1>UNBLOCK EMPLOYEE</h1><br/><br/><br/><br/><br/>
	<form action="Unblock" method="post">
		<input type="text" name="empid" id="name" minlength="9" maxlength="9" size="20px" placeholder="Enter Employee id" required = "required"/>
		<br/><br/><br/>
		
		<br/><br/><br/>
		<input type="submit" value="UNBLOCK"  name="b1" id="b1" />
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