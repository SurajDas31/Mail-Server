

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

/**
 * Servlet implementation class UpdateVerify
 */
public class UpdateVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVerify() {
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
		PrintWriter pw = response.getWriter();
		IDsetget obj = new IDsetget();
		String n = request.getParameter("empid");
		
		
		obj.setT1(n);
		ServletContext context = getServletContext();
		context.setAttribute("idsetget", obj);
	
		System.out.println("eid : "+n);
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select * from addemp where eid = ?");
			ps.setString(1, n);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				pw.print("Success in verification<b>UserID : "+n+" <br><b>Update details");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateEmpDetails");
				rd.include(request, response);
			}else{
				pw.print("Sorry!!!! ID is invalid<b>No such employee with this ID exists");
				RequestDispatcher rd = request.getRequestDispatcher("UpdateEmpDetails.jsp");
				rd.include(request, response);
		}
	}
	catch(Exception e1){
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
