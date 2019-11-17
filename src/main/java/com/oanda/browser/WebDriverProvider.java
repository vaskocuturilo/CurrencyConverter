package com.oanda.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * The interface Web driver provider.
 */
public interface WebDriverProvider {

    /**
     * Create driver web driver.
     *
     * @param desiredCapabilities the desired capabilities
     * @return the web driver
     */
    WebDriver createDriver(DesiredCapabilities desiredCapabilities);
}
