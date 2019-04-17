import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Logout extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession ses=req.getSession();
		ses.invalidate();

		res.sendRedirect("login");	
	}
}