package com.oanda.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * The interface Web driver provider.
 */
public interface WebDriverProvider {

    /**
     * Create new {@link WebDriver} instance. The instance will be bound to current thread, so there is no need to cache
     * this instance in method implementation. Also don't cache the instance in static variable, as <a
     * href="http://code.google.com/p/selenium/wiki/FrequentlyAskedQuestions#Q:_Is_WebDriver_thread-safe?">WebDriver
     * instance is not thread-safe</a>.
     *
     * @param desiredCapabilities set of desired capabilities as suggested by Selenium framework;
     *                            method implementation is recommended to pass this variable to {@link WebDriver},
     *                            probably modifying it according to specific needs.
     * @return new {@link WebDriver} instance.
     */
    WebDriver createDriver(DesiredCapabilities desiredCapabilities);
}
