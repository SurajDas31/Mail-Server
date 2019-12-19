<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*" %>
 <%@ page errorPage="mainPageerrorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
<link rel="stylesheet" href="style.css"></link>

</head>
<body style="background-image:url('first.jpg')">
<!--   <table>
<tr>
<th><span class="tag" style="background-color: cyan">From::</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th></tr>
<tr> 
<th><span class="tag">Subject::</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th></tr>
<tr>
<th><span class="tag">Message::</span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th></tr>
</table>
-->
<%
HttpSession hs = request.getSession();
String n = (String)hs.getAttribute("uname");
System.out.println("from:"+n);
try{

	if(n.equals(null)){
		System.out.println("frommmmmmmm:"+n);
		out.print("<div background-color='white'>");
		out.print("<font color=white><h1>Login Again First<br>Please Logout And Again Login !!<h1></font>");
	    out.print("</div>");
	}
	Class.forName("com.mysql.jdbc.Driver");
	
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
		PreparedStatement ps=con.prepareStatement("select * from composemail where mailto = ?");
		ps.setString(1,n);
		ResultSet rs=ps.executeQuery();
	
	/* Printing column names */
		out.print("<h1 align='center'>Your Inbox is Here</h1><br>");
		
		out.print("<table align='center' border='2px dashed' cellpadding=10 >");	
		
//	ResultSetMetaData rsmd=rs.getMetaData();
//	int total=rsmd.getColumnCount();
//	out.print("<tr>");
//	out.print("<th>fname</th>");
	//for(int i=1;i<=total;i++)
//	{
	//	out.print("<th>"+rsmd.getColumnName(i)+"</th>");

//	}
//	out.print("</tr>");
	
	/* Printing result */
	out.print("<tr>");
	out.print("<th>From</th>");
	out.print("<th>Subject</th>");
	out.print("<th>Message</th>");
	out.print("<th>Time</th>");
	out.print("<th>Delete</th>");
	out.print("</tr>");
	while(rs.next())
	{
	//	out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
	
	
	out.print("<tr>");
	out.print("<td>"+rs.getString(2)+"</td>");
	out.print("<td>"+rs.getString(3)+"</td>");
	out.print("<td>"+rs.getString(4)+"</td>");
	out.print("<td>"+rs.getString(5)+"</td>");
	out.print("<td><form action='Delete' method='post'>");
	out.print("<input type='checkbox' name='t11' value = '"+rs.getString(5)+"'/>");
	out.print("<input type='submit' value='Dlt' align='center'>");
	out.print("</form></td>");
	out.print("</tr>");
	
	
	
	
}
	out.print("</table><br><br>");
	/*out.print("<form action='Delete' method='post'>");
	out.print("<input type='submit' value='Dlt' align='center'>");
	out.print("</form>");*/

	
}catch(Exception e){
	out.print("<font color=white><h1 color='white'>Please ! Login Again First</h1></font>");
	e.printStackTrace();
}

%>
</body>
</html>