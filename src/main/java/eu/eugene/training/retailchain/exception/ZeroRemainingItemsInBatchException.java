package eu.eugene.training.retailchain.exception;

import eu.eugene.training.retailchain.enums.ExceptionMessageTemplate;

public class ZeroRemainingItemsInBatchException extends RuntimeException {
    public ZeroRemainingItemsInBatchException() {
        super(ExceptionMessageTemplate.ZERO_REMAINING_ITEMS_IN_BATCH.getMessageTemplate());
    }
}
