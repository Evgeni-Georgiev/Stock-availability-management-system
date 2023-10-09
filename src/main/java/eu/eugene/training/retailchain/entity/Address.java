package eu.eugene.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents the physical location of a contact.
 */
@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address_line", nullable = false)
    private String addressLine;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "postal_code", length = 10, nullable = false)
    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
