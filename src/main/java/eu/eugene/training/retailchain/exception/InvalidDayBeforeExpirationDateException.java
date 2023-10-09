package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class InvalidDayBeforeExpirationDateException extends RuntimeException {
    public InvalidDayBeforeExpirationDateException() {
        super(ExceptionMessageTemplate.INVALID_DAY_BEFORE_EXPIRATION_DATE.getMessageTemplate());
    }
}
