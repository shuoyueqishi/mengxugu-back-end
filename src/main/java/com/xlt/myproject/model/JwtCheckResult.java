package com.xlt.myproject.model;

import io.jsonwebtoken.Claims;

import java.io.Serializable;

public class JwtCheckResult implements Serializable {
    private static final long serialVersionUID = 3223058115657494105L;
    private boolean success;
    private Claims claims;
    private String errCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "success=" + success +
                ", claims=" + claims +
                ", errCode='" + errCode + '\'' +
                '}';
    }
}
