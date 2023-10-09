package eu.eugene.training.retailchain.service.supplierService;

import eu.eugene.training.retailchain.dto.supplier.SupplierDetailsDTO;
import eu.eugene.training.retailchain.dto.supplier.SupplierDTO;
import eu.eugene.training.retailchain.entity.Supplier;
import eu.eugene.training.retailchain.mapper.SupplierMapper;
import eu.eugene.training.retailchain.repository.SupplierRepository;
import eu.eugene.training.retailchain.specification.SupplierSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static eu.eugene.training.retailchain.mapper.SupplierMapper.*;

/**
 * Concrete implementation service of business logic for Supplier Domain model.
 */
@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final SupplierSpecification supplierSpecification;

    @Override
    public List<SupplierDetailsDTO> search(String name, String idNumber) {
        Specification<Supplier> spec = Specification.where(supplierSpecification.searchByName(name))
                .and(supplierSpecification.searchByIdNumber(idNumber));
        List<Supplier> findAllSuppliers = supplierRepository.findAll(spec);
        return findAllSuppliers.stream()
                .map(SupplierMapper::mapToSupplierData)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDTO create(SupplierDTO supplierDTO) {
        Supplier supplier = mapToSupplier(supplierDTO);
        if(supplierRepository.findByIdNumber(supplier.getIdNumber()) != null) {
            throw new IllegalArgumentException("Supplier with this idNumber already exists!");
        }
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
    public SupplierDTO update(int id, SupplierDTO supplierUpdateDTO) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not updated for ID: " + id));
        mapToSupplier(supplierUpdateDTO, supplier);
        supplier = supplierRepository.save(supplier);
        return mapToSupplierUpdateDTO(supplier);
    }
}
