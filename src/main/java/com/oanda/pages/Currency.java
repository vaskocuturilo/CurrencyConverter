package com.oanda.pages;

/**
 * The enum Currency.
 */
public enum Currency {

    /**
     * Eur currency.
     */
    EUR("EUR"),

    /**
     * Usd currency.
     */
    USD("USD"),

    /**
     * Gbp currency.
     */
    GBP("GBP"),

    /**
     * Cad currency.
     */
    CAD("CAD");

    /**
     * The private value for selection.
     */
    private String select;

    /**
     * The constructor.
     */
    Currency(String selectData) {
        this.select = selectData;
    }

    /**
     * Getter.
     *
     * @return the select.
     */
    public String getSelect() {
        return select;
    }
}
