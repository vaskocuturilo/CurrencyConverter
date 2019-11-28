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
import java.util.logging.Logger;


/**
 * The class Screen shot on failure.
 */
public class ScreenShotOnFailure extends TestListenerAdapter implements ITestListener {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(ScreenShotOnFailure.class.getName());

    private ByteArrayOutputStream request = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();

    /**
     * The default constructor.
     */
    public ScreenShotOnFailure() {
        super();
        //empty
        return;
    }

    /**
     * Attach browser screen shot byte [ ].
     *
     * @return the byte [ ]
     * @throws IOException the io exception
     */
    @Attachment(value = "ScreenShot on Failed step", type = "image/png")
    static byte[] attachBrowserScreenShot() throws IOException {
        final File scrFile = ((TakesScreenshot) DriverHolder.getDriverThread()).getScreenshotAs(OutputType.FILE);
        return Files.toByteArray(scrFile);
    }

    @Override
    public void onTestFailure(final ITestResult iTestResult) {
        try {
            attachBrowserScreenShot();
            onTestSuccess(iTestResult);
        } catch (IOException ex) {
            LOGGER.info("This error" + ex);
        }
    }

    /**
     * Method Attach byte [ ].
     *
     * @param log the log
     * @return the byte [ ]
     */
    public byte[] attach(final ByteArrayOutputStream log) {
        final byte[] array = log.toByteArray();
        log.reset();
        return array;
    }
}
