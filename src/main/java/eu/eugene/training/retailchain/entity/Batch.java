package eu.deltasource.training.retailchain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import eu.deltasource.training.retailchain.enums.BatchExpirationStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;

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

    @Column(name = "quantity_status", nullable = false)
    private int quantityStatus;

    @Column(name = "expiration_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BatchExpirationStatus expirationStatus;

    @Column(name = "is_expired", nullable = true)
    private Boolean isExpired = false;

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
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    private Supplier supplier;
}
