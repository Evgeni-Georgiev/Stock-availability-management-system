package eu.deltasource.training.retailchain.repository;

import eu.deltasource.training.retailchain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
