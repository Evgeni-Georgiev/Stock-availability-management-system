package eu.eugene.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents the producer of a particular product.
 */
@Entity
@Data
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "id_number", length = 8, nullable = false)
    private String idNumber;

    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
}
