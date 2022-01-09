package com.atguigu.pojo;

/**
 * 页面
 *
 * @author DELL_
 * @date 2022/01/09
 */
public class Page {

    // pageSeize是一个常量, 这是根据我们前端的布局设置的, 每页4条数据
    public static final Integer PAGE_SIZE = 4;

    /**
     * 页面编号
     */
    private Integer pageNo;
    /**
     * 页面大小
     */
    private Integer pageSize = PAGE_SIZE;
    /**
     * 总记录数
     */
    private Integer pageTotalCount;
    /**
     * 总页数
     */
    private Integer pageTotal;
    /**
     * 项目
     */
    private Integer items;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }


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
