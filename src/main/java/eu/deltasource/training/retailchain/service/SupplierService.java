package eu.deltasource.training.retailchain.service;

import eu.deltasource.training.retailchain.dto.SupplierDTO;

public interface SupplierService {

    /**
     * Persists Supplier data.
     *
     * @return saved supplier's DTO as a result.
     */
    SupplierDTO create(SupplierDTO supplierDTO);

    /**
     * Updates supplier entity.
     *
     * @return updated supplier's DTO as a result.
     */
    SupplierDTO update(int id, SupplierDTO supplierDTO);

    /**
     * Performs soft delete for Supplier data.
     *
     * @param id of resource to be marked as inactive.
     */
    void delete(int id);
}
