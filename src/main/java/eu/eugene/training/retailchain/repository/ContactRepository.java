package eu.eugene.training.retailchain.repository;

import eu.eugene.training.retailchain.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
