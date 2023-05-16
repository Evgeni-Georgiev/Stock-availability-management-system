package eu.deltasource.training.retailchain.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/**
 * Represents the composite primary key of the ProductSupplier entity.
 * Holds the different parts of the composite key.
 */
@Embeddable
@Data
public class ProductSupplierKey implements Serializable {

    private int productId;

    private int supplierId;
}
