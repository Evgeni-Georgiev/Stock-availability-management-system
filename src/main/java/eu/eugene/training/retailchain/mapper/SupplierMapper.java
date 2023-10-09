package eu.deltasource.training.retailchain.mapper;

import eu.deltasource.training.retailchain.dto.supplier.SupplierDetailsDTO;
import eu.deltasource.training.retailchain.dto.supplier.SupplierDTO;
import eu.deltasource.training.retailchain.entity.Supplier;

import static eu.deltasource.training.retailchain.mapper.ContactMapper.*;

/**
 * Mapper class holding the Conversion from DTO to Entity.
 */
public class SupplierMapper {

    /**
     * Convert SupplierDTO to Supplier Entity.
     *
     * @param supplierDTO DTO to convert from.
     * @return converted entity.
     */
    public static Supplier mapToSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setName(supplierDTO.getName());
        supplier.setIdNumber(supplierDTO.getIdNumber());
        supplier.setContact(mapToContact(supplierDTO.getContactDTO()));
        return supplier;
    }

    /**
     * Convert Supplier entity to SupplierDTO.
     *
     * @param supplier entity to convert from.
     * @return converted DTO.
     */
    public static SupplierDTO mapToSupplierDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setIdNumber(supplier.getIdNumber());
        supplierDTO.setContactDTO(mapToContactDTO(supplier.getContact()));
        return supplierDTO;
    }

    /**
     * Convert Supplier Entity to DTO.
     *
     * @param supplier entity to convert from.
     * @return converted DTO.
     */
    public static SupplierDetailsDTO mapToSupplierData(Supplier supplier) {
        SupplierDetailsDTO supplierDetailsDTO = new SupplierDetailsDTO();
        supplierDetailsDTO.setName(supplier.getName());
        supplierDetailsDTO.setIdNumber(supplier.getIdNumber());
        supplierDetailsDTO.setEmail(supplier.getContact().getEmail());
        supplierDetailsDTO.setCountryName(supplier.getContact().getAddress().getCountry().getName());
        return supplierDetailsDTO;
    }

    /**
     * Convert DTO to Supplier Entity.
     *
     * @param supplierDetailsDTO DTO to convert from.
     * @return converted entity.
     */
    public static Supplier mapToSupplierData(SupplierDetailsDTO supplierDetailsDTO) {
        Supplier supplier = new Supplier();
        supplierDetailsDTO.setName(supplier.getName());
        supplierDetailsDTO.setIdNumber(supplier.getIdNumber());
        supplierDetailsDTO.setEmail(supplier.getContact().getEmail());
        supplierDetailsDTO.setCountryName(supplier.getContact().getAddress().getCountry().getName());
        return supplier;
    }

    /**
     * Updates properties of an existing Supplier entity.
     *
     * @param supplierUpdateDTO DTO to convert from.
     * @param supplier entity to convert to.
     */
    public static void mapToSupplier(SupplierDTO supplierUpdateDTO, Supplier supplier) {
        supplier.setName(supplierUpdateDTO.getName());
        supplier.setIdNumber(supplierUpdateDTO.getIdNumber());
        mapToContact(supplierUpdateDTO.getContactDTO(), supplier.getContact());
    }

    /**
     * Convert Supplier entity to SupplierDTO.
     *
     * @param supplier entity to convert from.
     * @return converted DTO.
     */
    public static SupplierDTO mapToSupplierUpdateDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName(supplier.getName());
        supplierDTO.setIdNumber(supplier.getIdNumber());
        supplierDTO.setContactDTO(mapToContactDTO(supplier.getContact()));
        return supplierDTO;
    }
}
