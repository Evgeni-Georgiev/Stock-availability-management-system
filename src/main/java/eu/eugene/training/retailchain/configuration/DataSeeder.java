package eu.deltasource.training.retailchain.configuration;

import eu.deltasource.training.retailchain.repository.AddressRepository;
import eu.deltasource.training.retailchain.repository.ContactRepository;
import eu.deltasource.training.retailchain.repository.CountryRepository;
import eu.deltasource.training.retailchain.repository.SupplierRepository;
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
