package com.oanda.base;

import org.openqa.selenium.WebDriver;

/**
 * The class Abstract page.
 */
public abstract class AbstractPage {

    /**
     * The default constructor.
     */
    public AbstractPage() {
        super();
        //empty
        return;
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
