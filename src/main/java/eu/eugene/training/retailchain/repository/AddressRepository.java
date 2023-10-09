package eu.deltasource.training.retailchain.repository;

import eu.deltasource.training.retailchain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
