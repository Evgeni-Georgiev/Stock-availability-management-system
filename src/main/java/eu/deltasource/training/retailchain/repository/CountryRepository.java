package eu.deltasource.training.retailchain.repository;

import eu.deltasource.training.retailchain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
