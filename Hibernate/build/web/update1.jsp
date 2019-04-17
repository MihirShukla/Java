<%-- 
    Document   : update1
    Created on : Apr 1, 2019, 10:20:38 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.vvp.java.*,org.hibernate.*,java.sql.*"%>
<html>
    <%
        if(request.getParameter("id")!=null){
int id = Integer.parseInt(request.getParameter("id"));
String sname = request.getParameter("sname"); 
int semester = Integer.parseInt(request.getParameter("sem")); 
int enroll = Integer.parseInt(request.getParameter("enroll"));

Session ses=NewHibernateUtil.getSessionFactory().openSession();
    Transaction t=ses.beginTransaction();
    Student st=(Student)ses.get(Student.class,id);
    
    st.setPName(sname);
    st.setPEnroll(enroll);
    st.setPSem(semester);
    
    ses.update(st);
    t.commit();
    
  
    response.sendRedirect("Student.jsp");
        }
    %>
</html>
