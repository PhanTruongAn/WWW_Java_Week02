package com.example.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    private long orderId;
    @Basic
    @Column(name = "order_date")
    private Timestamp orderDate;
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<OrderDetail> orderDetailsByOrderId;
    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customerByCustId;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "emp_ip")
    private Employee employeeByEmployeeId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
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

    public Collection<OrderDetail> getOrderDetailsByOrderId() {
        return orderDetailsByOrderId;
    }

    public void setOrderDetailsByOrderId(Collection<OrderDetail> orderDetailsByOrderId) {
        this.orderDetailsByOrderId = orderDetailsByOrderId;
    }

    public Customer getCustomerByCustId() {
        return customerByCustId;
    }

    public void setCustomerByCustId(Customer customerByCustId) {
        this.customerByCustId = customerByCustId;
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
                ", customerByCustId=" + customerByCustId +
                ", employeeByEmployeeId=" + employeeByEmployeeId +
                '}';
    }
}
