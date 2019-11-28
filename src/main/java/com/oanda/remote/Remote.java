package com.oanda.remote;

import com.oanda.browser.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static com.oanda.remote.GridLauncher.createLauncher;
import static com.oanda.remote.StartHub.createHub;

/**
 * The class Remote.
 */
public class Remote implements WebDriverProvider {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Remote.class.getName());

    /**
     * The default constructor.
     */
    public Remote() {
        super();
        //empty
        return;
    }

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        createHub();
        createLauncher();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "77.0");
        try {
            return new RemoteWebDriver(getGridHubUrl(), capabilities);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * The private method for run Grid .
     */
    private static URL getGridHubUrl() {
        URL hostURL = null;
        try {
            hostURL = new URL(System.getProperty("http://localhost:5555/wd/hub", "http://localhost:5555/wd/hub"));
        } catch (MalformedURLException ex) {
            LOGGER.info("This error" + ex);
        }
        return hostURL;
    }


}



