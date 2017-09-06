<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2017/8/28
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getProperty and setProperty</title>
</head>
<body>
<jsp:useBean id="employee" class="app03a.Employee"/>
<jsp:setProperty name="employee" property="firstName" value="Abigail"/>
<jsp:getProperty name="employee" property="firstName"/>
</body>
</html>
