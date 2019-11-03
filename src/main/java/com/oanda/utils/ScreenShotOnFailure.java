package com.oanda.utils;

import com.google.common.io.Files;
import com.oanda.base.DriverHolder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure extends TestListenerAdapter implements ITestListener {
    private ByteArrayOutputStream request = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();

    @Attachment(value = "ScreenShot on Failed step", type = "image/png")
    static byte[] attachBrowserScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) DriverHolder.getDriverThread()).getScreenshotAs(OutputType.FILE);
        return Files.toByteArray(scrFile);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            attachBrowserScreenShot();
            onTestSuccess(iTestResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] attach(ByteArrayOutputStream log) {
        byte[] array = log.toByteArray();
        log.reset();
        return array;
    }
}
