package com.oanda.remote;

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
        WebDriverManager.chromedriver().setup();
        GridLauncherV3.main(new String[]{"-role", "node", "-hub",
                "http://localhost:4444/grid/register", "-browser",
                "browserName=chrome", "-port", "5555"});

    }
}
