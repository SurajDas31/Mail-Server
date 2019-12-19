

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEmpDetails
 */
public class UpdateEmpDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpDetails() {
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
		System.out.println("In the UpdateEmpDetails");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
			
	//	String eid=request.getParameter("empid");
		ServletContext context = getServletContext();
		IDsetget obj = (IDsetget)context.getAttribute("idsetget");
		String n = obj.getT1();
	//	String n = "Nar24-abc";
		
		IDsetget obj1 = new IDsetget();
		obj1.setT1(n);
		ServletContext context1 = getServletContext();
		context1.setAttribute("idsetget2", obj1);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			/*Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
			PreparedStatement pss=conn.prepareStatement("select * from signup where eid = ?");
			pss.setString(1, n);
			
			ResultSet rss=pss.executeQuery();
			*/
			
			  //       if(rss.next()){
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mailcastserver","root","root");
				PreparedStatement ps=con.prepareStatement("select * from signup where eid = ?");
			    ps.setString(1, n);
				ResultSet rs=ps.executeQuery();
			
			/* Printing column names */
				out.print("<h1 align='center'>Employee Details Update<h1><br>");
				
				out.print("<table align='center' width=50% border='5px solid' cellpadding=10 cellspacing=10>");	
				
		//	ResultSetMetaData rsmd=rs.getMetaData();
		//	int total=rsmd.getColumnCount();
			
		   
		    /*out.print("<tr>");
			for(int i=1;i<=total;i++)
			{
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");
		
			}
			out.print("</tr>");
			*/
			/* Printing result */
			
			while(rs.next())
			{
				out.print("<form action='Update'>");
				out.print("<tr>");
			    out.print("<th>First Name</th>");
			    out.print("<td><input type='text' size='30px' name='t1' value = '"+rs.getString(3)+"'/></td>");
			    out.print("</tr>");
			    
			    out.print("<tr>");
			    out.print("<th>Last Name</th>"); 
				out.print("<td><input type='text' size='30px' name='t2' value = '"+rs.getString(4)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>Gender</th>");
				out.print("<td><input type='text' size='30px' name='t3' value = '"+rs.getString(7)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>DOB</th>");
				out.print("<td><input type='text' size='30px' name='t4' value = '"+rs.getString(8)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>Experience</th>");
				out.print("<td><input type='text' size='30px' name='t5' value = '"+rs.getString(9)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>Address</th>");
				out.print("<td><input type='text' size='30px' name='t6' value = '"+rs.getString(10)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>City</th>");
				out.print("<td><input type='text' size='30px' name='t7' value = '"+rs.getString(11)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>State</th>");
				out.print("<td><input type='text' size='30px' name='t8' value = '"+rs.getString(12)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>Country</th>");
				out.print("<td><input type='text' size='30px' name='t9' value = '"+rs.getString(13)+"'/></td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<th>Mobile</th>");
				out.print("<td><input type='text' minlength='9' maxlength='9' size='30px' name='t10' value = '"+rs.getString(14)+"'/></td>");
				out.print("</tr>");
				
				//out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11)+"</td><td>"+rs.getString(12)+"</td><td>"+rs.getString(13)+"</td><td>"+rs.getString(14)+"</td></tr>");
				
			}
			
			
			
			out.print("</table><br><br>");
			
			PreparedStatement pss=con.prepareStatement("select * from addemp where eid = ?");
		    pss.setString(1, n);
		    ResultSet rss=pss.executeQuery();
		    out.print("<table align='center' width=50% border='5px solid' cellpadding=10 cellspacing=10>");
		    while(rss.next())
			{
				out.print("<tr>");
			    out.print("<th>Designation</th>");
			    out.print("<td><input type='text' size='30px' name='t11' value = '"+rss.getString(4)+"'/></td>");
			    out.print("</tr>");
			}
		    out.print("</table>");

			
			
			out.print("<input type='submit' value='UPDATE' align='center'/>");
			out.print("<input type='reset' value='reset' align='center'/>");
			out.print("</form>");
			     //    }	
						
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
