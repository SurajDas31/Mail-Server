

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
 * Servlet implementation class Forgot
 */
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
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
		String n = request.getParameter("v");
		String n1 = request.getParameter("npassword");
		String n2 = request.getParameter("cpassword");
		
		System.out.println("ID : "+n);
		System.out.println("npassword : "+n1);
		System.out.println("cpassword : "+n2);
		
		
		try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
         PreparedStatement ps = conn.prepareStatement("select * from signup where eid = ?");
         ps.setString(1, n);
         
         ResultSet rs = ps.executeQuery();
         if(rs.next()){
        	 PreparedStatement ps1 = conn.prepareStatement("update signup set npassword = ? , cpassword = ? where eid = ?");
             ps1.setString(1, n1);
             ps1.setString(2, n2);
             ps1.setString(3, n);
             
             int i = ps1.executeUpdate();
             if(i>0){
            	 out.print("<b>Successfully changed password </b><br/><b>Please ! Login Now By New password</b>");
   				  out.print("<br><b>Password = "+n1+"<b>");
					RequestDispatcher rd = request.getRequestDispatcher("IndexPage.jsp");
					rd.include(request, response);
             }
         }else{
        	 out.print("<b>Invalid ID ! Try again with correct ID");
 			RequestDispatcher rd = request.getRequestDispatcher("Forgot.jsp");
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
