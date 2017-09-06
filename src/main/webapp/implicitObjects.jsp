<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2017/8/28
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public Date getTodaysDate(){
        return new java.util.Date();
    }
%>
<html>
<head>
    <title>JSP Implicit Objects</title>
</head>
<body>
<b>Http Headers:</b><br/>
<%
    for (Enumeration<String> e = request.getHeaderNames();e.hasMoreElements();){
        String header = e.nextElement();
        out.println(header+":"+request.getHeader(header)+"<br/>");
    }
%>
<hr>
<%
    out.println("Buffer size:"+response.getBufferSize()+"<br/>");
    out.println("Session id:"+session.getId()+"<br/>");
    out.println("Servlet name:"+config.getServletName()+"<br/>");
    out.println("Server Info:"+application.getServerInfo());
%><br>
    Today is <%=java.util.Calendar.getInstance().getTime()%><br>
    Today is <%=getTodaysDate()%>

</body>
</html>
