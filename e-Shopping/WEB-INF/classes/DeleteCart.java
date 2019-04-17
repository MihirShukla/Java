import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteCart extends HttpServlet
{
	Connection con;
	Statement stmt;
	ResultSet rs;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
			stmt=con.createStatement();
		}
		catch(Exception e)
		{
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		try
		{
			stmt.executeUpdate("delete from cart where cart_id="+req.getParameter("cartid"));
			res.sendRedirect("cart");
		}
		catch(Exception ex)
		{
		}
		

	}
	public void destroy()
	{
		try
		{
			con.close();
		}
		catch(Exception e)
		{
		}
	}
}