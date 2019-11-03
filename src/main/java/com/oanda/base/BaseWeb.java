package com.oanda.base;

import com.oanda.utils.TakeScreenShotOnFailureListeners;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


/**
 * The class Base web.
 */
@Listeners(TakeScreenShotOnFailureListeners.class)
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
        DriverHolder.getDriverThread().manage().window().maximize();
    }

    /**
     * Close browser.
     */
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        AbstractPage.closeWebBrowser();

    }
}
