package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal nettPrice;

    @ManyToOne
    @JoinColumn(name = "cart_id") // TODO: 2019-09-18 many to many ???
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(quantity, product.quantity) &&
                Objects.equals(nettPrice, product.nettPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, quantity, nettPrice, cart, company);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", nettPrice=" + nettPrice +
                ", cart=" + cart +
                ", company=" + company +
                '}';
    }
}