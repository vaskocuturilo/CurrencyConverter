package com.oanda.remote;

import org.openqa.grid.selenium.GridLauncherV3;

public class StartHub {

    public static void createHub(){
        GridLauncherV3.main(new String[] { "-role", "hub", "-port", "4444" });

    }
}
