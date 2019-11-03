package com.oanda.utils;

import io.qameta.allure.Step;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class TakeScreenShotOnFailureListeners implements ITestListener, ITestNGListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Step("Шаг на onTestFailure в TestNG listener")
    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ScreenShot.captureScreen(methodName);
    }

    @Step("Шаг на onTestSkipped в testng listener")
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        ScreenShot.captureScreen(methodName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
