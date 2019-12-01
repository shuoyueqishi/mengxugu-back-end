package com.xlt.myproject.model;

import com.xlt.myproject.constant.Constant;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class MemberResponse extends BasicResponse implements Serializable {
    private static final long serialVersionUID = -245646394425887394L;
    private List<Member> result;

    public List<Member> getResult() {
        return result;
    }

    public void setResult(List<Member> result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MemberResponse that = (MemberResponse) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), result);
    }

    @Override
    public String toString() {
        return "MemberResponse{" +
                "result=" + result +
                '}';
    }
}
