package eu.deltasource.training.retailchain.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents origin country of supplier or producer.
 */
@Entity
@Data
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;
}
