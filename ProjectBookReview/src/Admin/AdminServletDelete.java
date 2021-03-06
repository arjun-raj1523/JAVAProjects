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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServletDelete
 */
@WebServlet(
		urlPatterns = { "/AdminServletDelete" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/bookreviewsystem"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class AdminServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 	String BookName,BookID,Author;
     	static PreparedStatement pst3;
		static Connection con;
		static ResultSet rs,rs1;
		String driver,url,user,password; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServletDelete() {
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
			pst3= con.prepareStatement("DELETE FROM `bookreviewsystem`.`booksearch`"
					+ "WHERE BookId=?;");
			
			
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
		HttpSession session=request.getSession();
		ServletContext sc= this.getServletContext();
		BookID =request.getParameter("BookID");
        PrintWriter out= response.getWriter();
		
		try{
			pst3.setString(1,BookID);
			pst3.execute();		
			RequestDispatcher rd = sc.getRequestDispatcher("/Adminpage.html");
			rd.include(request, response);
			out.println("<span class=\"label label-success\">Book Deleted</span>");
			out.println("<script>hideLabel()</script>");
		}catch(Exception e){
			RequestDispatcher rd = sc.getRequestDispatcher("/Adminpage.html");
			rd.include(request, response);
			out.println("<span class=\"label label-danger\">No Book Found</span>");
			out.println("<script>hideLabel()</script>");
			}
	}

}
