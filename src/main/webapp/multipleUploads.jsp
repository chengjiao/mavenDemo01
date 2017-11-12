<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2017/11/12
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select a file to upload</title>
</head>
<body>
<h1>Select a file to upload</h1>
<form action="multipleUploads" enctype="multipart/form-data" method="post">
    Author:<input name="author"/><br/>
    First file to upload<input type="file" name="filename"/><br/>
    Second file to upload<input type="file" name="filename"/><br/>
    <input type="submit" value="Upload"/>

</form>
</body>
</html>
