package com.example.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private long productId;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "manufacturer_name")
    private String manufacturerName;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "status")
    private Integer status;
    @Basic
    @Column(name = "unit")
    private String unit;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<OrderDetail> orderDetailsByProductId;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<ProductImage> productImagesByProductId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (manufacturerName != null ? !manufacturerName.equals(product.manufacturerName) : product.manufacturerName != null)
            return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (status != null ? !status.equals(product.status) : product.status != null) return false;
        if (unit != null ? !unit.equals(product.unit) : product.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (productId ^ (productId >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (manufacturerName != null ? manufacturerName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public Collection<OrderDetail> getOrderDetailsByProductId() {
        return orderDetailsByProductId;
    }

    public void setOrderDetailsByProductId(Collection<OrderDetail> orderDetailsByProductId) {
        this.orderDetailsByProductId = orderDetailsByProductId;
    }

    public Collection<ProductImage> getProductImagesByProductId() {
        return productImagesByProductId;
    }

    public void setProductImagesByProductId(Collection<ProductImage> productImagesByProductId) {
        this.productImagesByProductId = productImagesByProductId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unit='" + unit + '\'' +
                ", orderDetailsByProductId=" + orderDetailsByProductId +
                ", productImagesByProductId=" + productImagesByProductId +
                '}';
    }
}
