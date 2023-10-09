package eu.eugene.training.retailchain.repository;

import eu.eugene.training.retailchain.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
