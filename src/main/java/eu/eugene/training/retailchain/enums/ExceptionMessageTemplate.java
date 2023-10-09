package eu.eugene.training.retailchain.enums;

/**
 * Store all default message templates used in Exceptions.
 */
public enum ExceptionMessageTemplate {

        NEGATIVE_PERIOD("End date is before start date."),
        NEGATIVE_NUMBER_REMAINING_QUANTITY("Remaining quantity of item is negative count."),
        INVALID_DAY_BEFORE_EXPIRATION_DATE("Invalid number of days before expiration date."),
        ITEMS_LESS_THAN_HALF_RECEIVED("Remaining items are less than half received."),
        ZERO_REMAINING_ITEMS_IN_BATCH("Remaining items in batch are zero."),
        REMAINING_TIME_MORE_THAN_HALF_TOTAL_TIME("Remaining time is more than half the total time."),
        ZERO_PERIOD("Start and end dates are the same.");

        final String messageTemplate;

        ExceptionMessageTemplate(String messageTemplate) {
            this.messageTemplate = messageTemplate;
        }

        public String getMessageTemplate() {
            return messageTemplate;
        }
}
