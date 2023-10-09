package eu.eugene.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * Represents a supplier of a particular product.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Table(name = "supplier")
public class Supplier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "min_quantity", nullable = false)
    private int minQuantity;

    @Column(name = "max_quantity", nullable = false)
    private int maxQuantity;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id_number", length = 8, nullable = false)
    private String idNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @OneToMany(mappedBy = "supplier")
    private Set<ProductSupplier> productSuppliers;

    @OneToMany(mappedBy = "supplier")
    private Set<Batch> batches;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;
}
