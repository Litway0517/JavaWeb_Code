package com.atguigu.filter;

import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 事务过滤器
 *
 * @author DELL_
 * @date 2022/01/21
 */
public class TransactionFilter implements Filter {

    /**
     * 初始化
     *
     * @param filterConfig 过滤器配置
     * @throws ServletException servlet异常
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 摧毁
     */
    @Override
    public void destroy() {

    }

    /**
     * 做过滤器
     *
     * @param request  请求
     * @param response 响应
     * @param chain    链
     * @throws IOException      IO异常
     * @throws ServletException servlet异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /*
            使用TransactionFilter来管理全局的事物. 所以: 必须让TransactionFilter的try ... catch ... 作为最顶层的异常捕获,
            其他所有的调用时的异常捕获都必须上抛给TransactionFilter, 让这个过滤器知道底层出现了异常, 那么这里进行数据库事物的回滚!
            从而确保了数据库的数据一致性, 多张表再关联的是时候就不会导致, A表的数据插入了, 但是本应该配套的B表却没有插入数据.
            这里是通过的打印调用栈, 发现BaseServlet程序接收到了最后的异常, 因此BaseServlet程序的异常需要外抛给TransactionFilter

            这样做, 能够解决这种情况: 某个业务过程中出现了问题bug, 这是会阻止数据库数据的插入, 因为出现问题时的数据向数据库中插入
            肯定是不安全的, 会导致意想不到的错误. 比如表与表之间的关联性缺失. 导致一个完整的业务有头无尾.
            这些问题大部分出现在req.getRequestDispatcher("/")请求转发, 或者请求重定向之前, 那么错误信息就不能够回显了,
            因此, 下面使用Tomcat的统一信息管理错误的回显.
         */

        try {
            chain.doFilter(request, response);
            // 提交事务
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            // 回滚事务
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();

            // 这里面, 捕获到了异常还是要抛出, 上抛给Tomcat服务器. 否则, 如果出现了错误, Tomcat不能够处理并跳转到错误界面.
            throw new RuntimeException(e);
        }

    }
}

