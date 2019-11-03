package com.oanda.utils;

import com.oanda.base.DriverHolder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShot {

    @Attachment(value = "ScreenShot ''{0}''", type = "image/png")
    public static byte[] captureScreen(String someCoolName) {
        return ((TakesScreenshot) DriverHolder.getDriverThread()).getScreenshotAs(OutputType.BYTES);
    }
}
