package eu.eugene.training.retailchain.exception;

import eu.eugene.training.retailchain.enums.ExceptionMessageTemplate;

public class RemainingQuantityNegativeCountException extends RuntimeException {
    public RemainingQuantityNegativeCountException() {
        super(ExceptionMessageTemplate.NEGATIVE_NUMBER_REMAINING_QUANTITY.getMessageTemplate());
    }
}
