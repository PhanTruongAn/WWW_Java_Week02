package com.example.models;

import com.example.enums.ProductStatus;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "product")
@NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status=:status")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "status",columnDefinition = "INT(11)")
    private ProductStatus status;
    @Basic
    @Column(name = "unit")
    private String unit;
    @OneToMany(mappedBy = "productByProductId")
    private List<OrderDetail> orderDetailsByProductId;
    @OneToMany(mappedBy = "productByProductId")
    private List<ProductImage> productImagesByProductId;

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

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
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

    public List<OrderDetail> getOrderDetailsByProductId() {
        return orderDetailsByProductId;
    }

    public void setOrderDetailsByProductId(List<OrderDetail> orderDetailsByProductId) {
        this.orderDetailsByProductId = orderDetailsByProductId;
    }

    public List<ProductImage> getProductImagesByProductId() {
        return productImagesByProductId;
    }

    public void setProductImagesByProductId(List<ProductImage> productImagesByProductId) {
        this.productImagesByProductId = productImagesByProductId;
    }

    public Product() {
    }

    public Product(long productId, String description, String manufacturerName, String name, ProductStatus status, String unit) {
        this.productId = productId;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.status = status;
        this.unit = unit;

    }
    public Product(String description, String manufacturerName, String name, ProductStatus status, String unit) {
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.name = name;
        this.status = status;
        this.unit = unit;

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
                '}';
    }
}
