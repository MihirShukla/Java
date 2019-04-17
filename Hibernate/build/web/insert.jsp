<%-- 
    Document   : insert
    Created on : Apr 1, 2019, 9:52:11 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,org.hibernate.*,com.vvp.java.*"%>
<html>
    <%
        if(request.getParameter("sname")!=null){

        String sname = request.getParameter("sname");
        int enroll = Integer.parseInt(request.getParameter("enroll")); 
        int sem = Integer.parseInt(request.getParameter("sem"));
        
        Session ses=NewHibernateUtil.getSessionFactory().openSession();
        Transaction t=ses.beginTransaction();
        Student st=new Student();
        st.setPName(sname);
        st.setPEnroll(enroll);
        st.setPSem(sem);
        
        out.print(ses.save(st));
        
        t.commit();
        ses.close();
        response.sendRedirect("Student.jsp");
        }    
        %>
<body>
    <form action="" method="post">
Name:<input type="text" name="sname"><br/> 
Enroll:<input type="text" name="enroll"><br/> 
semester:<input type="text" name="sem"><br/> 
<input type="submit" name="submit" value="insert">
</form>
</body>
</html>
