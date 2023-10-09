package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class NegativePeriodException extends RuntimeException {

    public NegativePeriodException() {
        super(ExceptionMessageTemplate.NEGATIVE_PERIOD.getMessageTemplate());
    }
}
