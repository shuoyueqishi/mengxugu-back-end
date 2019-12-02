package com.xlt.myproject.model;

import com.xlt.myproject.constant.Constant;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MemberResponse extends BasicResponse implements Serializable {
    private static final long serialVersionUID = -245646394425887394L;
    private List<Member> result;
    private Page page;

    public List<Member> getResult() {
        return result;
    }

    public void setResult(List<Member> result) {
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
        MemberResponse response = (MemberResponse) o;
        return Objects.equals(result, response.result) &&
                Objects.equals(page, response.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), result, page);
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "result=" + result +
                ", page=" + page +
                '}';
    }
}
