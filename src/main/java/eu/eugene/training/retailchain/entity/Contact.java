package eu.deltasource.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the contact details of supplier and producer.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "mobile", length = 50, nullable = false)
    private String mobile;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}