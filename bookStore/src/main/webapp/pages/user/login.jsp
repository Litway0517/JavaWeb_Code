<%-- 下面是jsp界面包含的一句声明 jsp文件特有的 不用纠结 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员登录页面</title>

    <%--  改为静态包含 --%>
    <%@ include file="/pages/common/header.jsp"%>

</head>

<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>尚硅谷会员</h1>
                    <a href="pages/user/regist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        ${ empty requestScope.msg ? "请输入用户名和密码" : requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <%--
                        这里, action=userServlet是因为, 在上面的<%@ include ... %>这个标签, 包含了一个<base>标签
                        因此, 提供了前面的地址信息(如下), 最后加上userServlet即可, 通过web.xml文件就能讲改次form表单的请求发送到目的Servlet上
                            http://
                            ip:port
                            /工程路径名
                    --%>
                    <form action="userServlet" method="post">
                        <!-- 这是隐藏域, 后端根据此值能够判断前端传过来的动作类型: 登录 -->
                        <input type="hidden" name="action" value="login">

                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username"
<%--                               value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
                               value="${ requestScope.username }"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

    <%--  静态包含页脚内容 --%>
    <%@ include file="/pages/common/footer.jsp"%>

</body>
</html>





