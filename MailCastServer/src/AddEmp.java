

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
 * Servlet implementation class AddEmp
 */
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmp() {
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
		
		String n = request.getParameter("name");
		String n1 = request.getParameter("name1");
		String n2 = request.getParameter("name2");
		
		System.out.println("eid : "+n1 );
		System.out.println("ename : "+n );
		System.out.println("destination : "+n2 );
		
		String n3 = n.substring(0, 3);
		String n4 = n1.substring(0, 3);
		String n5 = n2.substring(0, 3);
		
		System.out.println("Neweid : "+n3 );
		System.out.println("Newename : "+n4 );
		System.out.println("NewDestination : "+n5 );
		
		String n6 = n3.concat(n4.concat(n5));
		
		System.out.println("Concat : "+n6);
		
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps1 =  conn.prepareStatement("select * from addemp where eid = ?");
			
			ps1.setString(1, n6);
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()){
				out.print("<b>ID already exist ! Try again !");
				RequestDispatcher rd = request.getRequestDispatcher("AddEmp.jsp");
				rd.include(request, response);
			}else{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
				PreparedStatement ps =  conn1.prepareStatement("insert into addemp(eid,ename,estatus,destination)values(?,?,?,?)");
				ps.setString(1, n6);
				ps.setString(2, n);
				ps.setString(3, "A");
				ps.setString(4, n2);
				
				int i = ps.executeUpdate();
				if(i>0){
					//System.out.println(i);
					out.print("Success");
					out.println("<b>Unique ID is : "+n6);
					RequestDispatcher rw = request.getRequestDispatcher("AdminPage.jsp");
					rw.include(request, response);
			
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
