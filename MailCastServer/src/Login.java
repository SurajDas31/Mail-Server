

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		PrintWriter pw = response.getWriter();
		String n = request.getParameter("t1");
		String n1 = request.getParameter("t2");
		
		System.out.println("Username : "+n);
		System.out.println("Password : "+n1);
		
		//context
		/*EmailSetGet obj = new EmailSetGet();
		obj.setT1(n);
		ServletContext context = getServletContext();		
		//obj.setT2(n1);
		context.setAttribute("emailsetget", obj);*/
		
		HttpSession hs = request.getSession();
		hs.setAttribute("uname", n);
		
		
		try{
			if(n.equals("admin@techno.com")&&n1.equals("admin123")){
				
				pw.print("<b>Admin logged in with ID</b> : "+n);
				
				  RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
				  rd.include(request, response);
				
			}else{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select * from signup where email = ? and npassword = ?"); 
			ps.setString(1, n);
			ps.setString(2, n1);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				PreparedStatement ps1 =  conn1.prepareStatement("select * from addemp where estatus = ? and email = ?");
				
				ps1.setString(1, "A");
				ps1.setString(2, n);
				
				ResultSet rs1 = ps1.executeQuery();
				  if(rs1.next()){
			      pw.print("<font color='white'>");
				  pw.print("<b>user logged in with UserID </b> : "+n);
				  pw.print("</font>");
				  RequestDispatcher rd = request.getRequestDispatcher("mainpage.jsp");
				  rd.include(request, response);
				  pw.close();
			                    }
			                      else{
				        pw.print("<b>User has Currently InActive Status<br><b>Contact your Admin");
				        RequestDispatcher rd = request.getRequestDispatcher("IndexPage.jsp");
				        rd.include(request, response);
				                       }
				
			}else{
				pw.print("<b>SignUp first Please OR Input correct UserID and Password !</b>");
				RequestDispatcher rd = request.getRequestDispatcher("IndexPage.jsp");
				rd.include(request, response);
                 }
			
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
