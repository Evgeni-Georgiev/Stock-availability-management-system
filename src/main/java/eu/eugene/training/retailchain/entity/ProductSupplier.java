package eu.eugene.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * ProductSupplier entity represents the relationship between a product and a supplier.
 * It contains a composite primary key, consisting of the product id and the supplier id.
 */
@Entity
@Data
@Table(name = "product_supplier")
public class ProductSupplier {

    @EmbeddedId
    private ProductSupplierKey id;

    @MapsId("ProductId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    private Product product;

    @ManyToOne(optional = false)
    @MapsId("SupplierId")
    @JoinColumn(name = "supplierId", referencedColumnName = "id", nullable = false)
    private Supplier supplier;

    @Column(name = "delivery_time_days", nullable = false)
    private int deliveryTimeDays;
}
