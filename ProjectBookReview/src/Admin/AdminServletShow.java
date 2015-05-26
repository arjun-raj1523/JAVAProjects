package Admin;

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
 * Servlet implementation class AdminServletShow
 */
@WebServlet(
		urlPatterns = { "/AdminServletShow" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/bookreviewsystem"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class AdminServletShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PreparedStatement pst3;
	static Connection con;
	static ResultSet rs,rs1;
	String driver,url,user,password; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServletShow() {
        super();
        // TODO Auto-generated constructor stub
    }
    public  void init() throws ServletException {
  		// TODO Auto-generated method stub
  		ServletConfig sc1=this.getServletConfig(); 
  		driver=getServletConfig().getInitParameter("driver");
  		url=getServletConfig().getInitParameter("url");
  		user=getServletConfig().getInitParameter("user");
  		password=getServletConfig().getInitParameter("password");
  		
      	try {
      		
      		Class.forName(driver);
      		con= DriverManager.getConnection(url,user,password);	
  			pst3= con.prepareStatement("select * from bookreviewsystem.booksearch");
  			
  		} catch (ClassNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      	
  	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		ServletContext sc= this.getServletContext();
		try{
			
			rs=pst3.executeQuery();
			RequestDispatcher rd = sc.getRequestDispatcher("/Adminpage.html");
			rd.include(request, response);
			out.print("<table class=\"table table-striped\">");
			out.print("<tr>"+
					"<td>"+"<b>BookID</b>"+"</td>"+
					"<td>"+"<b>Book Name</b>"+"</td>"+
					"<td>"+"<b>Author</b>"+"</td>"+
					"<tr>");
			while(rs.next()){	
			out.print("<tr>"+
				"<td>"+rs.getString(1)+"</td>"+
				"<td>"+rs.getString(2)+"</td>"+
				"<td>"+rs.getString(3)+"</td>"+
				"<tr>");
			}
			
		}catch(Exception e){}
	}

}
