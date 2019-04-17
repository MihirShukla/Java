import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Login extends HttpServlet
{

	public void init()
	{
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<html><head>");
		out.print("<link rel='stylesheet' href='css/style.css'/>");
		out.print("</head>");
		out.print("<body>");
		out.print("<form method='post'>");
		out.print("<table>");

		out.print("<tr class='title_row'>");
		out.print("<td colspan='2'>Login</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td>Email</td>");
		out.print("<td><input type='email' name='txtemail' id='txtemail'/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td>Password</td>");
		out.print("<td><input type='password' name='txtpwd' id='txtpwd'/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td colspan='2'><button type='submit'>Login</button></td>");
		out.print("</tr>");


		out.print("<tr>");
		out.print("<td colspan='2'><a href='register.html'>New user?</a></td>");
		out.print("</tr>");

		out.print("</table>");
		out.print("</form>");
		out.print("</body></html>");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();

		String n=req.getParameter("txtemail");
		String p=req.getParameter("txtpwd");
		if(n.equals(""))
		{
			out.print("email must not be empty");
			out.print("try <a href='login'>again</a>");
		}
		else if(p.equals(""))
		{
			out.print("password must not be empty");
			out.print("try <a href='login'>again</a>");
		}
		else
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
				PreparedStatement pstmt=con.prepareStatement("select * from users where email=? and password=?");
				pstmt.setString(1,n);
				pstmt.setString(2,p);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{
					HttpSession s=req.getSession();
					s.setAttribute("uid",rs.getInt(1));
					s.setAttribute("uname",rs.getString(2));
					s.setAttribute("uemail",n);
					res.sendRedirect("producttype");
				}
				else
				{
					out.print("Invalid email or password");
					out.print("try <a href='login'>again</a>");
				}
			}
			catch(Exception ex)
			{
			}
		}

		
	}
	public void destroy()
	{
	}
}