package com.oanda.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The class Abstract page.
 */
public abstract class AbstractPage {

    /**
     * The private value webDriverWait.
     */
    private final WebDriverWait webDriverWait;

    /**
     * The constant DELAY.
     */
    private static final long DELAY = 5000;

    /**
     * Instantiates a new Abstract page.
     */
    public AbstractPage() {
        webDriverWait = new WebDriverWait(DriverHolder.getDriverThread(), DELAY);
    }


    /**
     * Abstract method test.
     */
    public abstract void test();

    /**
     * Method navigateWebBrowser.
     *
     * @return the web driver . navigation
     */
    public WebDriver.Navigation navigateWebBrowser() {
        return DriverHolder.getDriverThread().navigate();
    }

    /**
     * Method getWindowTitle.
     *
     * @return the window title
     */
    public String getWindowTitle() {
        return DriverHolder.getDriverThread().getTitle();
    }


    /**
     * Method closeWebBrowser.
     */
    public static void closeWebBrowser() {
        DriverHolder.getDriverThread().manage().deleteAllCookies();
        DriverHolder.getDriverThread().close();
    }

}
