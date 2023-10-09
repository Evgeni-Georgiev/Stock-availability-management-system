package eu.deltasource.training.retailchain.repository;

import eu.deltasource.training.retailchain.entity.Batch;
import eu.deltasource.training.retailchain.enums.BatchExpirationStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

    @Query("""
            SELECT b
            FROM Batch b
            WHERE b.expirationDate IS NOT NULL
            AND b.expirationStatus = eu.deltasource.training.retailchain.enums.BatchExpirationStatus.EXPIRED
            AND b.isExpired = false
            """)
    List<Batch> findExpiredFoodBatches();

    @Query("""
            SELECT b
            FROM Batch b
            WHERE b.expirationDate IS NOT NULL
            AND b.expirationStatus = eu.deltasource.training.retailchain.enums.BatchExpirationStatus.HALF_TIME_PASSED
            AND b.isExpired = false
            """)
    List<Batch> findHalfTimeFoodBatches();

    @Query("""
            SELECT b
            FROM Batch b
            WHERE b.expirationDate IS NOT NULL AND b.expirationDate > NOW() AND b.expirationStatus <> eu.deltasource.training.retailchain.enums.BatchExpirationStatus.EXPIRED
            """)
    List<Batch> findUnexpiredFoodBatches();

    @Query("""
            UPDATE Batch b SET b.expirationStatus = eu.deltasource.training.retailchain.enums.BatchExpirationStatus.EXPIRED WHERE NOW() > b.expirationDate
            """)
    @Modifying
    @Transactional
    void updateExpireBatchStatusExpired();

    @Query("""
            UPDATE Batch b SET b.isExpired = true WHERE b.expirationStatus = eu.deltasource.training.retailchain.enums.BatchExpirationStatus.EXPIRED
            """)
    @Modifying
    @Transactional
    void updateExpireStatus();

    @Query("""
                UPDATE Batch b
                SET b.expirationStatus = eu.deltasource.training.retailchain.enums.BatchExpirationStatus.HALF_TIME_PASSED
                WHERE b.id = :id AND DATEDIFF(b.expirationDate, CURRENT_TIMESTAMP) >= 0 AND DATEDIFF(b.expirationDate, CURRENT_TIMESTAMP) <= 7
            """)
    @Modifying(clearAutomatically = true)
    @Transactional
    void updateHalTimeBatchStatus(@Param("id") int id);

    @Query("""
                UPDATE Batch b
                SET b.expirationStatus = CASE
                     WHEN DATEDIFF(b.expirationDate, CURRENT_TIMESTAMP) >= 7 THEN eu.deltasource.training.retailchain.enums.BatchExpirationStatus.SEVENTH_DAY
                     WHEN DATEDIFF(b.expirationDate, CURRENT_TIMESTAMP) >= 2 THEN eu.deltasource.training.retailchain.enums.BatchExpirationStatus.SECOND_DAY
                     ELSE eu.deltasource.training.retailchain.enums.BatchExpirationStatus.UNEXPIRED
                END
                WHERE b.id = :id
            """)
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    void updateExpireBatchStatus(@Param("id") int id);

}
