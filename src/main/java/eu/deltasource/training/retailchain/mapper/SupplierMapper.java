package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.SupplierDTO;
import eu.deltasource.training.retailchain.entity.Supplier;

import static eu.deltasource.training.retailchain.mapper.ContactMapper.*;

public class SupplierMapper {

    /**
     * Convert SupplierDTO to Supplier Entity
     *
     * @param supplierDTO DTO to convert from
     * @return converted entity
     */
    public static Supplier mapToSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setIdNumber(supplierDTO.getIdNumber());
        supplier.setContact(mapToContact(supplierDTO.getContactDTO()));
        return supplier;
    }

    /**
     * Convert Supplier entity to SupplierDTO
     *
     * @param supplier entity to convert from
     * @return converted DTO
     */
    public static SupplierDTO mapToSupplierDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName(supplier.getName());
        supplierDTO.setIdNumber(supplier.getIdNumber());
        supplierDTO.setContactDTO(mapToContactDTO(supplier.getContact()));
        return supplierDTO;
    }

    /**
     * Updates properties of an existing Supplier entity.
     *
     * @param supplierDTO DTO to convert from.
     * @param supplier entity to convert to.
     */
    public static void mapToSupplier(SupplierDTO supplierDTO, Supplier supplier) {
        supplier.setName(supplierDTO.getName());
        supplier.setIdNumber(supplierDTO.getIdNumber());
        updateContactProperties(supplierDTO.getContactDTO(), supplier.getContact());
    }
}
