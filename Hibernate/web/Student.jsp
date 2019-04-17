<%-- 
    Document   : Products
    Created on : Apr 1, 2019, 7:44:53 PM
    Author     : hp
--%>


<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,org.hibernate.*,com.vvp.java.*"%>

<html>
    <%
       
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
%>

</html>
