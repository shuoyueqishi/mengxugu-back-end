package com.xlt.myproject.model;

import java.io.Serializable;
import java.util.Objects;

public class Page implements Serializable {
    private static final long serialVersionUID = 8798896750104833391L;
    private int currentPage;
    private int pageSize;
    private int total;
    private int totalPages;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage<=0){
            currentPage=1;
        }
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        totalPages = (total%pageSize==0)?total/pageSize:(total/pageSize+1);
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return currentPage == page.currentPage &&
                pageSize == page.pageSize &&
                total == page.total &&
                totalPages == page.totalPages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPage, pageSize, total, totalPages);
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", totalPages=" + totalPages +
                '}';
    }
}
