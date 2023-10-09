package eu.eugene.training.retailchain.configuration;

import eu.eugene.training.retailchain.repository.AddressRepository;
import eu.eugene.training.retailchain.repository.ContactRepository;
import eu.eugene.training.retailchain.repository.CountryRepository;
import eu.eugene.training.retailchain.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSeeder {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository  contactRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Bean
    @Profile("dev")
    CommandLineRunner commandLineRunner(SupplierRepository supplierRepository, ContactRepository contactRepository) {
        return args -> {

        };
    }
}
