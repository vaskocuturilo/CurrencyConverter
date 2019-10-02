package com.oanda.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * The class Base web.
 */
public class BaseWeb {

    /**
     * The default constructor.
     */
    public BaseWeb() {
        super();
        //empty
        return;
    }

    /**
     * Start browser.
     */
    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        DriverHolder.setDriverThread(new ChromeDriver(capabilities));
    }

    /**
     * Close browser.
     */
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        AbstractPage.closeWebBrowser();

    }
}
