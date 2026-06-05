package com.example.leavemanagement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGExtentReporter implements ITestListener {

    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> TEST_THREAD = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String reportPath = System.getProperty("user.dir") + "/target/test-output/ExtentReports/LeaveServiceExecutionReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("Leave Service Test Execution Report");
        spark.config().setReportName("Leave Management TestNG Execution");
        spark.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Framework", "TestNG");
        extent.setSystemInfo("Reporter", "ExtentReports");
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        TEST_THREAD.set(test);
        test.info("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TEST_THREAD.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TEST_THREAD.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = TEST_THREAD.get();
        if (test == null) {
            test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
            TEST_THREAD.set(test);
        }
        test.skip("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        TEST_THREAD.get().warning("Test failed but within success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }
}

