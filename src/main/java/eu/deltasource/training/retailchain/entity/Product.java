package eu.deltasource.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Represents the product that can be supplied by a supplier under the form of batches.
 * Every product has a producer and supplier that can supply it.
 */
@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "barcode", length = 13, nullable = false, unique = true)
    private String barcode;

    @Column(name = "id_number", length = 8, nullable = false, unique = true)
    private String idNumber;

    @OneToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @OneToOne
    @JoinColumn(name = "producer_id", nullable = false)
    private Manufacturer producer;

    @OneToMany(mappedBy = "product")
    private Set<ProductSupplier> productSuppliers;

    @OneToMany(mappedBy = "product")
    private Set<Batch> batches;
}
