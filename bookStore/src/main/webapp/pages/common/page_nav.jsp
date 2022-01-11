<%--
  Created by IntelliJ IDEA.
  User: DELL_
  Date: 2022-1-11
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
  <%-- 将分页的控件添加上去 --%>
  <div id="page_nav">
    <c:if test="${ requestScope.page.pageNo > 1 }">
      <a href="${ requestScope.page.url }&pageNo=1">首页</a>&nbsp;
      <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo - 1 }">上一页</a>&nbsp;
    </c:if>
    <%-- 更改原有代码, 页码的显示换成了新的需求, 见PDF文档.
        <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo - 1 }">${ requestScope.page.pageNo - 1 }</a>&nbsp;
        [${ requestScope.page.pageNo }]&nbsp;
    --%>
    <%--
        再写a超链接标签的href标签的值时, 无论写多长, 都不能换行, 否则的话请求的地址就会莫名其妙出现 空格, 导致访问异常
    --%>
    <%--<a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo + 1 }">${ requestScope.page.pageNo + 1 }</a>&nbsp;--%>

    <%-- TODO: 新需求: 显示 5 个连续的页码，而且当前页码在中间。除了当前页码之外，每个页码都可以点击跳到指定页。 --%>
    <%-- 页码输出的开始 --%>
    <c:choose>
      <%-- 情况1: 如果总的页码数<5, 那么就显示1到最大页码数.  --%>
      <c:when test="${ requestScope.page.pageTotal <= 5 }">
        <c:set var="begin" value="1" />
        <c:set var="end" value="${ requestScope.page.pageTotal }" />
      </c:when>
      <%-- 情况2: 如果总页数>5, 需要进行如下处理. 假设有10页 --%>
      <c:when test="${ requestScope.page.pageTotal > 5 }">
        <%-- 页码数大于5时, 还需要分为三种小情况 --%>
        <c:choose>
          <%-- 小情况1: 页码为前面3个的情况: 1, 2, 3, 页码范围为: 1-5 --%>
          <c:when test="${ requestScope.page.pageNo <= 3 }">
            <c:set var="begin" value="1" />
            <c:set var="end" value="5" />
          </c:when>
          <%-- 小情况2: 当前页码为最后3个: 8, 9, 10 --%>
          <c:when test="${ requestScope.page.pageNo > requestScope.page.pageTotal - 3 }">
            <c:set var="begin" value="${ requestScope.page.pageTotal - 4 }" />
            <c:set var="end" value="${ requestScope.page.pageTotal }" />
          </c:when>
          <%-- 小情况3: 4, 5, 6, 7, 页码范围是: 当前页码-2 到 当前页码+2 --%>
          <c:otherwise>
            <c:set var="begin" value="${requestScope.page.pageNo - 2 }" />
            <c:set var="end" value="${ requestScope.page.pageNo + 2 }" />
          </c:otherwise>
        </c:choose>
      </c:when>
    </c:choose>
    <%-- 页码输出的结束 --%>

    <%-- 代码优化: 因为forEach只执行一次, 因此上面我们只需要记录下来begin和end的值即可, 让forEach在下面执行 --%>
    <c:forEach begin="${ begin }" end="${ end }" var="i">
      <c:if test="${ i == requestScope.page.pageNo }"> 【${ i }】 </c:if>
      <c:if test="${ i != requestScope.page.pageNo }">
        <a href="${ requestScope.page.url }&pageNo=${ i }">${i}</a>
      </c:if>
    </c:forEach>

    <c:if test="${ requestScope.page.pageNo < requestScope.page.pageTotal }">
      <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageNo + 1 }">下一页</a>&nbsp;&nbsp;
      <a href="${ requestScope.page.url }&pageNo=${ requestScope.page.pageTotal }">末页</a>&nbsp;&nbsp;
    </c:if>
    &nbsp;&nbsp;共 ${ requestScope.page.pageTotal } 页, ${ requestScope.page.pageTotalCount } 条记录&nbsp;&nbsp;
    到第<input value="${ requestScope.page.pageNo }" name="pn" id="pn_input"/><label for="pn_input">页</label>
    <input id="searchPageBtn" type="button" value="确定">
  </div>

  <%-- 这一小段js脚本是为了服务, 客户端输入任意一页时的跳转 --%>
  <script type="text/javascript">
    // 当页面加载完成这段js才能够相应, 别忘了, 这点很容易出错误, 而且不容易找出
    $(function () {
      // 当点击确定按钮时的操作
      $("#searchPageBtn").click(function () {
        let inputPageNo = $("#pn_input").val();
        let pageTotal = ${ requestScope.page.pageTotal };
        console.log("页码 -> ", inputPageNo);
        console.log("当前地址栏地址 -> ", location.href);

        if ((inputPageNo < 1) || (inputPageNo > pageTotal)) {
          alert("请输入正确的页码数目! ");
        } else {
          location.href = "${ pageScope.basePath }${ requestScope.page.url }&pageNo=" + inputPageNo;
        }
      });
    });
  </script>
