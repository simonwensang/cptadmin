package com.cpt.common;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

/**
 * Author:harding
 * Date:2016/10/20 13:30
 * Description:分页查询参数对象
 */
public class PageParam implements Serializable {

    private static final long serialVersionUID = -7047857825792876554L;

    /**
     * 当前页
     */
    private int page;
    /**
     * 每页显示记录数
     */
    private int rows;

    /**
     * 排序字段
     */
    private String sidx;

    /**
     * 排序方式 asc desc
     */
    private String sord;

    /**
     * 列排序 = 排序字段 + 排序方式
     */
    private String columnSort;

    private Integer offset;
    private Integer limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getColumnSort() {
        if (StringUtils.isNotEmpty(this.sidx)) {
            this.columnSort = this.sidx + " " + this.sord;
        }
        return columnSort;
    }

    public void setColumnSort(String columnSort) {
        this.columnSort = columnSort;
    }

    public Integer getOffset() {
        return offset = offset == null ? (page - 1) * rows : offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit = limit == null ? this.rows : limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
