package com.prestashop.core.utils.logger;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestProgressListener implements ITestListener {

    private static final Logger logger = LogUtil.getInstance();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " started.");
        logger.info(iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.info(iTestResult.getMethod().getMethodName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Failed with exception: " + iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logger.info("Skipped with exception: " + iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.info("Failed within success percentage with exception: " + iTestResult.getThrowable());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("==== starting " + iTestContext.getName() + "====");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("==== finished " + iTestContext.getName() + "====");
    }
}
