package User;

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
 * Servlet implementation class AddreviewUser
 */
@WebServlet(
		urlPatterns = { "/AddreviewUser" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/bookreviewsystem"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class AddreviewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PreparedStatement pst3;
	static Connection con;
	static ResultSet rs;
	String driver,url,user,password,Review,Author; 
	String temp,temp1;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddreviewUser() {
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
			
			 pst3=con.prepareStatement("INSERT INTO `bookreviewsystem`.`reviewtable` (`ID`,`Review`) VALUES (?,?);");	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();	
		
		ServletContext sc= this.getServletContext();
		temp=request.getParameter("countVar");
		temp1=request.getParameter("tempVar");
		Review =request.getParameter("reviewTextarea-"+temp);
		
		try{
			
			
			pst3.setString(1,session.getAttribute("bookId"+temp1).toString());
			pst3.setString(2,Review);
			pst3.execute();			
			out.print("<h2 class=welcomeText style=\"color:white\"> Welcome "+
					session.getAttribute("firstName")+"</h2>");
			RequestDispatcher rd = sc.getRequestDispatcher("/Userpage.html");
			
			rd.include(request, response);
			out.println("<span class=\"label label-success\">Success</span>");
		}catch(Exception e){
			e.printStackTrace();
			RequestDispatcher rd = sc.getRequestDispatcher("/Userpage.html");
			rd.include(request, response);
			out.println("<span class=\"label label-danger\">UnSuccessful</span>");
		}
	}

}
