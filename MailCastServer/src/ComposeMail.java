

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ComposeMail
 */
public class ComposeMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	//public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//	}

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
		
		String n = request.getParameter("toname");
		//String n1 = request.getParameter("fromname");
		String n2 = request.getParameter("subname");
		String n3 = request.getParameter("message");
		System.out.println("to:"+n);
		//System.out.println("from:"+n1);
		System.out.println("subject:"+n2);
		System.out.println("message:"+n3);
		
	/*	ServletContext context = getServletContext();
		EmailSetGet obj = (EmailSetGet)context.getAttribute("emailsetget");
		String n1 = obj.getT1();
		System.out.println("from:"+n1);*/
		Date date = new Date();
		String n4 = date.toString();
		HttpSession hs = request.getSession();
		String n1 = (String)hs.getAttribute("uname");
		System.out.println("from:"+n1);
		
		
		try{
			
			
			/*if(n1.equals(null)){
				out.print("<div background-color='white'>");
				out.print("<font color=white><h1>Login Again First<br>Please Logout And Again Login !!<h1></font>");
                out.print("</div>");
				
			}else{}*/
			Class.forName("com.mysql.jdbc.Driver");	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps =  conn.prepareStatement("insert into composemail values(?,?,?,?,?)");
			ps.setString(1, n);
			ps.setString(2, n1);
			ps.setString(3, n2);
			ps.setString(4, n3);
			ps.setString(5, n4);
			int i = ps.executeUpdate();
			if(i>0){
				//System.out.println(i);
				//out.print("YOUR OFFICIAL ID:"+c);
				//out.print("<script>");
				//out.print("alert('your id is:' +c)");
				//out.print("</script>");
				out.print("<font color=white><h1 color='white'>Sucessfully Send</h1></font>");
				//RequestDispatcher rw = request.getRequestDispatcher("mainpage.jsp");
			
				//rw.forward(request, response);
			}
			
			
							
			
			
		}catch(Exception e1){
			out.print("<font color=white><h1 color='white'>Please ! Login Again First</h1></font>");
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
