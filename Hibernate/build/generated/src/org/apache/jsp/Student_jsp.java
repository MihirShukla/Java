package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import java.sql.*;
import org.hibernate.*;
import com.vvp.java.*;

public final class Student_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    ");

    Session ses=NewHibernateUtil.getSessionFactory().openSession();
     Query q=ses.createQuery("FROM Student");
     List<Student> ps=q.list();
     
     Iterator it=ps.iterator();
     out.print("<table>");
     out.print("<tr>");
     out.print("<th>"+"Name"+"</th>");
     out.print("<th>"+"Enroll"+"</th>");
     out.print("<th>"+"Sem"+"</th>");
     out.print("</tr>");
     
      while(it.hasNext())
     {
         Student p=(Student)it.next();
         int id=p.getPId();
         out.print("<tr>");
         out.print("<td>"+p.getPId()+"</td>");
         out.print("<td>"+p.getPName()+"</td>");
         out.print("<td>"+p.getPEnroll()+"</td>");
         out.print("<td>"+p.getPSem()+"</td>"); 
         
         out.print("<td>" + "<a href='update.jsp?id=" + id + "'>update</a>" + "</td>");
         out.print("<td>" + "<a href='delete.jsp?id=" + id + "'>delete</a>" + "</td>");
         
         out.print("</tr>");
    }
        out.println("<td>"+"<a href='insert.jsp'>insert</a>"+"</td>");
        out.println("<td>"+"<a href='search.jsp'>search</a>"+"</td>");

    out.print("</table>");

      out.write("\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
