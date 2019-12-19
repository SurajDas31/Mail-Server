<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp Employee</title>
<script>
	alert("REDIRECTED TO REGISTRATION PAGE");

	function reg(){
		document.Signup.action = "SignUp" ;
		document.Signup.submit();
		}	
	function foc(x){
		
		if(document.getElementById("npassword").value == document.getElementById("cpassword").value){
		x.style.background = "green";	
		}else{
			x.style.background = "red";	
		}
		
	}
	</script>
<link rel="stylesheet" href="signupCss.css"></link>

</head>
<body>
<div id="i1">
	<h1>REGISTER YOURSELF HERE</h1>
	<h1>ENTER THE FIELDS CORRECTLY</h1>
</div>
<marquee>
	*All fields are mandatory !
</marquee>
<br clear="all"/>
<div id="i2">
<form name="Signup" method="post">
	<table cellspacing="20" cellpadding="20" border="1">
	  <tr>
	  	<td colspan="2" align="center">
	  		EMPLOYEE REGISTERATION FORM
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
			Choose username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</td>
			<td>
			  <input type="email" pattern = "[a-zA-Z0-9._]+@techno.com" size="30px" id="email" name="email" placeholder="abc@techno.com" required = "required"/>@techno.com
			  <br/>*(username may contain uppercase,lowercase,symbol(._),number and domain must be @techno.com)	
			</td>
			
		</tr>
		<tr>
			<td>
			New Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</td>
			<td>
			  <input type="password" size="30px" minlength="8" id="npassword" name="npassword" placeholder="Enter new password" required = "required"/>	
			</td>
			
		</tr>
		<tr>
			<td>
			Confirm Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</td>
			<td>
			  <input type="password" size="30px" minlength="8" onChange="foc(this)" id="cpassword" name="cpassword" placeholder="Enter Confirm password" required = "required"/>	
			</td>
			<span id='message'></span>
		</tr>
		
		<tr>
			<td>
			Employee ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</td>
			<td>
			  <input type="text" minlength="9" maxlength="9" size="30px" id="eid" name="eid" placeholder="Enter your unique id" required = "required"/>	
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
        		<input id ="submit" name="submit" onClick="reg()" src="register.png" width="90px" type="image" value="Register" >
                <input  id ="reset" name="reset" type="reset"   value="reset" align="right" >
        	</td>
        	
        </tr>
	</table>
	
	
</form>
</div>

</body>
</html>