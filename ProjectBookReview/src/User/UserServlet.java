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
 * Servlet implementation class UserServlet
 */
@WebServlet(
		urlPatterns = { "/UserServlet" }, 
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/bookreviewsystem"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PreparedStatement pst3,pst1;
	static Connection con;
	static ResultSet rs,rs1;
	String driver,url,user,password; 
	String BookName,BookId;
	static int count1=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
			pst3= con.prepareStatement("Select * from booksearch where BookName like ? or BookName LIKE ? or BookName like ?");
			pst1=con.prepareStatement("Select * from bookreviewsystem.reviewtable where ID=?");
  				
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
		RequestDispatcher rd = sc.getRequestDispatcher("/Userpage.html");
		
		try {
			
			
			out.print("<h2 class=welcomeText style=\"color:#1869F3;\"> Welcome "+
			session.getAttribute("firstName")+"</h2>");
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
				
				rd.forward(request, response);
					
				}
			else
			{
			rs.previous();
			rd.include(request, response);
			out.println("<br><p style=\"color:#1869F3;font-size: 30px;font-weight: 400;\">Search Results:</p><br>");
			
			while(rs.next())	{		
				out.println("<div class=\"searchresult\">");
				out.println("<p>");
			out.println("<p id=\"searchShow\">"+"<b>Book ID:</b> "+rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<b>Book Name:</b>"+rs.getString(2)
					+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<b>Author:</b>"+rs.getString(3)+
					"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<button class=\"btn btn-success\" id=\"review-"+count1+"\" onclick=\"addReview("+count1+")\">"
							+ "<span class=\"glyphicon glyphicon-plus\"></span>Add Review</Button>"
					+"<button id=\"reviewShow-"+count1+"\" class=\"btn btn-success\" onclick=\"displayReview("+count1+")\">"
							+ "<span class=\"glyphicon glyphicon-file\"></span>Show review</Button>"
					+"</p>");
			
			out.print("<p id=\"displayReview-"+count1+"\">");
			count1++;
			
			session.setAttribute("bookName",rs.getString(2));
			session.setAttribute("bookId"+count1,rs.getString(1));
			session.setAttribute("Author",rs.getString(3));
			
			pst1.setString(1,rs.getString(1));
			rs1=pst1.executeQuery();
			out.print("<br>"+"<b>Review</b>");
			out.println("<br><br>"+"--------------------");
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
			out.print("<script>$(\"p[id|='displayReview']\").hide();</script>");
			
			out.println("<form method=\"post\" action=\"AddreviewUser\">");
			out.print("<div id=\"reviewText-"+(count1-1)+"\">Review:(Word Length 100)<br/>"+
                      "<textarea id=\"feedback\" name=\"reviewTextarea-"+(count1-1)+"\" rows=\"5\" cols=\"30\" name=\"feedback\"></textarea>"+
                     "</div>");
			out.print("<input type=\"hidden\"  name=\"countVar\" id=\"countVar\" value=\""+(count1-1)+"\" /><br />");
			out.print("<input type=\"hidden\"  name=\"tempVar\" id=\"tempVar\" value=\""+(count1)+"\" /><br />");
			
			out.println("<button class=\"btn btn-success\" id=\"reviewSql-"+(count1-1)+"\" type=\"submit\">"
					+ "<span class=\"glyphicon glyphicon-plus\"></span>Add Review</Button> </form> ");
			out.print("<button class=\"btn btn-danger\" id=\"reviewCancel-"+(count1-1)+"\" onclick=\"reviewCancel("+(count1-1)+")\">"
					+ "<span class=\"glyphicon glyphicon-remove\"></span>Cancel</Button><br><br>");
			out.print("</div>");
			out.print("<script>$(\"div[id|='reviewText']\").hide();</script>");
			out.print("<script>$(\"button[id|='reviewSql']\").hide();</script>");
			out.print("<script>$(\"button[id|='reviewCancel']\").hide();</script>");
			out.print("<p></div>");
			}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	
	public void destroy(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
