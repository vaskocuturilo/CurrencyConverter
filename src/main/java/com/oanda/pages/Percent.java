package com.oanda.pages;

/**
 * The enum Percent.
 */
public enum Percent {

    /**
     * Zero percent.
     */
    ZERO(0),

    /**
     * One percent.
     */
    ONE(1),

    /**
     * Two percent.
     */
    TWO(2);

    /**
     * The private value.
     */
    private int percent;

    /**
     * The constructor.
     *
     * @param percentData this is percent data.
     */
    Percent(final int percentData) {
        this.percent = percentData;
    }

    /**
     * Getter.
     *
     * @return the percent.
     */
    public int getPercent() {
        return percent;
    }
}
