package com.xlt.myproject.model;

import java.io.Serializable;
import java.util.Objects;

public class Supplier implements Serializable {
    private static final long serialVersionUID = -6230345853240432797L;
    private Long id;
    private String code;
    private String name;
    private String contact;
    private String telephone;
    private String email;
    private String address;
    private String remark;
    private int validFlag;
    private String createBy;
    private String creationDate;
    private String lastUpdateBy;
    private String lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(int validFlag) {
        this.validFlag = validFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return validFlag == supplier.validFlag &&
                Objects.equals(id, supplier.id) &&
                Objects.equals(code, supplier.code) &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(contact, supplier.contact) &&
                Objects.equals(telephone, supplier.telephone) &&
                Objects.equals(email, supplier.email) &&
                Objects.equals(address, supplier.address) &&
                Objects.equals(remark, supplier.remark) &&
                Objects.equals(createBy, supplier.createBy) &&
                Objects.equals(creationDate, supplier.creationDate) &&
                Objects.equals(lastUpdateBy, supplier.lastUpdateBy) &&
                Objects.equals(lastUpdateDate, supplier.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, contact, telephone, email, address, remark, validFlag, createBy, creationDate, lastUpdateBy, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", validFlag=" + validFlag +
                ", createBy='" + createBy + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                '}';
    }
}
