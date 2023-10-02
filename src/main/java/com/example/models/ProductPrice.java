package com.example.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
@NamedQuery(name = "ProductPrice.findAll", query = "from ProductPrice")
public class ProductPrice {
    @Id
    @Column(name = "price_date_time",columnDefinition = "DATETIME(6)")
    private LocalDate priceDateTime;
    @Basic
    @Column(name = "note")
    private String note;
    @Basic
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product productByProductId;

    public LocalDate getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDate priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPrice that = (ProductPrice) o;

        if (priceDateTime != null ? !priceDateTime.equals(that.priceDateTime) : that.priceDateTime != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = priceDateTime != null ? priceDateTime.hashCode() : 0;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", productByProductId=" + productByProductId +
                '}';
    }
}
