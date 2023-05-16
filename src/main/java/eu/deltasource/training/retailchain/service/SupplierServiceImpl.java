package eu.deltasource.training.retailchain.service;

import eu.deltasource.training.retailchain.dto.SupplierDTO;
import eu.deltasource.training.retailchain.entity.Supplier;
import eu.deltasource.training.retailchain.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static eu.deltasource.training.retailchain.mapper.SupplierMapper.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDTO create(SupplierDTO supplierDTO) {
        Supplier supplier = mapToSupplier(supplierDTO);
        supplier = supplierRepository.save(supplier);
        return mapToSupplierDTO(supplier);
    }

    @Override
    public void delete(int id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not updated for ID: " + id));
        supplierRepository.softDelete(supplier.getId());
    }

    @Override
    public SupplierDTO update(int id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not updated for ID: " + id));
        mapToSupplier(supplierDTO, supplier);
        supplier = supplierRepository.save(supplier);
        return mapToSupplierDTO(supplier);
    }
}
