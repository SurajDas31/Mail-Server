

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
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		System.out.println("In the UPDATE query");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//String id = request.getParameter("t1");
		String n = request.getParameter("t1");
		String n1 = request.getParameter("t2");
		String n2 = request.getParameter("t3");
		String n3 = request.getParameter("t4");
		String n4 = request.getParameter("t5");
		String n5 = request.getParameter("t6");
		String n6 = request.getParameter("t7");
		String n7 = request.getParameter("t8");
		String n8 = request.getParameter("t9");
		String n9 = request.getParameter("t10");
		
		String n10 = request.getParameter("t11");
		
		ServletContext context = getServletContext();
		IDsetget obj = (IDsetget)context.getAttribute("idsetget2");
		String id = obj.getT1();
		
		System.out.println("ID : " + id );
		System.out.println("firstname : " + n );
		System.out.println("lastname : " + n1 );
		System.out.println("gender : " + n2);
		System.out.println("dob : " + n3);
		System.out.println("experience : " + n4 );
		System.out.println("telephone : " + n5 );
		System.out.println("address : " + n6 );
		System.out.println("city : " + n7 );
		System.out.println("state : " + n8 );
		System.out.println("country : " + n9 );
		
		System.out.println("Designation : " + n10 );
		
	//	RequestDispatcher rd= request.getRequestDispatcher("IndexPage.html");
		//rd.forward(request, response);
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			/*Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps1 =  conn1.prepareStatement("select * from addemp where eid = ?");
			ps1.setString(1, id);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()){
			*/
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver", "root", "root");
			PreparedStatement ps =  conn.prepareStatement("update signup set firstname=? , lastname=?  , gender=? , dob=? , experience=? , address=? , city=? , state=? , country=? , telephone=?  where eid = ?");
		       
			     ps.setString(1,n);
				 ps.setString(2,n1);
				 ps.setString(3,n2);
				 ps.setString(4,n3);
				 ps.setString(5,n4);
				 ps.setString(6,n5);
				 ps.setString(7,n6);
				 ps.setString(8,n7);
				 ps.setString(9,n8);
				 ps.setString(10,n9);
				 ps.setString(11,id);
				
				
				 int i = ps.executeUpdate();
				 if(i>0){
					 PreparedStatement pss  =  conn.prepareStatement("update addemp set destination=? where eid = ?");
					 pss.setString(1, n10);
					 pss.setString(2, id);
					 int i1 = pss.executeUpdate();
					 
					 
					 if(i1>0){
				  out.print("<b>Successfully Updated ALL fields</b><br><b>Updated Details of Employee with ID : "+id+"<br><b>Name : "+n+" "+n1);
				 RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);
					 }
				 }
			//}	 
		/*	else{
			out.print("<b>Invalid ID ! Try again with correct ID");
			RequestDispatcher rd = request.getRequestDispatcher("UpdateDetails.jsp");
			rd.include(request, response);
					
			}*/
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
