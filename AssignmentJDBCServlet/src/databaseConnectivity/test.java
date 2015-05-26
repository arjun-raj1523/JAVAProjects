package databaseConnectivity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/emp"),
				@WebInitParam(name = "user", value = "root"),
				@WebInitParam(name = "password", value = "root")
		})
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement pst3;
	String driver,url,user,password;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException{

    	ServletConfig sc1=this.getServletConfig(); 
		driver=getServletConfig().getInitParameter("driver");
		url=getServletConfig().getInitParameter("url");
		user=getServletConfig().getInitParameter("user");
		password=getServletConfig().getInitParameter("password");
		
    	try {
    		
    		Class.forName(driver);
    		Connection con= DriverManager.getConnection(url,user,password);	
			pst3= con.prepareStatement("Select * from login where Empid=?");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String eid=request.getParameter("eid");
		String pass=request.getParameter("pass");
		PrintWriter out= response.getWriter();
		
		
		try {
				pst3.setString(1,eid);
			ResultSet rs=pst3.executeQuery();		
			rs.next();
			if(eid.equals("1")){
			if(pass.equals(rs.getString(2))){
				ServletContext sc= this.getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/Userpage.html");
				rd.include(request,response);	
				out.print("success");
				
			}
			else
				out.print("fail");
			}
			else{
				if(pass.equals(rs.getString(2))){
					ServletContext sc= this.getServletContext();
					RequestDispatcher rd = sc.getRequestDispatcher("/adminpage.html");
					rd.include(request,response);	
				}
				else
					out.print("Invalid Password");
				}
				
			
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			 out.print("No such Credentials");
			e.printStackTrace();
		
		}
	}
}
