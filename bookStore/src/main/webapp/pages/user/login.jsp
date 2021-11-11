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
                        <%=request.getAttribute("msg") == null ? "请输入用户名和密码" : request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <!-- 这是隐藏域, 后端根据此值能够判断前端穿过来的动作类型 -->
                        <input type="hidden" name="action" value="login">

                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username"
                                value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>
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





