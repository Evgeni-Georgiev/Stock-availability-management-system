package eu.eugene.training.retailchain.exception;

import eu.eugene.training.retailchain.enums.ExceptionMessageTemplate;

public class InvalidDayBeforeExpirationDateException extends RuntimeException {
    public InvalidDayBeforeExpirationDateException() {
        super(ExceptionMessageTemplate.INVALID_DAY_BEFORE_EXPIRATION_DATE.getMessageTemplate());
    }
}
