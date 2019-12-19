

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

import sun.awt.RepaintArea;

/**
 * Servlet implementation class StatusDetails
 */
public class StatusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusDetails() {
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
		
		String n = request.getParameter("empid");
		System.out.println("ID : "+n);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
			PreparedStatement pss=conn.prepareStatement("select * from addemp where eid=?");
			pss.setString(1,n);
			ResultSet rss=pss.executeQuery();
			
			if(rss.next()){
			
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
			PreparedStatement ps = con.prepareStatement("select * from addemp where eid = ?");
			ps.setString(1, n);
			
			ResultSet rs = ps.executeQuery();
			
			
			out.print("<h1 align='center'>Employee Status Details</h1><br>");
			out.print("<table align='center' border=1 cellpadding=10 cellspacing=5>");
			//column name
			ResultSetMetaData rsmd = rs.getMetaData();
			int total = rsmd.getColumnCount();
			out.print("<tr>");
			for(int i = 1;i<=total;i++){
				out.print(" <th> "+rsmd.getColumnName(i)+" </th> ");
			}
			out.print("</tr>");
			
			while(rs.next()){
				out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
			}
			out.print("</table><br><br>");
			out.print("<form action='AdminPage.jsp' method='post'>");
			
			out.print("<input type='submit' value='OK'>");
			out.print("</form>");
			
			
		}else{
			out.print("<b>Invalid ID <br><b>Input correct ID");
			RequestDispatcher rd = request.getRequestDispatcher("viewdetails.jsp");
			rd.include(request, response);
			
		}
			
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
