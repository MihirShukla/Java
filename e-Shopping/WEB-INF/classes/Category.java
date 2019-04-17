import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Category extends HttpServlet
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
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<html><head>");
		out.print("<link rel='stylesheet' href='css/style.css'/>");
		out.print("</head>");
		out.print("<body>");

		RequestDispatcher rd=req.getRequestDispatcher("/header");
		rd.include(req,res);


		out.print("<div class='products'>");
		try
		{
			rs=stmt.executeQuery("select * from category where product_type_id="+req.getParameter("ptid"));
			while(rs.next())
			{
				out.print("<a href='product?cid="+rs.getInt(1)+"'>");
				out.print("<div class='product'>");
				out.print("<img src='images/"+rs.getString(3)+"'/>");
				
				out.print(rs.getString(2));
				
				out.print("</div>");
				out.print("</a>");	
				
			}
		}
		catch(Exception e)
		{
		}
		out.print("</div>");
		RequestDispatcher rd1=req.getRequestDispatcher("/footer");
		rd1.include(req,res);
		out.print("</body></html>");

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