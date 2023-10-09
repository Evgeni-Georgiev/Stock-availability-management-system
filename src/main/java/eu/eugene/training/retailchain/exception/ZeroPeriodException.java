package eu.eugene.training.retailchain.exception;

import eu.eugene.training.retailchain.enums.ExceptionMessageTemplate;

public class ZeroPeriodException extends RuntimeException {

    public ZeroPeriodException() {
        super(ExceptionMessageTemplate.ZERO_PERIOD.getMessageTemplate());
    }
}
