package eu.deltasource.training.retailchain.repository;

import eu.deltasource.training.retailchain.entity.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Supplier s SET s.deleted=true WHERE s.id=?1")
    void softDelete(@Param("id") int id);
}
