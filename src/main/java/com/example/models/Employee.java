package com.example.models;

import com.example.enums.EmployeeStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.status=:statusActive")
public class Employee {
    @Id
    @Column(name = "emp_ip")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empIp;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "dob", columnDefinition = "DATETIME(6)")
    private LocalDate dob;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "phone")
    private String phone;

    @Column(name = "status", columnDefinition = "INT(11)")
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employeeByEmployeeId")
    private List<Orders> ordersByEmpIp;

    public Employee() {

    }

    public long getEmpIp() {
        return empIp;
    }

    public void setEmpIp(long empIp) {
        this.empIp = empIp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Employee(long empIp,String address, LocalDate dob, String email, String fullname, String phone, EmployeeStatus status) {
        this.empIp = empIp;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
    }
    public Employee(String address, LocalDate dob, String email, String fullname, String phone, EmployeeStatus status) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
    }



    public List<Orders> getOrdersByEmpIp() {
        return ordersByEmpIp;
    }

    public void setOrdersByEmpIp(List<Orders> ordersByEmpIp) {
        this.ordersByEmpIp = ordersByEmpIp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empIp=" + empIp +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", ordersByEmpIp=" + ordersByEmpIp +
                '}';
    }
}
