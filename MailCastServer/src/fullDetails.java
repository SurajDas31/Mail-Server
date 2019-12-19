

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fullDetails
 */
public class fullDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fullDetails() {
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
		
			
	//	String eid=request.getParameter("empid");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
				PreparedStatement ps=con.prepareStatement("select * from signup");
				//ps.setString(1,eid);
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
			
			
			
		}catch(Exception e){
			e.printStackTrace();
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
