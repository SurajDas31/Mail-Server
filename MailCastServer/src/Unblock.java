

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

/**
 * Servlet implementation class Unblock
 */
public class Unblock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unblock() {
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
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps1 =  conn.prepareStatement("select * from addemp where eid = ?");
			
			ps1.setString(1, n);
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()){
				
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				PreparedStatement ps11 =  connn.prepareStatement("select * from addemp where estatus = ? and eid = ?");
				
				
				ps11.setString(1, "A");
				ps11.setString(2, n);
				
				ResultSet rs11 = ps11.executeQuery();
				if(rs11.next()){
					out.print("<b>User Status Already Active of UserID : "+n);
					RequestDispatcher rw = request.getRequestDispatcher("AdminPage.jsp");
					rw.include(request, response);
					
				}else{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				PreparedStatement ps =  conn1.prepareStatement("update addemp set estatus=? where eid=?");
				ps.setString(1,"A");
				ps.setString(2, n);
				
				int i = ps.executeUpdate();
				if(i>0){
					//System.out.println(i);
					out.print("UNBLOCKED <b>UserID : "+n);
					RequestDispatcher rw = request.getRequestDispatcher("AdminPage.jsp");
					rw.include(request, response);
			
				  }
				else{
				out.print("<b> ! Try again with correct EmployeeID !");
				RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);
			  }
				}
			}
			else{
				out.print("<b>Sorry!!!!Can't ubdate status<br><b>Input Correct UserID");
				RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);
			}
				
			
		
	}
		catch(Exception e){
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


