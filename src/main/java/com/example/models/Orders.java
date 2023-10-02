package com.example.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "orders")
@NamedQuery(name = "Orders.findAll", query = "from Orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    private long orderId;
    @Basic
    @Column(name = "order_date", columnDefinition = "DATETIME(6)")
    private LocalDate orderDate;
    @OneToMany(mappedBy = "ordersByOrderId")
    private List<OrderDetail> orderDetailsByOrderId;
    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "emp_ip")
    private Employee employeeByEmployeeId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != orders.orderId) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }

    public List<OrderDetail> getOrderDetailsByOrderId() {
        return orderDetailsByOrderId;
    }

    public void setOrderDetailsByOrderId(List<OrderDetail> orderDetailsByOrderId) {
        this.orderDetailsByOrderId = orderDetailsByOrderId;
    }

    public Customer getCustomerByCustId() {
        return customer;
    }

    public void setCustomerByCustId(Customer customerByCustId) {
        this.customer = customerByCustId;
    }

    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderDetailsByOrderId=" + orderDetailsByOrderId +
                ", customerByCustId=" + customer +
                ", employeeByEmployeeId=" + employeeByEmployeeId +
                '}';
    }
}
