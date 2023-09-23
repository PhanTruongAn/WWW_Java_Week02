package com.example.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "cust_id")
    private long custId;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "cust_name")
    private String custName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "customerByCustId")
    private Collection<Orders> ordersByCustId;

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (custId != customer.custId) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (custName != null ? !custName.equals(customer.custName) : customer.custName != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (custId ^ (custId >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (custName != null ? custName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    public Collection<Orders> getOrdersByCustId() {
        return ordersByCustId;
    }

    public void setOrdersByCustId(Collection<Orders> ordersByCustId) {
        this.ordersByCustId = ordersByCustId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", custName='" + custName + '\'' +
                ", phone='" + phone + '\'' +
                ", ordersByCustId=" + ordersByCustId +
                '}';
    }
}
