import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Header extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");

		PrintWriter out=res.getWriter();		
		out.print("<div>");
		out.print("<h1>Shopping Carnival</h1>");
		out.print("<div class='links'>");
		HttpSession ses=req.getSession();
		if(ses.getAttribute("uid")==null)
		{
			out.print("<a href='login'>login</a>");
			out.print("|");
			out.print("<a href='register'>register</a>");
		}
		else
		{
			out.print("<a href='logout'>logout</a>");
			out.print("|");
			out.print("<a href='cart'>view cart</a>");
		}
		
		out.print("</div>");
		out.print("</div>");
	}
}