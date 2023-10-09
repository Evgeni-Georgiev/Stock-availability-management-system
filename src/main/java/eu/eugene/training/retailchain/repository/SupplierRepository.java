package eu.deltasource.training.retailchain.repository;

import eu.deltasource.training.retailchain.entity.Supplier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Supplier s SET deleted=true WHERE s.id=:id")
    void softDelete(@Param("id") int id);

    @Query(value = "SELECT * FROM supplier WHERE id_number = :idNumber", nativeQuery = true)
    Supplier findByIdNumber(String idNumber);
}
