<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>

	<%--  改为静态包含 --%>
	<%@ include file="/pages/common/header.jsp"%>

</head>
<body>
	电子产品
	<a href="http://localhost:8080/cartItem?action=addItem">电子产品</a>

        <%-- 静态包含分页控件, 地址由后台进行控制 --%>
        <%@ include file="/pages/common/page_nav.jsp"%>
        <%--
            这是被包含界面的编码格式:
                <%@ page contentType="text/html;charset=UTF-8" language="java" %>
            这是包含界面(即本界面)的contentType格式:
                <%@ page contentType="text/html; charset=UTF-8" %>

            两者因为一个空格的原因, 导致后端报错.
        --%>




	<%--  静态包含页脚内容 --%>
	<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>
