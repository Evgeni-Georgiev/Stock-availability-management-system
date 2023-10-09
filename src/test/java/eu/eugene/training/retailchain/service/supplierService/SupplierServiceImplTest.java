package eu.eugene.training.retailchain.service.supplierService;

import eu.eugene.training.retailchain.entity.Address;
import eu.eugene.training.retailchain.entity.Contact;
import eu.eugene.training.retailchain.entity.Country;
import eu.eugene.training.retailchain.entity.Supplier;
import eu.eugene.training.retailchain.repository.SupplierRepository;
import eu.eugene.training.retailchain.specification.SupplierSpecification;
import eu.eugene.training.retailchain.mapper.SupplierMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class SupplierServiceImplTest {

    private SupplierRepository supplierRepository;

    private SupplierSpecification supplierSpecification;

    private SupplierServiceImpl classUnderTest;

    @BeforeEach
    void setUp() {
        supplierRepository = mock(SupplierRepository.class);
        supplierSpecification = mock(SupplierSpecification.class);
        classUnderTest = new SupplierServiceImpl(supplierRepository, supplierSpecification);
    }

    @Test
    public void should_createSupplier_valid_data() {
        // Given
        Country country = new Country();
        country.setName("Bulgaria");

        Address address = new Address();
        address.setAddressLine("Bul Bulgaria 21");
        address.setCity("Sofia");
        address.setPostalCode("4000");
        address.setCountry(country);

        Contact contact = new Contact();
        contact.setName("Верея");
        contact.setEmail("vereq@gmail.com");
        contact.setMobile("+359 856435 412");
        contact.setPhone("0856435412");
        contact.setAddress(address);

        Supplier supplier = new Supplier();
        supplier.setName("Peter");
        supplier.setIdNumber("09584738");
        supplier.setContact(contact);

        // When
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        // Then
        Assertions.assertEquals(classUnderTest.create(SupplierMapper.mapToSupplierDTO(supplier)).getName(), supplier.getName());
        verify(supplierRepository).save(supplier);
    }
    @Test
    public void should_updateSupplier_when_valid_data() {
        // Given
        Country country = new Country();
        country.setName("Bulgaria");

        Address address = new Address();
        address.setAddressLine("Bul Bulgaria 21");
        address.setCity("Sofia");
        address.setPostalCode("4000");
        address.setCountry(country);

        Contact contact = new Contact();
        contact.setName("Верея");
        contact.setEmail("vereq@gmail.com");
        contact.setMobile("+359 856435 412");
        contact.setPhone("0856435412");
        contact.setAddress(address);

        Supplier supplier = new Supplier();
        supplier.setName("Peter");
        supplier.setIdNumber("09584738");
        supplier.setContact(contact);

        // When
        when(supplierRepository.findById(supplier.getId())).thenReturn(Optional.of(supplier));
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        // Then
        Assertions.assertEquals(classUnderTest.update(supplier.getId(), SupplierMapper.mapToSupplierUpdateDTO(supplier)).getName(), supplier.getName());
        verify(supplierRepository).save(supplier);
    }

    @Test
    public void should_invokeSoftDelete_when_valid_data() {
        // Given
        Supplier supplier = new Supplier();
        supplier.setId(1);
        supplier.setName("John Doe");

        // When
        when(supplierRepository.findById(supplier.getId())).thenReturn(Optional.of(supplier));
        classUnderTest.delete(supplier.getId());

        // Then
        verify(supplierRepository).softDelete(supplier.getId());
    }
}