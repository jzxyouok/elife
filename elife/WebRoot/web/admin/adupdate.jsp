<%@page language="java" import="java.util.*" import="java.sql.*" pageEncoding="GBK" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>�޸����</title>
 </head>
  <body>
   <%
   		request.setCharacterEncoding("GBK");
   	
   		String adname=request.getParameter("adname");
	   	String password=request.getParameter("password");
	    Class.forName("com.mysql.jdbc.Driver");
	   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","0");
	   	Statement stmt=con.createStatement();
	   	
	   	String sql="update administrator set adname='"+adname+"',password='"+password+"' where adname="+adname;
	    int i=stmt.executeUpdate(sql);
	   	if(i==1)
	   	{
	   		out.println("<script language='javaScript'> alert('�޸ĳɹ�������ȷ����ת������Ա�б�');</script>");
	   		response.setHeader("refresh","1;url=adminilist.jsp");
	   	}
	  
	   	stmt.close();
	   	con.close();
    %>
  </body>
</html>


