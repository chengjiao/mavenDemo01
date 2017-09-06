<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2017/8/28
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public void jspInit(){
        System.out.println("jspInit....");
    }
    public void jspDestroy(){
        System.out.println("jspDestroy....");
    }
%>
<html>
<head>
    <title>jspInit and jspDestroy</title>
</head>
<body>
overriding jspInit and jspDestroy
</body>
</html>
