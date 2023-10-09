package eu.eugene.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Represents a supplier's price for a product that will be changed in the future.
 */
@Entity
@Data
@Table(name = "supplier_details")
public class SupplierDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name = "product_id", referencedColumnName = "productId"),
            @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    })
    private ProductSupplier supplierPrice;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "since_date", nullable = false)
    private LocalDate sinceDate;
}
