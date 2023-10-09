package eu.eugene.training.retailchain.schedule;

import eu.eugene.training.retailchain.repository.BatchRepository;
import eu.eugene.training.retailchain.service.batchService.BatchServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Provides logic for cron jobs executing when a given time or condition comes in place.
 */
@Service
@RequiredArgsConstructor
public class ScheduleBatchExpiration {

    private final BatchRepository batchRepository;

    private final BatchServiceImpl batchService;

    /**
     * Sends email notification for every batch at 08:00 AM every time
     * when the remaining time is less than half of the total time and
     * the remaining items in the batch are more than half of the total received.
     */
//    @Scheduled(cron = "0 0 8 * * ?")
    @Scheduled(fixedDelay = 3000)
    public void sendPreliminaryEmailForExpiringBatches() {
        batchRepository.findUnexpiredFoodBatches()
                .stream()
                .filter(batch -> batchService.hasHalfExpirationTimePassed(batch)
                        && batchService.isOverstockedItems(batch))
                .forEach(batch -> {
                    batchRepository.updateHalTimeBatchStatus(batch.getId());
                    batchService.sendEmailNotification(batch);
                });
    }

    /**
     * Sends email notification for every batch at 08:30 AM every time
     * on the 7th day and on the 2nd day before the expiration date
     * regardless of the remaining items in the batch as long as there is at least one.
     */
    @Scheduled(fixedDelay = 5000)
//    @Scheduled(cron = "0 30 8 * * ?")
    public void sendEmailForExpiringBatchesInDays() {
        batchRepository.findHalfTimeFoodBatches()
                .stream()
                .filter(batchService::hasRemainingItems)
                .filter(batch -> batchService.isBatchExpiringIn(batch, 2)
                        || batchService.isBatchExpiringIn(batch, 7))
                .forEach(batch -> {
                    if(batchService.isBatchExpiringIn(batch, 7)) {
                        batchService.sendEmailNotification(batch);
                        batchRepository.updateExpireBatchStatus(batch.getId());
                    } else if(batchService.isBatchExpiringIn(batch, 2)) {
                        batchService.sendEmailNotification(batch);
                        batchRepository.updateExpireBatchStatus(batch.getId());
                    }
                });
    }
//
//
//
//    @Scheduled(fixedDelay = 7000)
//    public void sendEmailForAlreadyExpiredBatches() {
//        batchRepository.findUnexpiredFoodBatches()
//                .forEach(batch -> {
//                    if(batchService.hasBatchExpired(batch)) {
//                        batchRepository.updateExpireBatchStatusExpired();
//                    }
//                });
//    }

    /**
     * Send email notification when a batch has already expired.
     */
//    @Scheduled(cron = "0 40 8 * * ?")
    @Scheduled(fixedDelay = 9000)
    public void sendEmailForAlreadyExpiredBatches1() {
        batchRepository.findExpiredFoodBatches()
                .forEach(batch -> {
//                    if(batchService.hasBatchExpired(batch)) {
//                        batchRepository.updateExpireBatchStatusExpired();
//                        batchService.sendEmailNotification(batch);
                    if(!batch.getIsExpired()) {
                        batchService.sendEmailNotification(batch);
                        batchRepository.updateExpireStatus();
                    }
//                    }
                });
    }

}