package com.cpt.common;

import java.io.Serializable;
import java.util.List;
 
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -7710168010225904920L;

    /**
     * 数据列表
     */
    private List<T> rows;
    /**
     * 总记录数
     */
    private long records;
    /**
     * 总页数
     */
    private int total;
    /**
     * 当前页
     */
    private int page;

    public PageResult() {
    }

    public PageResult(List<T> rows, long records, int total, int page) {
        this.rows = rows;
        this.records = records;
        this.total = total;
        this.page = page;
    }

    public static <T> PageResult<T> newPage(List<T> rows, long records, int total, int page) {
        return new PageResult<T>(rows, records, total, page);
    }

    public static <T> PageResult<T> newPageResult(List<T> rows, long records, int pageNo,int pageSize) {
        int totalPages = (int) (records % pageSize == 0 ? records / pageSize : records / pageSize + 1);
        return new PageResult<T>(rows, records, totalPages, pageNo);
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
