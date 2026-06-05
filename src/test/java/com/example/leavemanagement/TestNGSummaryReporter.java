package com.example.leavemanagement;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestNGSummaryReporter implements ITestListener {

    private static final String OUTPUT_DIR = "target/test-output/Summary";
    private final List<TestResult> results = new ArrayList<>();
    private LocalDateTime startTime;

    private static class TestResult {
        String testName;
        String status;
        String description;
        long duration;
        String errorMessage;

        TestResult(String testName, String status, String description, long duration, String errorMessage) {
            this.testName = testName;
            this.status = status;
            this.description = description;
            this.duration = duration;
            this.errorMessage = errorMessage;
        }
    }

    @Override
    public void onStart(ITestContext context) {
        startTime = LocalDateTime.now();
        try {
            Files.createDirectories(Paths.get(OUTPUT_DIR));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        LocalDateTime endTime = LocalDateTime.now();
        long totalDuration = context.getEndDate().getTime() - context.getStartDate().getTime();

        generateMarkdownReport(context, totalDuration);
        generateCsvReport(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // no-op
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        results.add(new TestResult(
                result.getMethod().getMethodName(),
                "PASSED",
                result.getMethod().getDescription(),
                result.getEndMillis() - result.getStartMillis(),
                null
        ));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String errorMsg = result.getThrowable() != null ? result.getThrowable().getMessage() : "Unknown error";
        results.add(new TestResult(
                result.getMethod().getMethodName(),
                "FAILED",
                result.getMethod().getDescription(),
                result.getEndMillis() - result.getStartMillis(),
                errorMsg
        ));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        results.add(new TestResult(
                result.getMethod().getMethodName(),
                "SKIPPED",
                result.getMethod().getDescription(),
                0,
                "Test not implemented"
        ));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    private void generateMarkdownReport(ITestContext context, long totalDuration) {
        long passCount = results.stream().filter(r -> "PASSED".equals(r.status)).count();
        long failCount = results.stream().filter(r -> "FAILED".equals(r.status)).count();
        long skipCount = results.stream().filter(r -> "SKIPPED".equals(r.status)).count();
        long totalCount = results.size();

        StringBuilder md = new StringBuilder();
        md.append("# Leave Management TestNG Execution Summary\n\n");
        md.append("**Report Generated:** ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");
        md.append("## Execution Overview\n\n");
        md.append("| Metric | Count |\n");
        md.append("|--------|-------|\n");
        md.append("| **Total Tests** | ").append(totalCount).append(" |\n");
        md.append("| **Passed** | ").append(passCount).append(" |\n");
        md.append("| **Failed** | ").append(failCount).append(" |\n");
        md.append("| **Skipped** | ").append(skipCount).append(" |\n");
        md.append("| **Total Duration** | ").append(totalDuration).append(" ms |\n\n");

        md.append("## Pass Rate\n\n");
        double passRate = totalCount > 0 ? (passCount * 100.0 / totalCount) : 0;
        md.append("**").append(String.format("%.2f%%", passRate)).append("** (").append(passCount).append("/").append(totalCount).append(" tests)\n\n");

        md.append("## Test Results Detail\n\n");
        md.append("| Test Name | Status | Description | Duration (ms) |\n");
        md.append("|-----------|--------|-------------|---------------|\n");
        for (TestResult result : results) {
            md.append("| `").append(result.testName).append("` | **").append(result.status).append("** | ")
                    .append(result.description != null ? result.description : "-").append(" | ")
                    .append(result.duration).append(" |\n");
        }

        md.append("\n## Failed Tests\n\n");
        if (failCount > 0) {
            for (TestResult result : results) {
                if ("FAILED".equals(result.status)) {
                    md.append("### ").append(result.testName).append("\n");
                    md.append("- **Error:** ").append(result.errorMessage).append("\n\n");
                }
            }
        } else {
            md.append("All tests passed! ✅\n\n");
        }

        try (FileWriter writer = new FileWriter(OUTPUT_DIR + "/TestExecutionSummary.md")) {
            writer.write(md.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateCsvReport(ITestContext context) {
        StringBuilder csv = new StringBuilder();
        csv.append("Test Name,Status,Description,Duration (ms),Error Message\n");

        for (TestResult result : results) {
            csv.append("\"").append(escape(result.testName)).append("\",");
            csv.append("\"").append(result.status).append("\",");
            csv.append("\"").append(escape(result.description != null ? result.description : "")).append("\",");
            csv.append(result.duration).append(",");
            csv.append("\"").append(escape(result.errorMessage != null ? result.errorMessage : "")).append("\"\n");
        }

        try (FileWriter writer = new FileWriter(OUTPUT_DIR + "/TestExecutionResults.csv")) {
            writer.write(csv.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String escape(String value) {
        if (value == null) return "";
        return value.replace("\"", "\"\"");
    }
}
