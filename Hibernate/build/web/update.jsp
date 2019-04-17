<%-- 
    Document   : update
    Created on : Apr 1, 2019, 10:08:08 PM
    Author     : hp
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,org.hibernate.*,com.vvp.java.*"%>
<html>
<%
    Session ses=NewHibernateUtil.getSessionFactory().openSession();
    Transaction t=ses.beginTransaction();
    Student st=new Student();
    String id = request.getParameter("id");
    Query q=ses.createQuery("FROM Student s WHERE s.PId=" + id);
    List<Student> ps=q.list();
    Iterator it=ps.iterator();
    
    if(it.hasNext())
    {
        Student s=(Student)it.next();
%>

<body>  
<form action="update1.jsp?id=<%= s.getPId()%>" method="post">
Name:<input type="text" value="<%= s.getPName()%>" name="sname"><br/> 
Enroll:<input type="text" value="<%= s.getPEnroll() %>" name="enroll"><br/>
Semester:<input type="text" value="<%= s.getPSem()%>" name="sem"><br/> 

<input type="submit" name="submit" value="Update">
</form>

<%
    t.commit();
    ses.close();
}
%>
</body>
</html> 

</html>
