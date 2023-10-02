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

    public Employee(String address, LocalDate dob, String email, String fullname, String phone, EmployeeStatus status) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (empIp != employee.empIp) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (dob != null ? !dob.equals(employee.dob) : employee.dob != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (fullname != null ? !fullname.equals(employee.fullname) : employee.fullname != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (status != null ? !status.equals(employee.status) : employee.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (empIp ^ (empIp >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
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
