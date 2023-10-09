package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class ZeroRemainingItemsInBatchException extends RuntimeException {
    public ZeroRemainingItemsInBatchException() {
        super(ExceptionMessageTemplate.ZERO_REMAINING_ITEMS_IN_BATCH.getMessageTemplate());
    }
}
