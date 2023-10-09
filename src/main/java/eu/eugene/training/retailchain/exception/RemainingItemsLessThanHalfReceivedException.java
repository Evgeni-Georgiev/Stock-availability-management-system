package eu.eugene.training.retailchain.exception;

import eu.eugene.training.retailchain.enums.ExceptionMessageTemplate;

public class RemainingItemsLessThanHalfReceivedException extends RuntimeException {
    public RemainingItemsLessThanHalfReceivedException() {
        super(ExceptionMessageTemplate.ITEMS_LESS_THAN_HALF_RECEIVED.getMessageTemplate());
    }
}
