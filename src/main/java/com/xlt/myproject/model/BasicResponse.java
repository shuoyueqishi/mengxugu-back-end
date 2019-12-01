package com.xlt.myproject.model;

import com.xlt.myproject.constant.Constant;

import java.io.Serializable;
import java.util.Objects;

public class BasicResponse implements Serializable {
    private static final long serialVersionUID = 3133901045675557228L;
    private String message;
    private String code;
    private Constant.Status status;

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
        BasicResponse that = (BasicResponse) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(code, that.code) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, code, status);
    }

    @Override
    public String toString() {
        return "BasicResponse{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
