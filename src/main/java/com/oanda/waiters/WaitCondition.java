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

    /**
     * Wait for text to be present in element value by attribute boolean.
     *
     * @param locator the locator
     * @param text    the text
     * @return the boolean
     */
    public boolean waitForTextToBePresentInElementValueByAttribute(final WebElement locator, final String text) {
        return webDriverWait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
    }

    /**
     * Wait for invisibility of element located by boolean.
     *
     * @param locator the locator.
     * @return the boolean.
     */
    public boolean waitForInvisibilityOfElementLocatedBy(final By locator) {
        return webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait for presence of element located web element.
     *
     * @param locator this is locator(css or xpath).
     * @return the web element.
     */
    public WebElement waitForPresenceOfElementLocated(final By locator) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    /**
     * Wait for not presence of element located boolean.
     *
     * @param locator this is locator(css or xpath).
     * @return the boolean.
     */
    public boolean waitForNotPresenceOfElementLocated(final By locator) {
        return webDriverWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
    }


}
