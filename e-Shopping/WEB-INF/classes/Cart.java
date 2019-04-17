import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Cart extends HttpServlet
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
		out.print("<html><head>");
		out.print("<link rel='stylesheet' href='css/style.css'/>");
		out.print("</head>");
		out.print("<body>");


		HttpSession ses=req.getSession();
		if(ses.getAttribute("uid")==null)
		{
			res.sendRedirect("login");
		}	
		String uid=ses.getAttribute("uid")+"";
try
{

		if(req.getParameter("pid")!=null)
		{
			String pid=req.getParameter("pid");

			ResultSet rs=stmt.executeQuery("select * from cart where pid="+pid+" and uid="+uid);
			if(rs.next())
			{
				stmt.executeUpdate("update cart set qty=qty+1 where uid="+uid+" and pid="+pid);
			}
			else
			{
				stmt.executeUpdate("Insert into cart(pid,uid) values("+pid+","+uid+")");
			}
		}
		ResultSet rs1=stmt.executeQuery("select a.cart_id,a.qty,b.product,b.product_image,b.product_cost from cart a, product b where a.pid=b.product_id and a.uid="+uid);
		out.print("<table>");
		float tcost=0;
		while(rs1.next())
		{
			out.print("<tr>");
			out.print("<td><img src='images/"+rs1.getString(4)+"' class='cart_img'/></td>");

			out.print("<td>"+rs1.getString(3)+"</td>");
			out.print("<td>"+rs1.getString(2)+"</td>");
			out.print("<td>"+rs1.getString(5)+"</td>");
			float cost=rs1.getInt(2)*rs1.getFloat(5);
			out.print("<td>"+cost+"</td>");
			out.print("<td><a href='deletecart?cartid="+rs1.getInt(1)+"'>delete</a></td>");
			tcost=tcost+cost;
			out.print("</tr>");
		}
		out.print("<tr><td colspan='5'>Total Cost:-"+tcost+"</td></tr>");
		out.print("</table>");
		out.print("</body></html>");

}
catch(Exception ex){}
		

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