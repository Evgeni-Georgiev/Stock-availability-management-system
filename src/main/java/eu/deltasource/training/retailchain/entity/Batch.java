package eu.deltasource.training.retailchain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Represents a quantity of specific product that belongs to a specific supplier.
 */
@Entity
@Data
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "production_date")
    private LocalDate productionDate;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;
}
