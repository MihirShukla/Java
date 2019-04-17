<%-- 
    Document   : search
    Created on : Apr 1, 2019, 11:02:25 PM
    Author     : hp
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,org.hibernate.*,com.vvp.java.*"%>
<html>
    <body>
        <a href="Student.jsp" >Go back</a
        <table>
<tr>
<th> Select Category</th>
<th> </th>
<form method="post" action="">

<select name="search_by">
<option value="P_Id">Id</option>
<option value="P_Name">Name</option>
<option value="P_Enroll">Enrollment</option>
<option value="P_Sem">Semester</option>
</select>
<input type="text" name="value" />
<input type="submit" value="Search">

</form>

<%
    if(request.getParameter("value")!=null)
{
    Session ses=NewHibernateUtil.getSessionFactory().openSession();
        Transaction t=ses.beginTransaction();
        Student st=new Student();
        
        String search_by = request.getParameter("search_by");
        String operator = request.getParameter("operator");
        String value = request.getParameter("value");

        Query q=ses.createQuery("FROM Student where "+search_by+" like'"+value+"%'");
        List<Student> ps=q.list();
     
        Iterator it=ps.iterator();
        
        while (it.hasNext()) 
        {
            Student p=(Student)it.next();
        %>

         
        <tr>
            <td>
                <%= p.getPName()%>
                </td>
                <td>
                <%= p.getPEnroll()%>
                </td>
                <td>
                <%= p.getPSem()%>
                </td>
                <td>
                <a href="Update.jsp?pd_id=<%= p.getPId()%>">Update</a>
                </td>
                <td>
                    <a href="Delete.jsp?pd_id=<%= p.getPId()%>">Delete</a>
                </td> 


        </tr>

<% 
    }
    }
%>
</table>


</body>


</html>
