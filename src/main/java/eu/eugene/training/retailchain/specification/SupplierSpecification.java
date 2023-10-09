package eu.deltasource.training.retailchain.specification;

import eu.deltasource.training.retailchain.entity.Supplier;
import eu.deltasource.training.retailchain.entity.Supplier_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

/**
 * Handles Specification query predicates for Supplier entity.
 */
@Component
public class SupplierSpecification extends BaseSpecification {

    /**
     * Filters data based on "name" attribute of Supplier entity.
     * Partial string is supported.
     *
     * @param searchTerm Value of the attribute to search on.
     * @return Filtered data based on whether a given attribute contains a given search term. Else, returns all resources.
     */
    public Specification<Supplier> searchByName(String searchTerm) {
        return attributeContains(Supplier_.NAME, searchTerm);
    }

    /**
     * Filters data based on "idNumber" attribute of Supplier entity.
     * Partial string is supported.
     *
     * @param searchTerm Value of the attribute to search on.
     * @return Filtered data based on whether a given attribute contains a given search term. Else, returns all resources.
     */
    public Specification<Supplier> searchByIdNumber(String searchTerm) {
        return attributeContains(Supplier_.ID_NUMBER, searchTerm);
    }
}
