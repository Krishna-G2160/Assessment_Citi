package com.util;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport implements BeforeAllCallback, BeforeTestExecutionCallback, AfterAllCallback, AfterTestExecutionCallback {
    static ExtentReports reports;
    static ExtentTest test;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        String filename = System.getProperty("user.dir") + "/test-output/" + context.getDisplayName() + "_Results.html";
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        test = reports.createTest(context.getDisplayName());

        test.log(Status.INFO, context.getDisplayName() + " - started");

    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (!context.getExecutionException().isPresent()) {
            test.pass(context.getDisplayName() + " - passed");
        } else {
            test.fail(context.getExecutionException().get().getLocalizedMessage());
        }
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        reports.flush();
    }
}
