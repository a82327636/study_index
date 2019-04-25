<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <%@ include file="/view/back/common/include.jsp"%>
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">S</h1>
        </div>
        <h3>欢迎使用学习索引系统</h3>

        <form class="m-t" role="form" action="${ctx}/login" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名"  name="userAccount" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="password" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            <p class="text-muted text-center"><a href="${ctx}/view/back/register.jsp">注册一个新账号</a>
            </p>
        </form>
    </div>
</div>
</body>
</html>