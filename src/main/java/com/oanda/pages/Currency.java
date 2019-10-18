package com.oanda.pages;

public enum Currency {

    EUR("EUR"),
    USD("USD"),
    GBP("GBP"),
    CAD("CAD");


    private String select;

    Currency(String selectData) {
        this.select = selectData;
    }

    public String getSelect() {
        return select;
    }
}
