package eu.eugene.training.retailchain.controller;

import eu.eugene.training.retailchain.dto.supplier.SupplierDetailsDTO;
import eu.eugene.training.retailchain.dto.supplier.SupplierDTO;
import eu.eugene.training.retailchain.service.supplierService.SupplierService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles client input for manipulation of supplier resources.
 */
@Log4j2
@RestController
@RequestMapping(path="api/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * Searches for suppliers based on provided parameters.
     * If no parameters are provided, return all suppliers from database.
     *
     * @param name (Optional) Name of searched supplier.
     * @param idNumber (Optional) IdNumber of searched supplier.
     * @return ResponseEntity containing a list of suppliers(SupplierContactCountryDTO) matching
     * the search criteria, or all suppliers if no matches were found.
     * There is partial string matching.
     */
    @GetMapping("/search")
    public ResponseEntity<List<SupplierDetailsDTO>> get(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "idNumber", required = false) String idNumber) {
        List<SupplierDetailsDTO> suppliers = supplierService.search(name, idNumber);
        log.info("After Starting application");
        return ResponseEntity.ok(suppliers);
    }

    /**
     * Persists Supplier with Contact info and returns new resource created status.
     *
     * @param supplierDTO A ResponseEntity containing the newly created SupplierDTO.
     * @return ResponseEntity containing newly created resource(SupplierDTO).
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> create(@RequestBody @Validated SupplierDTO supplierDTO) {
        try {
            SupplierDTO newSupplier = supplierService.create(supplierDTO);
            log.warn("User with name and id {}, {} was created.", newSupplier.getName(), newSupplier.getId());
            return ResponseEntity.ok(newSupplier);
        } catch (Exception e) {
            log.error("userID: {} | message: {} | additionalProperty {}", supplierDTO.getName(), supplierDTO.getIdNumber(), supplierDTO.getContactDTO(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(supplierDTO);
        }
    }

    /**
     * Performs Soft delete operation on Supplier by the specified ID.
     *
     * @param id The ID of given supplier to delete.
     * @return ResponseEntity with "No content" HTTP status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates Supplier by the specified ID.
     *
     * @param id For given supplier to update.
     * @param supplierDTO Holds the parameters for updating information.
     * @return ResponseEntity containing the updated resource(SupplierDTO) and an HTTP status code indicating success.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> update(
            @PathVariable("id") int id,
            @RequestBody @Validated SupplierDTO supplierDTO) {
        SupplierDTO updatedSupplier = supplierService.update(id, supplierDTO);
        return ResponseEntity.ok(updatedSupplier);
    }
}