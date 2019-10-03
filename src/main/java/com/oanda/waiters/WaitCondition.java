package com.oanda.waiters;

import com.oanda.base.DriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * The class WaitCondition.
 */
public class WaitCondition {

    /**
     * The constant DELAY. This is delay for WebDriverWait is seconds.
     */
    private static final int DELAY = 5;

    /**
     * The private value webDriverWait.
     */
    private WebDriverWait webDriverWait;

    /**
     * The constructor.
     */
    public WaitCondition() {
        webDriverWait = new WebDriverWait(DriverHolder.getDriverThread(), DELAY);
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
