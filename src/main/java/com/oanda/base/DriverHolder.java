package com.oanda.base;

import org.openqa.selenium.WebDriver;


/**
 * The class DriverHolder.
 */
public final class DriverHolder {

    /**
     * The value DRIVER_THREAD.
     */
    private static final ThreadLocal<WebDriver> DRIVER_THREAD = new ThreadLocal<>();

    /**
     * The default constructor.
     */
    private DriverHolder() {
    }

    /**
     * Gets thread driver.
     *
     * @return the thread driver
     */
    public static WebDriver getDriverThread() {
        return DRIVER_THREAD.get();
    }

    /**
     * Sets thread driver.
     *
     * @param webDriverValue the web driver value
     */
    public static void setDriverThread(final WebDriver webDriverValue) {
        DRIVER_THREAD.set(webDriverValue);
    }
}
