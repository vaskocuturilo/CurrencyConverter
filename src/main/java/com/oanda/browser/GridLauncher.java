package com.oanda.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.GridLauncherV3;

/**
 * The class Grid launcher.
 */
public class GridLauncher {

    /**
     * Method create launcher.
     */
    public static void createLauncher() {
        GridLauncherV3.main(new String[]{"-role", "hub", "-port", "4444"});
        GridLauncherV3.main(new String[]{"-role", "node", "-hub",
                "http://192.168.0.103:4444/grid/register", "-browser",
                "browserName=chrome", "-port", "5555"});
        WebDriverManager.chromedriver().setup();
    }
}
