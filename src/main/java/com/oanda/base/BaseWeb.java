package com.oanda.base;

import com.oanda.browser.Chrome;
import com.oanda.utils.ScreenShotOnFailure;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;


/**
 * The class Base web.
 */
@Listeners(ScreenShotOnFailure.class)
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
    @SuppressWarnings("deprecation")
    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        Chrome chrome = new Chrome();
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        DriverHolder.setDriverThread(chrome.createDriver(capabilities));
    }

    /**
     * Close browser.
     */
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        AbstractPage.closeWebBrowser();

    }
}
