

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ViewDetails
 */
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
			
		String eid=request.getParameter("empid");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
			PreparedStatement pss=conn.prepareStatement("select * from addemp where eid=?");
			pss.setString(1,eid);
			ResultSet rss=pss.executeQuery();
			
			if(rss.next()){
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
				PreparedStatement ps=con.prepareStatement("select * from signup where eid=?");
				ps.setString(1,eid);
				ResultSet rs=ps.executeQuery();
			
			/* Printing column names */
				out.print("<h1 align='center'>Employee Details</h1><br>");
				
				out.print("<table align='center' width=50% border=1 cellpadding=10>");	
				
			ResultSetMetaData rsmd=rs.getMetaData();
			int total=rsmd.getColumnCount();
			out.print("<tr>");
		//	out.print("<th>fname</th>");
			for(int i=1;i<=total;i++)
			{
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
		
			}
			out.print("</tr>");
			
			/* Printing result */
			
			while(rs.next())
			{
				out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td>"+rs.getString(14)+"</td></tr>");
				
			}
			out.print("</table><br><br>");
			out.print("<form action='AdminPage.jsp' method='post'>");
			out.print("<input type='submit' value='OK' align='center'>");
			out.print("</form>");
			
			}else{
				out.print("<b>Invalid ID <br><b>Input correct ID");
				RequestDispatcher rd = request.getRequestDispatcher("viewdetails.jsp");
				rd.include(request, response);
				
			}
			
			
		/*	Class.forName("com.mysql.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
			
			PreparedStatement ps1=con1.prepareStatement("select * from ctype where ctype=?");
			ps1.setString(1,subject);
			ResultSet rs1=ps1.executeQuery();
			
											
			out.print("<form action='Order' method='post'>");
			while(rs1.next())
			{
				out.print("<table width=40% border=1>");
				out.print("<tr>");
				out.print("<td width=30%> <input type='checkbox' name='sub' value="+rs1.getString(3)+">"+rs1.getString(3)+"</td>");
				out.print("</tr>");
				out.print("</table>");
			}
			
			
			out.print("<input type='submit' value='Order'>");
			out.print("</form>");
			*/
			
			
			
			
			
			
			
			
			
			
		}catch (Exception e2) {e2.printStackTrace();}
		
		
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
