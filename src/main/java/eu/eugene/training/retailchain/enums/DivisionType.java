package eu.deltasource.training.retailchain.enums;

public enum DivisionType {

    TOTAL_TIME_DIVISOR(2),
    TOTAL_QUANTITY_DIVISOR(2);

    private final int divisionNumber;

    DivisionType(int divisionNumber) {
        this.divisionNumber = divisionNumber;
    }

    public int getDivisionNumber() {
        return this.divisionNumber;
    }
}
