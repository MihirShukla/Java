<%-- 
    Document   : delete
    Created on : Apr 1, 2019, 10:41:03 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,org.hibernate.*,com.vvp.java.*"%>
<html>
    <% 
        if(request.getParameter("id")!=null){
    int id = Integer.parseInt(request.getParameter("id"));
    
    Session ses=NewHibernateUtil.getSessionFactory().openSession();
    Transaction t=ses.beginTransaction();
    Student st=(Student)ses.get(Student.class,id);
    ses.delete(st);
    
t.commit();
response.sendRedirect("Student.jsp");
        }        %>
</html>
