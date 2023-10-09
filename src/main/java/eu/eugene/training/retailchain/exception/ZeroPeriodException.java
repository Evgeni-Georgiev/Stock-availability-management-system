package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class ZeroPeriodException extends RuntimeException {

    public ZeroPeriodException() {
        super(ExceptionMessageTemplate.ZERO_PERIOD.getMessageTemplate());
    }
}
