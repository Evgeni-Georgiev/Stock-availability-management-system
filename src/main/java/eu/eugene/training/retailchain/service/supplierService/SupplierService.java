package eu.eugene.training.retailchain.service.supplierService;

import eu.eugene.training.retailchain.dto.supplier.SupplierDetailsDTO;
import eu.eugene.training.retailchain.dto.supplier.SupplierDTO;

import java.util.List;

/**
 * Abstract service representation of business logic for Supplier Domain model.
 */
public interface SupplierService {

    /**
     * Retrieve list of Suppliers by given parameters. If non-provided, all existing resources are retrieved.
     *
     * @return List of existing suppliers or Exception.
     */
    List<SupplierDetailsDTO> search(String name, String idNumber);

    /**
     * Persists Supplier data.
     *
     * @return Saved supplier as a result.
     */
    SupplierDTO create(SupplierDTO supplierDTO);

    /**
     * Updates supplier entity.
     *
     * @return Updated supplier's DTO as a result.
     */
    SupplierDTO update(int id, SupplierDTO supplierUpdateDTO);

    /**
     * Performs soft delete for Supplier data.
     *
     * @param id Of resource to be marked as inactive.
     */
    void delete(int id);
}
