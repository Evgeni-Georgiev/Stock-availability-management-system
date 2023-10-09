package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class RemainingItemsLessThanHalfReceivedException extends RuntimeException {
    public RemainingItemsLessThanHalfReceivedException() {
        super(ExceptionMessageTemplate.ITEMS_LESS_THAN_HALF_RECEIVED.getMessageTemplate());
    }
}
