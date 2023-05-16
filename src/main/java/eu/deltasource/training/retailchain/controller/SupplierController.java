package eu.deltasource.training.retailchain.controller;

import eu.deltasource.training.retailchain.dto.SupplierDTO;
import eu.deltasource.training.retailchain.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * Persists Supplier with Contact info and returns new resource created status.
     *
     * @param supplierDTO holds the parameters for creating a new resource.
     * @return newly created resource.
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> create(@RequestBody @Valid SupplierDTO supplierDTO) {
        SupplierDTO newSupplier = supplierService.create(supplierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSupplier);
    }

    /**
     * Performs Soft delete operation on Supplier.
     *
     * @param id for given supplier.
     * @return "No content" HTTP status returned.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates Supplier data.
     *
     * @param id for given supplier
     * @param supplierDTO hold the parameters for updating a new resource.
     * @return status for successful update of the resource.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(@PathVariable int id, @RequestBody @Valid SupplierDTO supplierDTO) {
        SupplierDTO updatedSupplierDTO = supplierService.update(id, supplierDTO);
        return ResponseEntity.ok(updatedSupplierDTO);
    }
}