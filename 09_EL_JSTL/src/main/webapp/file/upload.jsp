<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2021/11/7
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件的上传与下载</title>
</head>
<body>

    <br><br>
    文件的上传
    <hr>
    <form action="" enctype="multipart/form-data" method="post" >
        用户名: <input type="text" name="username" id="name"> <br>
        头像: <input type="file" name="photo" id="upload_photo">

        <input type="submit" value="上传">


    </form>


</body>
</html>
