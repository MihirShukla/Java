import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Footer extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<div class='footer'>");
		out.print("&copy; copyright 2019-2020");
		out.print("</div>");
	}
}