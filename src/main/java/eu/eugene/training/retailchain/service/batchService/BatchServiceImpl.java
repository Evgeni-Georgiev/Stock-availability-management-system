package eu.deltasource.training.retailchain.service.batchService;

import eu.deltasource.training.retailchain.entity.Batch;
import eu.deltasource.training.retailchain.enums.BatchExpirationStatus;
import eu.deltasource.training.retailchain.enums.DivisionType;
import eu.deltasource.training.retailchain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    @Override
    public boolean hasHalfExpirationTimePassed(Batch batch) {
//        validateHasHalfExpirationTimePassed(batch);
        long remainingTime = getRemainingTimeUntilExpiration(batch);
        long halfTotalTime = getHalfTotalTime(batch);
        return remainingTime < halfTotalTime;
    }

    @Override
    public boolean isOverstockedItems(Batch batch) {
        validateRemainingQuantityIsNotZero(batch);
        int remainingQuantity = getRemainingQuantity(batch);
        long halfTotalQuantity = getHalfTotalQuantity(batch);
        return remainingQuantity > halfTotalQuantity;
    }

    @Override
    public boolean isBatchExpiringIn(Batch batch, int days) {
        if(days <= 0) {
            throw new InvalidDayBeforeExpirationDateException();
        }
        LocalDate today = LocalDate.now();
        LocalDate expirationDateUpcoming = batch.getExpirationDate().minusDays(days);
        return today.isEqual(expirationDateUpcoming);
    }

    @Override
    public boolean hasBatchExpired(Batch batch) {
        long countOfDaysBetweenCurrentTimeAndExpirationDate = ChronoUnit.DAYS.between(LocalDate.now(), batch.getExpirationDate());
        return countOfDaysBetweenCurrentTimeAndExpirationDate >= 0;
    }

    @Override
    public void sendEmailNotification(Batch batch) {
        if(batch.getExpirationStatus() == BatchExpirationStatus.HALF_TIME_PASSED) {
            System.out.println("Email notification Sent for " + batch + "that has trespassed half the time!");
        } else if(batch.getExpirationStatus() == BatchExpirationStatus.SEVENTH_DAY) {
            System.out.println("Email notification Sent for " + batch + "that will expire in seven days!");
        } else if(batch.getExpirationStatus() == BatchExpirationStatus.SECOND_DAY) {
            System.out.println("Email notification Sent for " + batch + "that will expire in two days!");
        } else if(batch.getExpirationStatus() == BatchExpirationStatus.EXPIRED) {
            System.out.println("Email notification Sent for " + batch + "that batch has already expired!");
        }
//        System.out.println("Email notification Sent for " + batch.getId() + "that batch has already expired!");
    }

    @Override
    public boolean hasRemainingItems(Batch batch) {
        validateRemainingQuantityIsNotZero(batch);
        return true;
    }

    /**
     * Retrieves half of the total quantity of a batch that was delivered.
     *
     * @param batch The given batch.
     * @return Half the quantity of a batch that was delivered.
     */
    private long getHalfTotalQuantity(Batch batch) {
        long halfTotalQuantityItems = batch.getQuantity() / DivisionType.TOTAL_QUANTITY_DIVISOR.getDivisionNumber();
        if (halfTotalQuantityItems <= 0 && batch.getQuantity() <= 0) {
            throw new RemainingQuantityNegativeCountException();
        }
        return halfTotalQuantityItems;
    }

    /**
     * Retrieves remaining items quantity from a batch.
     *
     * @param batch The given batch.
     * @return The remaining items quantity from a batch.
     */
    private int getRemainingQuantity(Batch batch) {
        if (batch.getQuantityStatus() <= 0) {
            throw new ZeroRemainingItemsInBatchException();
        }
//        validategetRemainingQuantity(batch);
        return batch.getQuantityStatus();
    }

    /**
     * Retrieves the remaining time in days between the delivery date and expiration date of a given batch.
     *
     * @param batch The given batch's delivery and expiration dates.
     * @return Remaining time in days between the delivery date and expiration date of the batch.
     */
    private long getRemainingTimeUntilExpiration(Batch batch) {
//        validateRemainingTimeUntilExpiration(batch);
        long daysBetweenDeliveryAndCurrentDates = getPeriodTimeBetweenDates(batch.getDeliveryDate(), LocalDate.now());
        long daysBetweenDeliveryAndExpirationDates = getPeriodTimeBetweenDates(batch.getDeliveryDate(), batch.getExpirationDate());
        return daysBetweenDeliveryAndExpirationDates - daysBetweenDeliveryAndCurrentDates;
    }

    /**
     * Retrieves half of the total time in days between the delivery date and expiration date of a given batch.
     *
     * @param batch The given batch to calculate half of the total time.
     * @return Half of the total time in days between the delivery date and expiration date of the batch.
     */
    private long getHalfTotalTime(Batch batch) {
        long totalTimeInDays = getPeriodTimeBetweenDates(batch.getDeliveryDate(), batch.getExpirationDate());
        return totalTimeInDays / DivisionType.TOTAL_TIME_DIVISOR.getDivisionNumber();
    }

    /**
     * Validates if the reining time between delivery and expiration dates are valid.
     *
     * @param batch The given batch.
     * @throws NegativePeriodException If any of the starting dates are not after the ending date.
     */
    private void validateRemainingTimeUntilExpiration(Batch batch) {
        LocalDate currentDate = LocalDate.now();
        if (batch.getExpirationDate().isBefore(batch.getDeliveryDate())
                || batch.getExpirationDate().isBefore(currentDate)
                || currentDate.isBefore(batch.getDeliveryDate())) {
            throw new NegativePeriodException();
        }
    }

    /**
     * Retrieves the period between two dates.
     *
     * @param startDate Start date of the period.
     * @param endDate   End date of the period.
     * @return Period object representing the time period between the start and end dates.
     */
    private long getPeriodTimeBetweenDates(LocalDate startDate, LocalDate endDate) {
        long periodBetweenDates = startDate.until(endDate, DAYS);
//        validateGetPeriodTimeBetweenDates(periodBetweenDates);
        return periodBetweenDates;
    }

    /**
     * Validates if start and end dates are the same.
     *
     * @param periodBetweenDates The period between start and end dates in days.
     */
    private void validateGetPeriodTimeBetweenDates(long periodBetweenDates) {
        if (periodBetweenDates == 0) {
            throw new ZeroPeriodException();
        }
    }

    /**
     * Validates if remaining items in batch are at least one.
     *
     * @param batch The given batch.
     * @throws ZeroRemainingItemsInBatchException If there are zero items in the given batch.
     */
    private void validateRemainingQuantityIsNotZero(Batch batch) {
        if (batch.getQuantityStatus() <= 0) {
            throw new ZeroRemainingItemsInBatchException();
        }
    }

    /**
     * Validates if remaining quantity is less than half total quantity.
     *
     * @param batch The given batch.
     * @throws RemainingItemsLessThanHalfReceivedException If remaining items are more than half received, throw exception.
     */
    private void validateGetRemainingQuantity(Batch batch) {
        if (batch.getQuantityStatus() < getHalfTotalQuantity(batch)) {
            throw new RemainingItemsLessThanHalfReceivedException();
        }
    }

    /**
     * Validates if the remaining time is less than half the total time for batch.
     *
     * @param batch The given batch.
     * @throws RemainingTimeMoreThanHalfTotalTimeException If remaining time is more than half the total time.
     */
    private void validateHasHalfExpirationTimePassed(Batch batch) {
        if (getRemainingTimeUntilExpiration(batch) > getHalfTotalTime(batch)) {
            throw new RemainingTimeMoreThanHalfTotalTimeException();
        }
    }
}