package com.oanda.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.GridLauncherV3;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Remote implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
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
        gridLauncher();
        URL hostURL = null;
        try {
            hostURL = new URL(System.getProperty("http://127.0.0.1:4444/wd/hub", "http://127.0.0.1:4444/wd/hub"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return hostURL;
    }

    private static void gridLauncher() {
        GridLauncherV3.main(new String[]{"-role", "hub", "-port", "4444"});
        GridLauncherV3.main(new String[]{"-role", "node", "-hub",
                "http://127.0.0.1:4444/grid/register", "-browser",
                "browserName=chrome", "-port", "5555"});
        WebDriverManager.chromedriver().setup();
    }
}



