package com.xlt.myproject.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Member implements Serializable {
    private static final long serialVersionUID = -5992046533967757584L;
    private Long id;
    private String cardNumber;
    private String name;
    private String birthday;
    private Long telephoneNumber;
    private int integral;
    private double money;
    private int paymentType;
    private String address;
    private Date createTime;
    private String createBy;
    private Date updateBy;
    private String lastUpdateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Date updateBy) {
        this.updateBy = updateBy;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                integral == member.integral &&
                Double.compare(member.money, money) == 0 &&
                paymentType == member.paymentType &&
                Objects.equals(cardNumber, member.cardNumber) &&
                Objects.equals(name, member.name) &&
                Objects.equals(birthday, member.birthday) &&
                Objects.equals(telephoneNumber, member.telephoneNumber) &&
                Objects.equals(address, member.address) &&
                Objects.equals(createTime, member.createTime) &&
                Objects.equals(createBy, member.createBy) &&
                Objects.equals(updateBy, member.updateBy) &&
                Objects.equals(lastUpdateBy, member.lastUpdateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardNumber, name, birthday, telephoneNumber, integral, money, paymentType, address, createTime, createBy, updateBy, lastUpdateBy);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", integral=" + integral +
                ", money=" + money +
                ", paymentType=" + paymentType +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateBy=" + updateBy +
                ", lastUpdateBy='" + lastUpdateBy + '\'' +
                '}';
    }
}
