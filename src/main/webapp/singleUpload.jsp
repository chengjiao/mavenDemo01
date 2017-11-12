<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2017/11/12
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select a file to upload</title>
</head>
<body>
<h1>Select a file to upload</h1>
<form action="singleUpload" enctype="multipart/form-data" method="post">
    Author:<input type="text" name="author"/>
    Select file to Upload<input type="file" name="filename"/>
    <input type="submit" value="Upload">
</form>
</body>
</html>
