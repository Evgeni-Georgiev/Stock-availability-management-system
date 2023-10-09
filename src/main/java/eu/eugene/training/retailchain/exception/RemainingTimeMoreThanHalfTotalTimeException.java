package eu.deltasource.training.retailchain.exception;

import eu.deltasource.training.retailchain.enums.ExceptionMessageTemplate;

public class RemainingTimeMoreThanHalfTotalTimeException extends RuntimeException {
    public RemainingTimeMoreThanHalfTotalTimeException() {
        super(ExceptionMessageTemplate.REMAINING_TIME_MORE_THAN_HALF_TOTAL_TIME.getMessageTemplate());
    }
}
