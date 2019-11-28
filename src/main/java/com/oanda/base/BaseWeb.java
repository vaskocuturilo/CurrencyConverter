package com.oanda.base;

import com.oanda.browser.Chrome;
import com.oanda.remote.Remote;
import com.oanda.environment.Environment;
import com.oanda.utils.ScreenShotOnFailure;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

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
    @BeforeClass(alwaysRun = true)
    public void startBrowser() {
        if (Environment.isCheckOperatingSystem()) {
            final Remote remote = new Remote();
            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            DriverHolder.setDriverThread(remote.createDriver(capabilities));
        } else {
            final Chrome chrome = new Chrome();
            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            DriverHolder.setDriverThread(chrome.createDriver(capabilities));
        }
    }

    /**
     * Close browser.
     */
    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        AbstractPage.closeWebBrowser();
    }
}
