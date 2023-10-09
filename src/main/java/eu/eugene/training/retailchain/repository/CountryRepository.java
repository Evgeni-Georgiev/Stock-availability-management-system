package eu.eugene.training.retailchain.repository;

import eu.eugene.training.retailchain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
