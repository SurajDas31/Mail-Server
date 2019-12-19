<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.*" %>   
<%@ page errorPage="mainPageerrorPage.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="style.css"></link>

</head>
<body style="background-image:url('first.jpg');">
<!-- <table>
<tr>
<th><span class="tag">To::</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th></tr>
<tr> 
<th><span class="tag">Subject::</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th></tr>
<tr>
<th><span class="tag">Message::</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th></tr>
</table>
 -->
<%
String n = (String)session.getAttribute("uname");
System.out.println("from:"+n);

 if(!n.equals("admin@techno.com"))
	 
 {
try{
	Class.forName("com.mysql.jdbc.Driver");
	
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
	PreparedStatement ps=con.prepareStatement("select * from signup where email = ?");
	ps.setString(1,n);
	ResultSet rs=ps.executeQuery();

/* Printing column names */
	out.print("<h1 align='center'>Your Profile is Here</h1><br><br>");
	
	out.print("<table align='center' border=1 cellpadding=10 cellspacing=15>");	
	
//ResultSetMetaData rsmd=rs.getMetaData();
//int total=rsmd.getColumnCount();
//	out.print("<th>fname</th>");


/* Printing result */

while(rs.next())
{
	out.print("<tr>");
    out.print("<th>Unique ID</th>");
    out.print("<td>"+rs.getString(1)+"</td>");
    out.print("<th>Mail ID</th>");
    out.print("<td>"+rs.getString(2)+"</td>");
     out.print("</tr>");
    
   
	out.print("<tr>");
    out.print("<th>First Name</th>");
    out.print("<td>"+rs.getString(3)+"</td>");
    out.print("<th>Last Name</th>");
    out.print("<td>"+rs.getString(4)+"</td>");
    out.print("</tr>");
    
	out.print("<tr>");
	out.print("<th>Gender</th>");
	out.print("<td>"+rs.getString(7)+"</td>");
	out.print("<th>DOB</th>");
	out.print("<td>"+rs.getString(8)+"</td>");
	out.print("</tr>");
		
	out.print("<tr>");
	out.print("<th>Experience</th>");
	out.print("<td>"+rs.getString(9)+"</td>");
	out.print("<th>Address</th>");
	out.print("<td>"+rs.getString(10)+"</td>");
	out.print("</tr>");
	
	out.print("<tr>");
	out.print("<th>City</th>");
	out.print("<td>"+rs.getString(11)+"</td>");
	out.print("<th>State</th>");
	out.print("<td>"+rs.getString(12)+"</td>");
	out.print("</tr>");
		
	out.print("<tr>");
	out.print("<th>Country</th>");
	out.print("<td>"+rs.getString(13)+"</td>");
	out.print("<th>Mobile</th>");
	out.print("<td>"+rs.getString(14)+"</td>");
	out.print("</tr>");
	
	
	//out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td>"+rs.getString(14)+"</td></tr>");
	
}
out.print("</table><br><br>");
  
	}catch(Exception e){
		out.print("<font color=white><h1 color='white'>Please ! Login Again First</h1></font>");
		e.printStackTrace();
	}
 }else{
	 out.print("<br><br><br><br><br><br><br><br><br><br><h1>You Are Admin</h1>");
	 
 }

%>

</body>
</html>