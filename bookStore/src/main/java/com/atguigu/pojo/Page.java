package com.atguigu.pojo;

import java.util.List;

/**
 * 页面
 *
 * @author DELL_
 * @date 2022/01/09
 */

/**
 * Page是分页的模型, 分页可能分的是, 每一页书, 每一页商户, 每一页订单, 每一页用户等等等等. 因此后面我们需要使用泛型
 * @param <T> T是泛型类型
 */
public class Page<T> {

    /**
     * 页面大小
     */// pageSeize是一个常量, 这是根据我们前端的布局设置的, 每页4条数据
    public static final Integer PAGE_SIZE = 4;

    /**
     * 页面没有
     */
    private Integer pageNo;
    /**
     * 页面大小
     */
    private Integer pageSize = PAGE_SIZE;
    /**
     * 页面总数
     */
    private Integer pageTotalCount;
    /**
     * 页面总
     */
    private Integer pageTotal;
    /**
     * 项目
     */
    private List<T> items;

    /**
     * 获取页面没有
     *
     * @return {@link Integer}
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置页面没有
     *
     * @param pageNo 页面没有
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取页面大小
     *
     * @return {@link Integer}
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置页面大小
     *
     * @param pageSize 页面大小
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取页面总数
     *
     * @return {@link Integer}
     */
    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    /**
     * 设置页面总数
     *
     * @param pageTotalCount 页面总数
     */
    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    /**
     * 获取页面总
     *
     * @return {@link Integer}
     */
    public Integer getPageTotal() {
        return pageTotal;
    }

    /**
     * 设置页面总
     *
     * @param pageTotal 页面总
     */
    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    /**
     * 得到项目
     *
     * @return {@link List}<{@link T}>
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * 设置项
     *
     * @param items 项目
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * 字符串
     *
     * @return {@link String}
     */
    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                '}';
    }
}
