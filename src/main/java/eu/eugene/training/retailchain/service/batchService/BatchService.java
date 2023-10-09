package eu.deltasource.training.retailchain.service.batchService;

import eu.deltasource.training.retailchain.entity.Batch;
import eu.deltasource.training.retailchain.exception.InvalidDayBeforeExpirationDateException;

public interface BatchService {

    /**
     * Checks if the remaining time in days between the delivery date and expiration date of a given batch
     * is less than half of the total time.
     *
     * @param batch The batch to check for remaining time.
     * @return True if the remaining time is less than half of the total time, false otherwise.
     */
    boolean hasHalfExpirationTimePassed(Batch batch);

    /**
     * Checks if the remaining quantity of a given batch is more than half of the total quantity.
     *
     * @return True if the remaining quantity is more than half of the total quantity, false otherwise.
     */
    boolean isOverstockedItems(Batch batch);

    /**
     * Checks if items in batch are present. There must be at least one item left.
     *
     * @param batch The given batch.
     * @return True if there is at least one item in a batch.
     */
    boolean hasRemainingItems(Batch batch);

    /**
     * Sends email notification for batches that are close to expiration date.
     *
     * @param batch The given batch.
     */
    void sendEmailNotification(Batch batch);

    /**
     * Checks for certain days before expiration date.
     *
     * @param batch The given batch.
     * @param days Set count of days before the expiration date to check for.
     * @return True, if the current date the second or seventh day before the expiration date.
     * @throws InvalidDayBeforeExpirationDateException For invalid set for days to check.
     */
    boolean isBatchExpiringIn(Batch batch, int days);

    /**
     * Checks if the expiration date of batch has passed.
     *
     * @param batch The given batch
     * @return True, if batch has expired, else - false
     */
    boolean hasBatchExpired(Batch batch);
}