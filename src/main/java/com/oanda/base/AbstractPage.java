package com.oanda.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
     * The constant DELAY. This is delay for WebDriverWait is seconds.
     */
    private static final int DELAY = 5;

    /**
     * The constructor.
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

    /**
     * Wait for visibility of element located by web element.
     *
     * @param locator the locator.
     * @return the web element.
     */
    public WebElement waitForVisibilityOfElementLocatedBy(final By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
