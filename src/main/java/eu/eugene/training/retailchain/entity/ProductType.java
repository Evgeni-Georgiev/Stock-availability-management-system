package eu.eugene.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents the type of product.
 */
@Entity
@Data
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;
}
