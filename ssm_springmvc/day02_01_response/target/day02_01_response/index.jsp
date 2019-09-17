<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/2
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function handleClick() {
            // alert("aaaa")

            let myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json")
            fetch("user/testAjax", {
                method: 'POST',
                body: '{"uname": "hehe", "age": "30"}',
                headers: myHeaders
            }).then(res =>{
                alert(res);
                res.json().then(json => {
                    alert(JSON.stringify(json))
                })
                
            })
        }

    </script>
</head>
<body>
321321321

<button onclick="handleClick()">点击加载</button>
</body>
</html>
