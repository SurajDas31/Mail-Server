

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sun.rmi.server.Dispatcher;
import java.sql.*;
/**
 * Servlet implementation class Test
 */

public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("In the init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("In the Destroy");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In the service");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("firstname");
		String n1 = request.getParameter("lastname");
		String n2 = request.getParameter("email");
		String n3 = request.getParameter("npassword");
		String n4 = request.getParameter("cpassword");
		String n5 = request.getParameter("eid");
		String n6 = request.getParameter("gender");
		String n7 = request.getParameter("dob");
		String n8 = request.getParameter("experience");
		String n9 = request.getParameter("telephone");
		String n10 = request.getParameter("address");
		String n11 = request.getParameter("city");
		String n12 = request.getParameter("state");
		String n13 = request.getParameter("country");
		
		System.out.println("eid : " + n5 );
		System.out.println("email : " + n2 );
		System.out.println("firstname : " + n );
		System.out.println("lastname : " + n1 );
		System.out.println("npassword : " + n3 );
		System.out.println("cpassword : " + n4);
		System.out.println("gender : " + n6);
		System.out.println("dob : " + n7);
		System.out.println("experience : " + n8 );
		System.out.println("telephone : " + n9 );
		System.out.println("address : " + n10 );
		System.out.println("city : " + n11 );
		System.out.println("state : " + n12 );
		System.out.println("country : " + n13 );
		
	//	RequestDispatcher rd= request.getRequestDispatcher("IndexPage.html");
		//rd.forward(request, response);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps1 =  conn.prepareStatement("select * from addemp where eid = ?");
			
			ps1.setString(1, n5);
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()){
				         Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				         PreparedStatement ps11 =  connn.prepareStatement("select * from signup where email = ?");
				
				         ps11.setString(1, n2);
				
				         ResultSet rss = ps11.executeQuery();
				
 			                             if(rss.next()){
 			                            	 out.print("<b>Email ID already Exist<br>Try Using Different UserName");
 			                            	 RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
 			                            	 rd.include(request, response);
 			                             }	else{
				
				
				Class.forName("com.mysql.jdbc.Driver");
				 Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				 PreparedStatement ps=conn1.prepareStatement("insert into SignUp(eid,email,firstname,lastname,npassword,cpassword,gender,dob,experience,address,city,state,country,telephone)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				 ps.setString(1,n5);
				 ps.setString(2,n2);
				 ps.setString(3,n);
				 ps.setString(4,n1);
				 ps.setString(5,n3);
				 ps.setString(6,n4);
				 ps.setString(7,n6);
				 ps.setString(8,n7);
				 ps.setString(9,n8);
				 ps.setString(10,n10);
				 ps.setString(11,n11);
				 ps.setString(12,n12);
				 ps.setString(13,n13);
				 ps.setString(14,n9);
				
				 int i = ps.executeUpdate();
				 if(i>0){
					 Connection connn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
						PreparedStatement ps111 =  connn1.prepareStatement("update addemp set email = ? where eid = ?");
					 
						ps111.setString(1, n2);
						ps111.setString(2, n5);
						
						int i1 = ps111.executeUpdate();
						   if(i1>0){
				           out.print("<b>Successfully Registred </b><br/><b>Please ! Login Now By</b>");
				           out.print("<br><b>Username = "+n2+"<b>");
				           out.print("<br><b>Password = "+n3+"<b>");
					         RequestDispatcher rd = request.getRequestDispatcher("IndexPage.jsp");
					         rd.include(request, response);
						           }
				       }
 			                             }
			}else{
			out.print("<b>Invalid ID ! Try again with correct ID");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.include(request, response);
					
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
