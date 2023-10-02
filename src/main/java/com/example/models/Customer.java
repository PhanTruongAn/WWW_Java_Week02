package com.example.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.findAll", query = "from Customer")
public class Customer {
    @Id
    @Column(name = "cust_id",columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custId;

    @Column(name = "address", columnDefinition = "VARCHAR(250)")
    private String address;

    @Column(name = "email", columnDefinition = "VARCHAR(250)")
    private String email;

    @Column(name = "cust_name",columnDefinition = "VARCHAR(250)")
    private String custName;

    @Column(name = "phone",columnDefinition = "VARCHAR(15)")
    private String phone;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Orders> orderList;

    public Customer(long custId,String address, String email, String custName, String phone) {
        this.custId = custId;
        this.address = address;
        this.email = email;
        this.custName = custName;
        this.phone = phone;
    }
    public Customer(String address, String email, String custName, String phone) {

        this.address = address;
        this.email = email;
        this.custName = custName;
        this.phone = phone;
    }

    public Customer() {
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrderList(List<Orders> orderList) {
        this.orderList = orderList;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCustName() {
        return custName;
    }

    public String getPhone() {
        return phone;
    }

    public List<Orders> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", custName='" + custName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
