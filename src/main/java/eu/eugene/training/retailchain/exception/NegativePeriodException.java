package eu.eugene.training.retailchain.exception;

import eu.eugene.training.retailchain.enums.ExceptionMessageTemplate;

public class NegativePeriodException extends RuntimeException {

    public NegativePeriodException() {
        super(ExceptionMessageTemplate.NEGATIVE_PERIOD.getMessageTemplate());
    }
}
