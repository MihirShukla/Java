import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Register extends HttpServlet
{
	Connection con;
	PreparedStatement stmt;
	vnmki=Aajalvvcldlkjfdsjk;
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();

		String n=req.getParameter("txtnm");
		String e=req.getParameter("txtemail");
		String p=req.getParameter("txtpwd");
		String cp=req.getParameter("txtcpwd");
		if(n.equals(""))
		{
			out.print("name must not empty");
			out.print("<br>");
			out.print("click here to register<a href='register.html'>again</a>");
		}
		else if(e.equals(""))
		{
			out.print("email must not empty");
			out.print("<br>");
			out.print("click here to register<a href='register.html'>again</a>");
		}
		else if(p.equals(""))
		{
			out.print("password must not empty");
			out.print("<br>");
			out.print("click here to register<a href='register.html'>again</a>");
		}
		else if(cp.equals(""))
		{
			out.print("confirm password must not empty");
			out.print("<br>");
			out.print("click here to register<a href='register.html'>again</a>");
		}
		else if(!p.equals(cp))
		{
			out.print("password and confirm passwortd do not match");
			out.print("<br>");
			out.print("click here to register<a href='register.html'>again</a>");				}
		else
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","");
				
		PreparedStatement pstmt=con.prepareStatement("select * from users where email=?");
		pstmt.setString(1,e);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			out.print("email already registered");
			out.print("<br>");
			out.print("click here to register<a href='register.html'>again</a>");		
		}
		else
		{

				stmt=con.prepareStatement("insert into users(name,email,password) values(?,?,?)");
				stmt.setString(1,n);
				stmt.setString(2,e);
				stmt.setString(3,p);
				int no=stmt.executeUpdate();
				if(no!=0)
				{
					out.print("registered successfully<br>");
					out.print("click here to <a href='login'>login</a>");
				}
				else
				{
					out.print("registered failed ");
					out.print("<a href='register.html'>try again</a>");	
				}
			}


			}
			catch(Exception ex)
			{
				out.print(ex.getMessage());
			}

		}
		
	}

}