<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <%@ include file="/view/back/common/include.jsp"%>
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">
<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">S</h1>
        </div>
        <h3>欢迎注册索引账号</h3>
        <p>创建一个S新账户</p>
        <form class="m-t" role="form" action="${ctx}/register" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="userName" placeholder="请输入用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="请输入密码" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="请再次输入密码" required="">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="userPhone" placeholder="请输入电话号码" required="">
            </div>
            <div class="form-group">
                <input type="email" class="form-control" name="userEmail" placeholder="请输入邮箱地址" required="">
            </div>
            <div class="form-group text-left">
                <div class="checkbox i-checks">
                    <label class="no-padding">
                        <input type="checkbox"><i></i> 我同意注册协议</label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>
            <p class="text-muted text-center"><small>已经有账户了？</small><a href="${ctx}/login">点此登录</a>
            </p>
        </form>
    </div>
</div>

<script>
    $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
</script>
</body>
</html>