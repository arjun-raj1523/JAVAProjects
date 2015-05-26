package Search;

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
 * Servlet implementation class Searchservlet
 */
@WebServlet(
		urlPatterns = { "/Searchservlet" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/bookreviewsystem"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class Searchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PreparedStatement pst3,pst1;
	static Connection con;
	static ResultSet rs,rs1;
	String driver,url,user,password; 
	String BookName,BookId;
	static int count=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchservlet() {
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
      		pst3= con.prepareStatement("Select * from booksearch where BookName like ? or BookName like ? or BookName like ?");
  			pst1=con.prepareStatement("Select * from reviewtable where ID=?");
  				
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
		HttpSession session=request.getSession();
		ServletContext sc= this.getServletContext();
		BookName =request.getParameter("BookName");
		PrintWriter out= response.getWriter();
		
		try {
			
					pst3.setString(1,BookName+"%");
					pst3.setString(2,"%"+BookName+"%");
					pst3.setString(3,"%"+BookName);
					rs=pst3.executeQuery();	
					if(!rs.next())
					{
					out.print("<script> "
							+ " alert(\"No such Book Found\"); "
							+ " "
							+ "</script>");
					RequestDispatcher rd = sc.getRequestDispatcher("/search.html");
					rd.include(request, response);
						
					}
				else
				{
				    rs.previous();
				    RequestDispatcher rd = sc.getRequestDispatcher("/search.html");
					rd.include(request, response);
					out.println("<br><p style=\"color:#1869F3;font-size: 30px;font-weight: 400;\">Search Results:</p><br>");
					out.print("<button class=\"btn btn-info\" onClick=\"newDoc()\">Add Review</button><br><p style=\"color:#1869F3;\"><b>Click on Tabs to SEE Review</b></p>");
					//out.print("<button class=\"btn btn-info\" onClick=\"window.navigate('Form.html')\">Add Review</button><br>");
				while(rs.next())				
				{
					out.println("<div class=\"searchresult\">");
					out.println("<p id=\"searchShow\" onclick=\"searchShow("+count+")\">"+"<b>Book ID:</b> "+rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<b>Book Name:</b> "+rs.getString(2)+"&nbsp;&nbsp;&nbsp;&nbsp;"
					+"<b>Author:</b> "+rs.getString(3)+"</p>");
					out.print("<p id=\"hideReview-"+count+"\">");
					count++;
					out.print("<br>"+"<b>Review</b>");
					out.println("<br><br>"+"--------------------");
					session.setAttribute("bookName",rs.getString(2));
					session.setAttribute("bookId",rs.getString(1));
					session.setAttribute("Author",rs.getString(3));					
					pst1.setString(1,rs.getString(1));
					rs1=pst1.executeQuery();	
					while(rs1.next()){
					if(rs1.getString(2).equals("-"))
						out.println("<br>No review");
					else			
					{
						
						out.println("<br>"+rs1.getString(2));
						out.println("<br>"+"--------------------");
						
					}
					}
					out.print("</p>");
					out.print("<script>$(\"p[id|='hideReview']\").hide();</script>");
					out.print("</div>");
				}
				}
		}catch(Exception e){
			
		}
	}

}
