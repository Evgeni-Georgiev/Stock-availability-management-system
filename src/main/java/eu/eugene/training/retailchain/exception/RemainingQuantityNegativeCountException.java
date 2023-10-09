package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class RemainingQuantityNegativeCountException extends RuntimeException {
    public RemainingQuantityNegativeCountException() {
        super(ExceptionMessageTemplate.NEGATIVE_NUMBER_REMAINING_QUANTITY.getMessageTemplate());
    }
}
