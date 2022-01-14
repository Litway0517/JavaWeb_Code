<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册</title>

    <%--  改为静态包含 --%>
    <%@ include file="/pages/common/header.jsp"%>

    <script type="text/javascript">

        // 页面加载完成之后
        $(function () {

            // 查询到 注册 按钮并绑定单击事件
            $("#sub_btn").click(function () {
                /*
                    验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                    验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                    验证确认密码：和密码相同
                    邮箱验证：xxxxx@xxx.com
                    验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                 */


                /*
                    验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                        - 获取输入框的内容
                        - 创建正则表达式对象
                        - 使用test方法验证
                        - 提示用户结果
                 */

                // 获取输入框的内容
                var usernameText = $("#username").val();
                // 创建正则表达式  \w是字母数字下划线
                // var usernamePatt = new RegExp("^\w{5,12}$");		// 这种方式不正确, 原因待查
                var usernamePatt = /^\w{5,12}$/;
                // test验证 -> 错误的话提示用户并且不跳转
                if (!usernamePatt.test(usernameText)) {
                    // 提示用户结果
                    $("span.errorMsg").text("用户名不合法!");		// 取反表明是在不匹配的情况下: 提示错误
                    // 停止跳转
                    return false;
                }


                /*
                    验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
                        和上面差不多
                 */
                // 获取输入框的内容
                var passwordText = $("#password").val();
                // 创建正则表达式  \w是字母数字下划线
                // var usernamePatt = new RegExp("^\w{5,12}$");		// 这种方式不正确, 原因待查
                var passwordPatt = /^\w{5,12}$/;
                // test验证 -> 错误的话提示用户并且不跳转
                if (!passwordPatt.test(passwordText)) {
                    // 提示用户结果
                    $("span.errorMsg").text("密码不合法!");		// 取反表明是在不匹配的情况下: 提示错误
                    // 停止跳转
                    return false;
                }


                /*
                    验证确认密码：和密码相同
                        - 获取确认密码的内容
                        - 和密码框中的内容比较
                        - 提示用户结果
                 */
                var repwdText = $("#repwd").val();
                if ((repwdText != passwordText)) {
                    $("span.errorMsg").text("密码和确认密码不一致");
                    return false;
                }


                /*
                    邮箱验证：xxxxx@xxx.com
                        - 先获取邮箱内容
                        - 创建正则表达式
                        - 使用test函数测试
                 */
                var emailText = $("#email").val();
                // 这个邮箱有点难写, 有现成的先用着!
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!(emailPatt.test(emailText))) {
                    $("span.errorMsg").text("邮箱地址不合法!");
                    return false;
                }


                /*
                    验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
                        - 目前仅测试, 验证码框是否有内容
                        - 但是用户仍然能输入非法字符串, 如果都是空格, 也是可以通过的, 这里使用trim函数去空格
                 */
                var codeText = $("#code").val();
                // alert("去空格前: [" + codeText + "]");
                codeText = $.trim(codeText);		// 重新接受一下
                // alert("去空格后: [" + codeText + "]");

                if (codeText == "" || codeText == null) {
                    $("span.errorMsg").text("验证码不能为空!");
                    return false;
                }

                // 只要上面输入的信息合法, 则要删掉提示信息
                $("span.errorMsg").text("");


            });


        });


    </script>


    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>

<body>

<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <!-- 后端根据此值来判断前端的动作 -->
                        <input type="hidden" name="action" value="regist">

                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username" id="username"
<%--                                value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>"/>--%>
                               value="${ requestScope.username }" />
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               autocomplete="off" tabindex="1" name="email" id="email"
<%--                               value="<%=request.getAttribute("username") == null ? "" : request.getAttribute("email")%>"/>--%>
                               value="${ requestScope.email }" />
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" name="code" style="width: 150px;" id="code"/>
                        <img alt="" src="kaptcha" style="float: right; margin-right: 50px; width: 84px; height: 38px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>
                        <!--
                            点击提交, 那么会跳转到form表单上面的action指定的链接!
                            将每一个input中的数据都携带上, 并且所有隐藏域hidden的数据也都携带上, 一并发送到请求的目标地址
                        -->

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




