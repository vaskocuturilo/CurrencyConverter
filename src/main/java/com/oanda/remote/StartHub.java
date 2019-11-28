package com.oanda.remote;

import org.openqa.grid.selenium.GridLauncherV3;


/**
 * The class Start hub.
 */
public class StartHub {

    /**
     * Method Create hub.
     */
    public static void createHub(){
        GridLauncherV3.main(new String[] { "-role", "hub", "-port", "4444" });

    }
}
