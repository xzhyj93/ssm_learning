<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/30
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>常用注解</h3>
    <a href="anno/testRequestParam">RequestParam</a>

    <br>
<%--    <form action="anno/testRequestBody" method="post">--%>
<%--        用户姓名：<input type="text" name="uname" /><br/>--%>
<%--        用户年龄：<input type="text" name="age" /><br/>--%>
<%--        用户生日：<input type="text" name="date" /><br/>--%>

<%--        <input type="submit" value="提交" />--%>
<%--    </form>--%>

    <a href="anno/testPathVariable/18">TestRequestParam</a>

    <form action="anno/testModelAttribute" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>

        <input type="submit" value="提交" />
    </form>

    <a href="anno/testSessionAttributes">testSessionAttributes</a>

</body>
</html>
