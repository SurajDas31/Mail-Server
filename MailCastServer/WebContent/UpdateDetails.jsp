<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>SignUp Employee</title>
<script>
	function reg(){
	document.Update.action = "Update" ;
	document.Update.submit();
	}	
	
	</script>
<link rel="stylesheet" href="Update.css"></link>

</head>
<body>
<header id ="head">
<h1> Admin Home Page</h1>
<h2> Welcome To The Mail Services</h2>
</header>
<marquee  id="mark" > **Only Admin Can Handle**</marquee>

<form name="Update" method="post">
<div id="empid">

<input type="text" minlength="9" maxlength="9" size="30px" id="eid" name="eid" placeholder="Enter Employee unique id" required = "required"/>
	
</div>

<div id="i2">

	<table cellspacing="20" cellpadding="20" border="1">
	  <tr>
	  	<td colspan="2" align="center">
	  		EMPLOYEE FULL DETAILS UPDATION FORM
	  	</td>
	  	
	  </tr>
		<tr>
			<td>
			FirstName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</td>
			<td>
			  <input type="text" size="30px" id="firstname" name="firstname" placeholder="firstname" required = "required"/>	
			</td>
			
		</tr>
		<tr>
			<td>
			LastName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</td>
			<td>
			  <input type="text" size="30px" id="lastname" name="lastname" placeholder="Lastname" required = "required"/>	
			</td>
			
		</tr>
				
				
		<tr>
		<td>
		 Gender&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
		</td>
		<td>
		Male<input type="radio" name="gender" value="male" id="male" name="male" required = "required"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
        Female<input type="radio" name="gender" value="female" id="female" name="female" required = "required" />
        </td>
        </tr>
        
        <tr>
        	<td>
        		DOB&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
        	</td>
        	<td>
        		<input  type="date" name="dob" id="dob" required = "required"/ >dd/mm/yyy
        	</td>
        	
        </tr>
        
        <tr>
        	<td>
        		Experience(In Yr)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
        		
        	</td>
        	<td>
        		<input type="number" name="experience" id="experience" required = "required"/>
        	</td>
        	
        </tr>
        <tr>
        	<td>
        		Contact No
        	</td>
        	<td>
        		<input type="text" pattern="[0-9]+" name="telephone" id="telephone" required = "required" minlength="10" maxlength="10"/>10 digits
        	</td>
        </tr>
        
        <tr>
        	<td>
        	Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
        		
        	</td>
        	<td>
        		<textarea  id ="address" name="address" cols="25" rows="4" required = "required"></textarea>
        		
        	</td>
        	
        </tr>
        <tr>
        	<td>
        		City&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
        	</td>
        	<td>
        		<input id ="city" type="text" name="city" required = "required" >
        	</td>
        </tr>
        <tr>
        	<td>
        		State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
        	</td>
        	<td>
        		<input id ="state" type="text" name="state" required = "required" >
        	</td>
        </tr>
        <tr>
        	<td>
        		Country&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
        	</td>
        	<td>
        		<select  id ="country" name="country" required = "required">
                <option>Select-Country:</option>
                <option>India</option>
                <option>Pakistan</option>
                <option>China</option>
                <option>Nepal</option>
                <option>USA</option>
                <option>France</option>
                <option>Other</option>
                 </select>
        	</td>
        </tr>
        
        <tr>
        	<td colspan="2" align="center">
        		<input id ="submit" name="submit" onClick="reg()" src="update.png" width="90px" type="image" value="Register" >
                <input  id ="reset" name="reset" type="reset"   value="reset" align="right" >
        	</td>
        	
        </tr>
	</table>
	
	
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
</div>
<br/><br/>
<hr/>


</body>
</html>
