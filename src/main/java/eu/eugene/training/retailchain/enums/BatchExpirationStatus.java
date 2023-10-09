package eu.eugene.training.retailchain.enums;

public enum BatchExpirationStatus {
    UNEXPIRED("Unexpired"),
    HALF_TIME_PASSED("Half Time passed"),
    SEVENTH_DAY("Seventh day"),
    SECOND_DAY("Second day"),
    EXPIRED("Expired");

    public final String label;


    BatchExpirationStatus(String label) {
        this.label = label;
    }

    public String getBatchExpirationLabel() {
        return label;
    }
}
