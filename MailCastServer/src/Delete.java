

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
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	//public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	//}

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
		String n = request.getParameter("t11");
		System.out.println(" Inbox delete : "+n);
		String n1 = request.getParameter("t12");
		System.out.println("Sent delete : "+n1);
        		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps = conn.prepareStatement("delete from composemail where datetime=?");
            ps.setString(1, n);		
			int i = ps.executeUpdate();
			if(i>0){
				out.print("<b>Deleted</b>");
				RequestDispatcher rd = request.getRequestDispatcher("Inboxpage.jsp");
				rd.include(request, response);
			}
			else{
				Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				PreparedStatement pss = connn.prepareStatement("delete from composemail where datetime=?");
	            pss.setString(1, n1);		
				int i1 = pss.executeUpdate();
				 if(i1>0){
					 out.print("<b>Deleted</b>");
					 RequestDispatcher rd = request.getRequestDispatcher("Inboxpage.jsp");
					rd.include(request, response);
				 }else{
					 out.print("<b><font color='white'>NOT Deleted</font></b>");
				 }
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
