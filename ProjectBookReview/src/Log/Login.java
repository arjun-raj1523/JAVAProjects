package Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(
		urlPatterns = { "/Login" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/bookreviewsystem"),
				@WebInitParam(name = "user", value = "root"),
				@WebInitParam(name = "password", value = "root")
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String eid,pass;
	static PreparedStatement pst3;
	static Connection con;
	String driver,url,user,password;
	int noOfUser;
	Map cookieMap = new HashMap();
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
			pst3= con.prepareStatement("Select * from login where EmpId=?");
				
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
	protected void  doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 eid=request.getParameter("eid");
		 pass=request.getParameter("pass");
		PrintWriter out= response.getWriter();
		HttpSession session= request.getSession();
		
		try {
				pst3.setString(1,eid);
			ResultSet rs=pst3.executeQuery();		
			rs.next();
			if(rs.getString(4).equals("Admin")){
			if(pass.equals(rs.getString(3))){
				ServletContext sc= this.getServletContext();
				session.setAttribute("firstName",rs.getString(2));
			    Cookie ck[]=request.getCookies();  
			   if(request.getCookies()==null)
			   {
				   System.out.println("No cookeis");
			   }
			   else{
			    for(int i=0;i<ck.length;i++){  
			     System.out.println(ck[i].getName()+" "+ck[i].getValue());  
			    }  
			   }
				RequestDispatcher rd = sc.getRequestDispatcher("/Adminpage.html");
				rd.include(request,response);	
			
				if(session.getAttribute("noOfUser")==null)
					System.out.println("noOfUser = 0");
				else
					{
					noOfUser=(int) session.getAttribute("noOfUser");	
					System.out.println("noOfUser ="+noOfUser);
					
					}
			}
			else{
				ServletContext sc= this.getServletContext();
				
				 RequestDispatcher rd = sc.getRequestDispatcher("/Form.html");
				 rd.include(request,response);
				 out.print("<span class=\"label label-danger\">Wrong Password</span>");
				 out.println("<script>hideLabel()</script>");
				
			}
			}
			else{
				if(pass.equals(rs.getString(3))){
					
					Cookie cookie = new Cookie(rs.getString(2), rs.getString(2));
					response.addCookie(cookie);
					ServletContext sc= this.getServletContext();
					RequestDispatcher rd = sc.getRequestDispatcher("/Userpage.html");
					noOfUser++;
					session.setAttribute("noOfUser",noOfUser);
					session.setAttribute("firstName",rs.getString(2));
					out.println("<script> document.getElementById(\"welcomeTag\").innerHTML="+rs.getString(2)+"</script>");
					out.print("<h2 class=welcomeText style=\"color:#1869F3;\">Welcome "+rs.getString(2)+"</h2>");
					rd.include(request,response);	
					
					
				}
				else
				{
					 ServletContext sc= this.getServletContext();
					 RequestDispatcher rd = sc.getRequestDispatcher("/Form.html");
					 rd.include(request,response);
					 out.print("<span class=\"label label-danger\">Wrong Password</span>");
					 out.println("<script>hideLabel()</script>");
				}
				}
				
			
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			 ServletContext sc= this.getServletContext();
			 RequestDispatcher rd = sc.getRequestDispatcher("/Form.html");
				rd.include(request,response);
				out.print("<span class=\"label label-danger\">INVALID</span>");
				out.println("<script>hideLabel()</script>");
		}
		
	}
	public  void destroy(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
