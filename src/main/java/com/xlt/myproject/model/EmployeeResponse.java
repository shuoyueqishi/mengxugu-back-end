package com.xlt.myproject.model;

import com.xlt.myproject.constant.Constant;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class EmployeeResponse implements Serializable {

    private static final long serialVersionUID = 8423532841989770880L;
    private List<Employee> result;
    private String message;
    private String code;
    private Constant.Status status;

    public List<Employee> getResult() {
        return result;
    }

    public void setResult(List<Employee> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Constant.Status getStatus() {
        return status;
    }

    public void setStatus(Constant.Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeResponse that = (EmployeeResponse) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(message, that.message) &&
                Objects.equals(code, that.code) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, message, code, status);
    }
}
