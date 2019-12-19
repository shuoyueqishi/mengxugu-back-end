package com.xlt.myproject.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SupplierResponse extends BasicResponse implements Serializable {
    private static final long serialVersionUID = -8967824823827727183L;
    private List<Supplier> result;
    private Page page;

    public List<Supplier> getResult() {
        return result;
    }

    public void setResult(List<Supplier> result) {
        this.result = result;
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
        return Objects.equals(result, that.result) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), result, page);
    }

    @Override
    public String toString() {
        return "SupplierResponse{" +
                "list=" + result +
                ", page=" + page +
                '}';
    }
}
