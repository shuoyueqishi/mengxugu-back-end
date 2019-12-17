package com.xlt.myproject.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SupplierResponse extends BasicResponse implements Serializable {
    private List<Supplier> list;
    private Page page;

    public List<Supplier> getList() {
        return list;
    }

    public void setList(List<Supplier> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SupplierResponse that = (SupplierResponse) o;
        return Objects.equals(list, that.list) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), list, page);
    }

    @Override
    public String toString() {
        return "SupplierResponse{" +
                "list=" + list +
                ", page=" + page +
                '}';
    }
}
